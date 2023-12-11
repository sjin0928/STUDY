package com.mystudy.ex02_random;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;

public class Calendar_Exam {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new Date() : " + date);

		// 월 : 0~11 - 0 : 1월, 1 : 2월, ..., 11 : 12월
		date = new Date(2023-1900, 7, 31);
		System.out.println("new Date(2023, 7, 31)" + date);
		System.out.println("===============");
		
		System.out.println("---- Calendar ----------");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		// 년, 월, 일
		System.out.println("연도 : " + cal.get(Calendar.YEAR));
		System.out.println("월 : " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		
		// 시, 분, 초
		System.out.println("오전오후 : " + cal.get(Calendar.AM_PM));
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR));
		System.out.println("시(24시간) : " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		System.out.println("밀리초 : " + cal.get(Calendar.MILLISECOND));
		
		// 년-월-일 시:분:초 또는 년/월/일 시:분:초
		String dateTime = cal.get(Calendar.YEAR)
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		System.out.println("년-월-일 시:분:초 : " + dateTime);
		System.out.println();
		
		cal.add(Calendar.YEAR, 2);
		cal.add(Calendar.MONTH, 2); // 2달 후
		cal.add(Calendar.DATE, -2); // 2일 전
		
		dateTime = cal.get(Calendar.YEAR)
				+ "-" + (cal.get(Calendar.MONTH) + 1)
				+ "-" + cal.get(Calendar.DATE)
				+ " " + cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE)
				+ ":" + cal.get(Calendar.SECOND);
		System.out.println("년-월-일 시:분:초 : " + dateTime);
		System.out.println();
		System.out.println("===============");
		
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
		date = new Date();
		
		System.out.println("new Date() : " + date);
		System.out.println("y-M-d H:m:s : " + sdf.format(date));
		System.out.println("-------");
		
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
		
//		System.out.println("===========");
//		cal.set(Calendar.YEAR, 2000);
//		date = cal.getTime();
//		System.out.println("yyyy-MM-dd HH:mm:ss : " + sdf.format(date));
		

	}

}
