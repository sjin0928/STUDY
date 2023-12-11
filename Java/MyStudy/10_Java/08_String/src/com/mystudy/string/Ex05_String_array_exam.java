package com.mystudy.string;

import java.util.Arrays;

public class Ex05_String_array_exam {

	public static void main(String[] args) {
		/* String[]과 String 메소드 사용 실습
		문자열 : "홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"
		1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
		2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력
		   출력 예) 홍길동,이순신,이순신,을지문덕....
		3. 배열에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		   출력 예) 홍,이,이,을,김,연,T,T...
		4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
		   예) 3:을지문덕
		5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
		   예) 1:이순신=2:이순신
		(기타) 이름 비교시에는 대소문자 구분 없이 비교처리(Tom, TOM 은 같다)
		========================================================= */

		// 1. 위의 문자열 값을 저장할 수 있는 문자열 배열(names) 변수를 선언하고 입력
		String[] names = {"홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"};
		
		// 강의내용 
		System.out.println("== 1. ");
		System.out.println(Arrays.toString(names) + "\n");
		
		// 2. 배열에 있는 값을 구분자 콤마(,)로 구분하여 한 라인에 출력

		// 패턴1) : 이름, + 이름(마지막)
		
		System.out.println("== 2. 개선된 for 문 (String 변수 : 배열명) + break");
		for (String name : names) {
			System.out.print(name);
			if (name == names[(names.length-1)]) break;
				System.out.print(",");
		}
		
		System.out.println("\n");
		
		System.out.println("== 2. 개선된 for 문 (String 변수 : 배열명) + !=");
		for (String name : names) {
			System.out.print(name);
			if (name != names[(names.length-1)]) {
				System.out.print(",");
			}	
		}
		System.out.println("\n");
		
		// 강의내용~
		System.out.println("==== 강의내용 ========");
		System.out.println("== 2. 개선된 for 문 (String 변수 : 배열명) + !=");
		boolean isfirst = true;
		for (String name : names) {
			if (isfirst) {
				System.out.print(name);
				isfirst = false;
			} else {
			System.out.print("," + name);
			}
		}
		
		System.out.println();
		System.out.println("===================");
		System.out.println();
		
		System.out.println("== 2. 이중 for문");
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
			if (i < (names.length-1)) {
				System.out.print(",");
			}
		}
		
		System.out.println("\n");

		// 강의내용~
		System.out.println("==== 강의내용 ====");
		System.out.println("== 2. for + if 분리");

		// 처음~마지막 이전까지
		for (int i = 0; i < names.length - 1; i++) {
				System.out.print(names[i] + ",");
			}
		// 마지막 데이터 처리
		if (names.length > 0) { //최소 한개 이상 있으면
			System.out.println(names[names.length - 1]);
		}

		System.out.println();

		
		// 패턴2) : 이름(처음) + ,이름
		System.out.println("== 2. if + else");
		for (int i = 0; i < names.length; i++) {
			if (i == (names.length - 1)) {
				System.out.print(names[i]);
			} else {
				System.out.print(names[i] + ",");
			}
		}
		System.out.println("\n");

		
		// 패턴 : 이름 (첫번째) / ,이름(나머지)
		System.out.println("== 2. if + else(이름 (첫번째) / ,이름(나머지))");
		for (int i = 0; i < names.length; i++) {
			if (i == 0) {
				System.out.print(names[i]);
			}else {
				System.out.print("," + names[i]);
			}
		}
		System.out.println("\n");

		System.out.println("== 2. 0번 출력후 for문(이름 (첫번째) / ,이름(나머지))");
		System.out.print(names[0]);
		for (int i = 1; i < names.length; i++) {
			System.out.print("," + names[i]);
		}
		System.out.println();
		System.out.println("===================");
		System.out.println();
		
