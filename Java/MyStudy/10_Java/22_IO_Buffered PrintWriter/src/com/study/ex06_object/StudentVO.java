package com.study.ex06_object;

import java.io.Serializable;

public class StudentVO implements Comparable<StudentVO>, Serializable{
	// NotSerializableException : serializable 아님 예외
	// Comparable

	/*
	 * 직렬화(Serialization) / 역직렬화(DeSerialization)
	  - 직렬화 : JVM 메모리에 있는 객체를(new하여 생긴 객체) 바이트스트림(byte 단위로 직렬)으로 변환하는 작업
	  - 역직렬화 : 바이트스트림 데이터를 자바 객체로 변환하는 작업(byte → 객체)
	  -----------------
	  데이터 전송을 위해서는 직렬화 처리가 가능해야 하는데, serializable 형식만 가능
	  - serializable 인터페이스를 구현하면 된다.
	  데이터 직렬화 처리시 제외할 때에는
	  - transient 를 사용하여 제외한다.
	  transient 처리해도 전달되는 데이터 : static, final 처리된 데이터
	 */
	private static final long serialVersionUID = 1356852705982784296L;
	// serialVersioID가 다른 경우에	
	// 만들어진 데이터가 사욜될때 InvalidClassException 발생할 수 있음
	//private static final long serialVersionUID = 1L;


	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	// transient : 데이터 전송시 값 전달을 제외한다.
	transient private String phoneNo;
	
	// 생성자 메소드 마음대로 만들기
	
	public StudentVO() {}
	
	public StudentVO(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		computeTotAvg();
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "StudentVO [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot
				+ ", avg=" + avg + ", phoneNo=" + phoneNo + "]";
	}
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
		
	}

	public void setKor(int kor) {
		this.kor = kor;
		computeTotAvg();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		computeTotAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		computeTotAvg();
	}
	
	public int getTot() {
		return tot;
	}


	public double getAvg() {
		return avg;
	}


	public void computeTotAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(StudentVO o) {
		return this.name.compareTo(o.name);
	}
	
	

}
