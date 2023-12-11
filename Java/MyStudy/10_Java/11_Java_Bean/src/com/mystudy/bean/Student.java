package com.mystudy.bean;
/*
  ■ 자바빈(Java Bean)
  => 콩깍지라고 생각
  - 멤버변수(property)의 접근제어자는 private
  - 멤버변수(property) 마다 get/set 메소드 제공(선택적으로 get만 제공)
  - get/set 메소드는 public
  - get 메소드는 파라미터 없고, set 메소드는 하나 이상의 파라미터 존재
  - 멤버변수(property)가 boolean 타입이면 get 메소드 대신 is 메소드 사용가능
  - 외부에서 멤버변수(property) 접근시에는 get/set 메소드를 통해 접근
*/
//public class Student extends Object {
class Student { // extends Object 생략하면 컴파일러가 자동삽입
	private String name; // 멤버변수
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	public Student() {
		super();
		// super : 부모클래스의 객체(인스턴스)
		// super() : 부모클래스 객체(인스턴스)의 기본 생성자 호출;
		// 생성자 호출, 생략시 컴파일러가 자동 삽입해서 처리함.
	}

	public Student (String name) {
		// super(); //생략되어있음 항상 최상단
		this.name = name;
	}
	public Student(String name, int kor, int eng, int math) {
		//현재객체(인스턴스)의 생성자 호출
		//생성자의 재사용
		//생성자 코드 중 맨 처름 작성되어 실행
		this(name); 
//		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeTotAvg();
	}
	
	// 다른곳에서 호출시 The field Student.name is not visible
	// 다른곳에서 호출가능하게 하려면 메소드를 만들기

	public Student(String name, int kor, int eng, int math, int tot, double avg) {
		// super(); 생성자의 재사용시 직접 명시 X
		this(name, kor, eng, math);
		this.tot = tot;
		this.avg = avg;
	}

	// == 메소드 작성 영역 ===========
	// 외부에서 사용할 수 있도록 메소드를 제공(public)
	// 외부에서 데이터를 전달받아 필드(멤버변수)에 데이터를 저장하기위한 set 메소드
	// 명칭 (호칭) : set 메소드, setter, set property(속성값 설정-쓰기)
	// 외부기준으로 명칭이 정해짐
	public void setName(String name) {
		this.name = name;
	}
	// 외부에서 데이터를 읽어가기위한 get 메소드(라고 요청할때는 값을 돌려줌)
	// 명칭(호칭) : get메소드, getter, get property(속성값 읽기)
	public String getName() {
		return name;
	}
	
	// kor : setter, getter
	public void setKor(int kor) {
		// 적절한 데이터 여부 확인
		if (kor >= 0 && kor <=100) {
			this.kor = kor;
		} else {
			System.out.println("[예외발생] 국어 0~100 값이 아님");
		}
			
	}
	public int getKor() {
		return kor;
	}
	
	// (실습) eng, math : setters, getters 작성
	
	public void setters (int eng, int math) {
		this.eng = eng;
		this.math = math;
	}
	public int gettersEng() {
		return eng;
	}
	public int gettersMath() {
		return math;
	}
	
	
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	//(실습) printdata() 메소드 작성 : 저장된 데이터 화면 출력
//		public void printdata(int math, int eng) {
//			System.out.println("수학 점수 : " + math +
//						"\n영어 점수 : " + eng);
//		}
	public void printdata2() {
		System.out.println(name + "\t" + kor + "\t" + math
				+ "\t" + eng + "\t" + tot + "\t" + avg);
	}
	
	private void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
}
