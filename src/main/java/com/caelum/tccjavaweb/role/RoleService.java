package com.caelum.tccjavaweb.role;

import com.caelum.tccjavaweb.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RoleService  {
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

//	@PostConstruct
//	protected void initialize() {
//		save(new Role("ROLE_USER"));
//		save(new Role("ROLE_ADMIN"));
//
//	}

	@Transactional
	public Role save(Role role) {
		roleRepository.save(role);
		return role;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Account account = roleRepository.findOneByEmail(username);
//		if(account == null) {
//			throw new UsernameNotFoundException("user not found");
//		}
//		return createUser(account);
//	}
	
	public void signin(Account account) {
		SecurityContextHolder.getContext().setAuthentication(authenticate(account));
	}
	
	private Authentication authenticate(Account account) {
		return new UsernamePasswordAuthenticationToken(createUser(account), null, Collections.singleton(createAuthority(account)));
	}
	
	private User createUser(Account account) {
		return new User(account.getEmail(), account.getPassword(), Collections.singleton(createAuthority(account)));
	}

	private GrantedAuthority createAuthority(Account account) {
		return new SimpleGrantedAuthority(account.getRole());
	}

}