		// 3. 배열에 있는 데이터의 첫 글자만 출력-구분자 콤마(,) 사용 한 라인에 출력
		System.out.println("== 3. charAt 사용");
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i].charAt(0));
			if (i < (names.length-1)) {
				System.out.print(",");
			}
		}
		System.out.println("\n");
		
		System.out.println("== 3. substring 사용");
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i].substring(0, 1));
			if (i < (names.length-1)) {
				System.out.print(",");
			}
		}
		System.out.println("\n");
		
		// 4. 이름의 글자수가 4글자 이상인 이름을 검색해서 "인덱스번호:이름" 형태로 출력
		System.out.println("== 4.");
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() >= 4) {
				System.out.print(i + " : " + names[i] + " ");
			}			
		}
		System.out.println("\n");
		
		// 5. 이름이 같은 데이터를 "인덱스번호:이름=인덱스번호:이름" 형태로 출력
		System.out.println("== 5. equals + toLoewrCase");
		for (int f = 0; f < names.length; f++) {
			for (int s = f + 1; s < names.length; s++) {
				if ((names[f].toLowerCase()).equals(names[s].toLowerCase())) {
					System.out.println(f + " : " + names[f] + " = " + s + " : " + names[s]);
				}
			}
		}
		System.out.println();
		
		System.out.println("== 5. contains + toupperCase");
		for (int f = 0; f < names.length; f++) {
			for (int s = f + 1; s < names.length; s++) {
				if ((names[f].toUpperCase()).contains((names[s].toUpperCase()))) {
					System.out.println(f + " : " + names[f] + " = " + s + " : " + names[s]);
				}
			}
		}
		// 강의내용~
		System.out.println();
		System.out.println("== 5. 강의내용");
//		int lastIndex = names.length - 1;
		for (int baseIdx = 0; baseIdx < names.length - 1; baseIdx++) {
			// 마지막 데이터 빼고~
			for (int i = baseIdx + 1; i < names.length; i++) {
				if (names[baseIdx].equalsIgnoreCase(names[i])) {
					System.out.println(baseIdx + ":" + names[baseIdx]
							+ " = " + i + ":" + names[i]);
				}
			}
		}
		System.out.println("=======================");
		//인덱스 : 0    1     2    3      4    5      6   7 (마지막: length - 1)
		//데이터 : 홍길동,이순신,이순신,을지문덕,김유신,연개소문,Tom,TOM
		names = new String[] {"홍길동","이순신","이순신","을지문덕","김유신","연개소문","Tom","TOM"};
		if (names[0].equalsIgnoreCase(names[1])) {
			System.out.println(0 + ":" + names[0] + "=" + 1 + ":" + names[1]);
		}
		if (names[0].equalsIgnoreCase(names[2])) {
			System.out.println(0 + ":" + names[0] + "=" + 2 + ":" + names[2]);
		}
		if (names[0].equalsIgnoreCase(names[3])) {
			System.out.println(0 + ":" + names[0] + "=" + 3 + ":" + names[3]);
		}
		//...
		//마지막 데이터 비교
		if (names[0].equalsIgnoreCase(names[names.length - 1])) {
			System.out.println(0 + ":" + names[0] + "=" + (names.length - 1) + ":" + names[names.length - 1]);
		}
		//-----------------------
		System.out.println("------");
		//기준인덱스 : 0
		for (int i = 1; i < names.length; i++) {
			if (names[0].equalsIgnoreCase(names[i])) {
				System.out.println(0 + ":" + names[0] + "=" + i + ":" + names[i]);
			}
		}
		//기준인덱스 : 1
		for (int i = 2; i < names.length; i++) {
			if (names[1].equalsIgnoreCase(names[i])) {
				System.out.println(1 + ":" + names[1] + "=" + i + ":" + names[i]);
			}
		}
		
		// 기준인덱스 : 2~생략
		// 기준인덱스 : 마지막데이터 비교
		for (int i = names.length - 1; i < names.length; i++) {
			if (names[names.length - 2].equalsIgnoreCase(names[i])) {
				System.out.println(names.length - 2 + ":" + names[names.length - 2] + "=" + i + ":" + names[i]);
			}
		}
		
		// 반복문처리 : 기준인덱스 - 0 ~ 마지막 이전 인덱스
		// names.length - 1 : 마지막 인덱스 번호
		// 배열 내의 비교는 개수 -1번 한다.
		System.out.println("==== 반복문 처리");
		int lastIndex = names.length - 1;
		System.out.println("마지막인덱스 번호 : " + lastIndex);
		 for(int gijun = 0; gijun < lastIndex; gijun++) {
			 for (int i = gijun + 1; i < names.length; i++) {
					if (names[gijun].equalsIgnoreCase(names[i])) {
						System.out.println(gijun + ":" + names[gijun] + "=" + i + ":" + names[i]);
					}
				}				
		 }
		 System.out.println(">>>> main () 끝 -----------");
	}

}
