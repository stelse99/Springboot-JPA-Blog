package com.scp.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자요청 --> 응답(Data)
@RestController
public class HttpControllerTest {
	
	private static final String TAG="HttpControllerTest:";
	
	@GetMapping("http/lombok")
	public String lombokTest() {
		// build pattern 은 순서와 상관 없다.
		Member m = Member.builder().username("suchang").email("suchang@naver.com").password("1234").build();
		System.out.println(TAG+"getter: "+ m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"getter: "+ m.getUsername());
				
		return "lombok test complete.";
	}
	
	
	// http://localhost:8080/http/get (select)
	@GetMapping("http/get")
	//public String getTest(@RequestParam int id, @RequestParam String username) {
	public String getTest(Member m) {
		return "get 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("http/post") // text/plain, application/json  
	//public String postTest(String text) { 
	//public String postTest(@RequestBody String text) {
	public String postTest(@RequestBody Member m) { 
		// MessageConverter(스프링부트) 가 자동 매핑 수행 한다.
		return "post 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	// http://localhost:8080/http/put (update)
	@PutMapping("http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}

	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청:"+m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}


}
