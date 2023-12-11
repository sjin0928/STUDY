package com.mystudy.array;

import java.util.Arrays;

public class Ex05_array_lotto {

	public static void main(String[] args) {
		// 로또 번호 생성기
		// 1. 1~45숫자 사용 int 배열
		// 2. 초기화 : 1~45 숫자입력
		// 3. 섞기
		// 4. 6개 번호를 추출 앞에서부터 6개
		
		// 랜덤한 숫자만들기
		// double 타입의 데이터 0 <= random < 1
		// System.out.println(Math.random()*45);
		// System.out.println(Math.random()*45);
		// for (int i = 0; i < 10 ; i++) {
		// System.out.println((int)(Math.random()*3));
		//}
		
		int balls[] = new int[45];
		for (int i = 0; i < balls.length; i++) {
			balls[i] = i + 1;
		}
		
//		System.out.println(Arrays.toString(balls));
		
		for (int i = 0; i < 1000 ; i++) {
			int a = (int)(Math.random() * 45);
			int b = (int)(Math.random() * 45);
			int c = balls[a];
			balls[a] = balls[b];
			balls[b] = c;
		}
		System.out.println("=========== 로또번호 ============");
		System.out.print("이번주 로또번호 : ");
		for (int i = 0; i < 6; i++) {
			System.out.print(balls[i] + " ");
		}
		System.out.println();
		//=============================
		System.out.println("---- 당첨번호 별도 저장하기 ----");
		int[] lottoNums = new int[6];
		for (int i = 0; i < 6; i++) {
			lottoNums[i] = balls[i];
		}
		System.out.println("balls : " + Arrays.toString(balls));
		System.out.println("lottoNums : " + Arrays.toString(lottoNums));
		
		// 로또번호 오름차순 정렬
		Arrays.sort(lottoNums);
		System.out.println("========== Arrays.sort 정렬후 =========");
		System.out.println("lottoNums : " + Arrays.toString(lottoNums));
		
		
		
		// 기본정렬의 방식 학습하기~
		
		
		
	}

}
