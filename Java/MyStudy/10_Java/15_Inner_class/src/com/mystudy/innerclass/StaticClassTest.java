package com.mystudy.innerclass;

public class StaticClassTest {

	int a = 100;
	private int b = 10;
	static int c = 200;
	
	static int sum = 0;
	static int sNum1 = 20;
	static int sNum2 = 30;
	
	// jvm에 생성시 static은 가장 먼저 생성됨 // 나머지는 new 객체 생성시 생성
	// => 생성시점이 달라 static은 static끼리만 사용 가능
	static void sum() {
		// sum = a + b; 안됨
		sum = Inner.d + sNum2;
	}
	
	// 스태틱(static) 내부 클래스
	static class Inner {
		static int d = 1000;
		int e = 2000; // non-static
		
		void printdata () { // non-static 메소드지만 클래스가 static
			// System.out.println("외부 int a : " + a);
			// 클래스가 static 이므로 외부의 non static 접근 불가
			// 외부의 non-static보다 먼저 생성됨.
			System.out.println("외부 static int c : " + c);
			System.out.println("외부 static int d : " + d);
			System.out.println("내부 static int e : " + e);
			sum();
			System.out.println("외부 static sum : " + sum);
		}
		
	}
	
	public static void main(String[] args) {
		// static은 객체생성 필요없음.
		int num = StaticClassTest.c;
		
		// static 내부클래스의 static 필드변수 사용
		int innerNum = StaticClassTest.Inner.d;
		
		// static 내부클래스의 객체(인스턴스) 생성 후 printdata () 호출(실행)
		StaticClassTest.Inner inner = new StaticClassTest.Inner();
		inner.printdata();
		
	}

}
