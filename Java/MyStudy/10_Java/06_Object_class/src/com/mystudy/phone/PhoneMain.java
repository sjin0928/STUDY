package com.mystudy.phone;

public class PhoneMain {

	public static void main(String[] args) {
		
		Phone phone1 = new Phone();
		System.out.println("phone1 : " + phone1);
		// phone1 타입의 데이터는 주소값 / 호출시 주소값을 따라가라는 뜻?
		phone1.dispData();
		System.out.println("=========================\n");
		
		Phone phone2 = new Phone("갤럭시", "S22");
		System.out.println("phone2 : " + phone2);
		System.out.println("모델명 : " + phone2.name);
		System.out.println("모델명 : " + phone2.type);
		System.out.println("------");
		Phone phone3 = new Phone("갤럭시", "S22", false);
		System.out.println("phone3 : " + phone3);
		System.out.println("모델명 : " + phone3.name);
		System.out.println("모델명 : " + phone3.type);
		System.out.println("모델명 : " + phone3.hasLCD);
		phone3.hsize = 40;
		phone3.vsize = 150;
		phone3.dispData();
		System.out.println("---------");
		phone3.call();
		phone3.receiveCall();
		phone3.sendSms("ㅠㅠ?");
		phone3.receiveSms("ssdsd");
		// 값 미지정시 오류 ㅠㅠ -> Phone의 sendSms msg에 저장 -> 출력
		
		String receivemsg = phone3.reSms("ㅠㅠㅠㅠㅠㅠㅠ");
		//ㅠㅠㅠ -> String msg에 저장 return msg에서 반환
		// -> receiveSms로 전달 phone3.receiveSmsdptj 좌측에 저장
		System.out.println("::받은메시지 : " + receivemsg);
				
		System.out.println("=========================");
		
	}

}
