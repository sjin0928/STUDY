package com.mystudy.array;

public class Ex02_array_exam {

	public static void main(String[] args) {
		//(실습)문제 : 배열에 저장된 숫자의 합계 구하기(변수명 nums)
		// 저장할 숫자 : 3, 5, 7, 1, 2, 4, 6, 8, 9, 10
		//0. 위의 숫자가 저장된 배열을 만드세요.
		//1. 배열에 저장된 데이터를 화면 출력(반복문사용)
		//2. 배열에 저장된 데이터의 합계 구하기
		//3. 합계결과 출력
		//-------------------------------
		
		// 0. 1.
//		int nums[] = new int[10];
//		int nums[] = new int[] {3, 5, 7, 1, 2, 4, 6, 8, 9, 10};
		
		int[] nums = {3, 5, 7, 1, 2, 4, 6, 8, 9, 10};
		System.out.print("2. ");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums [i] + " ");
		}
		
//		int nums[] = new int[10];
//		System.out.print("2. ");
//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = i + 1;
//			System.out.print(nums [i] + " ");
//		}
		
		System.out.println();
		// 1.
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		System.out.println("3. sum : " + sum);
		
		//(실습) 배열값 중 홀수합, 짝수합 구하기
		//배열에 있는 값 중 짝수는 짝수끼리 합산(evenSum)
		//배열에 있는 값 중 홀수는 홀수끼지 합산(oddSum)
		//짝수합계, 홀수합계 출력
		int evenSum = 0;
		int oddSum = 0;
		for (int i = 0; i < 10; i++) {
			if(nums[i] % 2 == 0) {
				evenSum = evenSum + nums[i]; 
			} else {
				oddSum = oddSum + nums[i];
			}
		}
//		for (int i = 0; i < 10; i++) {
//			if(nums[i] % 2 != 0) {
//				oddSum = oddSum + nums[i];
//			}
//		}
		System.out.println("짝수합계 : " + evenSum);
		System.out.println("홀수합계 : " + oddSum);
		

		
		

	}

}