package com.mystudy.bean_vo;

import java.util.Arrays;

public class StudentManager {

	public static void main(String[] args) {
		/* 3명의 성적처리 StudentVO 사용
		 * "김유신", 100, 90, 81
		 * "이순신", 95, 88, 92
		 * "홍길동", 90, 87, 77
		 =======================
		 김유신	100	90	81 	271	90.33
		 이순신	95	88	92	???	??.??
		 홍길동	90	87	77	???	??.??
		 ********************************/
		// 생성자 사용
		// 저장할 수 있는 공간 생성 // new 사용하여 객체 생성
		// 타입이 서로 맞아야 함
		
		// 생성자 및 sungjuk()메소드 사용하여 출력
		StudentVO stu4 = new StudentVO("김유신", 100, 90, 81);
		stu4.sungjuk();
		
		StudentVO stu5 = new StudentVO("이순신", 95, 88, 92);
		stu5.sungjuk();
		
		StudentVO stu6 = new StudentVO("홍길동", 90, 87, 77);
		stu6.sungjuk();
		System.out.println("-----------------------------------------");
		
		printData(stu4);
		printData(stu5);
		printData(stu6);
		
		System.out.println("-----------------------------------------");
		
		StudentVO[] students = new StudentVO[3];
		students[0] = stu4;
		students[1] = stu5;
		students[2] = stu6;
		
		System.out.println("----------");
		students = new StudentVO[] {stu6, stu5, stu4};
		System.out.println(Arrays.toString(students));
		printData(students);
		
		
		System.out.println("----------");
		StudentVO stu = new StudentVO();

		String[]names = new String[] {"김유신", "이순신", "홍길동"};
		int[][] score = {{100, 90, 81}, 
						 {95, 88, 92},
						 {90, 87, 77}};		
		

		for (int i = 0; i < score.length; i++) {
			// 배열에 점수 입력
			stu.setName(names[i]);
			stu.setKor(score[i][0]);
			stu.setEng(score[i][1]);
			stu.setMath(score[i][2]);
			// 점수 및 이름 변수 생성
			String name = stu.getName();
			int kor = stu.getKor();
			int eng = stu.getEng();
			int math = stu.getMath();
			// 합산, 평균 계산
			stu.setTot(kor + eng + math);
			int tot = stu.getTot();
			stu.setAvg(tot * 100 / 3 / 100.00);
			double avg = stu.getAvg();
			// 출력
			System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math
							+ "\t" + tot + "\t" + avg);
		}
		
		System.out.println("--------------------end---------------------");

	}
	
	static void printData(StudentVO stu) {
		System.out.println(stu.getName() + "\t" +
				stu.getKor() + "\t" + stu.getEng() + "\t" + stu.getMath() + "\t" + 
				stu.getTot() + "\t" + stu.getAvg());
	}

	static void printData(StudentVO[] students) {
		for (int i = 0; i < students.length; i++) {
			printData(students[i]);
		}
	}
}
