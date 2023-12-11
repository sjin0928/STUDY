package com.mystudy.set1_hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSet_Exam {

	public static void main(String[] args) {
		// HashSet : set 인터페이스 구현한 구현체(클래스)
		// 중복데이터가 없음(동일데이터는 1개만 저장), 순서가 없다 
		// ------------------------------
		// Set에서 동일데이터 여부 확인 hashCode(), equals()값 확인
		// 1. 해시코드값 확인 : hashCode()
		// 2. equals() 메소드 결과값이 모두 일치하면 동일 데이터 처리
		HashSet<String> set = new HashSet<String>();
		set.add("홍길동"); 
		set.add("김유신");
		set.add("홍길동"); // 데이터주소는 다르나 저장은 1개만 됨
		set.add(new String("홍길동"));
		
		System.out.println("set : " + set);
		System.out.println("set.size() : " + set.size());
		System.out.println("\"홍길동\".hashCode() : " + "홍길동".hashCode());
		System.out.println("new String(\"홍길동\") : " + new String("홍길동").hashCode());
		// 다른객체이나 문자열에대한 hash코드 값이 같다
		// hash Code는?????????????????????????
		
		System.out.println("set.contains(\"홍길동\") : " + set.contains("홍길동"));
		System.out.println("set.contains(\"김자바\") : " + set.contains("김자바"));
		
		set.add("을지문덕");
		set.add("홍경래");
		System.out.println("set : " + set);
		
		System.out.println("--- Set 전체 데이터 조회 ---");
		//개선된 포문 // iterator
		for (String name : set) {
			System.out.println(name);
		}
		// 이터러블 가능한 데이터만 됨
		
		System.out.println("--- Set 전체 데이터 조회 (iterator 사용) ---");
		// 이터레이터는 순차적으로 데이터를 처리함
		
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) { // 데이터가 있는지 묻기
			//String name = ite.next();
			//System.out.println(name); // 저장해놓고 쓰면 몇번 더 출력 가능
			System.out.println(ite.next()); // 한번만출력가능
		}
		
		System.out.println("==== 김유신 -> 강감찬 수정/변경 ===");
		// 수정(변경) : 김유신 삭제 강감찬 추가
		// 일단 김유신이 있는지 확인하고 있으면 변경하고, 없으면 진행x
		// 김유신 삭제 and 강감찬 유리
		// 강감찬 입력 and 김유신 삭제
		// 전체 데이터 화면 출력
		
//		set.remove("김유신");
//		System.out.println("set : " + set);
//		set.add("강감찬");
//		System.out.println("set : " + set);
		
		// 있는지 혹인하고 있으면 수정작업, 없으면 작업중단
		if(set.contains("김유신")) {
			set.remove("김유신");
			System.out.println(">> 데이터 있음 : 수정 처리");
			set.add("강감찬");
			System.out.println("수정후 set : " + set);
		} else {
			System.out.println(">> 데이터 없음 : 작업처리 안함");
			System.out.println("set : " + set);
		}
	

		System.out.println("수정전 set : " + set);
		if(set.remove("홍길동2")) {
			System.out.println(">> 삭제처리됨");
			System.out.println("수정후 set : " + set);
		} else {
			System.out.println(">> 없어서 삭제 못함");
			System.out.println("set : " + set);
		}
		
		System.out.println("== 실행 끝 ==");
		
		System.out.println("-- 전체데이터 화면 출력 ---");
		for (String name : set) {
			System.out.println(name);
			
		}
		
	}

}
