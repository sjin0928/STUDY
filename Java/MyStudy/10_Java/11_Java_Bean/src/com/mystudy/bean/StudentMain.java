package com.mystudy.bean;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student();
		System.out.println("stu : " + stu.toString());
		
		// System.out.println("stu.name : " + stu.name);
		// not visible
		
		stu.setName("홍길동");
		String name = stu.getName();
		System.out.println("name : " + name);
		System.out.println("name : " + stu.getName());
		
		//stu.kor = 999;
		//System.out.println("kor : " + stu.kor);
		System.out.println("입력전 kor : " + stu.getKor());
		stu.setKor(999);
		System.out.println("입력후 kor : " + stu.getKor());

		stu.setters(11, 12);
		System.out.println("영어점수 : " + stu.gettersEng());
		System.out.println("수학점수 : " + stu.gettersMath());
		
//		stu.printdata(55, 66);
		
		int tot = stu.getKor() + stu.getEng() + stu.getMath();
		System.out.println("tot : " + tot);
		
		stu.setTot(tot); //계산된 합계 데이터를 Student 타입의 객체의 필드에 저장
		
		double avg = tot * 100 / 3 / 100.0; //100을 곱하여 소수점 둘째자리를 정수로 표현하여 3을 나눈 후 100.0으로 실수화
		stu.setAvg(avg);
		stu.printdata2();
		
		System.out.println("==== 생성자 사용 데이터 입력 ===");
		Student stu2 = new Student("김유신", 100, 90, 82);
		stu2.printdata2();
		
	}

}
