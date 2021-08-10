package com.scp.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scp.blog.model.Board;
import com.scp.blog.model.User;
import com.scp.blog.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void 글쓰기(Board board, User user) {
		board.setUser(user);
		board.setCount(0);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable){ 
		return  boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id) {
		return boardRepository
				.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글상세보기 실패:아이디를 찾을수 없습니다.");
				});
	}
	
	@Transactional
	public void 글삭제하기(int id) {
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard) {
		Board board = boardRepository
				.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글찾기 실패:아이디를 찾을수 없습니다.");
				}); // 영속화 완료
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시(Service 종료시) 트랜잭션이 종료됨. 이때 더티 체킹-자동 업데이트가 DB 로 flush 즉 commit 됨.
	}

}
