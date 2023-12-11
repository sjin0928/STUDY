package com.mystudy.ex06_type_casting;

public class CarTest {

	public static void main(String[] args) {
		System.out.println("=== Car 클래스 ====");
		Car car = new Car();
		car.type = "자동차";
		System.out.println("타입 : " + car.type);
		car.drive();
		car.stop();
		
		System.out.println("=== Ambulance 클래스 ===");
		Ambulance am = new Ambulance();
		am.type = "구급차";
		System.out.println("타입 : " + am.type);
		am.drive();
		am.stop();
		am.siren();
		
		System.out.println("==== FireEngine 클래스 ====");
		FireEngine fe = new FireEngine();
		fe.type = "소방차";
		System.out.println("타입 : " + fe.type);
		fe.drive();
		fe.stop();
		fe.siren();
		fe.water();
		
		System.out.println("=== 형변환 ===");
		// car, Ambulance, FireEngine
		Car car2 = new Car();
		car2.type = "자동차";
		System.out.println("type : " + car2.type);
		car2.drive(); 
		car2.stop();
		// car2.siren(); // 컴파일 오류 undefined : Car 타입에는 siren() 이 없음
		
		System.out.println("--- Car <---Ambulance 저장 ---");
		// Car <--- Ambulance : 부모 (상위)타입  <--- 자녀 (하위) 타입 자동 형변환
		// 부모(상위)클래스에 자녀 (하위)클래스를 저장
		car2 = am; // Car <--- Ambulance : 자동 형변환
		System.out.println("type : " + car2.type);
		car2.drive();
		car2.stop();
		
		// 앰뷸런스 고유기능 siren() 사용하려면 Ambulance 타입이 되어야함.
		((Ambulance)car2).siren(); //타입은 car 타입이라 안됨 
		
		// ======================
		System.out.println("--- Ambulance <--- Car <-- Ambulance ---");
		System.out.println("car2 type : " + car2.type);
		Ambulance am2 = (Ambulance)car2; // Car 타입에 저장되어 있던 Ambulance타입은 가능
		am2.drive();
		am2.siren();
		
		// 자녀 (하위) 클래스에 부모(상위)클래스를 저장
		System.out.println("--- Ambulance <--- Car 저장 ---");
		Car carTemp = new Car();
		carTemp.type = "일반자동차";
		System.out.println("carTemp type : " + carTemp.type);
		// 강제 형변환 문법적으로 가능하나 실행시 오류 발생 : ClassCastException
		//Ambulance am2 = (Ambulance)carTemp; // 강제형변환
		
	}

}
