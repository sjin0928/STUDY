package com.mystudy.ex01_random;

import java.util.Calendar;
import java.util.Random;

public class Random_Exam3 {

	public static void main(String[] args) {
		// 오늘 당신의 행운지수를 알아보기(0~100)
		// Math.random(), Random 사용해서 행운지수 값 만들기
		// 예) 2023년 7월 31일 당신의 행운지수(0~100)는 77입니다.
		Calendar calendar = Calendar.getInstance();  // Calendar는 추상클래스임
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;  // (0 : 1월, 1 : 2월...)
		int date = calendar.get(Calendar.DATE);
		System.out.println("year : " + year);
		System.out.println("month : " + month);
		System.out.println("date : " + date);
		System.out.println(year + "년 " + month + "월 " + date + "일");
		String yyyymmdd = year + "년 " + month + "월 " + date + "일";
		System.out.println("-------");
		// 방법1 - Random next(t숫자)
		Random ran = new Random();
		int result = ran.nextInt(101);
		System.out.println(yyyymmdd + " 당신의 행운지수(0~100)는 "
					+ result + "입니다.");
		
		// 방법2 - Math.random()
		result = (int)(Math.random() * 101);
		System.out.println(yyyymmdd + " 당신의 행운지수(0~100)는 "
				+ result + "입니다.");

	}

}
