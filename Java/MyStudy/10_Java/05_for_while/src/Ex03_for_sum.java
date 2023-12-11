
public class Ex03_for_sum {

	public static void main(String[] args) {
		// 문제 : 1~10까지의 합계 (for, 화면 출력)
		// 1~10 까지의 합계 : 55
		// 
		
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("1~10 까지의 합계 : " + sum);
		
		//1~10 까지의 숫자중에 짝수를 찾아서 출력
		System.out.println("===1~10 까지의 숫자중에 짝수를 찾아서 출력====");
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}			
		}
		
		System.out.println("=====1~10까지의 숫자중에 홀수 찾아서 출력=====");
		//1~10까지의 숫자중에 홀수 찾아서 출력
		for (int i = 1; i <= 10; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
		
	}

}
