package com.mystudy.innerclass;

interface TestInter {
	int DATA = 100; // 공통으로 사용
	void printData(); // 추상메소드 구현부x
}

// 인터페이스를 구현한 클래스
class TestInterImpl implements TestInter {

	@Override
	public void printData() {
		System.out.println(">>> 구현한 메소드");
	}
}

public class AnonymousClassTest {

	public static void main(String[] args) {
		TestInterImpl imp = new TestInterImpl();
		imp.printData();
		
		TestInter imp2 = new TestInterImpl();
		imp.printData();
		
		System.out.println("---- 익명클래스 작성 ----");
		// 익명클래스 : 클래스의 이름이 없는 클래스
		TestInter test = new TestInter() {
			
			// 구현~ 했으므로.. 클래스..
			@Override
			public void printData() {
				System.out.println("DATA : " + DATA);
				
			}
		}; //문장의 끝?
		
		test.printData();
		
		// 단한번 사용 하고 버려짐
		(new TestInter() {
			// 구현~ 했으므로.. 클래스..
			@Override
			public void printData() {
				System.out.println("DATA : " + DATA);
			}
		}).printData();

	}

}
