package com.mystudy.array2;

public class ArraySortSelection {

	public static void main(String[] args) {
		// 배열숫자 데이터 정렬(sort) - 오름차순(ASC), 내림차순(DESC)
		int[] num = {30, 20, 50, 40, 10};
		System.out.println("num : " + num);
		// 데이터 확인
		System.out.print("원본데이터(num) : ");
		printData(num);
		
		System.out.println("=== 정렬시작 ===");
//		if (num[0] > num[1]) {
//			int temp = num[0];
//			num[0] = num[1];
//			num[1] = temp;
//		}
//		printData(num);
//		
//		System.out.println("=======================");
//		if (num[0] > num[2]) {
//			int temp = num[0];
//			num[0] = num[2];
//			num[2] = temp;
//		}
//		printData(num);
//		
//		System.out.println("=======================");
//		for (int i = 0 ; i < num.length; i++) {
//			if (num[0] > num[i]) {
//				int temp = num[0];
//				num[0] = num[i];
//				num[i] = temp;
//			}
//			printData(num);
//		}
//		System.out.println("========반복문 변경 적용==========");
//		
//		System.out.print("배열데이터(num) : ");
//		printData(num);
//		
//		// 첫번째 값 기준 비교작업 (인덱스 0기준)
//		System.out.println("=== 기준 인덱스 0인경우 ===");
//		for (int i = 1 ; i < num.length; i++) {
//			if (num[0] > num[i]) {
//				int temp = num[0];
//				num[0] = num[i];
//				num[i] = temp;
//			}
//			printData(num);
//		}
//
//		System.out.print("배열데이터(num) : ");
//		printData(num);
//		
//		// 두번째 값 기준 비교작업 (인덱스 1기준)
//		System.out.println("=== 기준 인덱스 1인경우 ===");
//		for (int i = 2 ; i < num.length; i++) {
//			if (num[1] > num[i]) {
//				int temp = num[1];
//				num[1] = num[i];
//				num[i] = temp;
//			}
//			printData(num);
//		}
//
//		System.out.print("배열데이터(num) : ");
//		printData(num);
//		
//		// 세번째 값 기준 비교작업 (인덱스 2기준)
//		System.out.println("=== 기준 인덱스 2인경우 ===");
//		for (int i = 3 ; i < num.length; i++) {
//			if (num[2] > num[i]) {
//				int temp = num[2];
//				num[2] = num[i];
//				num[i] = temp;
//			}
//			printData(num);
//		}
//		
//
//		System.out.print("배열데이터(num) : ");
//		printData(num);
//		
//		// 네번째 값 기준 비교작업 (인덱스 3기준)
//		System.out.println("=== 기준 인덱스 3인경우 ===");
//		for (int i = 4 ; i < num.length; i++) {
//			if (num[3] > num[i]) {
//				int temp = num[3];
//				num[3] = num[i];
//				num[i] = temp;
//			}
//			printData(num);
//		}
//		
//		System.out.print("배열데이터(num) : ");
//		printData(num);
//		
//		// 다섯번째 값 기준 비교작업 (인덱스 4기준)
//		// 반복문에선 오류 x 4>5 무의미한 작업
//		System.out.println("=== 기준 인덱스 4인경우 ===");
//		for (int i = 5 ; i < num.length; i++) {
//			if (num[4] > num[i]) {
//				int temp = num[4];
//				num[4] = num[i];
//				num[4] = temp;
//			}
//			printData(num);
//		}

		
		System.out.println("========이중(중첩) 반복문 변경 적용==========");
		int lastIdx = num.length - 1;
		
		for(int gijun = 0 ; gijun < lastIdx; gijun++) {
			System.out.print("배열데이터(num) : ");
			printData(num);
			for (int i = gijun + 1 ; i < lastIdx; i++) {
				if (num[gijun] > num[i]) {
					int temp = num[gijun];
					num[gijun] = num[i];
					num[i] = temp;
				}
				printData(num);
			}
			printData(num);
		}
		System.out.print("배열데이터(num) : ");
		printData(num);
	}

	static void printData(int[] num) {
		for(int i = 0 ; i < num.length; i++) {
			System.out.print(num[i] + " ");
			
		}
		System.out.println();
	}

}
