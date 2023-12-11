package com.mystudy.scanner4_scissors;

import java.util.HashMap;
import java.util.Scanner;

public class Scanner_Exam4_scissors {

	public static void main(String[] args) {
		/* Scanner를 이용한 가위, 바위 , 보 게임 *******
		// scissors, rock, paper
		// draw : 무승부, person_win, computer_win
		컴퓨터와 함께하는 가위,바위,보 게임
		0. 컴퓨터가 가위(1),바위(2),보(3) 선택(Math.random())
		1. 1.가위   2.바위   3.보   0.종료   선택 메뉴 출력 
		2. 선택값 입력
		3. 결과 비교 후 승자, 패자 결정
		(반복) 게임 반복 진행 - 0 선택시 종료 처리
		=============================== */
		
//		HashMap<Integer, String> game = new HashMap<Integer, String>();
//		game.put(1, "가위");
//		game.put(2, "바위");
//		game.put(3, "보");
		
		Scanner start = new Scanner(System.in);
		System.out.println("** 컴퓨터와 함께하는 가위바위보 게임 **");
		System.out.println("가위 : 1, 바위 : 2 ,보 : 3 을 입력하세요.");
		System.out.println("0 입력시 게임종료.");
		
		boolean ing = true;
		while (ing) {
			int insert = 0;
			System.out.print(">> 입력 : ");
			try {
				insert = start.nextInt();
				if (insert >= 0 && insert <= 3) {
					break;
				} else {
					System.out.println("입력값 오류 : 0 ~ 3 입력해주세요.");
				}
				
			} catch (Exception e) {
				System.out.println("입력값 오류 : 0 ~ 3 입력해주세요.");
			}
			
			if (insert == 0) {
				ing = false;
				System.out.println("게임 종료");
				break;
			}
			
			
			Integer com = (int)(Math.random() * 3 + 1);
			String computer = select(com);
			String user = select(insert);
			
			result(user, computer);

		}
	}

	private static void result (String user, String computer) {
		
		System.out.println("computer : " + computer
				+ "\t user : " + user);
		
		switch (user) {
		case "가위" : 
			if (user.equals(computer)) {
				draw();
			} else if(computer.equals("바위")) {
				userlose();
			} else if(computer.equals("보")) {
				userWin();
			} break;
			
		case "바위" : 
			if (user.equals(computer)) {
				draw();
			} else if(computer.equals("보")) {
				userlose(); break;
			} else if(computer.equals("가위")) {
				userWin();
			} break;
			
		case "보" : 
			if (user.equals(computer)) {
				draw();
			} else if(computer.equals("가위")) {
				userlose();
			} else if(computer.equals("바위")) {
				userWin();
			} break;
		} 
		
	}
	
	private static void userlose() {
		System.out.println(">> 결과 : computer가 이겼다.");
	}

	private static void userWin() {
		System.out.println(">> 결과 : user 이겼다.");
	}
	
	private static void draw() {
		System.out.println(">> 결과 : 무승부");
	}

	private static String select(int num) {
		String result = null;
		switch (num) {
		case 1 : result = "가위"; break;
		case 2 : result = "바위"; break;
		case 3 : result = "보"; break;
		}
		return result;
	}

}
