package com.scp.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.scp.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤러에서는 세션을 어떻게 찾는지?
		// /WEB-INF/views/index.jsp
		System.out.println("로그인 사용자 id:"+principal);
		return "index";
	}

}
