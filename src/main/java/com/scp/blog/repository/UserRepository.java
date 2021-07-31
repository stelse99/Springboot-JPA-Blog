package com.scp.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.blog.model.User;

// DAO
// 자동으로 Bean 등록이 된다.
//@Repository 생략 가능 하다.
public interface UserRepository extends JpaRepository<User, Integer> {
	// JPA Naming 쿼리
	// select * from user where username = ? and password = ?
	User findByUsernameAndPassword(String username, String password);
	
//	@Query(value="select * from user where username = ?1 and password = ?2", nativeQuery = true)
//	User login(String username, String password);
	
}
