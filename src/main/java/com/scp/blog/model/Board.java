package com.scp.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량데이타
	private String content; // 썸머노트 라이브러리 <html> 테그가 섞여서 디자인됨.
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne  // Many=Board, One=User
	@JoinColumn(name="userId")
	private User user; // DB 는 오브젝트를 저장할수 없다.FK, 자바는 오브젝트를 저장할수 있다. 
	
	@CreationTimestamp
	private Timestamp createDate;
		

}
