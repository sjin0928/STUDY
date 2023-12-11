package com.mystudy.array3_copy;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		// 배열복사
		int [] num1 = new int[5];
		int [] num2 = new int[5];
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		printData("num1", num1);
		printData("num2", num2);
		// 참조형 데이터 비교 : == (주소값 비교, 동일객체 여부 비교)
		System.out.println("num1 == num2 : " + (num1 == num2));
		num1[0] = 10;
		num1[1] = 20;
		num1[2] = 30;
		num1[3] = 40;
		num1[4] = 50;
		
		printData("num1", num1);
		printData("num2", num2);
		
		System.out.println("=== 배열 복사(주소값 복사, 얕은 복사) ===");
		num2 = num1; // 주소값 복사
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		
		System.out.print("num1 : ");
		printData (num1);
		
		System.out.print("num2 : ");
		printData (num2);
		// 참조형데이터 비교 : == (주소값 비교, 동일 객체 여부 비교)
		System.out.println("num1 == num2 : " + (num1 == num2));
		
		// 주소값 복사 후에는 한개의 데이터만 변경해도 같이 바뀜
		num1[0] = 999;
		printData("num1", num1);
		printData("num2", num2);
		
		System.out.println("=== 배열값 복사 (물리적 복사, 깊은복사(deep copy)");
		// 특정변수와 같은 크기로만들고 싶을때는 해당 변수.length 기재
		int[] num3 = new int [num1.length];
		printData("num3", num3);
		
		// num3 <---- num1 배열 값 복사
		// 5배열->3배열은 O / 3배열 ->5배열 X???
		for (int i = 0; i < num3.length; i++) {
			num3[i] = num1[i];
		}
		printData("num1", num1);
		printData("num3", num3);
		System.out.println("num1 : " + num1);
		System.out.println("num3 : " + num3);
		System.out.println("num1 == num3 : " + (num1 == num3));
		
		num1[0] = 888;
		System.out.println(" >> num1 = 888");
		printData("num1", num1);
		printData("num3", num3);
		
		System.out.println("=======================");
	
		System.out.println("====System.arraycopy()로 복사하기====");
		int[] num4 = new int [num1.length];
		printData("num1", num1);
		printData("num4", num4);
		//System.arraycopy(Object src, int srcPos, Object dest(대상), int destPos(위치),int length) 
		System.arraycopy(num1, 0, num4, 0, num1.length);
		
		System.out.println(">> printData(); 복사후");
		printData("num1", num1);
		printData("num4", num4);
		System.out.println("num1 == num4 : " + (num1 == num4));
		
		System.out.println("=== 배열객체.clone() 복사(복제) ===");
		int[] num5 = num4.clone();
		printData("num4", num4);
		printData("num5", num5);
		System.out.println("num4 == num5 : " + (num4 == num5));
		
		System.out.println("==== Arrays.copyOf() 사용 복사====");
		// Arrays.copyOf (원본데이터, 복사갯수)
		int[] num6 = Arrays.copyOf(num4, num4.length);
		
		printData("num4", num4);
		printData("num6", num6);
		System.out.println("num4 == num6 : " + (num4 == num6));
		
		// Arrays.copyOfRange(원본, from, to) : from 부터 to 이전까지(미만) 
		// 복사의 시작지점을 정할 수 있음
		Arrays.copyOfRange(num4, 0, 3);
		printData("num4", num4);
		printData("num6", num6);
		System.out.println("num4 == num6 : " + (num4 == num6));
		
		
		
	}
	
	static void printData(int[] num) {
		for (int i = 0; i < num.length; i++) {
		System.out.print(num[i] + " ");
	    }
		System.out.println();
	}
	
	
	
	// 메소드명이 똑같아도 데이터 변수가 다르면 ㄱㅊ음
	// 메소드 오버로딩 (method Overloading)

	static void printData(String name, int[] num) {
		System.out.print(name + " : ");
		for (int i = 0; i < num.length; i++) {
		System.out.print(num[i] + " ");
	    }
		System.out.println();
	}
	

}

