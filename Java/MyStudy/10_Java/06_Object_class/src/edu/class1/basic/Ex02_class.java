package edu.class1.basic;

// 클래스 선언부
// 클래스 내부에 작성하는 내용 : 변수선언, 생성자, 메소드 선언

public class Ex02_class {
	// ==================변수 선언 영역===============
	// 필드변수(인스턴스변수, 멤버변수, 속성-property, 전역변수(클래스 영역에서의 전역) 
	int num = 111;
	
	// 클래스변수, 스테틱(static)변수, 인스턴스(객체) 공통변수(의미상)
	static int staticNum = 222;
	
	// =================생성자 선언 영역===============
	Ex02_class() {}  // 기본 생성자 (default constructor) 생략가능
	// =================메소드 선언 영역===============
	
	// void는 return값이 없을때
	static void main(String[] args) {
		// 지역변수(local variable)
		int num1 = 300;
		//System.out.println("num : "+num); // non static 접근불가
		System.out.println("num1 : "+ num1);
		
		Ex02_class ex02 = new Ex02_class();
		System.out.println("ex02"+ ex02);
		System.out.println("ex02.num :" + ex02.num);
		System.out.println("ex02.staticNum" + ex02.staticNum);
		System.out.println("===================");
		
		int result = add(100, 200); //arguments를 준다
		// static 붙은 클래스끼리는 서로 호출 가능
		// add 메소드에 static 없으면 호출 불가
		System.out.println("add(100,200) 결과 : " + result);
		System.out.println("add(300,500) 결과 : " + add(300, 500));

	} // main 메소드는 static 
	//add가 메소드 이름 
	static int add(int a, int b) { //parameter값을 받는다
		return a + b;
	} // 위치에 맞게 입력 됨 a=100, b=200 / 100+ 200 = 300으로 되돌려줌

}
