
public class Ex02_if_else {

	public static void main(String[] args) {
		// if 문 3종류
		// if (조건) {}
		// if (조건) {} else {}
		// if (조건) {} else if {} 
		
		int num1 = 30;
		int num2 = 50;
		System.out.println("num1 : " + num1 + ", num2 : " + num2);
		
		// 1. if (조건){}
		if (num1 > num2) {
			System.out.println("num1 > num2 : " + (num1 > num2));
			System.out.println("num1이 num2보다 크다");
		}
		if (num1 <= num2) {
			System.out.println("num1이 num2보다 작거나 같다");
		}// else대신 if로도 작성 가능
		
		System.out.println(">> if () 끝");
		System.out.println("----------------------");
		
		// 2. if (조건) {} else {}
		if (num1 > num2) {
			System.out.println("num1이 num2보다 크다");
		} else {
			System.out.println("num1이 num2보다 작거나 같다");
		}
		
		System.out.println(">> if ~ else () 끝");
		System.out.println("----------------------");
		
		//3. if (조건) {} else if () {} else if () {} ...else {} 
		num1 = 100;
		num2 = 50;
		System.out.println("num1 : " + num1 + ", num2 : " + num2);
		
		if (num1 > num2) {
			System.out.println("num1이 num2보다 크다");
		} else if (num1 == num2) {
			System.out.println("num1은 num2와 동일하다(같다)");
		} else {
			System.out.println("num1이 num2보다 작다");
		}
		System.out.println();
		System.out.println("========================");
		
		// 점수 평가 결과 출력 : 수, 우, 미, 양, 가
		/*
		 90~100 : 수
		 80~89 : 우
		 70~79 : 미
		 60~69 : 양
		 0~59 : 가
		 --------------------*/
		// if (조건) {} else if () {} else if () {} ...else {}
		
		System.out.println("---- 성적처리 ----");
		String name = "홍길동";
		String result;
		int jumsu = 55;
		
		if(jumsu < 0 || jumsu >= 90) {
			result = "수";
		} else if (jumsu >= 80) {
			result = "우";
		} else if (jumsu >= 70) {
			result = "미";
		} else if (jumsu >= 60) {
			result = "양";
		} else {
			result = "가";
			
		}
		System.out.println("이름 : " + name);
		System.out.println("점수 : " + jumsu);
		System.out.println("평가 : " + result);
		System.out.println("========================");
		
		// ============================
		/* if 문 내에 중첩해서 if문 사용 가능
		 *if() {
		 		if() {
		 		} else {
		 		}
		 */
		
	}

}
