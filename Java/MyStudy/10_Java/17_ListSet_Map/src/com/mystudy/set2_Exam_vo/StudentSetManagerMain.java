package com.mystudy.set2_Exam_vo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StudentSetManagerMain {

	public static void main(String[] args) {
		/* (실습) Set 중 HashSet 또는 TreeSet 사용
		 사용클래스명 : StudentVO, StudentSetManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		   ---------------------
		2. Set 타입의 변수(set)에 저장하고
		3. set에 있는 데이터를 사용해서 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. "김유신" 국어 점수를 ?? 점으로 수정 // 다른 점수로 변경
		5. 수정된 "김유신" 데이터만 출력 확인 // 별도로 출력 ㅇㅁㅇ
		6. 전체 데이터 화면 출력
		======================================== */
		
		//1. StudentVO 클래스를 사용해서
		//   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		//   "홍길동", 100, 90, 81
		//   "이순신", 95, 88, 92
		//   "김유신", 90, 87, 77
		System.out.println("== 1. ");
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81, 0, 0);
		//stu1.computeTotAvg();
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92, 0, 0);
		//stu2.computeTotAvg();
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77, 0, 0);
		//stu3.computeTotAvg();
		System.out.println("stu1 : " + stu1);
		System.out.println("stu2 : " + stu2);
		System.out.println("stu3 : " + stu3);
		
		//2. Set 타입의 변수(set)에 저장하고
		System.out.println("\n== 2. ");
		HashSet<StudentVO> set = new HashSet<StudentVO>();
		set.add(stu1);
		set.add(stu2);
		set.add(stu3);

		System.out.println(set);
		
		//3. set에 있는 데이터를 사용해서 화면출력
		//   성명   국어  영어  수학  총점  평균
		//   ---------------------------------
		//   홍길동  100  90  81   270  90.33
		System.out.println("\n== 3. ");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------");
		
		for (StudentVO vo : set) {
			System.out.println(vo.getName() + "\t" + vo.getKor() + "\t"
					+ vo.getEng() + "\t" + vo.getMath() + "\t"
					+ vo.getTot() + "\t" + vo.getAvg());
		}
		
		Iterator<StudentVO> ite = set.iterator();
		while (ite.hasNext()) {
			StudentVO vo = ite.next();
			System.out.println(vo.getName() + "\t" + vo.getKor() + "\t"
					+ vo.getEng() + "\t" + vo.getMath() + "\t"
					+ vo.getTot() + "\t" + vo.getAvg());
			
		}
		
		// 4. "김유신" 국어 점수를 ?? 점으로 수정 // 다른 점수로 변경
		System.out.println("\n== 4. ");
		String name = "김유신";
		int score = 95;
		//stu4.computeTotAvg();
		for (StudentVO vo : set) {
			if(name.equals(vo.getName())) {
				vo.setKor(score);
				//vo.computeTotAvg();
			}
		}
		System.out.println("==================");
		
//		StudentVO stu4 = new StudentVO("김유신", 55, 87, 77, 0, 0);
//		
//		if(set.contains(stu4)) {
//			set.remove(stu4);
//			set.add(stu4);
//		}
//		System.out.println(set);


		// 5. 수정된 "김유신" 데이터만 출력 확인 // 별도로 출력
		System.out.println("\n== 5. ");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------");
		
		
		ite = set.iterator();
		for (int i = 0; i < set.size(); i++) {
			StudentVO vo = ite.next();
			if (vo.getName().equals("김유신")) {
				System.out.println(vo.getName() + "\t" + vo.getKor() + "\t"
						+ vo.getEng() + "\t" + vo.getMath() + "\t"
						+ vo.getTot() + "\t" + vo.getAvg());
			}
		}

		for (StudentVO vo : set) {
			// set이라는 배열을 vo라는 객체에 차례대로 출력함???
			if (vo.getName().equals("김유신")) {
				System.out.println(vo.getName() + "\t" + vo.getKor() + "\t"
						+ vo.getEng() + "\t" + vo.getMath() + "\t"
						+ vo.getTot() + "\t" + vo.getAvg());
			}
		}
		
		ite = set.iterator();
		while (ite.hasNext()) {
			StudentVO vo = ite.next();
			if (vo.getName().equals("김유신")) {
				System.out.println(vo.getName() + "\t" + vo.getKor() + "\t"
						+ vo.getEng() + "\t" + vo.getMath() + "\t"
						+ vo.getTot() + "\t" + vo.getAvg());
				break;
			}
		}
		
//		if(set.contains(stu4)) {
//			set.clear();
//			set.add(stu4);
//			ite = set.iterator();
//			System.out.println(ite.next());
//		}
		System.out.println();
		
		// 6. 전체 데이터 화면 출력
		System.out.println("\n== 6. ");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------");
		ite = set.iterator();
		while (ite.hasNext()) {
			StudentVO vo = ite.next();
			System.out.println(vo.getName() + "\t" + vo.getKor() + "\t"
					+ vo.getEng() + "\t" + vo.getMath() + "\t"
					+ vo.getTot() + "\t" + vo.getAvg());
			break;
			
		}
		for (StudentVO vo : set) {
			// set이라는 배열을 vo라는 객체에 차례대로 출력함???
			System.out.println(vo.getName() + "\t" + vo.getKor() + "\t"
					+ vo.getEng() + "\t" + vo.getMath() + "\t"
					+ vo.getTot() + "\t" + vo.getAvg());
		}
		System.out.println("=================");
		
		//set.descendingIterator(); //개인별 실습
	}

}
