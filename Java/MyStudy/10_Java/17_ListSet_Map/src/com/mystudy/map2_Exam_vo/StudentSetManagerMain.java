package com.mystudy.map2_Exam_vo;

import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.mystudy.set2_Exam_vo.StudentVO;

public class StudentSetManagerMain {

	public static void main(String[] args) {
		/*(실습) Map<K, V> 데이터 다루기
		 사용클래스명 : StudentVO, StudentMapManagerMain - main() 메소드
		1. StudentVO 클래스를 사용해서
		   3명의 학생데이터(성명,국어,영어,수학)를 만들고(저장하고)
		   "홍길동", 100, 90, 81
		   "이순신", 95, 88, 92
		   "김유신", 90, 87, 77
		   ---------------------
		2. Map<String, StudentVO> 타입의 변수(map)에 저장하고
		3. map에 있는 데이터를 사용해서 화면출력
		   성명    국어   영어  수학    총점     평균
		   --------------------------
		   홍길동   100  90  81  270  90.33
		   ...
		   -----------------------------
		4. 저장된 map에 있는 김유신 학생의 국어 점수를 95점으로 수정
		5-1. "김유신" 학생의 성적 화면 출력
		5-2. "김유신" 학생의 성명, 총점, 평균 화면 출력
		======================================= */
		System.out.println("== 1.");
		StudentVO stu1 = new StudentVO("홍길동", 100, 90, 81, 0, 0);
		StudentVO stu2 = new StudentVO("이순신", 95, 88, 92, 0, 0);
		StudentVO stu3 = new StudentVO("김유신", 90, 87, 77, 0, 0);
		System.out.println(stu1);
		
		// 2. Map<String, StudentVO> 타입의 변수(map)에 저장하고
		System.out.println("\n== 2.");
		HashMap<String, StudentVO> map = new HashMap<String, StudentVO>() ;
		map.put("홍길동", stu1);
		map.put("이순신", stu2);
		map.put("김유신", stu3);
		
		// 데이터가 많을수록 map은 HashMap보다 오래걸림
		// 직접 이름을 적는거보단 map 내부의 데이터 사용이 좋음
		Map<String, StudentVO> map2 = new HashMap<String, StudentVO>();
		map2.put(stu1.getName(), stu1);
		map2.put(stu2.getName(), stu2);
		map2.put(stu3.getName(), stu3);
		
		System.out.println("\n== 3.");
		// 3. map에 있는 데이터를 사용해서 화면출력
		
		System.out.println("성명\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------");

		System.out.println("-----values------");
		Collection<StudentVO> values = map.values();
		
		for (StudentVO vo : values) {
			//System.out.println(vo);
			printdata(vo);
		}
		System.out.println("-----keySet------");
		
		Set<String> keySet = map.keySet();
		// key의 문자열~
		System.out.println(keySet);
		for (String key : keySet) {
			printdata(map.get(key));
		}

		// 4. 저장된 map에 있는 김유신 학생의 국어 점수를 95점으로 수정
		System.out.println("\n== 4.");
		
		String name = "김유신";
		int score = 95;

		map.get(name).setKor(score);
		
		//---------컴퓨터가 일해야댐 ㅇ ㅁ ㅇ --------------
		StudentVO student = map.get(name);
		// 새로운 변수 생성
		System.out.println(student);
		if (student == null) {
			System.out.println(">>> 데이터 없음");
		} else {
			student.setKor(score);
		}
		printdata(student);
		
		// 5-1. "김유신" 학생의 성적 화면 출력
		System.out.println("\n== 5-1. \"김유신\" 학생의 성적 화면 출력");
		
		printdata(map.get(name));
		
		for (StudentVO vo : values) {
			if (vo.getName().equals(name)) {
				printdata(vo);	
			}
		}
		
		// 5-2. "김유신" 학생의 성명, 총점, 평균 화면 출력
		System.out.println("\n== 5-2. \"김유신\" 학생의 성명, 총점, 평균 화면 출력");
		for (StudentVO vo : values) {
			if (vo.getName().equals(name)) {
				//StudentVO kim = map.get(name);  와 같은 뜻
				System.out.println(vo.getName()
				+ "\t" + vo.getTot() + "\t" + vo.getAvg() );	
			}
		}
		
		StudentVO kim = map.get(name);
		System.out.println(kim.getName()
				+ "\t" + kim.getTot() + "\t" + kim.getAvg());
		
	}
	
	static void printdata (StudentVO vo) {
		System.out.println(vo.getName() + "\t" + vo.getKor() 
		+ "\t" + vo.getEng() + "\t" + vo.getMath()
		+ "\t" + vo.getTot() + "\t" + vo.getAvg() );
	}

}
