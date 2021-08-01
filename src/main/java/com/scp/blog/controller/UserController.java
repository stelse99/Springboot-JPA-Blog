package com.scp.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//인증이 안된 사용자들이 출입 할수 있는 경로를 /auth/** 허용
//그냥 주소가 / 이면 index.jsp 허용
//static 이하에 있는 /js/**, /css/**, /image/** 허용


@Controller
public class UserController {
	// 전통적인 로그인 방식
//	@GetMapping("/user/joinForm")
//	public String joinForm() {
//		return "user/joinForm";
//	}
//	
//	@GetMapping("/user/loginForm")
//	public String loginForm() {
//		return "user/loginForm";
//	}
	
	// Security 방식
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
}
