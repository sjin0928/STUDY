
public class Ex08_double {

	public static void main(String[] args) {
		// 실수형 double : 8Byte
		// 범위 : 4.9E-324~1.7976931348623157E308
		// 표시형식 : 숫자.숫자 / 숫자.숫자 + D or d
		
		double d1 = 1.1;
		double d2 = 1.12345678901234567890d;
		
		System.out.println("double 1.1 : " + d1);
		System.out.println("double 12345678901234567890d : " + d2);
		
		double sum = d1 + d2;
		System.out.println("d1 + d2 : " + sum);
		
		System.out.println("3.4d + 3.2d : " + (3.4d + 3.2d));
		
		System.out.println("double 최소값 : " + Double.MIN_VALUE);
		System.out.println("double 최대값 : " + Double.MAX_VALUE);

	}

}
