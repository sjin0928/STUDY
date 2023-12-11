package com.mystudy.vo;

import java.sql.Date;

public class EmployeeVO {
	// 각자 객체 생성하여 고유의 값 갖을 수 있게 static 없이
	// 변수명은 db와 같게
	private int sabun;
	private String name;
	private Date regdate;
	private int pay;
	
	public EmployeeVO() {
		super();
	}

	public EmployeeVO(int sabun, String name, Date regdate, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.regdate = regdate;
		this.pay = pay;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return "EmployeeVO [sabun=" + sabun + ", name=" + name + ", regdate=" + regdate + ", pay=" + pay + "]";
	}
	
}
