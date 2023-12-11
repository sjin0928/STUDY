package com.mystudy.scanner3_cafe;

import java.util.Scanner;

public class Scanner_Exam3_Cafe_me {
	private int num;
	private int cnt;
	private int inCoin;
	private int totSale;
	private int outCoin;
	private String drink;
	Scanner scan = new Scanner(System.in);
	
	final int AMERICANO = 3000;
	final int CAFE_LATTE = 3500;
	final int CAFE_MOCA = 4000;
	final int JUICE = 5000;
	
	public Scanner_Exam3_Cafe_me() {}
	
	public void start() {
		// (실습) 카페 음료 주문 처리
		//음료의 종류 : 
		//1.아메리카노(3000)  2.카페라떼(3500)  3.카페모카(4000)  4.과일주스(5000)
		//-------------------------------------
		// 입력값 : 메뉴번호, 주문수량, 입금액(고객이 낸 돈)
		// 출력값 : 입금액, 판매액(단가 * 수량), 잔돈(입금액 - 판매액)
		//----------------------------------------
		/*
		 while (true) { //0. 입력시 종료
		 menu 1.아메리카노(3000)  2.카페라떼(3500)  3.카페모카(4000)  4.과일주스(5000)
		 0. 종료
		 > 메뉴를 선택하세요(1~4) : 1
		 > 주문수량 : 3
		 
		 > 입금액 : 10000
		 ================
		 입금액 : 10000
		 판매액 : 9000
		 잔액 : 1000
		 }
		 ==================================== */
		
		while (true) {
			//입력
			input();
			
			if (num == 0) {
				System.out.println("주문을 종료합니다.");
				break;
			}
			
			input2();
	
			//처리
			process();
			
			//출력
			output();

		}
		
	}
	private void input() {
		System.out.println("Menu : \t1.아메리카노(3000)  \n\t2.카페라떼(3500)"
				+ "  \n\t3.카페모카(4000)  \n\t4.과일주스(5000) \n\t0.주문 종료" );
		System.out.println("======================\n");
		
		System.out.print("> 메뉴를 선택하세요(0~4) : ");
		num = scan.nextInt();
		
	}
	
	private void input2() {

		System.out.print("> 수량을 입력하세요 : ");
		cnt = scan.nextInt();
		
		System.out.print("> 입금액 : ");
		inCoin = scan.nextInt();	
	}
	
	private void process() {
		switch(num) {
		case 1 :
			drink = "아메리카노";
			totSale = cnt * AMERICANO;
			check();
			break;
		case 2 :
			drink = "카페라떼";
			totSale = cnt * CAFE_LATTE;
			check();
			break;
		case 3 :
			drink = "카페모카";
			totSale = cnt * CAFE_MOCA;
			check();
			break;
		case 4 :
			drink = "과일주스";
			totSale = cnt * JUICE;
			check();
			break;
		}
		outCoin = totSale - inCoin;
	}
	
	
	private void output() {
		System.out.println("===============");
		
		System.out.println("입금액 : " + inCoin);
		System.out.println("판매액 : " + totSale);
		System.out.println("잔액 : " + outCoin);
		
		System.out.println("===============\n");
	}
	
	private void check() {
		System.out.println("주문확인 : " + drink + " " + cnt + "잔 " + totSale + "원 입니다.");
	}

}
