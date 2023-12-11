package com.mystudy.list5_list_vo;

import java.util.List;

/*
성적처리를 위한 관리용 클래스를 생성 CRUD 기능을 구현하고 확인하시오
(학생 정보를 List에 저장하고 관리하되 이름은 중복되지 않는다)  
■ 클래스명 : StudentListManager
■ 속성(필드변수) : StudentVO 저장을 위한 List
■ 기능(메소드)
  - select : StudentVO 타입 데이터를 전달받아 동일한 이름 데이터를 찾아서 리턴
  - select : 이름(String)을 전달받아 동일한 이름 데이터 찾아서 리턴
  - selectAll : 전체 데이터 리턴
  - insert : StudentVO 타입 데이터를 전달받아 List에 추가
  - update : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 수정
  - updateKor : 이름(String), 국어점수를 전달받아 동일한 이름 데이터 수정
  - delete : StudentVO 타입 데이터를 전달받아 List에서 동일데이터 찾아서 삭제
  - delete : 이름(String)을 전달받아 동일한 이름 데이터 삭제
*/

	
public class StudentListManager {
	
	private List<StudentVO> list;
	public List<StudentVO> selectAll() {
		return null;
	}
	
	StudentVO a;
	
	public String select(StudentVO a) {
		for(StudentVO vo : list) {
			if(vo.getName().equals(a.getName())) {
				return vo.getName();
			}else {
				return "데이터 없음";
			}
		}
		return null;
		
		
	}
	
	
	
}
