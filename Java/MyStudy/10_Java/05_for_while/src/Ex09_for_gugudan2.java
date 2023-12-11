
public class Ex09_for_gugudan2 {

	public static void main(String[] args) {
		/* 구구단 2~9단 출력
		 2*1=2		3*1=3   ...   9*1=9
		 2*2=4		3*2=6   ...   9*2=18
		 2*3=6		3*3=9   ...   9*3=27
		 ...
		 2*9=18     3*9=27  ...   9*9=81
		 */
		
		int gob = 1;
		for (int e = 1; e <= 9; e++) {
			int dan = 2;
			for (int i = 1; i <= 8; i++) {
				System.out.print(dan + "*" + gob + "=" + dan*gob);
				System.out.print("\t");
				dan++;
			}
			gob++;
			System.out.println();	
		}
		
		System.out.println("======================================================");
		for (int e = 1; e <= 9; e++) {
			for (int i = 2; i <= 9; i++) {
				System.out.print(i + "*" + e + "=" + (i * e));
				System.out.print("\t");				
			}
			System.out.println();	
		}

	}

}
