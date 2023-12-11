package com.mystudy.thread04_error2;

class Bank {
	int money = 0;
	
}

class ATM_Error extends Thread {

	//int money;
	Bank bank;
	
	public ATM_Error () {}
	public ATM_Error (Bank bank) {
		this.bank = bank;
	}
	
	// 입금처리
	void add(int money) { 
		bank.money += money;
		System.out.println(Thread.currentThread() + " - "
				+ "입금 : " + money + ", 잔액 : " + bank.money);
	}
	
	// 출금처리
	void out(int money) { 
		bank.money -= money;
		System.out.println(Thread.currentThread() + " - "
				+ "출금 : " + money + ", 잔액 : " + bank.money);
	}
	
	@Override
	public void run() {
		// 입금 후 계속 출금
		add(1000);
		banksleep(1000);
		out(500);
		banksleep(1000);
		out(300);
		banksleep(1000);
		out(200);
		// 입금 조작 하는 중에 다른 사람이 데이터를 쓸수 있게 함
		
	}
	
	public void banksleep(int millisecond) {
		try {
			Thread.currentThread().sleep(millisecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class ATM_Thread_Error {

	public static void main(String[] args) {
		System.out.println("==== main() 시작 ====");
		Bank bank = new Bank();
		
		ATM_Error atm1 = new ATM_Error(bank);
		atm1.start();
		ATM_Error atm2 = new ATM_Error(bank);
		atm2.start();
		
		System.out.println("==== main() 끝 ====");
		
	}

}
