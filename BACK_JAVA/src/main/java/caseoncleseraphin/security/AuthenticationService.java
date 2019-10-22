package caseoncleseraphin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import caseoncleseraphin.service.UserService;

public class AuthenticationService implements UserDetailsService {

	
	
	
	@Autowired
	
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		
	         userService.findByUsername(username);
	        UserBuilder builder = null;
	        if (userService.findByUsername(username) != null) {
	          builder = org.springframework.security.core.userdetails.User.withUsername(username);
	          builder.password(new BCryptPasswordEncoder().encode(userService.findByUsername(username).getPassword()));
	          builder.roles(userService.findByUsername(username).getRole().getName());
	        } else {
	          throw new UsernameNotFoundException("User not found.");
	        }
	        return builder.build();
}
}
