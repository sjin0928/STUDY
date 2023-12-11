
public class Ex11_while_exam {

	public static void main(String[] args) {
		// while 문으로 처리
		// (실습) 문제1 : 1~10까지의 합을 구하고 화면 출력
		System.out.println("========문제1=========");
		int i = 1;
		int sum = 0;
		while (i <= 10) {
			sum = sum + i; 
			i++;
		}
		System.out.println("1~10까지의 합 : " + sum);
				
		/* (실습) 문제2 ------ 
		 *****
		 *****
		 *****
		 --------*/
		
		System.out.println("========문제2=========");
		int o = 1;
		while (o <= 3) {
			int e = 1; // 중복while 문은 while 문의 바로 앞에 변수 지정 해야 반복 가능
			while (e <= 5) {
				System.out.print("*");
				e++;
			}
			System.out.println();
			o++;
		}
			
		/* (실습) 문제3 ------ 
		 *
		 **
		 ***
		 ****
		 --------*/
		System.out.println("========문제3=========");
		int line = 1;
		while (line <= 4) {
			int star = 1;
			while (star <= line) {
				System.out.print("*");
				star++;
			}
			System.out.println();
			line++;
		}
	}

}
