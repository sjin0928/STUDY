package com.mystudy.jdbc2_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student_Select_PreparedStatement {

	public static void main(String[] args) {
		//JDBC 이용한 DB 연동 프로그래밍 작성 절차
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			//url(jdbc:oracle:thin:@:ip:포트:SID(DB의 접속에서 확인)), 유저명, 패스워드
			
			//3. Statement 문 실행(SQL 문 실행)
			String sql = ""
				+ "SELECT ID, NAME, KOR, ENG, MATH, TOTAL, AVG "
				+ "FROM STUDENT "
				+ "WHERE ID = ? "; // ? : 데이터 설정 위치만 지정 DB에서의 ID : 와 같음
			
			// 3-1. connection 객체로부터 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql); //createStatement와 달리sql문 필요함
			
			// 3-2. ?(바인드변수)의 위치에 값 설정
			pstmt.setString(1, "2023011");
			
			System.out.println("sql : " + sql);
			rs = pstmt.executeQuery(); // 준비되어있는 SQL문 실행요청
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			while (rs.next()) {
				String str = ""
						+ rs.getString("ID") + "\t"
						+ rs.getString("NAME") + "\t" 
						+ rs.getInt("KOR") + "\t"
						+ rs.getInt("ENG") + "\t"
						+ rs.getInt("MATH") + "\t"
						+ rs.getInt("TOTAL") + "\t"
						+ rs.getDouble("AVG");
				System.out.println(str);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//5. 클로징 처리에 의한 자원 반납
		
	}
	
}
