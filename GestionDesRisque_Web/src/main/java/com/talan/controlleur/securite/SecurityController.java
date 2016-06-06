package com.talan.controlleur.securite;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;

import com.talan.entities.Processus;
import com.talan.entities.Utilisateur;
import com.talan.service.ActionService;
import com.talan.service.AlerteService;
import com.talan.service.ProcessService;
import com.talan.service.RisqueService;
import com.talan.service.UtilisateurService;



@Controller

public class SecurityController {
@Autowired
UtilisateurService utilisateurServiceImpl;
@Autowired
AlerteService alerteServiceImpl;
@Autowired
RisqueService risqueServiceImpl;
@Autowired
ActionService actionServiceImpl;
@Autowired
ProcessService processServiceImpl;

	
	public HttpSession session(HttpServletRequest request){

		HttpSession session=request.getSession();  
        System.out.println(session.getId());
        UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        Utilisateur myUser = new Utilisateur() ;
        myUser = utilisateurServiceImpl.getById(user.getUsername());
        session.setAttribute("user", myUser.getEmail());
        return session;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpSession session) {
		ModelAndView model=new ModelAndView();
		UserDetails user = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		Utilisateur myUser = new Utilisateur();
		myUser = utilisateurServiceImpl.getById(user.getUsername());
		model.addObject("firstname", myUser.getFirstName());
		model.addObject("lastname", myUser.getLastName());
		 model.addObject("nombreAlerte", alerteServiceImpl.getAllAction().size()+alerteServiceImpl.getAllAction().size());
		UserDetails userr = (UserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
        Utilisateur myUserx = new Utilisateur() ;
        myUserx = utilisateurServiceImpl.getById(userr.getUsername());
        session.setAttribute("user", myUserx.getEmail());
		
	
       
		model.setViewName("index");
		List<Processus> proc = processServiceImpl.getAll() ; 
		model.addObject("procs",proc );
		model.addObject("TotalAction", actionServiceImpl.getAll().size());
		model.addObject("TotalRisk", risqueServiceImpl.getAll().size());
		model.addObject("TotalUser", utilisateurServiceImpl.getAll().size());
		model.addObject("TotalProc", processServiceImpl.getAll().size());
		return model;
		}

	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(ModelMap model,@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		 
		if (error != null) {
			model.addAttribute("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
		
			HttpSession session=request.getSession();  
            session.invalidate();


	
		
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		
		//model.setViewName("Supplier");

		return "login";

	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
                @RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout, 
                HttpServletRequest request) {


ModelAndView model = new ModelAndView();
		if (error!=null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));

		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	
	

	
	
	
	
	

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid username and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid username and password!";
		}

		return error;
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}
	
	

	
	
}
