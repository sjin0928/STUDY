package com.spring.biz.view.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

//@Controller
@RestController // 클래스 내의 요청처리 결과가 모두 @ResponseBody 처리됨
public class BoardAjaxController {
	@Autowired
	private BoardService boarderService;
	
	@RequestMapping("/getJasonBoardList.do")
	// 응답객체의 바디영역에 return 값 응답
	//@ResponseBody // response 응답 객체의 몸체 (body)에 데이터 전달
	public List<BoardVO> getAjaxBoardList(BoardVO vo) {
		System.out.println("==== BoardAjaxController.getAjaxBoardList() 실행~");
		
		List<BoardVO> boardList = boarderService.getBoardList(vo);
		System.out.println("boardList : " + boardList);
 		
		return boardList;
	}
	@RequestMapping("/getJasonBoard.do")
	@ResponseBody
	// post 방식으로 처리시 어노테이션 @RequestBody 추가
	//@RequestBody post 방식 전달데이터 처리
	public BoardVO getAjaxBoard(@RequestBody BoardVO vo) { //@RequestBody post 방식 전달데이터 처리
		System.out.println("=== BoardAjaxController.getAjaxBoard() 실행");
		System.out.println("getAjaxBoard() vo : " + vo);
		BoardVO board = boarderService.getBoard(vo);
		System.out.println("board : " + board);
		
		return board;
	}
}
