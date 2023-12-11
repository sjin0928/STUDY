package com.mystudy.ex03_interface;

//public class phone extends Object { extends Object는 자동으로 컴파일시 생성

class Phone{ //extends Object는 자동으로 컴파일시 생성 / 생략사용
	// 필드변수 (속성)-------------
	private String type; // 전화타입(형태)
	private String phoneNo; //전화번호

	// 생성자----------
	// 기본값을 필드변수에서 해도됨.
	// 기본생성자는 쓸수없는 생성자가 됨
	public Phone () {}
	public Phone (String phoneNo) {
		this.type = "phone 타입";
		this.phoneNo = phoneNo;
	}
	
	public Phone (String type, String phoneNo) {
		this.type = type;
		this.phoneNo = phoneNo;
	}
	
	// 메소드=========
	// set 타입이 없으므로 개별 변경 불가
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	// 전화걸기 기능
	public void call() {
		System.out.println(">> 전화걸기");
	}
	// 전화받기 기능
	public void receiveCall () {
		System.out.println(">> 전화받기~~");
	}
	
	// 전화정보 확인
	public void view() {
		System.out.println("타입 : " + type + ", 전화번호 : " + phoneNo);
	}
}
