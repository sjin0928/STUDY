package com.mystudy.bean_vo;

// 자바빈(Java Bean)형태의 클래스 작성
// VO(Value Object) : 값(데이터)을 저장하기 위한 클래스(객체) - Oxxxx, OxxxVO, OxxxVo
// DTO(Data Transfer Object) : 값(데이터)을 저장해서 전달하기 위한 클래스(객체)
// 		Oxxxx, OxxxDTO, OxxxDto
public class StudentVO {
	// 필드(변수)선언 ------------------
	// 성명 - name : String
	// 국어 - kor : int
	// 영어 - eng : int
	// 수학 - math : int
	// 총점 - tot : int
	// 평균 - avg : double
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	
	// 생성자 작성 --------------------
	// 생성자 - 성명, 국어, 영어, 수학 점수를 입력받는 생성자
	
	// 생성자로 한번에 입출력 진행
	public StudentVO () {};
	public StudentVO (String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		calTotAvg();
	};
	
	// 메소드 작성 --------------------

	// setters, getters 모두 작성
	// set, get으로 분할하여 진행 / 각 개별의 값을 출력할 수 있음.
	public void setName (String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setKor (int kor) {
		if (kor >= 0 && kor <= 100) {
		this.kor = kor;
		} else {
			System.out.println("점수 오류");
		}
	}
	// 점수 개별 입력시 사용
	public int getKor () {
		return kor;
	}
	// 점수를 개별 호출시 사용
	
	public void setEng (int eng) {
		if (eng >= 0 && eng <= 100) {
		this.eng = eng;
		} else {
			System.out.println("점수 오류");
		}
	}
	public int getEng () {
		return eng;
	}
	
	public void setMath (int math) {
		if (eng >= 0 && eng <= 100) {
			this.math = math;
		} else {
			System.out.println("점수 오류");
		}
	}
	public int getMath () {
		return math;
	}
	
	public void setTot (int tot) {
		this.tot = tot;
	}
	public int getTot () {
		return tot;
	}
	
	public void setAvg (double avg) {
		this.avg = avg;
	}
	public double getAvg () {
		return avg;
	}
	
	private void calTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.00;
	}
	
	public String toString() {
		return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + "]";
	}
	
	public void sungjuk() {
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg);
	}
}
