
public class Ex06_for_star {

	public static void main(String[] args) {
		// ***** 화면 출력 :)
		System.out.println("*****");
		System.out.println("-----------");
		
		System.out.print("*****");
		System.out.println(); // 줄바꿈 역할
		System.out.println("-----------");
		
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.print("*");
		System.out.println();
		
		
		System.out.println("---- 반복문 print *(별) 찍기 반복 ----");
		String star = "*";
		
		for (int i = 1; i <= 5; i++) {
			System.out.print(star);
		}
		System.out.println();
		System.out.println("-----------");
		
		// 1번째
		for (int i = 1; i <= 5; i++) {
			System.out.print(star);
		}
		System.out.println();
		// 2번째
		for (int i = 1; i <= 5; i++) {
			System.out.print(star);
		}
		System.out.println();
		// 3번째
		for (int i = 1; i <= 5; i++) {
			System.out.print(star);
		}
		System.out.println();
				
		System.out.println("==== 이중 반복 처리 ====");
		for (int line = 1; line <= 3; line++) {
			for (int i = 1; i <= 5; i++) {
				System.out.print(star);
			}
			System.out.println();
		}
		System.out.println("=======================");
		
		System.out.print("*****");
		System.out.println();
		System.out.println("=======================");
		
		for (int i = 1; i <= 3; i++) {
			for (int st = 1; st <= 5; st++) {
				System.out.print("*");
			}			
			System.out.println();
		}
		System.out.println("=======================");
		
		System.out.println("==== 삼각형 * 찍기====");
		/* 화면(콘솔창)에 삼각형 모양을 출력
		 * 
		 **
		 ***
		 ****
		 *****
		 */
		for (int e = 1; e <= 5; e++) {
			if (e == 1) {
				for (int i = 1; i <= e; i++) {
					System.out.print("*");
					}
				}
			if (e == 2) {
				for (int i = 1; i <= e; i++) {
					System.out.print("*");
				}
			}
			if (e == 3) {
				for (int i = 1; i <= e; i++) {
					System.out.print("*");
				}
			}
			if (e == 4) {
				for (int i = 1; i <= e; i++) {
					System.out.print("*");
				}
			}
			if (e == 5) {
				for (int i = 1; i <= e; i++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("====================");
		
		for (int e = 1; e <= 5; e++) {
			for (int i = 1; i <= e; i++) {
					System.out.print("*");
				}
			System.out.println();
			}
		
		System.out.println("====================");
		
		for (int e = 1; e <= 5; e++) {
			for (int i = 1; i <= (5 - e); i++) {
				System.out.print(" ");
				}
			for (int i = 1; i <= e; i++) {
				System.out.print("*");
				}
			System.out.println();
			}
	}

}
