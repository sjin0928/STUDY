package com.mystudy.generic;

class BoxT<T> { // T는 타입의 총칭
	T obj;
	T getObj() {
		return obj;
	}
	void setObj(T obj) { // 파라미터타입(매개변수)
		this.obj = obj;
	}
}

public class GenericWildcardExam {

	public static void main(String[] args) {
		/*
		 제네릭(Generic)의 대표문자(wildcard)
		  1. <?> : 모든 타입(객체) 자료형에 대한 대표문자를 의미
		  2. <? extends 자료형> : 자료형(포함)을 상속받은 자녀(sub) 클래스 타입 사용
		  3. <? super 자료형> : 자료형(포함)의 부모(super) 타입 사용
		---------------------------------------------------------------- */
		
		BoxT<String> box1 = new BoxT<String>();
		box1.setObj("문자열");
		BoxT<Integer> box2 = new BoxT<>(); // 앞에 쓰면 뒤에 생략 가능
		// box2.setObj("문자열"); // 타입 불일치
		// box2.setobj(100.00); // 타입 불일치
		box2.setObj(1000);
		
		System.out.println("----------------");
		// <?> 모든것을 담을 수 있는 형태
		BoxT<?> box3 = new BoxT <String>();
		box3 = new BoxT<Integer>();
		box3 = new BoxT<StringBuilder>();
		
		// <? extends 자료형> : 자료형(포함)을 상속받은 자녀(sub) 클래스 타입 사용
		BoxT<? extends Number> box4 = null;
		box4 = new BoxT<Number>();
		box4 = new BoxT<Integer>();
		box4 = new BoxT<Double>();
		box4 = new BoxT<Float>();
		
		// [컴파일 오류] Character가 Number 타입을 상속(extends) 받지않음
		// box4 = new BoxT<Character>();

		// =========================================
		// <? super 자료형> : 자료형(포함)의 부모(super) 타입 사용
		
		BoxT<? super Number> box5 = null;
		box5 = new BoxT<Number>();
		box5 = new BoxT<Object>();

		// [컴파일 오류] Integer가 Number 타입의 상위/수퍼(super) 타입아님
		// box5 = new BoxT<Integer>(); // 자녀타입 x
		
	}

}

