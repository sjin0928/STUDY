package com.mystudy.array4_2dim;

import java.util.Arrays;

public class ArrayExam {

	public static void main(String[] args) {
		/* 문제 : 2차원 배열을 사용하여
		 int[] num2dim = { { 10, 20}, {30, 40}, {50, 60} };
		 1. 2차원 배열 num2dim 값을 화면 출력 : 10 20 30 ...
		 2. num2dim의 세번째 데이터의 값(30)을 100으로 변경 후 출력
		    전체 or 세번째만
		 3. num2dim의 크기만큼 num2Copy 배열선언
		 	num2dim ----> num2Copy 데이터 복사
		 	num2Copy 데이터 화면 출력
		 *** 데이터 복사 형태 확인 : 얕은복사(주소값 복사), 깊은복사(물리적복제)
		 */
		int[][] num2dim = new int [3][];
		int sum = 0;
		for (int i1 = 0; i1 < num2dim.length; i1++) {
			int n = 10;
			num2dim[i1] = new int [] {sum+=n, sum+=n};	
		}
				
		// 1. 2차원 배열 num2dim 값을 화면 출력 : 10 20 30 ...
		System.out.println("==2차원 배열 num2dim 값을 화면 출력===");
		System.out.print("num2dim : ");
		System.out.println(num2dim[0].toString());
		System.out.println(Arrays.deepToString(num2dim));
		System.out.println();
		
		System.out.println("==이중 for문 출력==========");
		printData ("num2dim", num2dim);
		System.out.println();
		
		// 2. num2dim의 세번째 데이터의 값(30)을 100으로 변경 후 출력
		System.out.println("==num2dim[1][0] = 100; 변경===");
	    num2dim [1][0] = 100;
	    printData ("num2dim", num2dim);
	    System.out.println();
	    
	    // 3. num2dim의 크기만큼 num2Copy 배열선언
	    System.out.println("==2차원 배열복사============");
	    int num2Copy[][] = new int [num2dim.length][];
//	    for (int i = 0; i < num2Copy.length; i++) {
//	    	num2Copy[i] = num2dim[i];
//	    } => 주소값 복사됨 
	    
	    for (int i = 0; i < num2dim.length; i++) {
			num2Copy[i] = new int[num2dim[i].length];
		}
	    // 1차원 배열 길이 지정
	    
		System.out.println("num2Copy : " + Arrays.toString(num2Copy));
	    
	    System.out.println("---- 데이터 직접 복사 ---");
	    for (int d2 = 0; d2 < num2dim.length; d2++) {
	    	for (int i = 0; i < num2dim[d2].length; i++) {
	    		num2Copy[d2][i] = num2dim[d2][i];
	    	}
	    }
	    printData ("num2dim", num2dim);
		printData ("num2Copy", num2Copy);
		System.out.println();
		
	    System.out.println("---- [0][0] = 999 ---");
	    num2Copy[0][0] = 999;
	    printData ("num2dim", num2dim);
		printData ("num2Copy", num2Copy);
		System.out.println();
		
		System.out.println("==데이터 복사 형태 확인===");
		printAd("num2dim", num2dim);
		printAd("num2Copy", num2Copy);
		printAd("num2dim[0]", num2dim[0]);
		printAd("num2Copy[0]", num2Copy[0]);
		printAd("num2dim[0]", num2dim[1]);
		printAd("num2Copy[0]", num2Copy[1]);
		
		boolean result = copy (num2dim, num2Copy);
	    printSS (result);


	    // num2dim ----> num2Copy 데이터 복사	    
//	    num2Copy = num2dim.clone ();
	    
	    
	    // num2Copy 데이터 화면 출력
//		printData ("num2dim", num2dim);
//		printData ("num2Copy", num2Copy);
//		System.out.println();


	}
	static void printData(String name, int num[][]) {
		System.out.print(name + " : " + "\n");
		for (int i2 = 0; i2 < num.length; i2++) {
			for(int i1 = 0; i1 < num[i2].length; i1++) {
				System.out.print(num[i2][i1] + " ");
			}
			System.out.println();
		}		
	}		
	
	static void printAd (String name, int num[][]) {
		System.out.println(name + " : " + num);
	}
	static void printAd (String name, int num[]) {
		System.out.println(name + " : " + num);
	}
	// 2차원 배열의 1차원배열을 출력시 별도로 생성
	static boolean copy (int num[][], int num1[][]) {
		if (num == num1) {
			return true;
		}else {
			return false;
		}
	}
	static void printSS (boolean result) {
		System.out.print("num2dim == num2Copy : ");
		if (result) {
	    	System.out.println("얕은복사(주소값 복사)");
	    }else {
	    	System.out.println("깊은복사(물리적복제)");
	    }
	}
	
}
