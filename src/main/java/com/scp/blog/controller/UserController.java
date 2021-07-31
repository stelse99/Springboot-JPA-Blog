package com.scp.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	// 전통방식
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
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
}
