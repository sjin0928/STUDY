
public class Ex04_PlusEqual {

	public static void main(String[] args) {
		// 대입연산자 : =, +=, -=, *=, /=, %=
		// ex) num += 2; => num = num + 2; 
		int result = 0;
		System.out.println("result : "+ result);
		
		result += 15; // result = result + 15;
		System.out.println("result : "+ result);
		
		result += 15; // result = result + 15;
		System.out.println("result : "+ result);
		
		System.out.println("---- -= 연산 ----");
		System.out.println("result : "+ result);
		result -= 10; // result = result - 10;
		System.out.println("result : "+ result);
		System.out.println(); // 줄바꿈만 됨
		
		System.out.println("---- *= 연산 ----");
		result *= 10; // result = result * 10
		System.out.println("result : "+ result);
		
		System.out.println("---- /= 연산 ----");
		result /= 10; // result = result / 10 (몫만 출력)
		System.out.println("result : "+ result);
		
		System.out.println("---- %= 연산 ----");
		result %= 3; // result = result % 3
		System.out.println("result : "+ result);
		

	}

}
