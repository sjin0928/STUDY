package com.mystudy.ex02_random;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

public class LocalDateTime_Exam {

	public static void main(String[] args) {
		// Calendar : 원본 값의 변경이 가능(mutable)
		Calendar cal = Calendar.getInstance();
		System.out.println("cal : " + cal);
		System.out.println("cal date : " + cal.get(Calendar.DATE));
		cal.add(Calendar.DATE, -3);
		System.out.println("cal 3일 전 : " + cal);
		System.out.println("cal date : " + cal.get(Calendar.DATE));
		
		System.out.println("==================");
		// LocalDate, LocalTime, LocalDateTime : 원본 데이터 불변(immutable)
		System.out.println("======= LocalDate =========");
		LocalDate nowDate = LocalDate.now();
		System.out.println("LocalDate.now() : " + LocalDate.now());
		System.out.println("LocalDate.now() : " + nowDate.toString());
		System.out.println("년 : " + nowDate.getYear());
		System.out.println("월 : " + nowDate.getMonthValue()); //1~12값
		System.out.println("일 : " + nowDate.getDayOfMonth());
		
		LocalDate newLocalDate = nowDate.plusYears(2).plusMonths(2).minusDays(2);
		System.out.println("newLocalDate :" + newLocalDate);
		System.out.println("nowDate :" + nowDate);
		
		System.out.println("========= LocalTime ============");
		LocalTime nowTime = LocalTime.now();
		System.out.println("LocalTime.now() : " + nowTime);
		System.out.println("시 : " + nowTime.getHour());
		System.out.println("분 : " + nowTime.getMinute());
		System.out.println("초 : " + nowTime.getSecond());
		
		System.out.println("========= LocalDateTime ============");
		LocalDateTime nowDT = LocalDateTime.now();
		System.out.println("LocalDateTime.now() : " + nowDT);
		System.out.println("년 : " + nowDT.getYear());
		System.out.println("월 : " + nowDT.getMonthValue());
		System.out.println("일 : " + nowDT.getDayOfMonth());
		System.out.println("시 : " + nowDT.getHour());
		System.out.println("분 : " + nowDT.getMinute());
		System.out.println("초 : " + nowDT.getSecond());
	}

}
