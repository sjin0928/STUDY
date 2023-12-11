package edu.class2.car;

/* 자동차 클래스
  속성 : 차량명, 모델명, 차량색상
  기능 : 가고, 서고, 뒤로가고,차량정복 확인
 */

public class Car {
	// 필드변수 (속성)----------
	String name = "마이카"; //차량명
	String model; //모델명
	String color; //차량색상
	
	// final 제한자 : 마지막의 의미, 변수에서는 마지막 값(데이터, 변경불가)
	final int CAR_LENGTH = 350; // 차량길이 
	final int CAR_WIDTH = 200;
	
	boolean hasAirbag; // 에어백 존재여부
	
	// 필드변수는 값 미지정시 참조형 = null 정수형 = 0 실수형 = 0.0 boolean = false
	
	// 생성자-----------
	// 클래스명 () {} - 기본생성자
	// 클래스명 (매개변수, 파라미터...) {}
	// 별도의 생성자가 있다면 기본생성자 필요시 직접 지정
	// 생성자에 아무것도 명시되어있지 않으면 인스턴스 변수 실행
	Car() {
		model = "드림카";
		color = "흰색";
	} // 파라미터 없는 메소드와 닮음 / 생성자는 앞에 클래스명 / return 타입x

	
	// 생성자를 명시적으로 만듬 = 해당 생성자만 사용한다. = 기본생성자 없어짐
	Car(String n, String m, String c) {
		name = n;
		model = m;
		color = c;
	}
	// 메소드(기능, 동작, 함수) 호출됨
	void run () {
		System.out.println(">> 앞으로 이동");
	}
	void stop () {
		System.out.println(">> 멈추기");
	}
	void back () {
		System.out.println(">> 뒤로가기");
	}
	// main method가 없어 실행 불가
	
	// 자동차 속성값 확인
	void dispData() {
		System.out.println("---- 자동차 정보 ----");
		System.out.println("자동차명 : " + name);
		System.out.println("모델명 : " + model);
		System.out.println("차량색상 : " + color);
		System.out.println("차량길이 : " + CAR_LENGTH);
		System.out.println("차량폭 : " + CAR_WIDTH);
		System.out.println("에어백 유무 : " + hasAirbag);
	}
}
