package com.mystudy.scanner5_guess;

import java.util.Scanner;

public class GuessNumberGameClass {
	
	private int min = 1;
	private int max = 100;
	private Scanner scan = new Scanner(System.in);
	
	public void start() {
		System.out.println("::: 게임을 시작합니다.");
		while (true) {
			playGame();
			System.out.println("컴) 다시 도전하겠습니까? (y/n)?");
			if ("n".equalsIgnoreCase(scan.nextLine())) {
				break;
			}
		}
		System.out.println("::: 게임을 종료합니다.");
	}

	private void playGame() {
		System.out.println(">> 게임 플레이 시작");
		//1. 컴퓨터가 1~100까지 숫자 중 하나를 선택
		int comNo = (int)(Math.random() * 100 + 1);
		System.out.println("컴) 1~100까지 숫자중 하나를 생각했습니다."+"맞춰보세요~");
		System.out.println("> 컴퓨터가 생각한 숫자 : " + comNo);
		
		//for (int i = 1; i <= 5; i++) {
		int tryCnt = 1;
		while(tryCnt <= 5) {	
			//2. 사람이 숫자를 선택

			
			int selectNumber = selectNumber(tryCnt);
			if(selectNumber < min || selectNumber > max) {
				System.out.println("컴) 범위 확인하고 다시 입력");
				continue;
			}
			
			//3. 사람선택 숫자와 컴퓨터 숫자 비교
			if(comNo == selectNumber) {
				System.out.println("컴) 성공!! 맞췄습니다. 내가 생각한 숫자는 "
						+ comNo + "입니다.");
				break;
			}
			if(comNo > selectNumber) {
				System.out.println("컴) " + selectNumber + "보다 큽니다.");
				min = selectNumber + 1;
			}
			if(comNo < selectNumber) {
				System.out.println("컴) " + selectNumber + "보다 작습니다.");
				max = selectNumber - 1;
			}
			System.out.println("다음 선택 값 범위 : " + min + "~" + max);
			
			// 5번 시도하고 여기까지 왔으면 실패
			if (tryCnt == 5) {
				System.out.println("컴) 실패!! 내가 생각한 숫자는 "
						+ comNo + "입니다.");
			}
		}
		System.out.println(">> 게임 플레이 종료");
	}

	private int selectNumber(int tryCnt) {
		int number = -1;
		while (true) {
			try {
				System.out.println(tryCnt + "번째 숫자 선택 (" + min + "~" + max + ")>");
				number = Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("[주의] 숫자값을 입력하세요");
			}
		}
		return number;
	}
	
}
