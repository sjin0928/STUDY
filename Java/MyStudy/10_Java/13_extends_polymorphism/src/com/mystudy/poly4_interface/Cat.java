package com.mystudy.poly4_interface;

public class Cat extends AbstractAnimal {
	
	public Cat() {
		super("고양이");
	}

	@Override
	public void sound() {
		System.out.println(super.getName() + ">> 야옹~~");
		
	}
	// getname 메소드가 cat에 있으면 그거씀 super.는 생략가능
	
	public void test() {
		System.out.println(">> 테스트용 메소드 실행");
	}
	// 애니멀에 담겨있는 객체가 cat // 애니멀에는 test가 없으므로 사용 x

}
