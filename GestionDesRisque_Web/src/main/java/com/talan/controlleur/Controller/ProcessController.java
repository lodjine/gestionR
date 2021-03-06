package com.talan.controlleur.Controller;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Activite;
import com.talan.entities.Information;
import com.talan.entities.Processus;
import com.talan.entities.SousProcessus;
import com.talan.entities.Tracabilite;
import com.talan.entities.Utilisateur;
import com.talan.service.ActiviteService;
import com.talan.service.AlerteService;
import com.talan.service.InformationService;
import com.talan.service.ProcessService;
import com.talan.service.SousProcessusService;
import com.talan.service.TracabiliteService;
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
	@Autowired
	TracabiliteService tracabiliteServiceImpl;
	@Autowired
	AlerteService alerteServiceImpl;
	@Autowired
	ActiviteService activiteServiceImpl ; 
	@Autowired
	SousProcessusService spServiceImpl ; 
	
	
	
	public AlerteService getAlerteServiceImpl() {
		return alerteServiceImpl;
	}

	public void setAlerteServiceImpl(AlerteService alerteServiceImpl) {
		this.alerteServiceImpl = alerteServiceImpl;
	}

	public ActiviteService getActiviteServiceImpl() {
		return activiteServiceImpl;
	}

	public void setActiviteServiceImpl(ActiviteService activiteServiceImpl) {
		this.activiteServiceImpl = activiteServiceImpl;
	}

	public SousProcessusService getSpServiceImpl() {
		return spServiceImpl;
	}

	public void setSpServiceImpl(SousProcessusService spServiceImpl) {
		this.spServiceImpl = spServiceImpl;
	}

	public UtilisateurService getUtilisateurServiceImpl() {
		return utilisateurServiceImpl;
	}

	public void setUtilisateurServiceImpl(UtilisateurService utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}

	public InformationService getInformationServiceImpl() {
		return informationServiceImpl;
	}

	public void setInformationServiceImpl(InformationService informationServiceImpl) {
		this.informationServiceImpl = informationServiceImpl;
	}

	public TracabiliteService getTracabiliteServiceImpl() {
		return tracabiliteServiceImpl;
	}

	public void setTracabiliteServiceImpl(TracabiliteService tracabiliteServiceImpl) {
		this.tracabiliteServiceImpl = tracabiliteServiceImpl;
	}

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
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
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
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AddProcessus", method = RequestMethod.POST)
	public ModelAndView validProcess(@ModelAttribute Processus processus){
		
		ModelAndView model = new ModelAndView("index") ; 
	Utilisateur user=utilisateurServiceImpl.getById(processus.getUser().getEmail());
	processus.setUser(user);
	
////////////tracabilite/////////////
	
UserDetails user1 = (UserDetails) SecurityContextHolder.getContext()
	.getAuthentication().getPrincipal();
String role="";
Utilisateur myUser = new Utilisateur();
myUser = utilisateurServiceImpl.getById(user1.getUsername());


Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Action");
trace.setLabelEntity(processus.getProcessus());
trace.setOperation("Modification");
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		processServiceImpl.save(processus);
		

		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/AffichProc", method = RequestMethod.GET)
	public ModelAndView AffichProcess(@ModelAttribute Processus processus){
		UserDetails user1 = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
			String role="";
			Utilisateur myUser = new Utilisateur();
			myUser = utilisateurServiceImpl.getById(user1.getUsername());
		ModelAndView model = new ModelAndView("Process/processAffich") ; 
		List<Processus> Listprocess=processServiceImpl.getAll(myUser);
		model.addObject("Listprocess", Listprocess);
		model.addObject("size",Listprocess.size());
		
		
	
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/MenuProces", method = RequestMethod.GET)
	public ModelAndView MenuProc(){
		
		ModelAndView model = new ModelAndView("Process/ActifMenu") ; 

		
	
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());

		
			String role="";
			
			
		model.addObject("Listprocess", processServiceImpl.getAll(myUser));

		return model ;
		
		
	}
	
	@RequestMapping(value="/procCreation" , method = RequestMethod.GET)
	public ModelAndView getProcCreationJsp() {
		ModelAndView model = new ModelAndView("Process/procCreation") ;
		 return model ; 
	}
	
	@RequestMapping(value = "/procUpload",  method = RequestMethod.POST)
	public ModelAndView Upload(@RequestParam("file") MultipartFile path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

		
		
		
		
		
    
    List<SousProcessus> subList = new ArrayList<>();
    List<Activite> actList = new ArrayList<>() ; 
    List<Information> infoList = new ArrayList<>() ; 
    Processus p = new Processus() ; 
    SousProcessus sp = new SousProcessus() ; 
    Activite ac = new Activite() ; 
	 Information info = new Information() ; 
	
		
	try {
	
		
		  
			
			 
			XSSFWorkbook book = new XSSFWorkbook(path.getInputStream()); 
			XSSFSheet sheet = book.getSheetAt(0);
			System.out.println("file found");
			 Iterator<Row> itr = sheet.iterator();
			 
			 
			 ArrayList <String> rows = new ArrayList();
			 Date bookDate = new Date() ; 
			 
			 
			
	         
	        
	         int i = 0  ; 
	         String sproc = "" ; 
	           String act = "" ; 
			 while (itr.hasNext() ) {
						
					System.out.println(sheet.getLastRowNum());
					 
						 String rowHolder = "";
						 Row row = itr.next();
						 System.out.println(row.getRowNum());
						 if(row.getRowNum()== 0  ){
							   continue; //just skip the rows if row number is 0 or 1
							  }
						 
				            Iterator<Cell> cellIter = row.cellIterator();
				            
		
				            
				            
				           int n = row.getPhysicalNumberOfCells();
				          int last = row.getLastCellNum();
				          

				         
				            Boolean first =true;
				          
				           
				           
				            while ( cellIter.hasNext())
				            {
				            	
				      
				            
				 

				            	
				                if (!first)
				                    rowHolder = rowHolder + ",";

				               Cell cell =  cellIter.next();
				               if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				            	   
				            	   
				            	  cell.setCellValue("");}

				                rowHolder = rowHolder + cell.toString() ;
				                first = false;
				                System.out.println("1"+rowHolder);
				               
				            }
				            System.out.println("line : "+rowHolder);
				            String delims = "[,]";
				            
				            rows.add(rowHolder);
				            
				            String[] tokens = rowHolder.split(delims);
				            
				           if(i == 0 ){
				        	   p.setProcessus(tokens[0]);
				        	   sp.setSousProcessus(tokens[1]);
				        	   ac.setLabelActivity(tokens[2]);
				        	   info.setInformation(tokens[3]);
					           info.setProprietaire(tokens[4]);
					           infoList.add(info) ;
					           sproc = tokens[1] ; 
					           act=tokens[2] ; 
					           i++;
				           }else{
				            
				        	   
				        	   if((tokens[1].equals(sproc)) && tokens[2].equals(act)) {
				        		   info = new Information() ; 
						            info.setInformation(tokens[3]);
						            info.setProprietaire(tokens[4]);
						            
						             infoList.add(info) ;
				        	   }else if(tokens[1].equals(sproc) && !tokens[2].equals(act) ){
				        		   
				        		   	ac.setInformations(infoList);
					            	infoList = new ArrayList<>() ; 
					            	actList.add(ac) ;
					            	ac = new Activite() ; 
					            	ac.setLabelActivity(tokens[2]);
					            	info = new Information() ; 
						            info.setInformation(tokens[3]);
						            info.setProprietaire(tokens[4]);
						            
						             infoList.add(info) ;
					            	act = tokens[2] ;
				        		   
				        	   }else if (!tokens[1].equals(sproc) && !tokens[2].equals(act)){
				        		   
				        			ac.setInformations(infoList);
					            	infoList = new ArrayList<>() ; 
					            	actList.add(ac) ;
					            	sp.setActivites(actList);
					            	subList.add(sp) ;
					            	
					            	sp = new SousProcessus() ;
					            	sp.setSousProcessus(tokens[1]);
					            	actList = new ArrayList<>() ;
					            	
					            	
					            	ac = new Activite() ; 
					            	ac.setLabelActivity(tokens[2]);
					            	info = new Information() ; 
						            info.setInformation(tokens[3]);
						            info.setProprietaire(tokens[4]);
						            
						             infoList.add(info) ;
					            	act = tokens[2] ;
					            	sproc = tokens[1] ; 
				        		   
				        	   }
				        	   
				        	  
				        	   
				        	   
				        	  
				           } 
				             
				          
			 }
			 	
			  
				            
	}catch (FileNotFoundException fe) { fe.printStackTrace(); } 
	catch (IOException ie) { ie.printStackTrace(); }
	ac.setInformations(infoList);
	actList.add(ac);
	sp.setActivites(actList);
	 subList.add(sp); 
	p.setSsProcs(subList);
	
	
	int procid = processServiceImpl.save(p); 
	
		for (int i = 0 ; i< p.getSsProcs().size() ; i ++) {
			
			p.getSsProcs().get(i).setProcessus(processServiceImpl.getById(procid));
			int spId = spServiceImpl.save(p.getSsProcs().get(i));
			for(int  x =0 ; x<p.getSsProcs().get(i).getActivites().size() ; x++){
				p.getSsProcs().get(i).getActivites().get(x).setSubprocess(spServiceImpl.getById(spId));
				int acId = activiteServiceImpl.save(p.getSsProcs().get(i).getActivites().get(x));
					for ( int z = 0 ; z<p.getSsProcs().get(i).getActivites().get(x).getInformations().size() ; z ++ ){
						p.getSsProcs().get(i).getActivites().get(x).getInformations().get(z).setActivite(activiteServiceImpl.getById(acId));
						informationServiceImpl.save(p.getSsProcs().get(i).getActivites().get(x).getInformations().get(z));
					}
			}
		}
	
	
	
	

	
	
	
	
	
	
	

	
	ModelAndView model = new ModelAndView("Process/ActifMenu") ; 

	
	
	
	UserDetails user = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
	Utilisateur myUser = new Utilisateur();
	myUser = utilisateurServiceImpl.getById(user.getUsername());
	model.addObject("firstname", myUser.getFirstName());
	model.addObject("lastname", myUser.getLastName());
	 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());

	
		String role="";
		
		
	model.addObject("Listprocess", processServiceImpl.getAll(myUser));

	return model ;
	
	
	
	
	
	

	
	
	}
	
	
	//excel
	@RequestMapping(value = "/ProcessExcel",  method = RequestMethod.GET)
	public void  getExcel(HttpServletResponse response,HttpSession session) throws IOException {
		UserDetails user1 = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
			String role="";
			Utilisateur myUser = new Utilisateur();
			myUser = utilisateurServiceImpl.getById(user1.getUsername());
		List<Processus> processList=processServiceImpl.getAll(myUser);
		
		ModelAndView model = new ModelAndView(
				"Process/ActifMenu");
		
		
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
				                        			   Cell  cell6= row.createCell(4);
											              cell6.setCellValue(infList.get(rownumInf).getProprietaire());
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
				                        			   Cell  cell6= rowInf.createCell(4);
											              cell6.setCellValue(infList.get(rownumInf).getProprietaire());
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
		        
					

		        
		  		
		  		model.addObject("firstname", myUser.getFirstName());
		  		model.addObject("lastname", myUser.getLastName());
		  		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
					
		
				 
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
