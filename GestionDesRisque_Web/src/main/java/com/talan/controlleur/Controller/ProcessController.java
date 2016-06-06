package com.talan.controlleur.Controller;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Activite;
import com.talan.entities.Information;
import com.talan.entities.Processus;
import com.talan.entities.SousProcessus;
import com.talan.entities.Utilisateur;
import com.talan.service.InformationService;
import com.talan.service.ProcessService;
import com.talan.service.UtilisateurService;




@Controller
public class ProcessController {
	static SXSSFWorkbook  wb ;
	 static Sheet sh ;
	@Autowired
	ProcessService processServiceImpl;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	InformationService informationServiceImpl;
	
	public ProcessService getProcessServiceImpl() {
		return processServiceImpl;
	}

	public void setProcessServiceImpl(ProcessService processServiceImpl) {
		this.processServiceImpl = processServiceImpl;
	}

	@RequestMapping(value = "/ShowProcessus", params="newRecord",method = RequestMethod.GET)
	public ModelAndView addProcess(){
		
		ModelAndView model = new ModelAndView("Process/processAjout") ; 
		System.out.println("---------------------------------------");
		Processus processus=new Processus();
		List<Utilisateur> users=utilisateurServiceImpl.getAll();
		model.addObject("users", users);
		model.addObject("processus", processus);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/ShowProcessus",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView AfficheProcess(@RequestParam("byCode") int id){
		int sizeTotal = 0 ; 
		ModelAndView model = new ModelAndView("Process/processAffiche") ; 
		List<List<Activite>> activitys = new ArrayList<List<Activite>>();
		List<List<Information>> infoss = new ArrayList<List<Information>>();
		Processus proc =  processServiceImpl.getById(id);
		List<Integer> infoList = new ArrayList<Integer>() ; 
		List<Integer> intList = new ArrayList<Integer>() ; 
		List<Integer> activitysize = new ArrayList<Integer>();
		List<SousProcessus> sousProcesss = new ArrayList<SousProcessus>();
		
		sousProcesss = proc.getSsProcs() ; 
		
		for(int i = 0 ; i<sousProcesss.size() ; i++){
			activitys.add(i,sousProcesss.get(i).getActivites());
			sizeTotal = 0  ;
			for (int x = 0 ; x<activitys.get(i).size() ; x++ ) {
				infoss.add(activitys.get(i).get(x).getInformations());
				infoList.add(activitys.get(i).get(x).getInformations().size());
				sizeTotal = sizeTotal+activitys.get(i).get(x).getInformations().size() ; 
				
			}
			intList.add(i, sizeTotal);
			activitysize.add(sousProcesss.get(i).getActivites().size());
		}
		
		
		model.addObject("actSize",activitysize);
		model.addObject("intList",intList) ;
		model.addObject("addValue",infoList.size());
		model.addObject("infoList",infoList);
		model.addObject("sizeTotal",sizeTotal);
		model.addObject("activitys",activitys);
		model.addObject("infoss",infoss);
		model.addObject("proc",proc);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AddProcessus", method = RequestMethod.POST)
	public ModelAndView validProcess(@ModelAttribute Processus processus){
		
		ModelAndView model = new ModelAndView("index") ; 
	Utilisateur user=utilisateurServiceImpl.getById(processus.getUser().getEmail());
	processus.setUser(user);
		processServiceImpl.save(processus);
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AffichProc", method = RequestMethod.GET)
	public ModelAndView AffichProcess(@ModelAttribute Processus processus){
		
		ModelAndView model = new ModelAndView("Process/processAffich") ; 
		List<Processus> Listprocess=processServiceImpl.getAll();
		model.addObject("Listprocess", Listprocess);
		model.addObject("size",Listprocess.size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/MenuProces", method = RequestMethod.GET)
	public ModelAndView MenuProc(){
		
		ModelAndView model = new ModelAndView("Process/ActifMenu") ; 
		
		model.addObject("Listprocess", processServiceImpl.getAll());
		return model ;
		
		
	}
	
	
	
	
	//excel
	@RequestMapping(value = "/ProcessExcel",  method = RequestMethod.GET)
	public void  getExcel(HttpServletResponse response,HttpSession session) throws IOException {
		
		List<Processus> processList=processServiceImpl.getAll();
		
		ModelAndView model = new ModelAndView(
				"Framework/FramworkAdmin/GroupMenu");
		
		
		 XSSFWorkbook book = null;
		  
		  XSSFSheet mySheet = null;
		  
		  List<String> header=new ArrayList<String>();
		  
		  header.add("Process");
		  header.add("Sub Process");
		  header.add("Activite");
		  header.add("information");
	 
		  
		    wb =  new SXSSFWorkbook(150);
		    sh = wb.createSheet("Sample sheet");
		  
		    CellStyle headerStle= getHeaderStyle();
		  
		    CellStyle normalStyle = getNormalStyle();
		  	int j=0;
		  	int numberOfInfo=informationServiceImpl.getAll().size();
		    for(int rownumProc = 0; rownumProc <= numberOfInfo+processList.size()-1; rownumProc++){
		    	
	
		        
		      
		    	
		  
		            if(rownumProc == 0)
		            	  
		            {
		            	Row rowHead = sh.createRow(rownumProc);  
		  for(int i=0;i<4;i++)
		  {
		  Cell cell = rowHead.createCell(i);
		  cell.setCellValue(header.get(i));
		  cell.setCellStyle(headerStle);
		  
		  }
		          
		            }
		  
		            else
		  
		            {
		            
		            	try
		            	{
		            		
					              
					              List<SousProcessus> ssProcList =processList.get(j).getSsProcs();
				            		for(int rownumSsProc=0;rownumSsProc<ssProcList.size();rownumSsProc++){
				            			
				            			List<Activite> actList=ssProcList.get(rownumSsProc).getActivites();
				            			
				                           for(int rownumAct=0;rownumAct<actList.size();rownumAct++){
				                        	   List<Information> infList=actList.get(rownumAct).getInformations();
				                        	   
				                        	   
				                        	   for(int rownumInf=0;rownumInf<infList.size();rownumInf++){
				                        		   
				                        		   if(rownumInf==0){
				                        			   Row row = sh.createRow(rownumProc);
				                        			 Cell  cell4= row.createCell(3);
											              cell4.setCellValue(infList.get(rownumInf).getInformation());
											              cell4.setCellStyle(normalStyle);
											              Cell  cell3= row.createCell(2);
											              cell3.setCellValue(actList.get(rownumAct).getLabelActivity());
											              cell3.setCellStyle(normalStyle); 
											            if(rownumAct==0){
											            	Cell  cell2= row.createCell(1);
												              cell2.setCellValue(ssProcList.get(rownumSsProc).getSousProcessus());
												              cell2.setCellStyle(normalStyle); 
												              
												              if(rownumSsProc==0){
													            	 Cell  cell5= row.createCell(0);
														              cell5.setCellValue(processList.get(j).getProcessus());
														              cell5.setCellStyle(normalStyle);
													            }  
												              else{
												            	  Cell  cell5= row.createCell(0);
													              cell5.setCellValue(" ");
													              cell5.setCellStyle(normalStyle);
												              }
											            }else{
											            	Cell  cell2= row.createCell(1);
												              cell2.setCellValue(" ");
												              cell2.setCellStyle(normalStyle); 	
											            }
											            
											            
											            	  
											              

											              

				                        		   }
				                        		   else{
				                        			   Row rowInf = sh.createRow(rownumProc);
				                        			   
				                        			   Cell  cell4= rowInf.createCell(3);
											              cell4.setCellValue(infList.get(rownumInf).getInformation());
											              cell4.setCellStyle(normalStyle);
											              Cell  cell3= rowInf.createCell(2);
											              cell3.setCellValue(" ");
											              cell3.setCellStyle(normalStyle);
											              Cell  cell2= rowInf.createCell(1);
											              cell2.setCellValue(" ");
											              cell2.setCellStyle(normalStyle);
											              Cell  cell5= rowInf.createCell(0);
											              cell5.setCellValue(" ");
											              cell5.setCellStyle(normalStyle);
				                        		   }
				                        		   
				                        		  rownumProc++;
				                        	   }
				                        	   
				                        	   
				                           }
				            		
				            		
				            		}
		            	}
		            	catch (Exception e) {
//							Cell cell = row.createCell(0);
//							 cell.setCellValue("--"+rownumProc );
//				              cell.setCellStyle(normalStyle);
						}
		            	
		            	
		            	
		            	
		            	
		            		
		            		
		            		
		            	
		  
		              
		            	
		            	
		            	
		            	
		            
		              
		           
		              j++;
		            }
		            
		    
		    }
		  
		  
		    //Below code Shows how to merge Cell
		    
		    sh.addMergedRegion(new CellRangeAddress(
		  
		             90, //first row (0-based)
		  
		               90, //last row  (0-based)
		  
		               90, //first column (0-based)
		  
		               90  //last column  (0-based)
		  
		       ));
		  
		  
		    autoResizeColumns();
		  
		  
			 
		  
 
		  File excel = new File("C:/test/GroupeExcel2.xlsx");
		 
		  
 
 
		  
		  
		  if(!excel.exists())
		  
		              {
		  
		                  //If directories are not available then create it
		  
		                  File parent_directory = excel.getParentFile();
		  
		                  if (null != parent_directory)
		  
		                  {
		  
		                      parent_directory.mkdirs();
		  
		                  }
		  
		   
		  
		                  try {
		  					excel.createNewFile();
		  				} catch (IOException e) {
		  					// TODO Auto-generated catch block
		  					e.printStackTrace();
		  				}
		  
		              }
		  
		  FileOutputStream out;
		  try {
		  out = new FileOutputStream(excel,false);
		  wb.write(out);
		  out.close();
		  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  }

		  
		   
		  
		       
		  
		  
		  
		          // dispose of temporary files backing this workbook on disk
		  
		          wb.dispose();
		  
		          System.out.println("File is created");
		  
		          //Launch Excel File Created
		  
		   

		
		
		
	 
		
		          
		          /////////////////return to menu////////////////////
		        
					

					model = new ModelAndView("Framework/FramworkAdmin/GroupMenu");
					
		
				 
		        //////////////////////////////////////////////////////////////////  
					
					/////////////// send file to download /////////////
					
					
					
				
			
						InputStream input = reteriveByteArrayInputStream(excel) ; 
						
						
						// get your file as InputStream
				       
				        // copy it to response's OutputStream
							ConfigurableMimeFileTypeMap mimeMap = new ConfigurableMimeFileTypeMap();
					        String contentType = mimeMap.getContentType(excel.getName());
					        response.setContentType(contentType);
					        if(contentType.equals("application/octet-stream"))
					        {
					        response.setHeader( "Content-Disposition", "attachment;filename="
					        	      + excel.getName() );
					        }	        
					        response.flushBuffer();
					        org.apache.commons.io.IOUtils.copy(input, response.getOutputStream());

					
					
			       
		///////////////////////
		          
		
		
		
		
	} 
	
	
	
private static CellStyle getHeaderStyle()
	
    {

        CellStyle style = wb.createCellStyle();

        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());

        style.setFillPattern(CellStyle.SOLID_FOREGROUND);

 

        style.setBorderBottom(CellStyle.BORDER_THIN);

        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderLeft(CellStyle.BORDER_THIN);

        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(CellStyle.BORDER_THIN);

        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderTop(CellStyle.BORDER_THIN);

        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        style.setAlignment(CellStyle.ALIGN_CENTER);

 

        return style;

    }

 
private static CellStyle getNormalStyle()

    {

        CellStyle style = wb.createCellStyle();

 

        style.setBorderBottom(CellStyle.BORDER_THIN);

        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderLeft(CellStyle.BORDER_THIN);

        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(CellStyle.BORDER_THIN);

        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderTop(CellStyle.BORDER_THIN);

        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        style.setAlignment(CellStyle.ALIGN_CENTER);

 

        return style;

    }

 

 private static void autoResizeColumns()
 
     {
 
         for(int colIndex = 0; colIndex < 32 ; colIndex++)
 
         {
 
             sh.autoSizeColumn(colIndex);
 
         }
 
     }

	
 public static ByteArrayInputStream reteriveByteArrayInputStream(File file) throws IOException {
	    return new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
	}
}
