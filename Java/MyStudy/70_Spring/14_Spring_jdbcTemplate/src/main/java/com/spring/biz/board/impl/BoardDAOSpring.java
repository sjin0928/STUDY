package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	//@Autowired //필드에 @Autowired 설정으로 다이렉트 주입
	private JdbcTemplate jdbcTemplate;
	
	//SQL 문장
		private final String BOARD_INSERT
		 	= "INSERT INTO BOARD (SEQ, TITLE, WRITER, CONTENT)"
		 		+ "VALUES ((SELECT NVL(MAX(SEQ),0) + 1 FROM BOARD), ?, ?, ?)";
		
		private final String BOARD_UPDATE
			= "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ?";
		
		private final String BOARD_DELETE
			= "DELETE FROM BOARD WHERE SEQ = ?";

		private final String BOARD_GET
			= "SELECT * FROM BOARD WHERE SEQ = ?";
		
		private final String BOARD_LIST
			= "SELECT * FROM BOARD ORDER BY SEQ DESC";
		
		public BoardDAOSpring() {
			System.out.println(">> BoardDAOSpring() 객체 생성");
		}
		@Autowired // 생성자에 @Autowired 설정해서 의존주입 (DI) 처리 
		public BoardDAOSpring(JdbcTemplate jdbcTemplate) {
			System.out.println(">> BoardDAOSpring(jdbcTemplate) 객체 생성");
			System.out.println("jdbcTemplate : " + jdbcTemplate);
			this.jdbcTemplate = jdbcTemplate;
		}
		// 글입력
		public void insertBoard(BoardVO vo) {
			System.out.println("SpringJDBC로 insertBoard() 실행");
			//insert 메소드 없음 전부 update (int값 반환됨)
			//1. jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
			//2. 배열 만들어서 입력
			Object[]args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
			jdbcTemplate.update(BOARD_INSERT, args);
		}
		// 글수정
		public void updateBoard(BoardVO vo) {
			System.out.println("SpringJDBC로 updateBoard() 실행");
//			Object[]args = {vo.getTitle(), vo.getContent(), vo.getSeq()};
//			jdbcTemplate.update(BOARD_UPDATE, args);
			jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
		}
		//글삭제
		public void deleteBoard(BoardVO vo) {
			System.out.println("SpringJDBC로 deleteBoard() 실행");
			jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
		}
		//게시글 1개 조회
		public BoardVO getBoard(BoardVO vo) {
			System.out.println("SpringJDBC로 getBoard() 실행");
			// 데이터의 나열은 끝에 자리에서만 가능하므로 배열만들어 입력해주기
			// mapper 클래스로 만들어서 입력
			Object[] args = {vo.getSeq()};
			return jdbcTemplate.queryForObject(BOARD_GET, args, new BoradRowMapper());
			
		}
		//리스트 조회
		public List<BoardVO> getBoardList() {
			System.out.println("SpringJDBC로 getBoardList() 실행");
			return jdbcTemplate.query(BOARD_LIST, new BoradRowMapper());
		}
}
