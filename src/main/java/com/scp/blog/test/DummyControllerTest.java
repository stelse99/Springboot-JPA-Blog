package com.scp.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scp.blog.model.RoleType;
import com.scp.blog.model.User;
import com.scp.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired
	private UserRepository userRepository;

	// {id} 주소로 파라메터를 전달받을수 있다.
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
//		 user/3 을 찾으면 내가 db 에서 못찾을경우 user 가 null 이 될것 아냐?
//		 그럼 return 할때 null 이 return 되잖아.. 그럼 프로그램에 문제가 있지 않겠니?
//		 Optional 로 너의 User 객체를 감싸서 가져 올테니 null 인지 아닌지는 너가 판단해서 return 해!!!
//       아래 3 가자 방법이 있다.
//		 1) null 절대 없을경우 처리방법. 요건 좀 위험 하다.
//		 User user = userRepository.findById(id).get();
//		
//		 2) null 인경우 객체를 생성 해서 return 방식.
//		 User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			 @Override
//			 public User get() {
//				 // TODO Auto-generated method stub
//				 return new User();
//			 }
//		 });
//		
//		 3) Throw IllegalArgumentException
//		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//			@Override
//			public IllegalArgumentException get() {
//				// TODO Auto-generated method stub
//				return new IllegalArgumentException("해당 유져는 없습니다. id:" + id);
//			}
//		});
		
//		4) 람다식
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 유져는 없습니다. id:" + id);
		});

		//스프링 부트는 응답시 MessageConverter 가 
		//자동으로 Jackson lib 를 호출해서 user 객체를 
		//json 으로 변환해서 브라우져로 return 해준다.
		return user;
	}

	// http://localhost:8000/blog/dummy/join (요청)
	// http body 에 username, password, email 데이타를 가지고 요청.
	@PostMapping("/dummy/join")
	// public String join(String username, String password, String email) { //
	// key=value (약속된규칙)
	public String join(User user) {
		System.out.println("id:" + user.getId());
		System.out.println("username:" + user.getUsername());
		System.out.println("password:" + user.getPassword());
		System.out.println("email:" + user.getEmail());
		System.out.println("email:" + user.getRole());
		System.out.println("email:" + user.getCreateDate());

		user.setRole(RoleType.USER);
		userRepository.save(user);

		return "회원가입이 완료 되었어요.";
	}

}
