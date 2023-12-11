package co.mystudy.wrapper;

public class Ex02_wrapper_Charater {

	public static void main(String[] args) {
		// Character 클래스
		// "a" : String
		char ch = 'a';
		System.out.println(Character.isAlphabetic(ch)); //true
		System.out.println("Character.isAlphabetic('한') : " + 
				Character.isAlphabetic('한'));
		// 문자에 true 한글도 포함
		System.out.println(Character.isLetter('0')); //ch : true
		System.out.println(Character.isDigit('0'));//true
		System.out.println(Character.isLetter('A')); //true
		// Digit은 숫자에 true // Letter은 문자에 true
		System.out.println(Character.isUpperCase('A')); //true
		System.out.println(Character.isLowerCase('A')); //false
		System.out.println(Character.isWhitespace(' ')); //true
		System.out.println(Character.isWhitespace('\t')); //true
		
		System.out.println("------");
		char[] chs = {'한', 'a', ' ', 'A', '+', '0'};
		for (int i = 0; i < chs.length; i++) {
			System.out.print(chs[i] + " : ");
			if(Character.isDigit(chs[i])) {
				System.out.print("숫자");
			}
			if(Character.isWhitespace(chs[i])) {
				System.out.print("공백(제어문자)");
			}
			if(Character.isUpperCase(chs[i])) {
				System.out.print("대");
			}
			if(Character.isLowerCase(chs[i])) {
				System.out.print("소");
			}
			if(Character.isLetter(chs[i])) {
				System.out.print("문자");
			}
			if(Character.isDefined(chs[i])) {
				System.out.print("유니코드문자");
			}
			System.out.println();
		}
		
	}

}
