
public class Ex01_plusplus {

	public static void main(String[] args) {
		// 증감연산자 : ++, --
		// 사용형태 : ++변수명, 변수명++, --변수명, 변수명--
		// ++ : 값을 1 증가 시킴
		// -- : 값을 1 감소 시킴
		// ++num; >>>>>> num = num + 1
		int num = 100;
		System.out.println("num : " + num);
		num = num + 1;
		System.out.println("num = num + 1 : " + num);
		System.out.println("-------------------");
		
		// ++, -- 연산자 단독사용시 항상 1증가 or 감소
		num = 100;
		System.out.println("num : " + num);
		++num;  // num = num + 1;와 같은 의미
		System.out.println("++num : " + num);
		System.out.println("-----------------");
		
		num = 100;
		System.out.println("num : " + num);
		num++;  // num = num + 1;와 같은 의미
		System.out.println("num++ : " + num);
		System.out.println("-----------------");
		
		System.out.println("==========");
		//++, -- 연산자가 연산식에 사용되는 경우
		// ++변수명 : 변수값이 1 증가된 상태에서 연산에 사용됨
		// 변수명++ : 변수값이 연산에 사용된 후에 변수값이 1 증가됨
		
		int sum = 0;
		num = 100;
		System.out.println("num : " + num);
		sum = num++ + 5;
		System.out.println("sum = num++" + sum);
		System.out.println("num : " + num);
		System.out.println("==========");
		
		num = 100;
		System.out.println("num : " + num);
		sum = ++num + 5;
		System.out.println("sum = ++num" + sum);
		System.out.println("num : " + num);
		System.out.println("==========");
	}

}
