package com.mystudy.scanner4_scissors;

import java.util.Scanner;
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

public class Scanner_Game {
	private Scanner scan = new Scanner(System.in);
	private static final String PAPER = "보자기";
	private static final String ROCK = "주먹";
	private static final String SCISSORS = "가위";
	private static final String MENU = "1. 가위\t2. 바위\t3. 보\t0. 종료";
	private static final String COMPUTER_WIN = "컴퓨터 승리";
	
	public void gameStart() {
		
		System.out.println("::: 가위,바위," + PAPER + "게임 시작~~~~~");
		while(true) {
			boolean isContinue = isContinueGame();
			if (!isContinue) break;
		}
		System.out.println("::: 가위,바위," + PAPER + "게임 끝~~~");
	}
	
	private boolean isContinueGame() {
		boolean isContinue = true; // 게임계속

		// 0. 컴퓨터 선택
		int comSelect = (int)(Math.random() * 3 + 1);
		// 숫자를 문자열로 변경
		
		
		
		System.out.println("comSelect : " + comSelect);
		System.out.println("컴퓨터는 가위, 바위, " + PAPER + " 중에 하나를 선택했습니다.");

		// 1. 선택 메뉴 출력
		System.out.println(MENU);
				
		// 2. 사람이 선택
		int select = selectPerson();
		
		if (select == 0) {
			System.out.println("중단~");
			return false ;			
		}
		
		String strperson = changeNumberToString(select);
		String strComputer = changeNumberToString(comSelect);

		// 3. 결과 비교 후 승자, 패자 결정
		String result = compareResult(strComputer, strperson);
		
		// 승/패 결과출력
		System.out.println(">> 결과 : " + result + " (컴퓨터 : " + strComputer + ")");
		return isContinue;
	}

	private int selectPerson () {
		int select = -1;
		while (true) {
			try {
				System.out.println(">> 당신의 선택은(1~3)?");
				select = Integer.parseInt(scan.nextLine());
				if (select >= 0 && select <=3) {
					break;
				} else {
					System.out.println("::: 잘못된 선택 - 0~3 중에 선택하세요.");
				}
				break;
			} catch (Exception e) {
				System.out.println("::: 잘못된 값 입력 - 0~3 중에 선택하세요.");
			}
			
		}
		return select;
	}
	
	private String compareResult(String strComputer, String strperson) {
		String result = null;
		if (strperson.equals(strComputer)) {
			result = "비겼다.";
		}
		
		if (strperson == "가위") {
			if (strComputer == "바위") {// 컴 : 바위
				result = COMPUTER_WIN;
			}
			if (strComputer == PAPER) {// 컴 : 보
				result = "사람 승.";
			}
		}
		
		if (strperson == "바위") {
			if (strComputer == "가위") {// 컴 : 가위
				result = "사람 승.";
			}
			if (strComputer == PAPER) {// 컴 : 보
				result = COMPUTER_WIN;
			}
		}
		
		if (strperson == PAPER) {
			if (strComputer == "가위") {// 컴 : 가위
				result = "컴퓨터 승.";
			}
			if (strComputer == "바위") {// 컴 : 바위
				result = "사람 승.";
			}
		}
		return result;
	}

	private String changeNumberToString(int comSelect) {
		String str = "변환안됨";
		switch (comSelect) {
			case 1 : str = "가위"; break;
			case 2 : str = "바위"; break;
			case 3 : str = PAPER; break;
		}
		return str;
	}
}