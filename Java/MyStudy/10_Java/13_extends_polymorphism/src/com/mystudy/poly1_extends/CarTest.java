package com.mystudy.poly1_extends;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("==== Car 클래스 ====");
		Car car = new Car();
		car.type = "자동차(Car)";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("==== Ambulace 클래스 ===");
		Ambulance am = new Ambulance();
		am.type = "구급차(Ambulace)";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		
		am.siren();
		
		System.out.println("==== FireEngine 클래스 ===");
		FireEngine fe = new FireEngine();
		fe.type = "소방차(FireEngine)";
		System.out.println("타입 : " + fe.type);
		fe.drive();
		fe.stop();
		
		fe.siren();
		fe.water();
		
		System.out.println("==== 타입확인 =====");
		Car carTemp = car; // Car <-- Car 저장
		carTemp = am; // Car <-- Ambulance 저장
		carTemp = fe; // Car <-- FireEngine 저장
		System.out.println("자동차타입 : " + carTemp.type);
		System.out.println("--- 타입확인(instanceof) ---");
		// 현재 사용 carTemp 타입은 car타입 그 안에 am, fe가있음
		// Object<-Car<-FireEngine
		if(carTemp instanceof Object) {
			System.out.println("---- Object 타입이다");
		}
		
		if(carTemp instanceof Car) {
			System.out.println("---- Car 타입이다");
			carTemp.drive();
			carTemp.stop();
		}
		
		carTemp = am;
		if(carTemp instanceof Ambulance) {
			System.out.println("---- Ambulance 타입이다");
			carTemp.drive();
			carTemp.stop();
			((Ambulance) carTemp).siren(); // 형변환
		}
		
		carTemp = fe; // Car <-- FireEngine 저장
		if(carTemp instanceof FireEngine) {
			System.out.println("---- FireEngine 타입이다");
			carTemp.drive();
			carTemp.stop();
			((FireEngine) carTemp).siren(); // 강제형변환
			((FireEngine) carTemp).water();
		}
		
		System.out.println("=====================");
		// 상속관계이므로 drive, stop의 기능을 사용가능
		System.out.println("--- Car 타입객체 전달시(타입체크) ---");
		typecheck(car); // Car
		System.out.println("--- Ambulance 타입객체 전달시(타입체크) ---");
		typecheck(am); // Ambulance
		System.out.println("--- FireEngine 타입객체 전달시(타입체크) ---");
		typecheck(fe); // FireEngine
		
		System.out.println("--- main() 끝");
	}
	
	static void typecheck(Car car) {
		System.out.println(":: Car 타입입니다.");
		car.drive();
		car.stop();
		
		// 확인할 객체 instanceof 확인할 클래스명(타입명)
		if(car instanceof Ambulance) {
			System.out.println("---- Ambulance 타입이다");
			((Ambulance) car).siren(); // 형변환
		}
		
		if(car instanceof FireEngine) {
			System.out.println("---- FireEngine 타입이다");
			((FireEngine) car).siren(); // 강제형변환
			((FireEngine) car).water();
		}
	
	}

}







