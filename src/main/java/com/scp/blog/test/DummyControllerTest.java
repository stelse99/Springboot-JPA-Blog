package com.scp.blog.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {
	
	// http://localhost:8000/blog/dummy/join (요청)
	// http body 에 username, password, email 데이타를 가지고 요청.
	@PostMapping("/dummy/join")
	public String join(String username, String password, String email) { // key=value (약속된규칙)
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("email:"+email);
		
		return "회원가입이 완료 되었어요.";
	}

}
