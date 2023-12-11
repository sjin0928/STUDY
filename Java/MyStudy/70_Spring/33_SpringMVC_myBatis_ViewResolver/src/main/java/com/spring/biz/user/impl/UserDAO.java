package com.spring.biz.user.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.biz.user.UserVO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public UserDAO() {
		System.out.println("=== UserDAO() 실행");
	}
	
	public UserVO getUser(UserVO vo) {
		return mybatis.selectOne("userDAO.getUser", vo);
	}
}
