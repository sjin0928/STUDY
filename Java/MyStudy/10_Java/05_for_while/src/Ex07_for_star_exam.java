
public class Ex07_for_star_exam {

	public static void main(String[] args) {
			
			/* 문제 -------------------
		***** : * 5번 줄 바꿈
		****
		***
		**
		*
		-----------------------*/
		System.out.println("----------문제1------------");
		for (int e = 1; e <= 5; e++) {
			for (int i = 5; i >= e; i--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	
		
		/* 문제2------------------
		     * : 빈칸 4 + * 1개 + 줄바꿈
		    **
		   ***
		  ****
		 *****		 
		 -----------------------------*/
		System.out.println("----------문제2------------");
		for (int e = 1; e <= 5; e++) {
			for (int space =  1; space <= (5 - e); space++) {
				System.out.print(" ");
			}
			for (int star = 1; star <= e; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/* 문제 3
		 *****
		  ****
		   ***
		    **
		     *
		 -----------------------------*/
		System.out.println("----------문제3------------");
		for (int e = 1; e <= 5; e++) {
			for (int space = 1; space <= (e - 1); space++) {
				System.out.print(" ");
			}
			for (int star = 5; star >= e; star--) {
				System.out.print("*");
			}	
			System.out.println();
		}
		
		
		/* 문제 4
		 1 (1+ 빈칸1)
		 1 2 (1+ 빈칸1) + (2+ 빈칸1) + 줄바꿈
		 1 2 3
		 1 2 3 4
		 */
		System.out.println("----------문제4------------");
	
		for (int line = 1; line <= 4; line++) {
			for (int m = 1; m <= line; m++) {
				System.out.print(m);
				System.out.print(" ");
			}
			System.out.println();			
		}
		int cnt = 1;
		for (int line = 1; line <= 4; line++) {
			int num = 1;
			for (int i = 1; i <= cnt; i++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
			cnt++;
		}
		
		
		System.out.println("=====================");		
		
		/* 문제 5
		 1 (1+ 빈칸1)
		 2 3 (1+ 빈칸1) + (2+ 빈칸1) + 줄바꿈
		 4 5 6
		 7 8 9 10
		 */
		System.out.println("----------문제5------------");
		
		cnt = 1;
		int num1 = 1;
		for (int line = 1; line <= 4; line++) {
			
			for (int i = 1; i <= cnt; i++) {
				System.out.print(num1 + " ");
				num1++;
			}
			System.out.println();
			cnt++;
		}
		
		
		System.out.println("=======continue 삽입==========");
		
		for (int n = 1; n <= 10; n++) {
			System.out.print(n);
			System.out.print(" ");
			if(n == 2) continue;
			if(n == 4) continue;
			if(n == 5) continue;
			if(n == 7) continue;
			if(n == 8) continue;
			if(n == 9) continue;
			System.out.println();	
		}
		System.out.println("====== or 삽입 ===========");
		
		for (int d = 1; d <= 10; d++) {
			System.out.print(d);
			System.out.print(" ");
			if (d == 1 || d == 3 || d == 6) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("================");
		
		/* 문제 4
		 1 (1+ 빈칸1)
		 1 2 (1+ 빈칸1) + (2+ 빈칸1) + 줄바꿈
		 1 2 3
		 1 2 3 4
		 */
	
		
		int c = 1;
		for (int line = 1; line <= 4; line++) {
			int n = 1;
			for (int i = 1; i <= c; i++) { 
				System.out.print(n + " ");
				n++;
			}
			System.out.println();
			c++;
		}
	
		/* 문제 5
		 1 (1+ 빈칸1)
		 2 3 (1+ 빈칸1) + (2+ 빈칸1) + 줄바꿈
		 4 5 6
		 7 8 9 10
		 */
		
		int n = 1;
		c = 1;
		for (int line = 1; line <= 4; line++) {
			for (int i = 1; i <= c; i++) { 
				System.out.print(n + " ");
				n++;
			}
			System.out.println();
			c++;
		}
	}
}

