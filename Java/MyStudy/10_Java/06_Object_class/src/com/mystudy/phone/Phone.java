package com.mystudy.phone;

public class Phone {
	/* 속성(필드변수, 인스턴스변수, 멤버변수)
	가. 모델명 : name - String
	나. 타입 : type - String
	다. 가로크기 : hsize - int
	라. 세로크기 : vsize - int
	마. LCD유무 : hasLCD - boolean
	 */
	String name;
	String type;
	int hsize;
	int vsize;
	boolean hasLCD;
	
	// 생성자 선언
	
	Phone () {}
	
	Phone (String name) {
		this.name = name; //this 현재객체(인스턴스)
	}
	
	Phone (String name, String type) {
		// 파라미터값 name으로 할 경우 필드변수가 아닌 생성자 안에서만 저장됨 
		// this사용
		this.name = name;
		this.type = type;
	}
	
	Phone (String name, String type, boolean hasLCD) {
		this.name = name;
		this.type = type;
		this.hasLCD = hasLCD; 
	}
	
	
	void call ( ) {
		System.out.println(">> 전화걸기");
	}

	void receiveCall () {
		System.out.println(">> 전화받기");
	}

//	void method2(String param) {
//		System.out.println("파라미터값 O, return 값 X");
//	}
	
	void sendSms (String msg) {
		System.out.println("[메시지 전송] " + msg);
	}

//	String method4(String param) {
//		System.out.println("파라미터값 O, return 값 O");
//		return "파라미터값 O, return 값 O";
//	}
	
	String receiveSms (String msg) {
	// 메소드명 변수명 (파라미터값) {return }
		System.out.println("[메시지 수신] " + msg);
		return msg;
	}
	
	String reSms (String msg2) {
	// 메소드명 변수명 (파라미터값) {return }
		return msg2;
	}

		
	void dispData () {
		System.out.println("===전화기 정보 확인 ===");
		System.out.println("모델명 : " + name);
		System.out.println("타입 : " + type);
		System.out.println("가로크기 : " + hsize);
		System.out.println("세로크기 : " + vsize);
//		System.out.println("LCD 유무 : " + hasLCD);
		if (hasLCD) {
			System.out.println("LCD 유무 : 유");
		} else {
			System.out.println("LCD 유무 : 무");
		}
	}

}
