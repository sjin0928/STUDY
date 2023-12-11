package com.mystudy.scanner3_cafe;

import java.util.HashMap;
import java.util.Scanner;

public class Scanner_Cafe2_map {
	private int num;
	private int cnt;
	private int inCoin;
	private int sale;
	private int totSale;
	private int outCoin;
	private String drink;
	Scanner scan = new Scanner(System.in);
	
	public Scanner_Cafe2_map() {}
	
	public Scanner_Cafe2_map(int num, String drink, int sale) {
		this.num = num;
		this.drink = drink;
		this.sale = sale;
	}
	
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
			process2();
			
			//출력
			output();

		}
		
	}
	private void input() {
		System.out.println("Menu : \t1.아메리카노(3000)  \n\t2.카페라떼(3500)"
				+ "  \n\t3.카페모카(4000)  \n\t4.과일주스(5000) \n\t0.주문 종료" );
		
		System.out.print("> 메뉴를 선택하세요(0~4) : ");
		num = scan.nextInt();
		
	}
	
	private void input2() {

		System.out.print("> 수량을 입력하세요 : ");
		cnt = scan.nextInt();
		
		System.out.print("> 입금액 : ");
		inCoin = scan.nextInt();	
	}
	
	private void process2() {
		// 메뉴입력...
		HashMap<Integer, Scanner_Cafe2_map> drink2 = new HashMap<>();
		Scanner_Cafe2_map menu1 = new Scanner_Cafe2_map(1, "아메리카노", 3000); 
		drink2.put(menu1.num, menu1);
		Scanner_Cafe2_map menu2 = new Scanner_Cafe2_map(2, "카페라떼", 3500);
		drink2.put(menu2.num, menu2);
		Scanner_Cafe2_map menu3 = new Scanner_Cafe2_map(3, "카페모카", 4000);
		drink2.put(menu3.num, menu3);
		Scanner_Cafe2_map menu4 = new Scanner_Cafe2_map(4, "과일주스", 5000);
		drink2.put(menu4.num, menu4);
		
		
		for (Scanner_Cafe2_map a : drink2.values()) {
			if (num == a.num) {
				totSale = cnt * a.sale;
				System.out.println("\n주문확인 : " + a.drink + " " + cnt + "잔 " + totSale + "원 입니다.");
				outCoin = inCoin - totSale;
				break;
			}			
		}
	}
	
	private void output() {
		System.out.println("===============");
		
		System.out.println("입금액 : " + inCoin);
		System.out.println("판매액 : " + totSale);
		System.out.println("잔액 : " + outCoin);
		
		System.out.println("===============\n");
	}
	
	

}
