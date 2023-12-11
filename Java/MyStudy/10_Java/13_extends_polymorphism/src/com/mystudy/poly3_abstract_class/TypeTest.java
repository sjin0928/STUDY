package com.mystudy.poly3_abstract_class;

class TypeTest {

	public static void main(String[] args) {
		// AbstractAnimal animal = new AbstractAnimal();
		// 추상클래스로는 객체생성 불가
		Cat cat = new Cat();
		cat.sound();
		
		Dog dog = new Dog();
		dog.sound();
		
		System.out.println("--------------");
		sound(cat);
		sound(dog);

	}
	// 부모클래스인 추상클래스 타입으로 바아서 처리
	static void sound(AbstractAnimal animal) {
		animal.sound();
	}

}
