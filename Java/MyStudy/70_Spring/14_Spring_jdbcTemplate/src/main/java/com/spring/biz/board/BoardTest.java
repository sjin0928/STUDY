package com.spring.biz.board;

import java.util.List;

import com.spring.biz.board.impl.BoardDAO;
import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

public class BoardTest {

	public static void main(String[] args) {
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트2");
		vo.setWriter("홍길동2");
		vo.setContent("테스트2-내용");
		
		BoardDAO dao = new BoardDAO();
		
		//dao.insertBoard(vo);
		
		
		vo.setSeq(2);
		vo.setTitle("테스트2-수정");
		vo.setContent("테스트2-수정");
		dao.updateBoard(vo);
		
		BoardVO board = dao.getBoard(vo);
		
		System.out.println("board : " + board);
		
		//dao.deleteBoard(vo);
		List<BoardVO> list = dao.getBoardList();
		for (BoardVO boardvo : list) {
			System.out.println(boardvo);
		}
		
		//
		UserVO user = new UserVO();
		user.setId("test");
		user.setPassword("test");
		
		UserDAO userdao = new UserDAO();
		
		userdao.getUser(user);
	}

}
