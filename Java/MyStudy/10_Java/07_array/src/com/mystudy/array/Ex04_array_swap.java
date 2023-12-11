package com.mystudy.array;

import java.util.Arrays;

public class Ex04_array_swap {

	public static void main(String[] args) {
		// 변수값 서로 교환하기
		int a = 100;
		int b = 200;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("=====결과=====");
//		System.out.println("a : 200");
//		System.out.println("b : 100");
		
		int c;
		c = a;
		a = b;
		b = c;
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		int[] nums = {100, 200, 300, 400, 500, 600};
		System.out.println("배열의 크기 : " + nums.length);
		
		// 전체 데이터 화면 출력
		System.out.println(Arrays.toString(nums));
		//  0<->4  1<->3 2<->2  
		// 배열 데이터를 뒤집기
//		int g;
//		g = nums[0];
//		nums[0] = nums[5]; 
//		nums[5] = g;
//		g = nums[1];
//		nums[1] = nums[4]; 
//		nums[4] = g;
		System.out.println("============데이터 뒤집기=============");
		for (int i = 0; i < (nums.length/2); i++) {
			int len = nums.length -1;
			int h = nums[i];
			nums[i] = nums[len-i];
			nums[len-i] = h;
		}
		System.out.println(Arrays.toString(nums));
		System.out.println("==================================");
		for (int i = 0; i < 3 ; i++) {
			int h = nums[i];
			nums[i] = nums[nums.length-(i + 1)];
			nums[nums.length-(i + 1)] = h;
		}
		System.out.println(Arrays.toString(nums));
		System.out.println("============printArray============");
		printArray(nums);
		System.out.println("=============reverse==============");
		reverse(nums);
		// 변경된 배열 전체 데이터 화면 출력


	}
	// 함수의 배열 명과 호출하는 배열 명은 달라도 됨
	
	static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	static void reverse(int[] arr) {
		int len = arr.length - 1;
		for (int i = 0; i < (arr.length/2); i++) {
			int h = arr[i];
			arr[i] = arr[len - i];
			arr[len - i] = h;
		}
		System.out.println(Arrays.toString(arr));
	}

}
