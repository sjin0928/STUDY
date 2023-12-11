package com.mystudy.list5_list_vo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentManagerMain {

	public static void main(String[] args) {
		/* (실습) List를 사용한 성적 처리
		사용클래스명 : StudentVO, StudentListManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		   => 학생정보 만들기
		2. ArrayList 타입의 변수(list)에 저장하고
		3. list에 있는 전체 데이터 화면출력
		   성명   국어  영어  수학  총점  평균
		   ---------------------------------
		   홍길동  100  90  81   270  90.33
		   ...
		4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		5. 전체 데이터 화면 출력
		========================================== */
		
		StudentVO stuHong = new StudentVO("홍길동", 100, 90, 81);
		StudentVO stuLee = new StudentVO("이순신", 95, 88, 92);
		StudentVO stuKim = new StudentVO("김유신", 90, 87, 77);
		stuHong.computeTotAvg();
		stuKim.computeTotAvg();
		stuLee.computeTotAvg();
		
		System.out.println("== 1. 학생정보");
		System.out.println(stuHong);
		System.out.println(stuLee);
		System.out.println(stuKim);
		
		System.out.println();
		
		// 2. ArrayList 타입의 변수(list)에 저장하고
		System.out.println("== 2. ArrayList");
		ArrayList<StudentVO> list = new ArrayList<>();
		//LinkedList<StudentVO> list = new LinkedList<>();
		list.add(stuHong);
		list.add(stuKim);
		list.add(stuLee);
		
		System.out.println(list);
		
		//3. list에 있는 전체 데이터 화면출력
		//   성명   국어  영어  수학  총점  평균
		//   ---------------------------------
		//   홍길동  100  90  81   270  90.33
		//   ...
		System.out.println("\n== 3. list에 있는 전체 데이터 화면출력");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------");
		System.out.print(list.get(0).getName() + "\t");
		System.out.print(list.get(0).getKor() + "\t");
		System.out.print(list.get(0).getEng() + "\t");
		System.out.print(list.get(0).getMath() + "\t");
		System.out.print(list.get(0).getTot() + "\t");
		System.out.println(list.get(0).getAvg());
		
		System.out.print(list.get(1).getName() + "\t");
		System.out.print(list.get(1).getKor() + "\t");
		System.out.print(list.get(1).getEng() + "\t");
		System.out.print(list.get(1).getMath() + "\t");
		System.out.print(list.get(1).getTot() + "\t");
		System.out.println(list.get(1).getAvg());

		System.out.print(list.get(2).getName() + "\t");
		System.out.print(list.get(2).getKor() + "\t");
		System.out.print(list.get(2).getEng() + "\t");
		System.out.print(list.get(2).getMath() + "\t");
		System.out.print(list.get(2).getTot() + "\t");
		System.out.println(list.get(2).getAvg());
		

		System.out.println();
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------");
		printData(list);
		
		//4. 김유신 국어 점수를 95 점으로 수정 후 김유신 데이터만 출력
		System.out.println("\n4. 김유신 국어 점수를 95 점");
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------");

		String name = "김유신";
		int score = 95;
		for (StudentVO student : list) {
			if(name.equals(student.getName())) {
				student.setKor(score);
				student.computeTotAvg();
				break;
			}
		}
		System.out.println("------");
		printData(list, "김유신");
		printData(list, "이순신");
		
		System.out.println();
		
		// 강의내용~
		for (StudentVO student : list) {
			printData(student);
		}
		
		System.out.println();
		printData(list);
		System.out.println("------------------\n");
		
		// StudentVO equals() 구현 후 contains(), indexOf() 정상 동작
		System.out.println("list.contains(stuHong) : " + list.contains(stuHong));
		System.out.println("list.contains(stuLee): " + list.contains(stuLee));
		System.out.println("list.indexOf(stuHong) : " + list.indexOf(stuHong));
		System.out.println("------------------\n");
		StudentVO test = new StudentVO("을지문덕", 0, 0, 0);
		System.out.println(test);
		System.out.println("list.contains(test) : " + list.contains(test));
		System.out.println("list.indexOf(test) : " + list.indexOf(test));
		
		System.out.println("==== 김유신 국어점수 88점으로 수정 ===");
		StudentVO kim = new StudentVO("김유신", 88, 0, 0);
		System.out.println("list.contains(kim) : " + list.contains(kim));
		System.out.println("list.indexOf(kim) : " + list.indexOf(kim));
		
		int idx = list.indexOf(kim);
		StudentVO listkim = list.get(idx);
		System.out.print("list 원본 : ");
		printData(listkim);
		
		System.out.println(">> 국어점수 수정처리");
		listkim.setKor(kim.getKor());
		listkim.computeTotAvg();
		
		System.out.print("수정 후 : ");
		printData(listkim);
		
	}
	
	static void printData(StudentVO vo) {
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getKor() + "\t");
		System.out.print(vo.getEng() + "\t");
		System.out.print(vo.getMath() + "\t");
		System.out.print(vo.getTot() + "\t");
		System.out.println(vo.getAvg());
	}
	
	static void printData(ArrayList<StudentVO> list) {
		for (StudentVO student : list) {
			printData(student);
		}
			
	}
	static void printData(List<StudentVO> list, String name) {
		for (StudentVO student : list) {
			if (name.equals(student.getName())) {
				printData(student);
				//break;
			}
		}
	}
	static StudentVO getData(List<StudentVO> list, String name) {
		for (StudentVO student : list) {
			if (name.equals(student.getName())) {
				return student;
			}
		}
		return null;
	}

}
