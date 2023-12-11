
public class Ex02_for_exam {

	public static void main(String[] args) {
		// for (초기값 설정; 실행(종결) 조건; 증감설정) {명령문}

		// (실습1) 1~5까지의 숫자
		// --------------------
		// (실습2) 11, 12, 13, 14, 15
		// --------------------
		// (실습3) 1,3,5,7,9
		// --------------------
		// (실습4) 2,4,6,8,10 
		// --------------------
		// (실습5) 5,4,3,2,1
		// --------------------

		System.out.println("----(실습1) 1~5까지의 숫자----");
		for (int i = 1 ; i <= 5 ; i++) {
			System.out.println(i);
		}
		System.out.println("-------------------------");
		
		System.out.println("--(실습2) 11,12,13,14,15--");
		
		for (int i = 11 ; i <= 15 ; i++) {
			System.out.println(i);
		}
		System.out.println("-------------------------");
		
		System.out.println("----(실습3) 1,3,5,7,9-----");
		for (int i = 1 ; i <= 10 ; i += 2) {
			System.out.println(i);
		}
		System.out.println("-------------------------");
		
		System.out.println("----(실습4) 2,4,6,8,10----");
		for (int i = 2 ; i <= 10 ; i += 2) {
			System.out.println(i);			
		}
		
		System.out.println("----(실습4) 별도 변수 사용----");
		int num = 2;
		for (int i = 1 ; i <= 5 ; i++) {
			System.out.println(num);
			num += 2;
		}
		
		System.out.println("-------------------------");
		
		System.out.println("----(실습5) 5,4,3,2,1-----");
		for (int i = 5 ; i >= 1 ; i--) {
			System.out.println(i);
		}
		System.out.println("-------------------------");
	}

}
