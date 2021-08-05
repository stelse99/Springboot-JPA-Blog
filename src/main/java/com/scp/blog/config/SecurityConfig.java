package com.scp.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.scp.blog.config.auth.PrincipalDetail;
import com.scp.blog.config.auth.PrincipalDetailService;

@Configuration // 빈등록(IoC관리)
@EnableWebSecurity // 시큐리티 필터등록=스프링 시큐리티가 활성화 되어 있는데 어떤설정을 해당 파일에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정주소로 접근을 하면 권한 및 인증을 미리 체크 하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	// 시큐리티가 대신 로그인 해주는데 password 를 가로채기를 하는데
	// 해당 password 가 뭘로 해쉬가 되어 회원 가입이 되었는지 알아야
	// 같은 해쉬로 암호화 해서 DB 에 있는 해쉬와 비교 할수 있음.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(principalDetailService)
			.passwordEncoder(encodePWD())
			;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() //csrf token 비활성화(테스트시 걸어주는게 좋다.)
			.authorizeRequests()
				//.antMatchers("/auth/loginForm", "/auth/joinform")
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/loginForm")
				.loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 요청시 가로 체서 대신로인 해준다.
				.defaultSuccessUrl("/") // 정상 요청이 완료된경우
				//.failureUrl("/fail") // 실패인경우
				
				;
	}
	
	
}
