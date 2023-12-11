package com.mystudy.ex04_interface2;
// extends Object 생략되어있음
// Phone 은 object에 상속되어있음
// Phone 은 I_Phone에 상속
class Phone implements I_Phone{
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
	public String getType() {
		return type;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	@Override
	public void view() {
		System.out.println("타입 : " + type + ", 전화번호 : " + phoneNo);
		
	}

	@Override
	public void call() {
		System.out.println(">> 전화걸기");
		
	}

	@Override
	public void receivecall() {
		System.out.println(">> 전화받기~~");
		
	}

	@Override
	public void sendSMS() {
		System.out.println(">> 메시지 보내기");
		
	}

	@Override
	public void receiveSMS() {
		System.out.println(">> 메시지 받기");
		
	}
	
}
