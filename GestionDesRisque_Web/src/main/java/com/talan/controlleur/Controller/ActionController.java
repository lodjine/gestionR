package com.talan.controlleur.Controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Action;
import com.talan.entities.Activite;
import com.talan.entities.Processus;
import com.talan.entities.Responsable;
import com.talan.entities.Risque;
import com.talan.entities.Tracabilite;
import com.talan.entities.Utilisateur;
import com.talan.service.ActionService;
import com.talan.service.RisqueService;
import com.talan.service.TracabiliteService;
import com.talan.service.UtilisateurService;

@Controller
public class ActionController {
	static SXSSFWorkbook  wb ;
	 static Sheet sh ;
	@Autowired
	UtilisateurService utilisateurServiceImpl;
	@Autowired
	ActionService actionServiceImpl ; 
	@Autowired
	RisqueService rServiceImpl ; 
	
	@Autowired
	TracabiliteService tracabiliteServiceImpl;
	
	public RisqueService getrServiceImpl() {
		return rServiceImpl;
	}

	public void setrServiceImpl(RisqueService rServiceImpl) {
		this.rServiceImpl = rServiceImpl;
	}

	public ActionService getActionServiceImpl() {
		return actionServiceImpl;
	}

	public void setActionServiceImpl(ActionService actionServiceImpl) {
		this.actionServiceImpl = actionServiceImpl;
	}

	public UtilisateurService getUtilisateurServiceImpl() {
		return utilisateurServiceImpl;
	}

