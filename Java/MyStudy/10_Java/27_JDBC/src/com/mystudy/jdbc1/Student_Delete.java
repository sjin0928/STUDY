package com.mystudy.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_Delete {

	public static void main(String[] args) {
		// 자바에서 입력한 데이터는 자동으로 commit됨
		//JDBC 이용한 DB 연동 프로그래밍 작성 절차
		
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		
		Connection conn = null;
		Statement stmt = null;
		// ResultSet rs = null; -> 없음
		
		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
			
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"MYSTUDY", "mystudypw");
			
			//3. Statement 문 실행(SQL 문 실행)
			stmt = conn.createStatement();

			String sql = "";
			sql += "DELETE FROM STUDENT ";
			sql += " WHERE ID = '2023005'"; //""안에 ; 없어야함
			
			System.out.println(sql);
			// INSERT, UPDATE, DELETE 실행 : executeUpdate(sql)
			int result = stmt.executeUpdate(sql);
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			System.out.println("처리건수 : " + result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			
			try {
				if(stmt!=null) stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
				
	}

}
