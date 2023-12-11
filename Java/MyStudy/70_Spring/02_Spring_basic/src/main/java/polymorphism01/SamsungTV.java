package polymorphism01;

import polymorphism01.TV;

public class SamsungTV implements TV {
	//TV 인터페이스를 구현한 구현체
	public SamsungTV() {
		System.out.println(">> Samsung TV() 객체 생성");
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV - 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("SamsungTV - 전원 OFF");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV - 소리크게");
	}
	@Override
	public void volumeDown() {
		System.out.println("SamsungTV - 소리작게");
	}
}