	public void setUtilisateurServiceImpl(UtilisateurService utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "creationDate",
				new CustomDateEditor(formater, false));
		binder.registerCustomEditor(Date.class, "modificationDate",
				new CustomDateEditor(formater, false));
		binder.registerCustomEditor(Date.class, "beginDate",
				new CustomDateEditor(formater, false));
		binder.registerCustomEditor(Date.class, "endDate",
				new CustomDateEditor(formater, false));
	}
	
	
	@RequestMapping(value = "/ShowAction",params="updateByCode", method = RequestMethod.GET)
	public ModelAndView Affichinf(@RequestParam("byCode") String id){
		
		ModelAndView model = new ModelAndView("Risk/actionAffiche") ; 
		Action action = actionServiceImpl.getById(Integer.parseInt(id)) ; 
		
		List<Risque> rList = rServiceImpl.getAll() ; 
		model.addObject("rList" , rList); 
		model.addObject("action" , action); 
		return model ;
		
		
	}
	@RequestMapping(value = "/MenuAction", method = RequestMethod.GET)
	public ModelAndView Menuinf(){
		
		ModelAndView model = new ModelAndView("Process/actionMenu") ; 
		
		model.addObject("ListAdmin", actionServiceImpl.getAll());
		return model ;
		
		
	}
	@RequestMapping(value = "/ShowAction", params="newRecord" ,method = RequestMethod.GET)
	public ModelAndView addAcction(){
		
		ModelAndView model = new ModelAndView("Risk/actionAdd") ;
		List<Responsable> resps=utilisateurServiceImpl.getAllResp();
		List<Risque> rList = rServiceImpl.getAll() ; 
		model.addObject("rList" , rList); 
		return model ;
		
		
	}
	@RequestMapping(value = "/SeekAction", method = RequestMethod.GET)
    public @ResponseBody List<Action> seekAction() {
		
		List<Action> action = actionServiceImpl.getAll() ; 
		
		 
		List<Action> actionJs = new ArrayList<>()  ;
		for (Action a:action ){
			Action ac = new Action() ;
			ac.setBeginDate(a.getBeginDate());
			ac.setCreationDate(a.getCreationDate());
			ac.setEndDate(a.getEndDate());
			ac.setModificationDate(a.getModificationDate());
			ac.setLabel(a.getLabel());
			ac.setActionId(a.getActionId());
			ac.setStatus(a.getStatus());
			Processus pr = new Processus() ; 
			pr.setProcessus(a.getRisk().getProc().getProcessus());
			Risque r = new Risque() ; 
			r.setRisqueLabel(a.getRisk().getRisqueLabel());
			r.setProc(pr);
			ac.setRisk(r);
			actionJs.add(ac);
		}
		return actionJs ;
		
		}
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST)
	public ModelAndView validAct(@ModelAttribute Action action) throws ParseException{
		
		ModelAndView model = new ModelAndView("Process/actionMenu") ; 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String date = new Date().toString() ;
		action.setCreationDate(new Date()) ;
		action.setModificationDate(new Date());
		if(action.getRisk() != null){
			Risque r = rServiceImpl.getById(action.getRisk().getRisqueId()) ; 
			action.setRisk(r);
			Utilisateur user=r.getProc().getUser();
			
			action.setUser(user);
		}
		
		////////////tracabilite/////////////
		
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String role="";
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		
		
	Tracabilite trace=new Tracabilite();
	trace.setDate(new Date().toString());
	trace.setUser(myUser.getEmail());
	trace.setEntity("Action");
	trace.setOperation("Ajout");
	tracabiliteServiceImpl.persist(trace);
	/////////////////////////////////
		actionServiceImpl.save(action);
		model.addObject("ListAdmin", actionServiceImpl.getAll());
		return model ; 
		
		
	}
	
	@RequestMapping(value = "/editAction", method = RequestMethod.POST)
	public ModelAndView editAct(@ModelAttribute Action action) throws ParseException{
		Action ac = actionServiceImpl.getById(action.getActionId()) ; 
		ac.setBeginDate(action.getBeginDate());
		ac.setEndDate(action.getEndDate());
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		String date = new Date().toString() ;
		ac.setModificationDate(new Date());
		ac.setLabel(action.getLabel()); 
		ac.setRisk(action.getRisk());
		ac.setStatus(action.getStatus());
		if(action.getRisk() != null){
			Risque r = rServiceImpl.getById(action.getRisk().getRisqueId()) ; 
			action.setRisk(r);
		}
		if(action.getUser() != null) {
			Utilisateur u = utilisateurServiceImpl.getById(action.getUser().getEmail() ) ; 
			action.setUser(u );
		}
		ModelAndView model = new ModelAndView("Process/actionMenu") ; 
		model.addObject("ListAdmin", actionServiceImpl.getAll());
		actionServiceImpl.update(ac);
		
		
////////////tracabilite/////////////
		
	UserDetails user = (UserDetails) SecurityContextHolder.getContext()
			.getAuthentication().getPrincipal();
	String role="";
	Utilisateur myUser = new Utilisateur();
	myUser = utilisateurServiceImpl.getById(user.getUsername());
	
	
Tracabilite trace=new Tracabilite();
trace.setDate(new Date().toString());
trace.setUser(myUser.getEmail());
trace.setEntity("Action");
trace.setOperation("Modification");
tracabiliteServiceImpl.persist(trace);
/////////////////////////////////
		return model ; 
		
		
	}
	@RequestMapping(value = "/PersisteAction/{bDate}/{eDate}/{label}/{status}/{riskId}/", method = RequestMethod.GET)
    public @ResponseBody Boolean CheckRcode(@PathVariable("bDate") String bDate,@PathVariable("eDate") String eDate,@PathVariable("riskId") int rId,@PathVariable("label") String label , @PathVariable("status") int stat, HttpSession session) throws ParseException {
		Risque r = new Risque() ; 
		r= rServiceImpl.getById(rId) ; 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Action ac = new Action() ; 
		
		ac.setBeginDate(df.parse(bDate));
		ac.setEndDate(df.parse(eDate));
		ac.setCreationDate(new Date());
		ac.setModificationDate(new Date());
		ac.setStatus(stat);
		ac.setRisk(r);
		actionServiceImpl.persist(ac);
		return true ; 
		
    }
	@RequestMapping(value = "/updateAction/{bDate}/{eDate}/{label}/{status}/{riskId}/{acId}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("bDate") String bDate,@PathVariable("eDate") String eDate,@PathVariable("riskId") int rId,@PathVariable("label") String label , @PathVariable("status") int stat,@PathVariable("acId") int acId) throws ParseException {
		Action ac = actionServiceImpl.getById(acId) ; 
		Risque r = new Risque() ; 
		r= rServiceImpl.getById(rId) ; 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		ac.setBeginDate(df.parse(bDate));
		ac.setEndDate(df.parse(eDate));
		
		ac.setModificationDate(new Date());
		ac.setStatus(stat);
		ac.setRisk(r);
		actionServiceImpl.update(ac);
		return true ; 
		
    }
	@RequestMapping(value = "/deleteAdmin/{idAc}/", method = RequestMethod.GET)
    public @ResponseBody Boolean updateUser(@PathVariable("idAc") int id, HttpSession session) {
		
		Action user = new Action() ; 
		
		user = actionServiceImpl.getById(id);
		actionServiceImpl.delete(user);
		return true ; 
		
    }
	
	
	
	
	
	
	
	//excel
		@RequestMapping(value = "/ActionMenu", params = "excel", method = RequestMethod.GET)
		public void  getExcel(HttpServletResponse response,HttpSession session) throws IOException {
			
			
			
			List<Action> actions=actionServiceImpl.getAll();
			ModelAndView model = new ModelAndView(
					"Process/actionMenu");
			
		

			
		
			 XSSFWorkbook book = null;
			  
			  XSSFSheet mySheet = null;
			  
			  List<String> header=new ArrayList<String>();
			  
			  header.add("Label");
			  header.add("Risque");
			  header.add("Date Debut");
			  header.add("Date Fin");
			  header.add("Utilisateur");
			  
		 
			  
			    wb =  new SXSSFWorkbook(150);
			    sh = wb.createSheet("Sample sheet");
			  
			    CellStyle headerStle= getHeaderStyle();
			  
			    CellStyle normalStyle = getNormalStyle();
			  	int j=0;
			    for(int rownum = 0; rownum <= actions.size(); rownum++){
			        Row row = sh.createRow(rownum);
			      
			            
			  
			            if(rownum == 0)
			  
			            {
			  for(int i=0;i<6;i++)
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
						              String label=actions.get(j).getLabel();
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
						              String result=actions.get(j).getRisk().getRisqueLabel();
						              cell.setCellValue(result);
						              cell.setCellStyle(normalStyle);
			            	}
			            	catch (Exception e) {
								Cell cell = row.createCell(1);
								 cell.setCellValue("--");
					              cell.setCellStyle(normalStyle);
							}
			  
			            	try
			            	{
			            		Cell cell = row.createCell(2);
						              Date result=actions.get(j).getBeginDate();
						              cell.setCellValue(result);
						              cell.setCellStyle(normalStyle);
			            	}
			            	catch (Exception e) {
								Cell cell = row.createCell(2);
								 cell.setCellValue("--");
					              cell.setCellStyle(normalStyle);
							}
			   
			            	
			            	try
			            	{
			            		Cell cell = row.createCell(3);
						              Date result=actions.get(j).getEndDate();
						              cell.setCellValue(result);
						              cell.setCellStyle(normalStyle);
			            	}
			            	catch (Exception e) {
								Cell cell = row.createCell(3);
								 cell.setCellValue("--");
					              cell.setCellStyle(normalStyle);
							}
			   
			            	try
			            	{
			            		Cell cell = row.createCell(4);
						              String result=actions.get(j).getUser().getEmail();
						              cell.setCellValue(result);
						              cell.setCellStyle(normalStyle);
			            	}
			            	catch (Exception e) {
								Cell cell = row.createCell(4);
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
