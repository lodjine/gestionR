package com.talan.controlleur.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Activite;
import com.talan.entities.Confidentialite;
import com.talan.entities.Disponibilite;
import com.talan.entities.ImpactC;
import com.talan.entities.Information;
import com.talan.entities.Integrite;
import com.talan.entities.ListRisque;
import com.talan.entities.MesureEx;
import com.talan.entities.Processus;
import com.talan.entities.Risque;
import com.talan.entities.SousProcessus;
import com.talan.entities.Tracabilite;
import com.talan.entities.Utilisateur;
import com.talan.entities.Vulnerabilite;
import com.talan.service.ImpactCService;
import com.talan.service.MesureExService;
import com.talan.service.ProcessService;
import com.talan.service.RisqueService;
import com.talan.service.TracabiliteService;
import com.talan.service.UtilisateurService;
import com.talan.service.VulnerabiliteService;

@Controller
public class RiskController {
	static SXSSFWorkbook  wb ;
	 static Sheet sh ;
	@Autowired
	RisqueService riskServiceImpl ; ;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	MesureExService mesServiceImpl ; 
	@Autowired
	ImpactCService impactCServiceImpl ; 
	@Autowired
	VulnerabiliteService vulServiceImpl ; 
	@Autowired
	ProcessService pServiceImpl ; 
	@Autowired
	TracabiliteService tracabiliteServiceImpl;

	public ImpactCService getImpactCServiceImpl() {
		return impactCServiceImpl;
	}





	public void setImpactCServiceImpl(ImpactCService impactCServiceImpl) {
		this.impactCServiceImpl = impactCServiceImpl;
	}





	public VulnerabiliteService getVulServiceImpl() {
		return vulServiceImpl;
	}





	public void setVulServiceImpl(VulnerabiliteService vulServiceImpl) {
		this.vulServiceImpl = vulServiceImpl;
	}





	public MesureExService getMesServiceImpl() {
		return mesServiceImpl;
	}





	public void setMesServiceImpl(MesureExService mesServiceImpl) {
		this.mesServiceImpl = mesServiceImpl;
	}





	public UtilisateurService getUtilisateurServiceImpl() {
		return utilisateurServiceImpl;
	}





	public void setUtilisateurServiceImpl(UtilisateurService utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}





	public RisqueService getRiskServiceImpl() {
		return riskServiceImpl;
	}





	public void setRiskServiceImpl(RisqueService riskServiceImpl) {
		this.riskServiceImpl = riskServiceImpl;
	}






	
	
		@RequestMapping(value="/getRisks",method = RequestMethod.GET)
		public ModelAndView showRisks(){
			ModelAndView model = new ModelAndView("Risk/RiskPage");
					return model ;  
		}
	
	
	@RequestMapping(value = "/SeekRisk", method = RequestMethod.GET)
    public @ResponseBody List<Risque> seekRisk() {
		
		List<Risque> risques = riskServiceImpl.getAll() ; 
		
		 
		List<Risque> riskList = new ArrayList<>()  ;
		for (Risque m:risques ){
			Risque ris = new Risque() ; 
			ris.setRisqueId(m.getRisqueId());
			ris.setRisqueLabel(m.getRisqueLabel());
			Processus p = new Processus() ; 
			p.setDescription(m.getProc().getDescription());
			p.setProcessus(m.getProc().getProcessus());
			p.setProcId(m.getProc().getProcId());
			p.setUser(m.getProc().getUser());
			ris.setProc(p);
			
			riskList.add(ris) ; 
		}
		
	return riskList ; 
		
		}
	
