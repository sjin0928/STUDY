package polymorphism01;

import polymorphism01.TV;

public class LgTV implements TV {
	//TV 인터페이스를 구현한 구현체
	
	public LgTV() {
		System.out.println(">> LgTV() 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원 OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게~");
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게~");
	}
}
