package com.mystudy.array3_copy;

import java.util.Arrays;

public class ArrayCopy_exam {
	
	

	public static void main(String[] args) {
		/* 문제1 : int 타입의 데이터 4개를 저장할 수 있는 배열 (num1)에
		 1. 10, 20, 30, 40, 숫자 입력및 출력 (반복문 사용)
		 2. 세번째 데이터를 100으로 변경 후 출력
		 3. 20 숫자를 찾아서 99로 변경
		----------------------------------------- */
		
		/* 문제 2 : num1과 크기가 같은 배열 num1Copy를 만들고
		 num1Copy에 num1 데이터를 복사하고 화면출력
		 1. 주소값 복사인지 깊은 복사(물리적 복사) 여부 확인
		----------------------------------------- */
		
		int[] num1 = new int[4];
		
		System.out.println("문제1-1");
		for (int i = 0; i < num1.length; i++) {
			num1[i] = (i + 1) * 10;
		}
		System.out.println(Arrays.toString(num1));
		
		System.out.println("문제1-2");
		num1[2] = 100;
		System.out.println(Arrays.toString(num1));
		
		System.out.println("문제1-3");
		for (int i = 0; i < num1.length; i++) {
			if(num1[i] == 20) {
				num1[i] = 90;
			}
		}
		System.out.println(Arrays.toString(num1));
		
		System.out.println("\n*문제2");
		int[] num1Copy = new int[num1.length];
		printData("num1", num1);
		printData("num1copy", num1Copy);
		printE("num1", "num1Copy", num1, num1Copy);
		
		//Arrays.copyOf
		System.out.println("\n*Arrays.copyOf : 주소값 불일치");
		num1Copy = Arrays.copyOf(num1, num1.length);
		
		printData("num1", num1);
		printData("num1copy", num1Copy);
		printE("num1", "num1Copy", num1, num1Copy);

		//num1Copy
		System.out.println("\n*num1Copy : 주소값 불일치");
		num1Copy = num1.clone();
		
		printData("num1", num1);
		printData("num1copy", num1Copy);
		printE("num1", "num1Copy", num1, num1Copy);
		
		//System.arraycopy
		System.out.println("\n*System.arraycopy : 주소값 불일치");
		System.arraycopy(num1, 0, num1Copy, 0, num1Copy.length);
		
		printData("num1", num1);
		printData("num1copy", num1Copy);
		printE("num1", "num1Copy", num1, num1Copy);
		
		//for문
		System.out.println("\n*for문 사용 : 주소값 불일치");
		for (int i = 0; i < num1Copy.length; i++) {
			num1Copy[i] = num1[i];
		}
		
		printData("num1", num1);
		printData("num1copy", num1Copy);
		printE("num1", "num1Copy", num1, num1Copy);
		
		//num1=num1Copy
		System.out.println("\n*num1 = num1Copy; : 주소값 일치");
		num1 = num1Copy;		
		
		printData("num1", num1);
		printData("num1copy", num1Copy);
		printE("num1", "num1Copy", num1, num1Copy);

	}

	static void printData(String name, int[] num) {
		System.out.print(name + " : ");
		for (int i = 0; i < num.length; i++) {
		System.out.print(num[i] + " ");
	    }
		System.out.println();
	}
//
//	static void printDataP(String name, int[] num) {
//		System.out.print(name + " : ");
//		System.out.println(num);
//	}
	
	static void printE(String name, String name2, int num1[], int num2[]) {
		System.out.print("name1 == name2 : ");
		System.out.println(num1 == num2);
	}
//	
//	static printif() {
//		if() {
//			return true;
//		}else {
//			return false;
//		}
//		
//	}
	
	
}
