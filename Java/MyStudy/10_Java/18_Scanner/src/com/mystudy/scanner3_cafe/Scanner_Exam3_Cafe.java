package com.mystudy.scanner3_cafe;

import java.util.Scanner;

public class Scanner_Exam3_Cafe {
	private Scanner scan = new Scanner(System.in);
	public static final int AMERICANO = 3000;
	public static final int CAFE_LATTE = 3500;
	public static final int CAFE_MOCA = 4000;
	public static final int JUICE = 5000;
	int income = 0;
	//int inMoney;
	//int totMoney;
	//int change;


	public void opencafe () {
		while (true) {
			
			showMenu();
			
			int select = scan.nextInt();
			
			if (select == 0) {
				System.out.println(">>>> 영업을 종료합니다.");
				System.out.println("금일 매출 총액 : " + income);
				break;
			}	
		
			System.out.print("> 수량입력 : ");
			int count = scan.nextInt();
			
			System.out.print("> 입금액 : ");
			int inMoney = scan.nextInt();
			
			// 계산처리 ============
			int totMoney = computeMoney(select, count);

				
			// 잔액 계산
			int change = inMoney - totMoney;
			income += totMoney;
			
			// 계산결과 출력
			displayResult(inMoney, totMoney, change);
			
		}

	}
	
	private void displayResult(int inMoney, int totMoney, int change) {
		System.out.println("=============");
		System.out.println("입금액 : " + inMoney);
		System.out.println("판매액 : " + totMoney);
		System.out.println("잔액 : " + change);	
		System.out.println();
		
	}

	private void showMenu() {
		System.out.println("1.아메리카노  2.카페라떼  3.카페모카  4.과일주스   0.종료");
		System.out.print("> 메뉴선택(1~4) : ");
	}
	private int computeMoney(int select, int count) {
		int result = 0;
		switch (select) {
		case 1 : result = AMERICANO * count; break;
		case 2 : result = CAFE_LATTE * count; break;
		case 3 : result = CAFE_MOCA * count; break;
		case 4 : result = JUICE * count; break;
		}
		return result;
	}
	
	
}
