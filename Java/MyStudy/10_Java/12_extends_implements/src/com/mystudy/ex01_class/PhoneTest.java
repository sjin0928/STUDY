package com.mystudy.ex01_class;

public class PhoneTest {

	public static void main(String[] args) {
		// Phone 객체(인스턴스) 생성 후 기능 테스트
		System.out.println("===phone===");
		// object와 Phone의 상속
		Phone ph1 = new Phone("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receiveCall();
		
		System.out.println("-------------");
		// 생성자의 기능은 초기값 세팅
		Phone ph2 = new Phone("삼성갤럭시폰", "010-2222-2222");
		ph2.view(); 
		ph2.call();
		ph2.receiveCall();
		
		System.out.println("========== Mp3Phone ===========");
		// object와 Mp3Phone의 상속
		Mp3Phone mp3ph = new Mp3Phone("010-333-3333");
		mp3ph.view();
		mp3ph.call();
		mp3ph.receiveCall();
		mp3ph.playMusic();
				
	}

}
