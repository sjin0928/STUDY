package com.mystudy.string;

import java.util.Arrays;

public class Ex02_String_method {

	public static void main(String[] args) {
		// String 클래스 메소드를 사용 문자열 처리 (단, 원본 문자열 불변)
		// 인덱스번호	  0123456789
		String str = "Java World";
		System.out.println("str : " + str);
		
		System.out.println("---- charAt(인덱스번호) ---");
		char ch = str.charAt(0);
		System.out.println("str.charAt(0) : " + ch);
		System.out.println("str.charAt(1) : " + str.charAt(1));
		
		// ch2 = { str.charAt(0), str. charAt(1) }; 
		char[] ch2 = new char[4];
//		ch2[0] = str.charAt(0);
//		ch2[1] = str.charAt(1);
//		ch2[2] = str.charAt(2);
//		ch2[3] = str.charAt(3);
//		
		for (int i = 0; i < ch2.length; i++ ) {
			ch2[i] = str.charAt(i);
		}	
		
		System.out.println(Arrays.toString(ch2));
		
		System.out.println("---- compareTo() : 문자열비교(결과: 음수, 0, 양수) ----");
		System.out.println("\"java\".compareTo(\"java\") : "+  "java".compareTo("java"));
		System.out.println("aaa vs aaa : " + "aaa".compareTo("aaa"));
		System.out.println("bbb vs bbb : " + "bbb".compareTo("aaa"));
		System.out.println("ccc vs bbb : " + "ccc".compareTo("aaa"));
		System.out.println("aaa vs bbb : " + "aaa".compareTo("bbb"));
		// 앞쪽값을 기준으로 첫글자만 비교
		
		//     0123456789
		str = "Java World";
		System.out.println("str : " + str);

		// 문자의 유무 확인
		System.out.println("str.contains(\"Java\") : " + str.contains("Java"));
		
		System.out.println("--- indexOf() : 문자(문자열) 위치값 확인");
		System.out.println("indexOf('X') : " + str.indexOf('X')); // -1 : 없다
		System.out.println("indexOf('J') : " + str.indexOf('J')); //  0 : 첫번째 위치에 있다
		System.out.println("indexOf(\"Java\") : " + str.indexOf("Java")); //  0 : 첫번째 위치에 있다
		System.out.println("indexOf('a', 2) : " + str.indexOf('a', 2)); //  1 : 두번째 위치에 있다
		
		System.out.println("--- lastIndexOf() : 문자(문자열) 찾기 (뒤에서부터)");
		System.out.println("str.lastIndexOf('a') : " + str.lastIndexOf('a'));
		
		System.out.println("====================");
		System.out.println("str.startsWith(\"Java\") : " + str.startsWith("Java")); // 앞의 시작 문자 확인
		System.out.println("str.startsWith(\"World\") : " + str.startsWith("World"));
		System.out.println("str.endsWith(\"Java\") : " + str.endsWith("Java"));
		System.out.println("str.endsWith(\"World\") : " + str.endsWith("World"));
		
		System.out.println("--- isEmpty() ----");
		System.out.println("str : " + str);
		System.out.println("str.isEmpty() : " + str.isEmpty());
		str = ""; // 빈문자열
		System.out.println("str : - " + str + "-");
		System.out.println("str.isEmpty() : " + str.isEmpty());
		
		System.out.println("str.length() : " + str.length());
		
		str = "Java World";
		System.out.println("--- replace() : 문자, 문자열 변경값 리턴 ---");
		System.out.println("str : " + str);
		System.out.println("str.replace(\"Java\", \"Hello\") : " + str.replace("Java", "Hello"));
		System.out.println("str.replace(\"a\", \"m\") : " + str.replace("a", "m"));
		System.out.println("str : " + str);
		
		System.out.println("--------------");
		
		str = "Java Java";
		System.out.println("str : " + str);
		System.out.println("str.replace(\"Ja\", \"JA\") : " + str.replace("Ja", "JA"));
		System.out.println("str.replaceAll(\"Java\", \"Hello\") : " + str.replaceAll("Java", "Hello"));
		System.out.println("=====================");
		
		System.out.println("--- substring() : 부분 문자열 추출 ----");
		str = "Java World";
		System.out.println("str : " + str);
		System.out.println("str.substring(5) : " + str.substring(5));
		System.out.println("str.length() : " + str.length());
		
		// String.substring(int beginIndex, int endIndex)
		// beginIndex : 부터(포함)
		// endIndex : end 이전까지 (불포함)
		
		//     0123456789
		str = "Java World";
		System.out.println("str.substring(5,str.length()) : " + str.substring(5,str.length()));
		
		// 뒤에서 5개 문자만 사용
		System.out.println("str.substring(str.length() - 5) : "
							+ str.substring(str.length() - 5));
		System.out.println("-----------------");
		
		str = "  Java World   ";
		System.out.println("str : -" + str + "-");
		// 공백삭제
		System.out.println("-" + str.trim() + "-");
		System.out.println("str.toUpperCase()" + str.toUpperCase());
		System.out.println("str.toLowerCase()" + str.toLowerCase());
		System.out.println("--- String.valueOf(): 문자열로 변환 -------");
		int num = 100;
		str = num + ""; // int => String
		str = String.valueOf(100); // "100" 문자열로 형변환
		str = String.valueOf(num);
		// 객체가 없어도 가능? static선언 되있을시 class명.메소드 가능
		
		System.out.println("--- toCharArray() : 문자열을 char[]로 변환");
		str = "Java World";
		System.out.println("str : " + str);
		// 문자열을 배열에 저장
		char[] charArray = str.toCharArray();
		System.out.println(Arrays.toString(charArray));
		System.out.println("charArray[0] : " + charArray[0]);		
	}

}
