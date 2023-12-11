
public class Ex02_gt_lt {

	public static void main(String[] args) {
		// 비교연산자 : >, <, >=(크거나 같다), <=(작거나 같다)
		//			== (같다, 동일하다), != (같지않다, 다르다)
		// 비교연산자의 결과 값 : true, false
		int num1 = 10;
		int num2 = 20;
		
		// num > num : ???
		System.out.println(num1 > num2);
		System.out.println(num1 + " > " + num2 + " : " + (num1 > num2));
		System.out.println(num1 + " < " + num2 + " : " + (num1 < num2));
		System.out.println(num1 + " >= " + num2 + " : " + (num1 >= num2));
		System.out.println(num1 + " <= " + num2 + " : " + (num1 <= num2));

		System.out.println(num1 + " == " + num2 + " : " + (num1 == num2));
		System.out.println(num1 + " != " + num2 + " : " + (num1 != num2));
		System.out.println("=========================");
		
		// ! : 부정
		// !true => false, !false => ture
		boolean power = true; // 전원이 켜짐
		System.out.println("power : " + power);
		
		power = !power; // 현재 저장된 값이 아닌 값(부정처리)
		System.out.println("power : " + power);
	}

}
