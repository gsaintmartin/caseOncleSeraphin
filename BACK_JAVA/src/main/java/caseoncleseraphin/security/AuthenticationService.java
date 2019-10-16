package caseoncleseraphin.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthenticationService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO: Le but -> Chercher les users et leur rôle/leurs droits dans la base de données
		// Il faut créer les entités Role et Right et faire le mapping nécessaire :
		// User--1,1--(possède)--0,n--Role--0,n--(permet)--0,n--Right
		// En attendant, on met des trucs à l'arrache pour pouvoir tester.
		if (username.equals("ADMIN")) {
			List<GrantedAuthority> rights = new ArrayList<>();
			return new User("user", passwordEncoder.encode("password"), rights);
			
			
			
		} else if (username.equals("CUSTOMER")) {
			List<GrantedAuthority> rights = new ArrayList<>();
			rights.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin", passwordEncoder.encode("password"), rights);
		}
		return null;
	}

}
