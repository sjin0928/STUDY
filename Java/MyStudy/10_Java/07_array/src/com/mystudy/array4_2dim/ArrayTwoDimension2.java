package com.mystudy.array4_2dim;

import java.util.Arrays;

public class ArrayTwoDimension2 {

	public static void main(String[] args) {
		// 2차원 배열 선언 및 객체 생성
		// 타입[][] 변수명 = new 타입 [크기값][크기값];
		// 타입 변수명[][] = new 타입 [크기값][크기값];
		// 타입[][] 변수명 =  { {..}, {..}, ..., {..}};
		//--------------------------------------------
		
		// 2차원 배열(행)의 크기는 반드시 정해져있어야함
		int[][] nums = new int [3][];
		
		// 방법1 : new int[2] - new 사용 1차원 배열 생성 선언
		nums[0] = new int[2];
		nums[0][0] = 10;
		nums[0][1] = 20;
		
		// 방법2 : new int[] {30, 40} - new 사용 1차원 배열과 데이터 동시 입력
		nums[1] = new int [] {30, 40};
		
		// 방법3 : {30, 40} (X) 변수선언시에만 가능 컴파일오류
		// nums[3] = {30, 40}; 
		nums[2] = new int[] {50, 60, 70, 80};
		System.out.println(Arrays.toString(nums[2]));
	}

}
