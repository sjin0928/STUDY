package com.mystudy.array;

public class SungjunkManagerExam {

	public static void main(String[] args) {
		// 2차원 배열을 사용한 성적 처리
		// 국어, 영어, 수학 점수 3개를 저장한 2차원 배열(sungjuk)을 만들고
		// 3명의 성적을 입력하고 개인별 총점과 평균을 계산 후 화면에 출력
		// ---------------------------------------------
		/*
		국어\t영어 수학 총점 평균
		------------------
		100  90  80 270 90.0
		100  91  80 271 90.33
		100  90  82 272 90.66
		----------------------------- */
		//int sungjuk [][] = new int [][] {{100, 90, 80}, {100, 91, 80}, {100, 90, 82}};
		int [][] sungjuk = new int [3][];
		
		String title[] = new String [] {"이름", "국어", "영어", "수학", "총점", "평균"};
		String name[] = new String [] {"홍길동", "김유신", "강감찬"};
		sungjuk [0] = new int [] {100, 90, 80};
		sungjuk [1] = new int [] {100, 91, 80};
		sungjuk [2] = new int [] {100, 90, 82};
		
		for (int i = 0; i < title.length; i++) {
			System.out.print(title[i] + "\t");
		}
		System.out.println();
		System.out.println("-----------------------------------------------");
		
		for (int first = 0; first < sungjuk.length; first++) {
			int tot = 0;
			double avg = 0;
			int kor = sungjuk[first][0];
			int eng = sungjuk[first][1];
			int math = sungjuk[first][2];
			// 합산
			tot = kor + eng + math;
			// 평균
			avg = tot * 100 / sungjuk[first].length / 100.00;
			// 점수 출력
			System.out.print(name[first] + "\t" + kor + "\t" + eng + "\t" + math + "\t"+ tot + "\t" + avg);
			System.out.println();
		}
		System.out.println("-----------------------------------------------");
		
		System.out.println("end");
		
		
		System.out.println("=== 강의내용 ===");
		int[][] sungjuk2 = { {100, 90, 80},
							 {100, 91, 80},
							 {100, 90, 82} };
		
		// 1번째 사람 데이터 처리 ---------
		String names[] = new String [] {"김유신", "이순신", "홍길동"};
		//int[] tots = new int[sungjuk2.length];
		//double[] avgs = new double[sungjuk2.length];
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------");
		for (int i = 0; i < sungjuk2.length; i++) {
			int kor = sungjuk2[i][0];
			int eng = sungjuk2[i][1];
			int math = sungjuk2[i][2];
			
		// 계산처리
		int tot = kor + eng + math;
		double avg = tot * 100 / 3 / 100.0;
		
		// 화면출력
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg);
		}
		System.out.println(" === 김유신 성적 출력 ===(자율)");
		
		
		

	}

}

