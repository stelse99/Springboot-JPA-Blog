package com.scp.blog.test;

import org.testng.annotations.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {

	@Test
	public void 해쉬_암호화() {
		String encPassword=new BCryptPasswordEncoder().encode("1234");
		System.out.println("1234 암호화"+encPassword);
	}
}
