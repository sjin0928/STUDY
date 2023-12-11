package com.mystudy.ex02_extends;

class WebMp3Phone extends WebPhone{
	// 부모 클래스의 생성자 호출
	public WebMp3Phone (String phoneNo) {
		super (phoneNo);
	}
	public WebMp3Phone (String type, String phonNo) {
		super (type, phonNo);
	}
	
	public void mp3 () {
		System.out.println("Mp3 음악플레이..");
	}
}
