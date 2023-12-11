package com.mystudy.poly2_overriding;

public class TypeTest {

	public static void main(String[] args) {
		Animal an = new Animal();
		Cat cat = new Cat();
		Dog dog = new Dog();
		Pig pig = new Pig();
		
		cat.sound();
		dog.sound();
		pig.sound();
		
		System.out.println("---- 메소드 오버로딩(overloading) 방식 ");
		//오버로딩은 하나의 클래스안에서
		sound_overloading(cat);
		sound_overloading(dog);
		sound_overloading(pig);
		
		System.out.println("=== 메소드 오버라이딩(overriding)사용 ====");
		sound(an);
		sound(cat);
		sound(dog);
		sound(pig);
	}
	
	// 메소드 오버라이딩(overriding)사용
	// animal 하나로 객체에 따른 다양한 동작을 함
	static void sound(Animal animal) {
		animal.sound();
	}
	
	
	// 타입은 애니멀 캣타입 데이터생성시 애니멀(상위)타입, Object 가 생성
	// 애니멀타입의 메소드를 호출시 자녀쪽의 마지막 재정의된 메소드를 사용
	
	// instanceof 사용 타입 확인하는 패턴
	// 오버라이드가 없어 형변환 필요
	static void sound_instanceof(Animal animal) {
		if (animal instanceof Cat) {
			((Cat)animal).sound();
		} else if(animal instanceof Dog) {
			((Dog)animal).sound();
		}
	}
	
	// 메소드 오버로딩(overloading) 방식 ======================
	static void sound_overloading(Cat cat) {
		cat.sound();
	}
	static void sound_overloading(Dog dog) {
		dog.sound();
	}
	
	static void sound_overloading(Pig pig) {
		pig.sound();
	}

}
