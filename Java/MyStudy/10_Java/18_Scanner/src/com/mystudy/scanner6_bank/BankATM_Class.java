package com.mystudy.scanner6_bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankATM_Class {
	private int money; // 통장 계좌 금액
	private Scanner scan = new Scanner(System.in);
	
	public void startBank() {
		System.out.println(">>> 어서오세요(ATM 사용)");
		while(true) {
			int select = runningATM();
			if (select == 0) {
				
				break;
			}
		}
		System.out.println("\n>>> ATM 사용을 종료했습니다.");
	}
	
	private int runningATM() {
		//1. 메뉴표시
		showMenu();
		
		//2. 메뉴선택
		int select = -1;
		try {
			select = scan.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("[예외발생] 잘못된 값이 입력되었습니다. "
					 + "메뉴(0~3) 숫자만 입력하세요");
		} finally {
			scan.nextLine();
			// 줄바꿈 문자까지의 빈문자열("") 읽어서 처리(버림)
		}
		
		//3. 선택작업 처리
		if(select == 0) {
			System.out.println("종료----");
			return select;
		}
		if(select == 1) {
			//System.out.println("입금처리----");
			inputMoney();
		}
		if(select == 2) {
			//System.out.println("출금처리----");
			outputMoney();
		} 
		if(select == 3) {
			//System.out.println("통장확인----");
			showMoney();
		}
		return select;
	}
	
	private void outputMoney() {
		System.out.print("> 출금액 : ");
		money -= Integer.parseInt(scan.nextLine());
	}

	private void showMoney() {
		System.out.println(":: 통장잔액 : " + money + "원");
	}

	private void inputMoney() {
		while(true) {
			try{
				System.out.print("> 입금액 : ");
				money += Integer.parseInt(scan.nextLine());
				break;
			} catch(Exception e) {
				System.out.println("[예외발생] 잘못된 값이 입력되었습니다. "
						 + "숫자만 입력하세요");
			}
		}
	}
	
	private void showMenu() {
		System.out.println("---------------------------------");
		System.out.println("1. 입금  2. 출금  3. 통장확인  0. 종료");
		System.out.println("---------------------------------");
		System.out.print("> 작업선택 : ");
	}
}
