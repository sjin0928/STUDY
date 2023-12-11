package com.spring.biz.user.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.biz.user.UserVO;

public class UserDAOSpring {
	private JdbcTemplate jdbcTemplate;
	// SQL 문
		private final String USER_GET
			= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?"; 
		
		public UserDAOSpring() {
			System.out.println(">> UserDAOSpring() 객체 생성");
		}
		
		public UserVO getUser(UserVO vo) {
			Object args[] = {vo.getId(), vo.getPassword()};
			
			return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
		}
}