	@RequestMapping(value = "/PersisteRisk/{label}/{value}/{proc}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("proc") int proc ,HttpSession session) {
		
		Risque risk = new Risque() ; 
			Processus p = pServiceImpl.getById(proc) ; 
			risk.setProc(p);
			risk.setRisqueLabel(label);
			risk.setValue(value);
			riskServiceImpl.persist(risk);
////////////tracabilite/////////////
			
	UserDetails user = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
	String role="";
	Utilisateur myUser = new Utilisateur();
	myUser = utilisateurServiceImpl.getById(user.getUsername());
	
	
Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Risque");
trace.setOperation("Ajout");
trace.setLabelEntity(risk.getRisqueLabel());
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		return true ; 
		
    }
	@RequestMapping(value = "/updateRisk/{id}/{label}/{value}/{proc}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id,@PathVariable("label") String label,@PathVariable("value") int value,@PathVariable("proc") int proc , HttpSession session) {
		
		Risque ris = new Risque() ;
		ris = riskServiceImpl.getById(id) ;
		Processus p = pServiceImpl.getById(proc) ; 
		ris.setProc(p);
		ris.setValue(value);
		ris.setRisqueLabel(label);
		riskServiceImpl.update(ris);
		
////////////tracabilite/////////////
		
UserDetails user = (UserDetails) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
String role="";
Utilisateur myUser = new Utilisateur();
myUser = utilisateurServiceImpl.getById(user.getUsername());


Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Risque");
trace.setLabelEntity(ris.getRisqueLabel());
trace.setOperation("Modification");
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		return true ; 
		
    }
	@RequestMapping(value = "/deleteRisk/{id}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("id") int id, HttpSession session) {
		Risque ris = new Risque() ; 
		ris = riskServiceImpl.getById(id);
		riskServiceImpl.delete(ris);
		
////////////tracabilite/////////////
		
UserDetails user = (UserDetails) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
String role="";
Utilisateur myUser = new Utilisateur();
myUser = utilisateurServiceImpl.getById(user.getUsername());


Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Risque");
trace.setLabelEntity(ris.getRisqueLabel());
trace.setOperation("Delete");
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		return true ; 
		
    }
	
	
	@RequestMapping(value="/seekRisqueByProc/{id}/{type}" , method = RequestMethod.GET)
	public @ResponseBody List<ListRisque> getRisksByProc(@PathVariable("id") int id,@PathVariable("type") String type ,HttpSession session ) {
	List<Risque>rList = riskServiceImpl.getRiskByProc(id) ; 
	List<MesureEx> mesList = new ArrayList<>() ;
	List<ImpactC> impList = new ArrayList<>() ; 
	List<Vulnerabilite> vulList = new ArrayList<>() ; 
	List<ListRisque> listRisque = new ArrayList<>() ; 
			for(int i =0 ; i<rList.size() ; i++) {
				ListRisque lrisque = new ListRisque() ; 
				mesList = mesServiceImpl.getmesureByRiskAndType(rList.get(i).getRisqueId(), type) ;
				for(int j = 0 ; j<mesList.size() ; j++){
					lrisque.setRiskLabel(rList.get(i).getRisqueLabel());
					if(j== 0){
						lrisque.setMesures(mesList.get(j).getMesureLabel());
					}else{
					lrisque.setMesures(lrisque.getMesures()+"\r\n"+mesList.get(j).getMesureLabel());
					}
					lrisque.setTotalmes(lrisque.getTotalmes()+mesList.get(j).getValue() );
				}
				 impList = impactCServiceImpl.getImpactCByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<impList.size() ; j++){
					 if(j== 0){
							lrisque.setImpacts(impList.get(j).getImpactLabel());
						}else{
						lrisque.setImpacts(lrisque.getImpacts()+"\r\n"+impList.get(j).getImpactLabel());
						}
						lrisque.setTotalimps(lrisque.getTotalimps()+impList.get(j).getValue() );
					}
				 vulList = vulServiceImpl.getVulnerabiliteByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<vulList.size() ; j++){
					 if(j== 0){
						lrisque.setVuls(vulList.get(j).getVulnLabel());
					 }else{
						 
						 lrisque.setVuls(lrisque.getVuls()+"\r\n"+vulList.get(j).getVulnLabel());
					 }
						lrisque.setTotalvuls(lrisque.getTotalvuls()+vulList.get(j).getValue() );
					 
					}
				lrisque.setTotal((lrisque.getTotalvuls()*lrisque.getTotalimps()*rList.get(i).getValue())-lrisque.getTotalmes());
				listRisque.add(lrisque) ;
			}
			List<ListRisque> riskJson = new ArrayList<>() ; 
			for(int i = 0 ; i< listRisque.size(); i ++ ){
				
				if(listRisque.get(i).getRiskLabel() != null ){
					riskJson.add(listRisque.get(i)) ; 
				}
			}
		
		return riskJson ; 
	}
	
	@RequestMapping(value="/seekRisqueByProc/{id}/{type}/{puis}/" , method = RequestMethod.GET)
	public @ResponseBody List<ListRisque> getRisksByProcAndPuiss(@PathVariable("id") int id,@PathVariable("type") String type ,@PathVariable("puis") int puis ,HttpSession session ) {
	List<Risque>rList = riskServiceImpl.getRiskByProc(id) ; 
	List<MesureEx> mesList = new ArrayList<>() ;
	List<ImpactC> impList = new ArrayList<>() ; 
	List<Vulnerabilite> vulList = new ArrayList<>() ; 
	List<ListRisque> listRisque = new ArrayList<>() ; 
			for(int i =0 ; i<rList.size() ; i++) {
				ListRisque lrisque = new ListRisque() ; 
				mesList = mesServiceImpl.getmesureByRiskAndType(rList.get(i).getRisqueId(), type) ;
				for(int j = 0 ; j<mesList.size() ; j++){
					lrisque.setRiskLabel(rList.get(i).getRisqueLabel());
					if(j== 0){
						lrisque.setMesures(mesList.get(j).getMesureLabel());
					}else{
					lrisque.setMesures(lrisque.getMesures()+"\r\n"+mesList.get(j).getMesureLabel());
					}
					lrisque.setTotalmes(lrisque.getTotalmes()+mesList.get(j).getValue() );
				}
				 impList = impactCServiceImpl.getImpactCByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<impList.size() ; j++){
					 if(j== 0){
							lrisque.setImpacts(impList.get(j).getImpactLabel());
						}else{
						lrisque.setImpacts(lrisque.getImpacts()+"\r\n"+impList.get(j).getImpactLabel());
						}
						lrisque.setTotalimps(lrisque.getTotalimps()+impList.get(j).getValue() );
					}
				 vulList = vulServiceImpl.getVulnerabiliteByRiskAndType(rList.get(i).getRisqueId(), type) ; 
				 for(int j = 0 ; j<vulList.size() ; j++){
					 if(j== 0){
						lrisque.setVuls(vulList.get(j).getVulnLabel());
					 }else{
						 
						 lrisque.setVuls(lrisque.getVuls()+"\r\n"+vulList.get(j).getVulnLabel());
					 }
						lrisque.setTotalvuls(lrisque.getTotalvuls()+vulList.get(j).getValue() );
					 
					}
				lrisque.setTotal((lrisque.getTotalvuls()*lrisque.getTotalimps()*rList.get(i).getValue())-lrisque.getTotalmes());
				listRisque.add(lrisque) ;
			}
			List<ListRisque> riskJson = new ArrayList<>() ; 
			for (int i = 0 ; i< listRisque.size() ; i++){
				if(puis ==1 ){
					if(listRisque.get(i).getTotal()< 7 && listRisque.get(i).getTotal() >0 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}else if (puis == 2 ){
					if(listRisque.get(i).getTotal() >= 7 && listRisque.get(i).getTotal() <= 14 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}else if (puis == 3){
					if(listRisque.get(i).getTotal() > 14 && listRisque.get(i).getTotal() <= 19 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}else if(puis ==4 ){
					if(listRisque.get(i).getTotal()> 19 ){
						riskJson.add(listRisque.get(i)) ;
					}
				}
			}
		
		return riskJson ; 
	}
	
	
	//excel
	@RequestMapping(value = "/RisqueMenu", params = "excel", method = RequestMethod.GET)
	public void  getExcel(HttpServletResponse response,HttpSession session) throws IOException {
		
		
		
		List<Risque> risques=riskServiceImpl.getAll();
		ModelAndView model = new ModelAndView(
				"Risk/RiskPage");
		
	

		
		
		 XSSFWorkbook book = null;
		  
		  XSSFSheet mySheet = null;
		  
		  List<String> header=new ArrayList<String>();
		  
		  header.add("Label");
		  header.add("Result");
		  
	 
		  
		    wb =  new SXSSFWorkbook(150);
		    sh = wb.createSheet("Sample sheet");
		  
		    CellStyle headerStle= getHeaderStyle();
		  
		    CellStyle normalStyle = getNormalStyle();
		  	int j=0;
		    for(int rownum = 0; rownum <= risques.size(); rownum++){
		        Row row = sh.createRow(rownum);
		      
		            
		  
		            if(rownum == 0)
		  
		            {
		  for(int i=0;i<2;i++)
		  {
		  Cell cell = row.createCell(i);
		  cell.setCellValue(header.get(i));
		  cell.setCellStyle(headerStle);
		  
		  }
		          
		            }
		  
		            else
		  
		            {
		            
		            	try
		            	{
		            		Cell cell = row.createCell(0);
					              String label=risques.get(j).getRisqueLabel();
					              cell.setCellValue(label);
					              cell.setCellStyle(normalStyle);
		            	}
		            	catch (Exception e) {
							Cell cell = row.createCell(0);
							 cell.setCellValue("--");
				              cell.setCellStyle(normalStyle);
						}
		            	
		            	
		            	try
		            	{
		            		Cell cell = row.createCell(1);
					              int result=risques.get(j).getValue();
					              cell.setCellValue(result);
					              cell.setCellStyle(normalStyle);
		            	}
		            	catch (Exception e) {
							Cell cell = row.createCell(1);
							 cell.setCellValue("--");
				              cell.setCellStyle(normalStyle);
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
		  
		  
			 
		  
 
		  File excel = new File("C:/test/Risques.xlsx");
		 
		  
 
 
		  
		  
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
