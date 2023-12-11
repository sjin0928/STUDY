package di_annotation;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("--->> AppleSpeaker() 객체 생성");
	}
	@Override
	public void volumeUp() {
		System.out.println(">> AppleSpeaker - 소리크게");
	}
	@Override
	public void volumeDown() {
		System.out.println(">> AppleSpeaker - 소리작게");
	}
}
