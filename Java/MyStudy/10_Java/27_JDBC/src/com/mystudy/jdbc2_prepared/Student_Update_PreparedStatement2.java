package com.mystudy.jdbc2_prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_Update_PreparedStatement2 {

	public static void main(String[] args) {
		//JDBC 이용한 DB 연동 프로그래밍 작성 절차
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		
		// 수정 : 이름, 국어, 영어, 수학 - 아이디가 일치하는 것 찾아서
		Connection conn = null;
		PreparedStatement pstmt = null;
				
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
			
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"MYSTUDY", "mystudypw");
			System.out.println(">> DB연결 성공");
			
			
			//3. Statement 문 실행(SQL 문 실행)
			String sql = "";
			sql += "UPDATE STUDENT";
			sql += "   SET NAME = ? ";	//1
			sql += "     , KOR = ? ";	//2
			sql += "     , ENG = ? ";	//3
			sql += "     , MATH = ? ";	//4
			sql += " WHERE ID = ?";		//5
			
			
			//3-1. SQL문 실행을 위한 준비(PreparedStatement 객체 생성) "필수"
			pstmt = conn.prepareStatement(sql);
			
			//3-2. SQL 문장의 ? 위치에 값 설정(매칭, 대입)
			String id = "2023012";
			String name = "테스트12 수정";
			int kor = 50;
			int eng = 60;
			int math = 70;
			
			pstmt.setString(1, name);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, math);
			pstmt.setString(5, id);
			
			//3-3. 준비된 SQL문 실행 요청
			int result = pstmt.executeUpdate();
			
			//4. SQL 실행 결과에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			System.out.println("처리건수 : " + result);
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		

	}

}
