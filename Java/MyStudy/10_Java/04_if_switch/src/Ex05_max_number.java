
public class Ex05_max_number {

	public static void main(String[] args) {
		/* 숫자 3개 중 가장 큰 수를 구하시오
		 a : 30, b : 60, c : 20
		 <결과>
		 가장 큰수 : 60
		 ------------------------*/
		
		int a = 30;
		int b = 60;
		int c = 20;
		int max;
		
		if (a >= b && a >= c) {
			max = a;
		} else if (b >= c) {
			max = b;
		} else {
			max = c;
		}
		System.out.println("<결과>");
		System.out.println("가장 큰수 : " + max);
		
		System.out.println("===============");
		
		if (a > b) { //a가 큰 경우
			if(a > c) {
				System.out.println("가장 큰수 : " + a);
			} else { // c가 큰 경우
				System.out.println("가장 큰수 : " + c);
			}
		} else { // b가 큰 경우
			if(b > c) {
				System.out.println("가장 큰수 : " + b);
				} else { // c가 큰 경우
					System.out.println("가장 큰수 : " + c);
				}
			}
		
		System.out.println("===============");
		
		/* 숫자 5개 중 가장 큰 수를 구하시오
		 a : 30, b : 60, c : 20, d : 15, e : 70
		 <결과>
		 가장 큰수 : 70
		 ------------------------*/
		
		
		a = 30;
		b = 60;
		c = 20;
		int d = 15;
		int e = 70;
		//int max2;
		int max2 = Integer.MIN_VALUE;
		
		if (a >= b && a >= c && a >= d && a >= e) {
			max2 = a;
		} else if (b >= c && b >= d && b >= e) {
			max2 = b;
		} else if (c >= d && c >= e) {
			max2 = c;
		} else if (d >= e) {
			max2 = d;
		} else {
			max2 = e;
		}
			
			
		System.out.println("<결과>");
		System.out.println("가장 큰수 : " + max2);
		System.out.println("===============");
	
				
		if (a >= max2) {
			max2 = a;
		}
		if (b >= max2) {
			max2 = b;
		}
		if (c >= max2) {
			max2 = c;
		}
		if (d >= max2) {
			max2 = d;
		}
		if (e >= max2) {
			max2 = e;
		}
			
			
		System.out.println("<결과>");
		System.out.println("가장 큰수 : " + max2);
		System.out.println("===============");
	
				
	}
}
