package com.mystudy.scanner2_sungjuk;

import java.util.Scanner;

public class Scanner_Exam2 {

	public static void main(String[] args) {
		/* (실습) Scanner 사용 성적처리
		입력 : 성명, 국어, 영어, 수학 점수를 입력받아
		처리 : 총점, 평균 계산한다
		출력 : 결과를 화면 출력
		===(처리결과 출력예시)===
		성명 : 홍길동
		국어 : 100
		영어 : 90
		수학 : 81
		------------
		총점 : 271
		평균 : 90.33
		================= */
		
		System.out.println(":: 성명, 국어, 영어, 수학 점수를 입력해주세요");
		
		Scanner scan = new Scanner(System.in);
		boolean start = true;
		while (start) {
			System.out.print("성명 : ");
			String name = scan.next();
			
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			scan.nextLine();
			
			System.out.print("수학 : ");
			int math = Integer.parseInt(scan.nextLine());
			
			System.out.println("※ 점수 내역");
			
			System.out.println("성명 : " + name + ", 국어 : " + kor
					 + ", 영어 : " + eng + ", 수학 : " + math + "\n");
			
			System.out.println("※ 총점, 평균");
			int tot = kor + eng + math;
			double avg = tot * 100 / 3 / 100.0;
			System.out.println("총점 : " + tot + ", 평균 : " + avg);
			System.out.println();
			
			System.out.print("종료 or 다음 : ");
			String end = scan.nextLine();
			String answer = scan.nextLine();
			
			if(answer.equalsIgnoreCase("n")) {
				System.out.println("종료");
			}
			
			if(end.equals("종료")) {
				break;
			}
				
		}
		
		

	}

}
