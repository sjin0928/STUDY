package com.mystudy.innerclass;

public class LocalClass {
	int a  = 100;
	
	void print() {
		System.out.println("a : " + a);
	}
	
	void innerTest(int k) {
		int b = 200; // 지역변수 (local variable)
		int c = k;
		
		// 로컬클래서(지역클래스) : 메소드 내부에 선언된 클래스
		// 선언된 메소드 내부에서만 사용 가능
		class Inner {
			void printdata() {
				System.out.println("외부클래스 int a : " + a);
				System.out.println("메소드 int b : " + b);
				System.out.println("메소드 int c : " + c);
				System.out.println("파라미터 int k : " + k);
			}
		}
		Inner in = new Inner();
		in.printdata();
	}
}
