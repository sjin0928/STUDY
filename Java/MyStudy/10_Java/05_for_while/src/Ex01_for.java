
public class Ex01_for {

	public static void main(String[] args) {
		// 제어문 - 반복문 (for, while, do ~ while)
		// for (초기값 설정; 실행(종결) 조건; 증감설정) {명령문} - 예시
		
		// for (;;) {} 무조건 실행, 무한 반복
		for (int i = 1; i <=3 ; i++) {
			System.out.println("*");
		}
		System.out.println("---------------");
		// 별(*) 10번
		
		for (int i = 1 ; i <= 10 ; i += 2) {
			System.out.println("*");
		}
		
		// ======================================
		
		System.out.println("========== 1부터 5까지 출력");
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5); // 1~5의 숫자로는 반복 불가 변수로 지정하기
		System.out.println("--------------------");
		
		int num = 1;
		System.out.println(num); // 30-31라인의 패턴 반복
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num);
		num++;
		System.out.println(num); // for 반복문으로 변경 가능
		
		System.out.println("--------------------");
		num = 1;
		for(int i = 1 ; i <= 5 ; i++) {
			System.out.println(num);
			num++;
		}
		
		System.out.println("-----++ 앞에쓰면 2부터 출력-----");
		num = 1;
		for(int i = 1 ; i <= 5 ; i++) { // ++ 앞에쓰면 2부터 출력
			System.out.println(num++); 
		}
		
		System.out.println("---++를 앞에 쓰려면 초기값을 0으로---");
		num = 0;
		for(int i = 1 ; i <= 5 ; i++) { // ++를 앞에 쓰려면 초기값을 0으로
			System.out.println(++num);  
		}
		
		System.out.println("-----반복인자 값을 활용하여 출력------");
		
		for(int i = 1 ; i <= 5 ; i++) { // 반복인자 값을 활용하여 출력
			System.out.println(i);
		}
				
	}// end main

}// end class
