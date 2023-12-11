package com.spring.biz.user;

import com.spring.biz.user.impl.UserDAO;

public class UserTest {

	public static void main(String[] args) {
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		System.out.println("user : " + user);

	}

}
