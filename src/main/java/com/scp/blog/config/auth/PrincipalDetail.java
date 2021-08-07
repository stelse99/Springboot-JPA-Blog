package com.scp.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.scp.blog.model.User;

import lombok.Getter;

// 스프링시큐리티가 로그인 요청을 가로채서 로그인을 진행후 완료 되면 UserDetails 타입의 오브잭트를
// 스프링시큐리티의 고유한 세션 저장소에 저장을 해준다.
@Getter
public class PrincipalDetail implements UserDetails{
	
	private User user; // 콤포지션:class 안에 품고 있는것

    public PrincipalDetail(User user) {
    	this.user=user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료 되지 않았는지 return 한다.(true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정이 잠겨 있지 않았는지 return 한다.(true:잠기지안음)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료 되지 않았는지 return 한다.(true:만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용가능) 인지 return 한다.(true:활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// 계정이 가지고 있는 권한을 return 한다.
	// (권한이 여러개 있을수 있어서 루프를 돌려야 하지만 여기선 그냥 1개만 처리함.)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		// 람다식
		collectors.add(()->{
			return "ROLE_"+user.getRole();
		});
		
		//전통적인 방식
//		collectors.add(new GrantedAuthority() {
//			@Override
//			public String getAuthority() {
//				return "ROLE_"+user.getRole(); // ROLE_USER
//			}
//		});
	
		return collectors;
	}

}
