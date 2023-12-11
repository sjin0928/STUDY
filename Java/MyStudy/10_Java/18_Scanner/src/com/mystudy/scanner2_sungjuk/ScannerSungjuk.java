package com.mystudy.scanner2_sungjuk;

import java.util.Scanner;

//(개인별 실습) : StudentVO, List에 처리된 데이터 모아서 사용
public class ScannerSungjuk {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public ScannerSungjuk() {}
	
	public void start() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {

			input(scan); // 입력
			
			process(); // 처리
			
			output(); //결과 출력
			
			System.out.print(">> 계속(중단시: 0 입력)? ");
			String answer = scan.nextLine();
			if (answer.equalsIgnoreCase("0")) {
				System.out.println(":: 작업을 중단합니다~~~");
				break;
			}
		}
	}
	
	private void input(Scanner scan) {
		
		System.out.print("성명 : ");
		name = scan.next(); // 문자열(String) 값 읽기
		
		System.out.print("국어점수 : ");
		kor = scan.nextInt();
		
		System.out.print("영어점수 : ");
		eng = scan.nextInt();
		scan.nextLine(); //nextInt() 뒤에 nextLine() 사용시 문제해결용
		
		System.out.print("수학점수 : ");
		math = Integer.parseInt(scan.nextLine());
	}
	
	private void process() {
		int tot = kor + eng + math;
		double avg = tot * 100 / 3 / 100.0;
		avg = Math.round(tot * 100 / 3.0) / 100.0;
	}
	

	private void output() {
		System.out.println("\n=== 성적처리 결과 ===");
		
		System.out.println("성명 : " + name);
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("--------------");
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println();
		
	}

	
}
