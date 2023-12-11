package com.mystudy.scanner1;

import java.util.Scanner;

public class Scanner_Exam1 {

	public static void main(String[] args) {
		// Scanner 클래스 : 콘솔(화면)에서 데이터 읽어오기
		Scanner scan = new Scanner(System.in); // 시스템클래스의 in 변수
		
		System.out.print("문자열을 입력1 : ");
		String str1 = scan.nextLine(); // 사용하려면 출력문에 적거나 변수에 저장
		System.out.println(">>> " + str1);
		//문자열을 읽어 스트링 타입으로 변환
		System.out.println("-----------");
		
		System.out.print("문자열을 입력2 : ");
		String str2 = scan.nextLine();
		System.out.println(">>> " + str2);
		
		System.out.println("================\n");
		
		System.out.println("정수값 2개를 입력하면 더한 결과 출력");
		//int num1 = 10;
		//int num2 = 20;
		// (주의) nextXxx 메소드 사용 후 nextLine 사용시 문제가 발생
		int sum = 0;
		System.out.print("숫자입력1 : ");
		int num1 = scan.nextInt();
		scan.nextLine(); // 줄바꿈 문자까지의 값을 읽어서 버리기
		
		System.out.print("숫자입력2 : ");
		int num2 = Integer.parseInt(scan.nextLine());
		
		sum = num1 + num2;
		System.out.println("합계 : " + sum);
		
		System.out.print("문자열(nextLine) : ");
		String temp = scan.nextLine();
		System.out.println("입력문자열 출력 : " + temp);
		
		System.out.println("===============");
		System.out.print("정수 숫자 3개 연속 입력 : ");
		String strTemp = scan.next();
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		int n3 = scan.nextInt();
		System.out.println("첫번째 문자열 : " + strTemp);
		System.out.println(n1 + "," + n2 + "," + n3);
	}

}
