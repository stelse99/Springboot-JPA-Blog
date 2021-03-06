package com.scp.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scp.blog.dto.ResponseDto;
import com.scp.blog.model.Board;
import com.scp.blog.model.User;
import com.scp.blog.service.UserService;

@RestController
public class UserApiController {
	 
	@Autowired
	private UserService userService;
	
	// 전통적인방식의 로그인 방식
//	@Autowired
//	private HttpSession session;
	
		
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController::save 호출됨");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

	// 전통적인방식의 로그인 방식
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
//		System.out.println("UserApiController::login 호출됨");
//		User principal = userService.로그인(user); //principal: 접근주체
//		
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//	}
	
	
}
