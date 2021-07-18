package com.scp.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자요청 --> 응답(Data)
@RestController
public class HttpControllerTest {
	
	// http://localhost:8080/http/get (select)
	@GetMapping("http/get")
	//public String getTest(@RequestParam int id, @RequestParam String username) {
	public String getTest(Member m) {
		return "get 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)
	@GetMapping("http/post")
	public String postTest(Member m) {
		return "post 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	// http://localhost:8080/http/put (update)
	@GetMapping("http/put")
	public String putTest() {
		return "put 요청";
	}

	// http://localhost:8080/http/delete (delete)
	@GetMapping("http/delete")
	public String deleteTest() {
		return "delete 요청";
	}


}
