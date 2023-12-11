package com.spring.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.biz.user.UserVO;

public class UserRowMapper implements RowMapper<UserVO>{

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO users = new UserVO();
		users.setId(rs.getString("ID"));
		users.setPassword(rs.getString("PASSWORD"));
		users.setName(rs.getString("NAME"));
		users.setRole(rs.getString("ROLE"));
		
		return users;
	}
	

}
