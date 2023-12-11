
public class Ex01_boolean {
	
	public static void main(String[] args) {
		// boolean : true, false 값을 가짐(논리형)
		// 타입 변수명; : 변수선언만함
		// 타입 변수명 = 값; : 변수선언 + 초기값 설정
		boolean bool1 = true;
		boolean bool2 = false;
		
		System.out.println("bool1 : " + bool1);
		System.out.println("bool2 : " + bool2);
		
		bool1 = false; // 변수값 재지정
		//bool1 = true; // 변수값 재지정
		if(bool1) { //bool1의 값이 true일 경우에만 실행
			System.out.println("if문 bool1이 참(true)이면 실행");
		}else {
			System.out.println("if문 bool1이 거짓(false)이면 실행");
		}
		
		System.out.println("---- main() 메소드 끝-----");
	}

}
