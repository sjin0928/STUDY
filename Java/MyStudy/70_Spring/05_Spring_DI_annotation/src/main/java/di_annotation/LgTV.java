package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Speaker 추가하고 lgTV, @Component, @Autowired, @Qualifier 추가해서 설정
@Component("lgTV") //lgTV 명칭으로 객체 생성(클래스명 첫 글자 소문자)
public class LgTV implements TV {
	
	@Autowired
	@Qualifier("sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println(">> LgTV() 객체 생성");
	}
	
//	@Autowired
//	public LgTV(@Qualifier("sony") Speaker speaker) {
//		System.out.println(">> Speaker 객체 생성");
//		this.speaker = speaker;
//	}
	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원OFF");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게~~~");
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게~~~");
		speaker.volumeDown();
	}
}
