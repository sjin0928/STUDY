package com.mystudy.ex03_sungjuk;

public class SungjukTest {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 ---");
		
		SungjukVO stu = new SungjukVO("홍길동", 100, 90, 80, 0, 0);
		
		stu.setKor(999);
		
		System.out.println("stu : " + stu);

		try {
			stu.setEng(952);
		} catch (JumsuOutOfValueException e) { //상위타입이 먼저오면 하위타입은 쓸데가 없어 오류남
			e.printStackTrace();
			System.out.println(e.getMessage()
					+ " : 0~100 범위의 값으로 다시 입력하세요");
		} catch (SungjukProcessException e) {
			System.out.println("[예외발생} 성적처리중 예외발생");
		}
		
		System.out.println("stu : " + stu);
		
		System.out.println("--- main() 끝 ---");

	}

}
