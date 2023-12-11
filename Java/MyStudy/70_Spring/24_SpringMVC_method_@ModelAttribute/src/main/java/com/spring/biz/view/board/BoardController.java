package com.spring.biz.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	// 메소드 선언부에 선언된 @ModelAttribute는 리턴된 데이터를 VIEW에 전달
	// @ModelAttribute선언된 메소드는 @RequestMapping 메소드보다 먼저 실행 됨
	// 뷰에 전달될 때 설정된 명칭(예 : conditionMap)
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		System.out.println("===> Map searchConditionMap() 실행");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
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
	public String getBoardList(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">>> 게시글 전체 목록 보여주기");
		System.out.println("vo : " + vo);
		
		//List<BoardVO> boardList = boardDAO.getBoardList();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		//mav.addObject("boardList", boardList); //Model에 데이터 저장
		//mav.setViewName("getBoardList.jsp"); // View 명칭 저장
		
		model.addAttribute("boardList", boardList); //Model에 데이터 저장
		
		return "getBoardList.jsp";
	}
}
