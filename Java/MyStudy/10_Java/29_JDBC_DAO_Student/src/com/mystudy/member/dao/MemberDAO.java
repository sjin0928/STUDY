package com.mystudy.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mystudy.common.CommonJDBCUtil;
import com.mystudy.member.vo.MemberVO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	// 전체 데이터 검색(찾기) - selectAll() : List<MemberVO>

	public List<MemberVO> selectAll() {
		List<MemberVO> list = null;
		ResultSet rs = null;
		
		try {
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ID, NAME, PASSWORD, PHONE, ADDRESS ");
			sb.append("  FROM MEMBER ");
			// sb.append(" ORDER BY ID ");
			sb.append(" ORDER BY NAME ");
	
			pstmt = conn.prepareStatement(sb.toString());
			rs  = pstmt.executeQuery();
			
			list = new ArrayList<MemberVO>();
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			while (rs.next()) {
				MemberVO vo = new MemberVO(
						rs.getString("ID"),
						rs.getString("NAME"),
						rs.getString("PASSWORD"),
						rs.getString("PHONE"),
						rs.getString("ADDRESS")
						);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			//5. 클로징 처리에 의한 자원 반납
			CommonJDBCUtil.close(conn, pstmt, rs);
		}
		
		
	return list;	
	}
	
	// CommonJDBCUtil 사용 연결, close 처리
	// INSERT : VO 전달받아 데이터 입력처리 - insert(vo) : int
		
	public int insert(MemberVO vo) {
		int result = 0;
		try {

			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = CommonJDBCUtil.getConnection();
			
			//3. Statement 문 실행(SQL 문 실행)
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO MEMBER");
			sql.append(" 	   (ID, NAME, PASSWORD, PHONE, ADDRESS) ");
			sql.append("VALUES (?, ?, ?, ?, ?) ");
						
			pstmt = conn.prepareStatement(sql.toString());
			
			int i = 1;
			pstmt.setString(i++, vo.getId());
			pstmt.setString(i++, vo.getName());
			pstmt.setString(i++, vo.getPassword());
			pstmt.setString(i++, vo.getPhone());
			pstmt.setString(i++, vo.getAddress());
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			result = -1;
			//e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			CommonJDBCUtil.close(conn, pstmt);
		}

		return result;
	}
	
	

	

}
