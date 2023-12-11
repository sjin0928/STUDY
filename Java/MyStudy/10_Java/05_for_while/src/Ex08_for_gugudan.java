
public class Ex08_for_gugudan {

	public static void main(String[] args) {
		/* 구구단 중 2단 출력
		 2*1=2
		 2*2=4
		 2*3=6
		 ...
		 2*9=18
		 */
		int n = 2;
		int a = 9;
		System.out.println("---" + n + "단 출력---");
		for (int i = 1; i <= a; i++) {
			System.out.println(n + " * " + i + " = " + (n * i));
		}
		n++;
		System.out.println("---" + n + "단 출력---");
		for (int i = 1; i <= a; i++) {
			System.out.println(n + " * " + i + " = " + (n * i));
		}
		n++;
		System.out.println("---" + n + "단 출력---");
		for (int i = 1; i <= a; i++) {
			System.out.println(n + " * " + i + " = " + (n * i));
		}
		n++;
		
		System.out.println("---2~9단 출력---");
		n = 2;
		for (int m = 1; m <= 8; m++) {
			System.out.println("---" + n + "단 출력---");
			for (int i = 1; i <= a; i++) {
				System.out.println(n + " * " + i + " = " + (n * i));
			}
			n++;
		}

		System.out.println("**** 2~9단 출력 ****");
		for (int m = 2; m <= 9; m++) {
			System.out.println("---" + m + "단 출력---");
			for (int gop = 1; gop <= 9; gop++) {
				System.out.println(m + " * " + gop + " = " + (m * gop));
			}
		}

	}

}
