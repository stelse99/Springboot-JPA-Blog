package com.scp.blog.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@DynamicInsert // 인서트시에 null 인경우 제외처리
@Entity // User 클래스가 MySql 에 테이블이 생성이 된다.
public class User {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에 연결된 db 의 넘버링 전략을 따라간다. 
	private int id;
	
	@Column(nullable = false, length = 30, unique = true)
	private String username;
	
	@Column(nullable = false, length = 100)  // 해시로 암호화 해야 하기때문에
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//@ColumnDefault("'user'")
	// DB 는 RoleType 없다. 
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum 을 사용 하는게 좋다.(ADMIN, USER, MANAGER)
	
	@CreationTimestamp // 시간이 자동으로 입력
	private Timestamp createDate;

}
