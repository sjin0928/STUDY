package com.mystudy.list4_list_exam;

import java.util.ArrayList;
import java.util.List;

public class ArrayList_String_Exam {

	public static void main(String[] args) {
		/* List 중 ArrayList<String> 사용 실습
		문자열 : "홍길동","이순신","이순신","을지문덕"
		1. ArrayList 타입 names 변수를 선언하고 데이터 입력
		2. List에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력 예) 홍길동,이순신,이순신,을지문덕
		3. List에 있는 데이터의 첫 글자만 출력
		   출력 예) 홍,이,이,을
		4. 이름이 을지문덕 찾아서 "인덱스번호:이름" 형태로 출력
		   예) 3:을지문덕
		5. 이름이 "이순신" 데이터 모두 삭제
		========================================================= */
		// 1. ArrayList 타입 names1 변수를 선언하고 데이터 입력
		ArrayList<String> names1 = new ArrayList<String> ();
		names1.add("홍길동");
		names1.add("이순신");
		names1.add("이순신");
		names1.add("을지문덕");
//		String[] n = new String [] {"홍길동","이순신","이순신","을지문덕"};
//		for (int i = 0; i < n.length; i++) {
//			names1.add(n[i]);
//		}

		System.out.println("1. names1 : " + names1);
		
		// 2. List에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		//   출력 예) 홍길동,이순신,이순신,을지문덕
		
		System.out.print("2. names1(for) : ");
		int s = names1.size()-1;
		for (int i = 0; i < s; i++) {
		System.out.print(names1.get(i) + ",");
		}
		System.out.println(names1.get(s));
		
		System.out.print("2. names1(for + if) : ");
		for (int i = 0; i < names1.size(); i++) {
			System.out.print(names1.get(i));
			if (i < s) {
				System.out.print(",");
			}
		}
		System.out.println();
		System.out.print("2. names1(StringBuilder) : ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < names1.size(); i++) {
			sb.append(names1.get(i));
			if (i < s) {
				sb.append(",");
			}
		}
		System.out.print(sb);
		System.out.println();
		
		
		// 3. List에 있는 데이터의 첫 글자만 출력
		//   출력 예) 홍,이,이,을
		System.out.print("3. names1 : ");
		for (int i = 0; i < s; i++) {
			System.out.print(names1.get(i).charAt(0) + ",");
			}
		System.out.println(names1.get(s).charAt(0));

		System.out.print("3. names1 : ");		
		for (int i = 0; i < names1.size(); i++) {
			if(i < s) {
				System.out.print(names1.get(i).charAt(0) + ",");
			} else {
				System.out.println(names1.get(s).charAt(0));
			}
		}

		System.out.print("3. names1 : ");		
		for (int i = 0; i < names1.size(); i++) {
			System.out.print(names1.get(i).charAt(0));
			if(i < s) {
				System.out.print(",");
			}
		}
		System.out.println();
		
		StringBuilder sb1 = new StringBuilder();
		System.out.print("3. names1(StringBuilder) : ");
		for (int i = 0; i < names1.size(); i++) {
			sb1.append(names1.get(i).charAt(0));
			if (i < s) {
				sb1.append(",");
			}
		}
		System.out.print(sb1);
		System.out.println();
		
		// 4. 이름이 을지문덕 찾아서 "인덱스번호:이름" 형태로 출력
		//   예) 3:을지문덕
		int idx = names1.indexOf("을지문덕");
		System.out.println("4. names1 : " + idx + " : " + names1.get(idx));
		
		// 5. 이름이 "이순신" 데이터 모두 삭제
		while(names1.remove("이순신")) {}
		System.out.print("5. names1 : " + names1 + "\n");
		
		System.out.println("== 수업내용~~~~~~");
		
		// 수업내용~
		// 1.
		// ArrayList<String> names = new ArrayList<String>();
		// 변수선언과 동시에 객체생성
		List<String> names = new ArrayList<String>();
		
		names.add("홍길동");
		names.add("이순신");
		names.add("이순신");
		names.add("을지문덕");
		System.out.println("1. " + names);
		
		//2.
		System.out.print("2. ");
		for (int i = 0; i < names.size(); i++) {
			if (i == 0) {
				System.out.print(names.get(i));
			} else {
				System.out.print("," + names.get(i));
			}
		}
		System.out.println();
		System.out.println("-----------");
		int idx1 = 0;
		for(String name : names) {
			if(idx1 == 0) {
				System.out.print(name);
			} else {
				System.out.print("," + name);				
			}
			idx++;
		}
		
		System.out.println();
		System.out.print("3. ");
		boolean isfirst = true;
		for(String name : names) {
			if(isfirst) {
				System.out.print(name.charAt(0));
				isfirst = false;
			} else {
				System.out.print("," + name.charAt(0));
			}
			
		}
		System.out.println();
		System.out.print("4. ");
		for (int i = 0; i < names.size(); i++) {
			if ("을지문덕".equals(names.get(i))) {
				System.out.println(i + ":" + names.get(i));
				break;
			}
		}
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).length() >= 4) {
				System.out.println(i + ":" + names.get(i));
				break;
			}
		}
		
		System.out.println();
		System.out.println("5. ");
		
	}
}
