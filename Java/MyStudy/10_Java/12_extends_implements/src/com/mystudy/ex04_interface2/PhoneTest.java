package com.mystudy.ex04_interface2;

public class PhoneTest {

	public static void main(String[] args) {
		System.out.println("==== Phone ====");
		Phone ph1 = new Phone ("010-1111-1111");
		ph1.view();
		ph1.call();
		ph1.receivecall();
		ph1.sendSMS();
		ph1.receiveSMS();
		System.out.println("ph1.getPhoneNo()"+ph1.getPhoneNo());
		
		System.out.println("=== mp3ph ===");
		Mp3Phone mp3ph = new Mp3Phone("010-2222-2222");
		mp3ph.view();
		mp3ph.call();
		mp3ph.receivecall();
		mp3ph.sendSMS();
		mp3ph.receiveSMS();
		mp3ph.playMusic();
		

	}

}
