package com.spring.biz.view.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	@RequestMapping("/insertBoard.do") //insertBoard.do 요청이 들어오면
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : " + vo);
		
		boardDAO.insertBoard(vo);

		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 수정");
		System.out.println("vo : " + vo);
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		
		System.out.println(">>> 게시글 삭제");
		System.out.println("vo : " + vo);
		
		boardDAO.deleteBoard(vo);	
		
		return "getBoardList.do";
	}
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model){

		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("vo : " + vo);
		
		BoardVO board = boardDAO.getBoard(vo);
		
		//mav.addObject("board", board);
		//mav.setViewName("getBoard.jsp");
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	//여러 요청에서 들어오면 배열 사용
	@RequestMapping("/getBoardList.do")
	public String getBoardList (BoardDAO boardDAO, Model model,
		@RequestParam(value = "searchCondition", defaultValue = "TITLE", required=false) // 받아오는 데이터 명
		String Condition,
		@RequestParam(value = "searchKeyword", defaultValue = "", required=false)
		// value : 받아오는 데이터 명, defaultValue : 기본 값 설정, required : false는 값 필수 x true는 값 필수 
		String Keyword)
		throws ServletException, IOException {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("Condition : " + Condition);
		System.out.println("Keyword : " + Keyword);

		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardDAO.getBoardList(Condition, Keyword);

		//mav.addObject("boardList", boardList); // Model에 데이터 저장
		//mav.setViewName("getBoardList.jsp"); // View 명칭 지정
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
}
