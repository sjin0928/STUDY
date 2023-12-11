package com.mystudy.poly4_interface;

public class TypeTest {

	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		cat.eat();
		cat.sleep();
		cat.sound();
		cat.test();
		
		dog.sound();
		
		Pig pig = new Pig();
		
		System.out.println("===== Animal 타입 사용(Cat 객체) ====");
		Animal animal = new Cat();
		// interface 로 구현하는 순간 interface안에 있는것만 구현 가능
		animal.eat();
		animal.sleep();
		animal.sound();
		
		// 타입 변경시 해당 데이터 타입에 있는 정의된 기능(메소드)만 사용가능
		//animal.test(); 인터페이스 animal에 없는 메소드 = 사용불가
		
		System.out.println("==== 메소드 파라미터 Animal 인터페이스 사용 ===");
		soundPoly(cat);
		soundPoly(dog);
		soundPoly(pig);
	}
	// 인터페이스 Animal 타입으로 데이터를 받아서
	// 인터페이스 타입에 저장된 데이터에 있는 sound() 메소드 호출
	// (메소드 오버라이딩에 의해 저장된 객체의 메소드 호출)
	static void soundPoly(Animal animal) {
		animal.sound();
	}

}
