package com.mystudy.scanner5_guess;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 숫자 추측 게임
컴퓨터가 1~100 사이의 숫자를 정하면 사람이 맞추는 게임
선택 기회 5회
---------------------
Math.random() : 0 <= random값 < 1 범위의 실수값 
컴숫자 : 70 인 경우 
  사람이 선택한 숫자(80)가 크면 : 생각한 숫자보다 작다는 메시지 출력
  사람이 선택한 숫자(50)가 작으면 : 생각한 숫자보다 크다는 메시지 출력
5번 이내에 맞추면 : 성공!!! n번 만에 맞췄습니다.(화면출력)
5번을 넘기면 : 실패~~ 내가 생각한 숫자는 70입니다.(화면출력)
-----
다시 도전하시겠습니까?(y,n) 
---------------------------
*/
public class GuessNumberGame {
	
	
	final int tryNum = 5;  
	private Scanner scan = new Scanner(System.in);
	
	public void start() {
		// 입력
		while (true) {
				
			int num = (int)(Math.random() * 100 + 1);
			
			// 숫자입력
				numCatch(num);
	
			// 재도전 확인
			System.out.println("다시 도전하시겠습니까? (y or n)");
			if ("n".equalsIgnoreCase(scan.nextLine())) {
				break;
			
			}
		}
		
	}
	
	private void numCatch(int num) {
		
		for (int i = 0; i < tryNum; i++) {
			int insert = insert();
			if (insert == num) {
				System.out.println("* 정답입니다.");
				count(tryNum, i);
				break;
			
			} else {
				System.out.println("* 오답입니다.");
				compare(num, insert);
				count(tryNum, i);
			}
		
			if(i == (tryNum-1)) {
				System.out.println("!! 실패 정답은 " + num + "입니다.");
			}
		}
		
	}
	
//	private int insert() {
//		int number = -1;
//		while (true) {
//			try {
//				System.out.print("숫자를 맞춰주세요 : ");
//				number = scan.nextInt();
//				break;
//			} catch (InputMismatchException e) {
//				System.out.println("[주의 : !! 숫자를 입력해주세요]");
//			}
//		}
//		return number;
//	}
	
	private int insert() {
		int number = -1;
		while (true) {
			try {
				System.out.println("숫자 선택 > ");
				number = Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("[주의] 숫자값을 입력하세요");
			}
		}
		return number;
	}

	private void compare(int num, int insert) {
		if (num > insert) {
			System.out.println("** " + insert + "보다 더 큰 숫자 입니다.");
		}
		if (num < insert) {
			System.out.println("** " + insert + "보다 더 작은 숫자 입니다.");
		}
		
	}
	private void count(int tryNum, int i) {
		System.out.println("(도전횟수 : " + (i + 1) + "번,"
				+ " 남은 횟수 : " + (tryNum - (i + 1)) + "번)" );
	}
	
	
	
}
