package co.mystudy.wrapper;

public class Ex01_wrapper_class {

	public static void main(String[] args) {
		// wrapper : 기본 데이터타입의 기능확장한 클래스(들) 총칭
		// 기본 데이터 타입 : 전체 소문자
		//	*boolean, *char, byte, short, *int, long, float, *double
		// wrapper class : 기본데이터 타입의 첫글자를 대문자로
		// 	예외 : char _> Character, int -> Integer
		//	Boolean, Character, Byte, Short, Integer, Long, Float, Double
		int num = 100;
		System.out.println("num : " + num);
		
		// Integer intNum = new Integer(num);
		Integer intNum = new Integer("100");
		// 자동형변환 됨
		// 굳이 생성자 new를 하지 않아도됨
		// Integer intNum = 100;
		System.out.println("Integer intNum : " + intNum);
		
		String strNum = intNum.toString();
		// toString : 문자열로 변환
		System.out.println("String strNum : " + strNum);
		
		intNum = 900; // Integer <--- int : 자동형변환
		num = intNum; // int <--- Integer : 자동형변환
		
		num = Integer.parseInt("999"); // int <--- String : 형변환
		intNum = Integer.valueOf("999"); // Integer <--- String : 형변환
		
		String str = String.valueOf(9999); // String <--- int
		
		System.out.println("int 최소값 : " + Integer.MIN_VALUE);
		System.out.println("int 최대값 : " + Integer.MAX_VALUE);
		
		System.out.println("--- Boolean ---");
		Boolean bool = true;
		bool = new Boolean(true);
		bool = new Boolean("true");
		bool = new Boolean("TRUE");
		bool = new Boolean("TRue");
		// new를 해서 만들 필요는 없음
		// 대소문자 구분없이 철자만 맞으면 됨
		System.out.println("Boolean true : " + bool);
		
		bool = new Boolean("false");
		bool = new Boolean("FALSE");
		bool = new Boolean("FAlse");
		bool = new Boolean("true1"); // true가 아닌 다른 문자열 들어가면 false
		System.out.println("Boolean false : " + bool);
		
		System.out.println("--- String ---> Boolean ---");
		Boolean bool2 = Boolean.valueOf("true"); //Boolean <--- String
		boolean bool3 = Boolean.parseBoolean("true"); //boolean <--- String
		
		System.out.println(" --- Float, Double ---");
		Float f = 10.5f;// Float <-----float
		f = new Float(12.5f);
		f = new Float ("12.f");
		f = new Float ("12.5");
		//f = "12.5f"; //Type mismatch: cannot convert from String to Float
		
		System.out.println("float f : " + f);
		String str2 = String.valueOf(f);	// String <---Float
		System.out.println("String str2 : " + str2);
		
		f = Float.valueOf("12.5f");
		System.out.println("Float f : " + f);
		System.out.println("----------------------------");
		
		Double d = 10.5D; // Double <---double
		d = new Double(12.5d);
		d = new Double("12.5d");
				
		System.out.println("Double d : " + d);
		
		d = Double.valueOf("12.5d");
		d = Double.valueOf("12.5");
		d = Double.valueOf("10.5f");
		System.out.println("Double d : " + d);
		
	}

}
