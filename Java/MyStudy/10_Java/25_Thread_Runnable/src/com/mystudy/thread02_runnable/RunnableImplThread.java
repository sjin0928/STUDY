package com.mystudy.thread02_runnable;

class Parent {
	void print() {
		System.out.println("나는 Parent 클래스");
	}
}

// 다른 클래스를 상속확장하여 Thread 클래스를 상속받을 수 없을때
// 쓰레드로 만들기 위해서는 Runnable 인터페이스를 구현(implements)해서 만든다
class RunnableImple extends Parent implements Runnable {
	
	public void run() {
		super.print();
		System.out.println("RunnableImple run() : Runnable 인터페이스 구현");
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}
}

public class RunnableImplThread {

	public static void main(String[] args) {
		System.out.println("--- main() 시작 -------");
		
		// Runnable 이터페이스를 구현한 객체를 쓰레드로 사용하기 위해서는
		// Thread로 만들어야 하므로 Thread 클래스 객체를 생성해서 사용
		RunnableImple runnableImpl = new RunnableImple();
		// runnableImpl.run();
		
		// RunnableImple에는 .start 메소드가 없음
		
		// Thread 클래스의 생성자에 Runnable 구현객체를 주입해서 생성
		Thread th1 = new Thread(runnableImpl);
		th1.start();
		
		System.out.println("--- main() 끝 -------");

	}

}
