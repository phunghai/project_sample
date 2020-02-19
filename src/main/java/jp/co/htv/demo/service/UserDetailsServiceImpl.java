package jp.co.htv.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.htv.demo.entity.Authority;
import jp.co.htv.demo.repository.UserRepository;

/**
 * A custom service for spring security
 * @author Nguyen Phung Hai
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		jp.co.htv.demo.entity.User appUser = userRepository.findByEmail(username);
		
	    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
	    for (Authority authority: appUser.getAuthority()) {
	    	GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
            grantList.add(grantedAuthority);
	    }
	    
	    UserDetails user = (UserDetails) new User(appUser.getEmail(), appUser.getPassword(), grantList);
		return user;
	}

}
