
public class Ex03 {

	public static void main(String[] args) {
		// 십진수, 2진수(컴퓨터 언어), 8진수, 16진수
		int decimal = 10;
		// =우측의 데이터를 좌측의 변수에 저장한다.
		int binary = 0b1010; //0b, 0B 접두어사용하면 자바 2진수값 표현
		int octal = 012; // 0 접두어 숫자 0사용 (8진수)
		int hexaDecimal = 0xa; //0x, 0X 접두어 사용하면 16진수
		System.out.println("decimal : " + decimal);
		System.out.println("binary : " + binary);
		System.out.println("octal : " + octal);
		System.out.println("hexaDecimal : " + hexaDecimal);
		System.out.println(Integer.toBinaryString(10));
		
	}

}
