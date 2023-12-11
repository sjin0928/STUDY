package com.spring.biz.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {
	@RequestMapping("/insertBoard.do") //insertBoard.do 요청이 들어오면
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : " + vo);
		
		boardDAO.insertBoard(vo);

		return "getBoardList.do";
	}

}
