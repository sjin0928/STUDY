package com.mystudy.ex02_myexception;

public class MyExceptionTest {

	public static void main(String[] args) throws MyException {
		System.out.println("--- main() 시작 ----"); //(1)
		
		//throw new MyException("처음 만든 예외");
		
		try{
			firstMethod(); //(2)
		} catch(MyException e) {
			System.out.println(">> main -catch 문 실행");
			System.out.println(">> 오류메시지 : " + e.getMessage());
		}
		
		System.out.println("--- main() 끝 -----"); //(8)

	}

	private static void firstMethod() throws MyException {
		System.out.println("--firstMethod() 시작 ---"); //(3)
		
		secondMethod();//(4)
		
		System.out.println("--firstMethod() 끝 ----");//(7)
	}

	private static void secondMethod() throws MyException {
		System.out.println("---- secondMethod() 시작 ----");//(5)
		// 예외 발생시 4번으로 안감 // 예외 처리하면 정상 실행함
		// 예외 발생시키기
		throw new MyException("secondMethod()에서 예외 발생");
		
		
		//System.out.println("---- secondMethod() 끝 -----");//(6)
		
	}

}

