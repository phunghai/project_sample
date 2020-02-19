package jp.co.htv.demo.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jp.co.htv.demo.entity.Authority;
import jp.co.htv.demo.entity.User;
import jp.co.htv.demo.repository.AuthorityResository;
import jp.co.htv.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityResository authorityRespository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		
		Authority userAuthority = authorityRespository.findByAuthority("ROLE_ADMIN");
		user.setAuthority(new HashSet<Authority>(Arrays.asList(userAuthority)));
		userRepository.save(user);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User findUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
