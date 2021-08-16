package com.scp.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scp.blog.model.RoleType;
import com.scp.blog.model.User;
import com.scp.blog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword(); // 123 원문
		String encPassword = encoder.encode(rawPassword); // 해쉬
		
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	//전통적인 로그인 방식
//	@Transactional()
//	public User 로그인(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
}
