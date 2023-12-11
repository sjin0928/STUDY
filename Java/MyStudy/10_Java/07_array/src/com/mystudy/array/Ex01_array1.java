package com.mystudy.array;

import java.util.Arrays;

public class Ex01_array1 {

	public static void main(String[] args) {
		// 배열(array) : 동일한 데이터 타입들의 연속된 저장 공간
		// 배열의 선언 : 자료형[] 변수명
		// 변수에 값을 저장 : 배열변수명 [인덱스 번호] = 값;
		/* 배열의 선언 및 생성
		 1. (자료형 = 데이터타입)
		    자료형[] 변수명 = new 자료형[갯수];
		    자료형 변수명[] = new 자료형[갯수];  / 디폴트값 지정
		 2. 자료형[] 변수명 = new 자료형[] {값1, 값2 값3, ..., 값n};
		 3. 자료형[] 변수명 = {값1, 값2 값3, ..., 값n}; / 선언과 동시에만 가능
		 ----------------------*/
		int[] arr = new int[5]; //arr이라는 5개의 정수형 저장공간이 만들어짐
		System.out.println("arr : " + arr);
		System.out.println("arr : " + arr[0]);
		System.out.println("----------");
		
		for (int i = 0; i < 5; i++) {
			System.out.println(i + " : " + arr[i]);
		}
		
		arr[0] = 10; //배열의 첫번째 위치(인덱스번호 0번)에 10 설정(저장)
		// arr [ 10 | 0 | 0 | 0 | 0 ]
		System.out.println(arr[0]);
		arr[1] = 11;
		// arr [ 10 | 11 | 0 | 0 | 0 ]
		System.out.println(arr[1]);
		arr[2] = 12;
		arr[3] = 13;
		arr[4] = 14; // 마지막 데이터 (크기 -1)
		// arr[5] = 15; ArrayIndexOutOfBoundsException : 범위를 벗어남
		
		
		System.out.println("---------------");
		
		System.out.println("==== 배열 length의 속성 ====");
		// 배열의 크기(length)를 확인할 수 있는 속성값
		System.out.println("arr.length : " + arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + " : " + arr[i]);
		}
		
		System.out.println("==== 배열선언 형태 2번 ====");
		//2. 자료형[] 변수명 = new 자료형[] {값1, 값2, 값3, ..., 값n};
		//						0    1    2    3    4
		int[] arr2 = new int[] {100, 101, 102, 103, 104};
		for (int i = 0; i < arr2.length; i++)  {
			System.out.println(arr2[i]);
		}
		
		System.out.println("==== 배열선언 형태 3번 ====");
		//3. 자료형[] 변수명 = {값1, 값2 값3, ..., 값n};
		int [] arr3 = {10, 11, 12, 13, 14, 15};
		for (int i = 0; i < arr3.length; i++) {
			System.out.println(arr3[i]);
		}
		System.out.println("========================");
		
		int[] nums = new int[10];
		// 초기값 설정 : 1~10 숫자를 저장
		// 규칙성 있는 값은 반복문으로 초기값 설정 할 수 있음 규칙성 없으면 어려움
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		// 배열값 확인
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
		System.out.println(Arrays.toString(nums));
		
		System.out.println("========================");
		//char 타입
		System.out.println("==== 영어 알파벳 문자 저장/출력(A~Z) ====");
		char[] ch = new char[26];
		System.out.println(Arrays.toString(ch));
		// 배열의 저장 데이터 출력
		System.out.println("-" + ch[0] + "-");
		System.out.println("-" + '\u0000' + "-");
		ch[0] = 'A'; // A = 65
		ch[1] = 'B'; // B = 66 <- 65(A) + 1
		ch[2] = 'C'; // C = 67 <- 65(A) + 2
		
		ch[0] = 'A' + 0; //A
		ch[1] = 'A' + 1; //B
		ch[2] = 'A' + 2; //C
		ch[3] = 'A' + 3; //D
		
		System.out.println(Arrays.toString(ch));
		System.out.println("=======================");
		// (실습)데이터 A~Z일괄입력(반복문 사용)
		
		// i의 값을 문법적으로는 모름 char + int = int 형변환
		// 'A' + (char)i 로 쓰면 char + char = 66(int)
		// byte + byte = int => 큰타입으로 변환되므로 형변환 필요
		// int + long = long
		
		// int 타입 char 타입으로 형변환 필요 큰->작 (타입명)(데이터)
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char)('A' + i);

		}
		
		// (실습) 배열 데이터 화면출력(반복문 사용)
		for (char i = 0; i < ch.length; i++) {
			System.out.print(ch[i] + " ");
		}
		
		System.out.println();
		System.out.println(Arrays.toString(ch));
		

	}

}
