package com.spring.biz.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;

/* 
@SessionAttributes : 같은 컨트롤러에서 모델객체 공유해서 사용(session)
	단, 현재(동일) 컨트롤러에서만 사용 가능
	사용완료되면 SessionStatus 객체의 setComplete() 메소드 사용해서 해제
@SessionAttribute : HttpSession 에 데이터 저장 및 읽기
*/
@Controller
@SessionAttributes("board")
public class BoardController {
	
	// 메소드 선언부에 선언된 @ModelAttribute 는 리턴된 데이터를 VIEW 에 전달
	// @ModelAttribute 선언된 메소드는 @RequestMapping 메소드보다 먼저 실행
	// 뷰에 전달될 때 설정된 명칭(예: conditionMap)
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		System.out.println("====> Map searchConditionMap() 실행");
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	//리턴타입 : ModelAndView ---> String
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println(">>> 게시글 상세 보여주기");
		System.out.println("vo : " + vo);

		BoardVO board = boardDAO.getBoard(vo);
		System.out.println("board : " + board);
		
//		mav.addObject("board", board);
//		mav.setViewName("getBoard.jsp");
		
		model.addAttribute("board", board); //Model 객체 사용 View로 데이터 전달
		
		return "getBoard.jsp";
	}
	
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
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 입력");
		System.out.println("vo : " + vo);
		
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	// @ModelAttribute("board") : @SessionAttributes 설정으로 존재하는 "board" 데이터 사용
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		System.out.println(">>> 게시글 수정");
		System.out.println("vo : " + vo);
		
		boardDAO.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO, SessionStatus sessionStatus) {
		System.out.println(">>> 게시글 삭제");
		System.out.println("vo : " + vo);
		
		boardDAO.deleteBoard(vo);
		sessionStatus.setComplete();
		
		return "getBoardList.do";
	}
}
