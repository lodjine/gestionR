package com.talon.controlleur.securite;






import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.talon.entities.UserRole;
import com.talon.entities.Utilisateur;
import com.talon.service.UtilisateurService;




@Service(value="myUserDetailsService")

public class MyUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UtilisateurService userDao;

 
	
	
	




	// Converts UniQ.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(Utilisateur user, 
		List<GrantedAuthority> authorities) {
		
		
		return new User(user.getEmail(), 
			user.getPwd(), user.isEnabled(), 
                        true, true, true, authorities);
	}
 
	
	
	
	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
 
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
 
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
 
		return Result;
	}
 


	public UserDetails loadUserByUsername(final String username) 
            throws UsernameNotFoundException {
		 
		
		
		
		Utilisateur user = userDao.getById(username);
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = buildUserAuthority((Set<UserRole>) user.getUserRole());

		return buildUserForAuthentication(user, authorities);


	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
