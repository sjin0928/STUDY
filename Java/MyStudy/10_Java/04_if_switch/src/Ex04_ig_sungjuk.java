
public class Ex04_ig_sungjuk {

	public static void main(String[] args) {
		/* 성적처리
		 국어(kor), 영어(eng), 수학(math)
		 총점(tot) = 국어 + 영어 + 수학
		 평균(avg) = 총점 / 3
		 -----------------------------
		 평균점수 구간에 따라 평가
		 90 ~ 100 : A
		 80 ~ 89 : B
		 70 ~ 79 : C
		 60 ~ 69 : D
		 69 미만 (0 ~ 69) : F 재수강하세요
		 =============================
		 <처리결과>
		 국어 : 100
		 영어 : 90
		 수학 : 80
		 -----------
		 총점 : 270
		 평균 : 90
		 평가결과 : A
		 -------------------------------*/
		// 성적 입력
		int kor = 100;
		int eng = 10;
		int math = 80;
		String result;

		// 성적 처리
		int tot = kor + eng + math;
		double avg = tot * 100 / 3 / 100.0 ;
		// 소수점 이하 둘째자리까지 표기(버림)
		avg = Math.round(tot * 100 / 3.0) / 100.0;
		// 소수점 이하 둘째자리까지 표기(반올림)
		if (avg >= 90) {
			result = "A";
		} else if (avg >= 80) {
			result = "B";
		} else if (avg >= 70) {
			result = "C";
		} else if (avg >= 60) {
			result = "D";
		} else {
			result = "F 재수강하세요";
		}
		// 처리 결과 출력
		System.out.println("<처리결과>");
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("-----------");
		System.out.println("총점 : " + tot);
		System.out.println("평균 : " + avg);
		System.out.println("평가결과 : " + result);

	}

}
