package com.mystudy.list3_linkedlist;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_Exam {

	public static void main(String[] args) {
		// LinkedList : List 속성 (List 인터페이스 구현체)
		// list 제공 메소드 사용 가능 // list 외의 것은 다른 인터페이스에서 온 기능
		// 맨앞추가 맨뒤추가 메소드도 있음
		// offer, peek...
		// 연결정보를 가지고 데이터를 연결한 방식
		// 데이터를 삽입시 각 데이터가 연결되어 있는 연결정보를 끊고 다시 연결 뒷번호의 연결정보는 바뀜
		// 원형구조로도 만들수 있음
		// 링크에 저장된 데이터 삭제시 데이터는 삭제되지않고 연결정보만 끊는 방식
		// ArrayList보다 데이터의 맨앞에 끼워넣기 중간데이터 삭제가 시간이 덜걸린다.
		
		LinkedList<String> list = new LinkedList<String>();
		//List<String> list = new LinkedList<String>();
		list.add("홍길동"); // 0번 인덱스
		list.add("홍길동"); // 1번 인덱스
		list.add("김유신"); // 2번 인덱스
		System.out.println("list : " + list);
		// list타입 보다 메소드가 많다!
		
		list.remove("홍길동");
		System.out.println("list : " + list);
		
		String str = "홍길동,홍길동,강감찬,을지문덕,홍경래,김유신,홍길동";
		String[] names = str.split(",");
		// split 구분자 기준으로 배열 생성
		
		// 배열에 있는 데이터를 리스트에 추가
		System.out.println("names : " + Arrays.toString(names));
		for (int i = 0; i < names.length; i++) {
			list.add(names[i]);
		}
		System.out.println("list : " + list);
		
		// list : [홍길동, 김유신, 홍길동, 김유신, 강감찬, 을지문덕, 홍경래, 김유신, 홍길동]
		// --------------
		// (실습) 리스트에 있는 데이터 변경하기
		// 1. 홍길동 : 모두 삭제(Delete)
		// 2. 김유신 -> 김유신2 모두 수정 (Update)
		// ---------------
		
		System.out.println();
		//for문 사용
		// 1. 홍길동 : 모두 삭제(Delete)
		System.out.println("== for문 사용");
		for (int i = 0; i < list.size(); i++) {
			list.remove("홍길동");	
		}
		System.out.println("1. 홍길동 삭제 : " + list + "\n");
		
		// 2. 김유신 -> 김유신2 모두 수정 (Update)
		for (int i = 0; i < list.size(); i++) {
			int num = list.indexOf("김유신");
			if(list.contains("김유신")){
				//list.remove("김유신");
				//list.add(num, "김유신2");
				list.set(num, "김유신2");
			}
		}
		System.out.println("2. 김유신 -> 김유신2 모두 수정 " + list);
		System.out.println();
		
		str = "홍길동,김유신,홍길동,김유신,강감찬,을지문덕,홍경래,김유신,홍길동";
		names = str.split(",");
		LinkedList<String> list1 = new LinkedList<String>();
		
		for (int i = 0; i < names.length; i++) {
			list1.add(names[i]);
		}
		System.out.println("list1 : " + list1);
		
		// 1. 홍길동 : 모두 삭제(Delete)
		System.out.println("== while + contains 사용");
		while (list1.contains("홍길동")) {
			list1.remove("홍길동");
		}
		System.out.println("1. 홍길동 삭제 : " + list1);

		System.out.println();
		
		// while + contains 사용
		// 2. 김유신 -> 김유신2 모두 수정 (Update)
		while (list1.contains("김유신")) {
			list1.set(list1.indexOf("김유신"), "김유신2");
		}
		
		System.out.println("2. 김유신 -> 김유신2 모두 수정 " + list1);

// 수업내용		
		System.out.println("\n== 수업내용 ===\n");

		str = "홍길동,김유신,홍길동,김유신,강감찬,을지문덕,홍경래,김유신,홍길동";
		names = str.split(",");
		LinkedList<String> list2 = new LinkedList<String>();
		for (int i = 0; i < names.length; i++) {
			list2.add(names[i]);
		}
		System.out.println("list2 : " + list2);

		System.out.println("=== 김유신 ---> 김유신2 모두 수정 =====");
		for (int i = 0; i < list2.size(); i++) {
			if ("김유신".equals(list2.get (i))) {
				System.out.println(i + " : " + list2.get(i));
				list2.set(i,  "김유신2");
			}
		}
		System.out.println("김유신 수정후 : " + list2);
		System.out.println();
		
		// 1. 홍길동 : 모두 삭제(Delete)
		// 리스트 내에 있는 데이터 한개 삭제하는 순간 총 데이터의 길이가 변경됨
		System.out.println("홍길동 삭제전 : " + list2);
		/* 뒤에서 부터 검색하여 삭제
		int size = list2.size();
		int lastIdx = list2.size() -1;
		for (int i = lastIdx; i >= 0; i--) {
			System.out.println(i + " - size : " + list2.size());
			if ("홍길동".equals(list2.get (i))) {
				System.out.println(i + " : " + list2.get(i));
				//list2.remove(i);
			}
		}
		-----------------------------*/
		
		
		//System.out.println("list2.remove(\"홍길동\") : " + list2.remove("홍길동"));
		//System.out.println("list2.remove(\"ABC\") : " + list2.remove("ABC"));
		// 처리가 되면 true, 안되면 false 값 내놓음
		
		/* 찾아서 삭제할 수 없을 때까지 반복
		//while (list2.remove("홍길동")) {}
		while (true) {
			boolean removeSuccess = list2.remove("홍길동");
			if(!removeSuccess) { // 삭제 실패시
				break;
			}
		}
		*/
		System.out.println("list2.indexOf(\"홍길동\") : " + list2.indexOf("홍길동"));
		System.out.println("list2.indexOf(\"ABC\") : " + list2.indexOf("ABC"));

		while (true) {
			int idx = list.indexOf("홍길동");
			if (idx == -1) { // 데이터가 있냐?
				System.out.println(">> 삭제 완료(작업끝)");
				break;
			}
			
		}
		System.out.println();
		
		System.out.println("홍길동 삭제후 : " + list2);
		
		// 2. 김유신 -> 김유신2 모두 수정 (Update)
//		for (int i = 0; i < list.size(); i++) {
//		if ("김유신" == list.get (i)) {
//			System.out.println(i + " : " + list.get(i));
//			}
//		} => 주소값 달라서 데이터 안나옴
		


	}

}
