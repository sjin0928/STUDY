package com.mystudy.scanner6_bank;

import java.util.Scanner;

// 은행의 ATM
// 1. 입금 2. 출금 3. 통장확인 0. 종료
public class BankATM {
	private int money; // 통장 계좌 금액
	Scanner scan = new Scanner(System.in);
	
	public void startBank() {
		System.out.println("-------- ATM service 시작 --------");
		
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("1. 입금  2. 출금  3. 통장확인  0. 종료");
			System.out.println("---------------------------------");
			
			int insert = insert();
			
			switch (insert) {
				case 1:
					System.out.print("> 입금액 : ");
					money += insertMoney();
					System.out.println(">> 입금완료");
					break;
				case 2:
					System.out.print("> 출금액 : ");
					outMoney(insertMoney());
					System.out.println(">> 출금완료");
					break;
				case 3:
					System.out.println("> 통장잔고 : " + money);
					break;
				case 0:
					System.out.println("> 작업을 종료했습니다.");
				}
			
			if (insert == 0) {
				System.out.println("-------- ATM service 종료 --------");
				break;
			}
			if (insert > 3) {
				System.out.println("!! 작업 선택은 숫자 0~3번을 입력해주세요.");
			}
		}
	}
	
	private int insertMoney() {
		int insertMoney = 0;
		while (true) {
			try {
				insertMoney = Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("!! 금액은 숫자만 입력해주세요.");
			}
		}
		
		return insertMoney;
	}

	private int insert() {
		int insert = 0;
		System.out.print("작업선택 : ");
		while (true) {
			try {
				insert = Integer.parseInt(scan.nextLine());
				break;
			} catch (NumberFormatException e){
				System.out.println("!! 작업 선택은 숫자 0~3번을 입력해주세요.");
			}
		}
		return insert;
	}

	private int outMoney(int outMoney) {
		
		if (money >= outMoney) {
			money -= outMoney;
		} else {
			System.out.println("잔액이 부족합니다. 출금가능금액 : " + money);
		}
			
		return money;
	}
	
}

/* 출력시 
-------------------------
1. 입금 2. 출금 3. 통장확인 0. 종료
--------------------------
> 작업선택 : 1
> 입금액 : 10000

-------------------------
1. 입금 2. 출금 3. 통장확인 0. 종료
--------------------------
> 작업선택 : 3
:: 통장금액 : 10000원

--------------------------
1. 입금 2. 출금 3. 통장확인 0. 종료
--------------------------
> 작업선택 : 1
> 출금액 : 5000

-------------------------
1. 입금 2. 출금 3. 통장확인 0. 종료
--------------------------
> 작업선택 : 3
:: 통장금액 : 50000

-------------------------
1. 입금 2. 출금 3. 통장확인 0. 종료
--------------------------
> 작업선택 : 0
>> 작업을 종료했습니다.
*/