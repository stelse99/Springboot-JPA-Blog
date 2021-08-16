package com.scp.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scp.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	

}
