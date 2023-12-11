package com.mystudy;

import java.util.Arrays;

public class MemberVO {
	// 원래는 한줄에 하나씩
	private String id, pwd, name, email;
	private String gender;
	private String hobby[]; //checkbox는 여러개 선택 가능하여 배열임
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", gender=" + gender
				+ ", hobby=" + Arrays.toString(hobby) + "]";
	}

}
