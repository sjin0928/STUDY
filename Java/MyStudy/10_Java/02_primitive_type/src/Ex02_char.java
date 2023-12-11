
public class Ex02_char {

	public static void main(String[] args) {
		// 문자형(char) : 2Byte 사용, 문자 1글자 저장 (0~65535)
		// 자바 문자처리 방식은 유니코드(Unicode)형태
		char char1 = 'A'; // "A"는 문자열(String), 'A'는 문자(char)
		System.out.println("char1 : " + char1);
		System.out.println("char1 다음문자 : " + (char1 + 1));
		System.out.println("char1 다음문자 : " + ((char)(66)));
		//덧셈 연산 후 문자 붙여짐 A라는 문자가 65라는 숫자를 저장하고 있어서 66이 나옴
		// (char)는 형변환 의미
		
		char char2 = '한';
		System.out.println("char2 : " + char2);
		
		char char3 = '\uAC00'; //유니코드 값으로 설정(\)
		System.out.println("char3 : " + char3);
		System.out.println("----------------");
		System.out.println("char1 : " + char1); // A, 65
		
		char1 = (char)(char1 + 1);
		// char+1 은 int 값이므로 char로 형변환 필요
		System.out.println("chat1(다음값) : " + char1); // B, 66
		
	}

}
