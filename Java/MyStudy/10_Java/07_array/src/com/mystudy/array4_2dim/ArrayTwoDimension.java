package com.mystudy.array4_2dim;

public class ArrayTwoDimension {

	public static void main(String[] args) {
		// 2차원 배열 선언 및 객체 생성
		// 타입[][] 변수명 = new 타입 [크기값][크기값];
		// 타입 변수명[][] = new 타입 [크기값][크기값];
		// 타입[][] 변수명 =  { {..}, {..}, ..., {..}};
		//--------------------------------------------

		int[][] nums = { {10, 20}, // 10 : nums[0][0]; / 20 : nums[0][1];
						 {30, 40}, // 30 : nums[1][0]; / 40 : nums[1][1];
						 {50, 60},  // 50 : nums[2][0]; / 60 : nums[2][1];
						 {70, 80, 90}
						 };
		
		System.out.println("nums : " + nums);
		// nums 배열의 길이는 1
		System.out.println("nums.length : " + nums.length);
		System.out.println("nums[0] : " + nums[0]);
		// nums 배열의 0번라인 길이는 2
		System.out.println("nums[0].length : " + nums[0].length);
		System.out.println("nums[0][0] : " + nums[0][0]);
		System.out.println("----------------------");
		System.out.println("--- 2차원 배열데이터 --------------");
		System.out.println("nums : " + nums);
		System.out.println("nums.length" + nums.length);
		System.out.println("--- 2차원 배열안에 있는 1차원 배열 ----");
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("nums[0].length" + nums[0].length);
		System.out.println("--- int 값(데이터) 사용을 위한 인덱스 적용----");
		System.out.println("nums[0][0] : " + nums[0][0]);
		System.out.println("---------------");
		
		// nums에 있는 첫번째 데이터(1차원 배열) 화면출력
		System.out.println("nums[0] : " + nums[0]);
		for (int i = 0; i < nums[0].length; i++) {
			System.out.print(nums[0][i] + " ");
		}
		System.out.println();
		
		// nums에 있는 두번째 데이터(1차원 배열) 화면출력
		System.out.println("nums[1] : " + nums[1]);
		for (int i = 0; i < nums[1].length; i++) {
			System.out.print(nums[1][i] + " ");
		}
		System.out.println();

		// nums에 있는 세번째 데이터(1차원 배열) 화면출력
		System.out.println("nums[2] : " + nums[2]);
		for (int i = 0; i < nums[2].length; i++) {
			System.out.print(nums[2][i] + " ");
		}
		System.out.println();
		
		System.out.println("=== 2차원 배열 데이터 for 반복문으로 ====");
		for (int i = 0; i < nums.length; i++) {
			System.out.println("nums - " + i + " : " + nums[i]);
			for (int idx = 0; idx < nums[i].length; idx++) {
				System.out.print(nums[i][idx] + " ");
			}
			System.out.println();
			System.out.println("------------------");
		}
		System.out.println("====================");
		int[][] numsBackup = nums.clone();
		System.out.println("nums : " + nums);
		System.out.println("numsBackup : " + numsBackup);
		System.out.println("nums == numsBackup : " + (nums == numsBackup));
		System.out.println("------");
		System.out.println("nums[0] : " + nums[0]);
		System.out.println("numsBackup[0] : " + numsBackup[0]);
		System.out.println("nums[0] == numsBackup[0] : " + (nums[0] == numsBackup[0]));
		nums[0][0] = 999;
		System.out.println("nums[0][0] : " + nums[0][0]);
		System.out.println("numsBackup[0][0] : " + numsBackup[0][0]);
		
		

	}

}
