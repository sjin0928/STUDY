package com.spring.biz.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	//여러 요청에서 들어오면 배열 사용
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList (BoardDAO boardDAO, ModelAndView mav)
			throws ServletException, IOException {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		//1. 게시글 목록 조회(SELECT)
//		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();
		
		//2. 검색 결과를 세션에 저장하고
		//request.getSession().setAttribute("boardList", boardList);
		
		//3. 목록 화면으로 이동
		//response.sendRedirect("getBoardList.jsp");
		
		//return "getBoardList";
		//ModelAndView 는  데이터 view 저장 가능 // 명칭 지정 없이 데이터 넘기면 맨앞글자 소문자로 지정됨
//		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model에 데이터 저장
		mav.setViewName("getBoardList.jsp"); // View 명칭 지정
		
		return mav;
	}

}
