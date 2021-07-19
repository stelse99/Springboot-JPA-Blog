package com.scp.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		// prefix: /WEB-INF/views
		// suffix: .jsp
		return "test";
	}
}
