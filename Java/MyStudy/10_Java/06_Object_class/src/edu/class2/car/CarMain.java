package edu.class2.car;

public class CarMain {

	public static void main(String[] args) {
		// Car 클래스를 이용하여 Car타입의 객체(인스턴스) 생성하여 사용
		Car car1 = new Car(); // 호출하는 곳의 기본생성자
		car1.color = "검정";
		// car1.CAR_LENGTH = 400; =>컴파일 오류 : final 변수값 수정 못함.
		
		
		System.out.println("자동차명 : " + car1.name);
		System.out.println("모델명 : " + car1.model);
		System.out.println("차량색상 : " + car1.color);
		System.out.println("차량길이 : " + car1.CAR_LENGTH);
		System.out.println("차량폭 : " + car1.CAR_WIDTH);
		System.out.println("에어백 유무 : " + car1.hasAirbag);
		System.out.println("-------------");
		
		car1.name = "처음 가져 본 차";
		System.out.println("자동차명 : " + car1.name);
		car1.hasAirbag = true;
		System.out.println("에어백 유무 : " + car1.hasAirbag);
		
		System.out.println("=======기능 테스트=======");
		//호출함
		car1.run();
		car1.stop();
		car1.back();
		
		System.out.println("===========================");
		System.out.println("======= car2 생성 사용========");
		//Car car2 = new Car();
		Car car2 = new Car("자동차", "코나", "하늘색");
		car2.dispData();
		
	}

}
