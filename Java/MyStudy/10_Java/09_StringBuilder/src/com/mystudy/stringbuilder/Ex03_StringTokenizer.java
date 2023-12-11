package com.mystudy.stringbuilder;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex03_StringTokenizer {

	public static void main(String[] args) {
		// String 클래스의 split() vs StringTokenizer 클래스
		System.out.println("---- String split() ----");
		String str = "사과,배,복숭아,,포도";
		System.out.println("str : " + str.toString());
		System.out.println(str + str.toString());
		
		String[] strSplit = str.split(",");
		System.out.println("strSplit.length : " + strSplit.length);
		
		System.out.println("--- str.split(\",\") 실행결과 배열 ----");
		for (int i = 0; i < strSplit.length; i++) {
			System.out.println(i + ": -" + strSplit[i] + "-");
		}
		System.out.println();
		//공백 값 넣어도 데이터로서의 가치는 있음
		
		System.out.println("--- 개선된 for문으로(또는 for Each) ---");
		// 배열에 있는 데이터를 출력
		for (String str2 : strSplit) {
			System.out.println("-" + str2 + "-");
		}
		System.out.println("----");
		int idx = 0;
		for (String str2 : strSplit) {
			System.out.println(idx + " : "+ str2);
			idx++;
		}
		
		System.out.println("\n========= StringTokenizer ===========");
		str = "사과,배,복숭아,,포도";
		System.out.println("str : " + str);
		
		StringTokenizer strToken = new StringTokenizer(str, ",");
		System.out.println("strToken.countTokens() : " + strToken.countTokens());
		
		while (strToken.hasMoreTokens()) {
			String token = strToken.nextToken();
			System.out.println("-" + token + "-");
		}
		// strToken.nextToken();
		// 토큰이 없을때 NoSuchElementException 예외발생
		
		System.out.println("strToken.countTokens() : " + strToken.countTokens());
		// 재사용하고 싶으면 다시 입력
		System.out.println("=====================");
		
		System.out.println("== 실습 토큰데이터 for문으로 화면 출력 ==");
				
		strToken = new StringTokenizer(str, ",");
		System.out.println(strToken.countTokens());
		int count = strToken.countTokens();
		for (int i = 0; i < count; i++) {
			String tk = strToken.nextToken();
			System.out.println(tk);
		}
		
		System.out.println("--- main() 끝 ----");
		

	}

}
