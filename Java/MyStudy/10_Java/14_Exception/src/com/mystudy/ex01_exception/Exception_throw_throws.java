package com.mystudy.ex01_exception;

public class Exception_throw_throws {

	public static void main(String[] args) {
		
		// throw : 예외 발생시키기
		// throws : 예외(들) 던질 때 (위임, 전가) 사용
		// throws는 메소드 선언부에 사용
		//--------------------------------------------------
		// throw new ArithmeticException();// 이 위치에서 예외발생
		// throw new ArithmeticException("throw 테스트중");
		// Exception 계열은 강제 예외처리
		// throw new Exception (); // 예외를 발생시킴 => 호출한 곳 으로 감 메소드 선언부
		
		System.out.println("--- main() 시작 ---");
		int num1 = 100;
		int num2 = 0;
		int result = 0;
		
		System.out.println(">> 연산처리 시작");
		try {
			result = divThrows(num1, num2);
		} catch (Exception e) {
			e.printStackTrace(); // 예외의 히스토리 보여줌
			System.out.println("[예외발생] main() divThrows : " + e.getMessage());
		}
		
		System.out.println("계산결과 : " + result);
		System.out.println("--- main() 끝 ---");

	}
	// throw : 예외를 발생시킴
	// throws : 메소드 선언부에 작성하여 호출한 곳으로 예외를 던짐(위임, 전가) 
	static int divThrows(int num1, int num2) throws Exception{
		System.out.println("---->> divThrows() 시작");
		int result = 0;
		try {
			result = num1 / num2;	
		} catch(ArithmeticException e) {
			System.out.println(">>> 예외발생 : " + e.getMessage());
			throw new Exception(":::: 내가 발생시킨 예외"); // Runtime은 처리하지 않아도 됨 
		}
		
		
		System.out.println("---->> divThrows() 끝");
		return result;
	}

}

