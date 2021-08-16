package com.scp.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scp.blog.model.User;
import com.scp.blog.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	// 스프링이 로그인을 가로챌때 username, password 변수 2개를 가로 채는데
	// password 부분 처리는 알아서 해준다.
	// 우리는 username 이 DB 에 있는지만 확인하면 된다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을수 없습니다.:"+username);
				});
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저 정보가 저장이 됨.
	}
	
}
