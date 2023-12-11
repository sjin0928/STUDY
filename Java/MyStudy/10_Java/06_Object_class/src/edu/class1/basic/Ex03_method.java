package edu.class1.basic;

public class Ex03_method {
	
	Ex03_method() {} // 기본 생성자 (입력하지 않아도 생성되어 있음) 

	public static void main(String[] args) {
		int num1 = 500;
		int num2 = 200;
		int sum;
		
		sum = add (num1, num2); // 메소드 실행 (호출)
		System.out.println("sum : " + sum);
		
		// static 영역에서 non static 영역 접근시 객체(인스턴스)를 통해 사용
		// 인스턴스(객체)를 사용하면 static, non static 변수, 메소드 모두 사용 가능
		
		Ex03_method ex03 = new Ex03_method();
		// new : 해당 데이터 타입의 개체를 만든다 
		// Ex03_method(); 생성자의 호출 / 생성자의 생성이 안되있으면 자동으로 생성 되어있음
		System.out.println("sub : " + ex03.sub(num1, num2));
		System.out.println("mul : " + ex03.mul(num1, num2));
		System.out.println("div : " + ex03.div(num1, num2));
	}
	
	// 메소드 선언 (static) 모든클래스에서 공통으로 사용
	static int add (int a, int b) {
		return a + b;
	}
	// 메소드 선언 (non static) : 인스턴스 변수(=메소드)
	// 객체(인스턴스)를 생성하여 접근 가능
	int sub(int a, int b) {
		return a - b;
	}
	// 값을 돌려준 후에 종료됨
	int mul(int a, int b) {
		return a * b;
	}
	
	int div(int a, int b) {
		return a / b;
	}
	// ======================================
	// 기본 메소드 형태 : 파라미터 값 유무, 리턴값 유무
	// 이 외에는 참조형 메소드
	void method1() {
		System.out.println("파라미터값 X, return 값 X");
	}
	void method2(String param) {
		System.out.println("파라미터값 O, return 값 X");
	}
	String method3() { // 보이드가 아니면 무조건 타입에 맞는 값을 반환해야함
		System.out.println("파라미터값 X, return 값 O");
		return "파라미터값 X, return 값 O";
	}
	String method4(String param) {
		System.out.println("파라미터값 O, return 값 O");
		return "파라미터값 O, return 값 O";
	}

}
