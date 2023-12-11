package com.mystudy.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_Select2 {

	public static void main(String[] args) {

		// 하나의 try 구문으로 변경 한개만 틀어져도 실행이 안되기때문에
		//JDBC 이용한 DB 연동 프로그래밍 작성 절차
		
		//0. JDBC 라이브러리 개발환경 설정(빌드경로에 등록)
		//1. JDBC 드라이버 로딩
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println(">> 드라이버 로딩 성공");
			
			//2. DB연결 - Connection 객체 생성 <- DriverManager
			// .getConnection : 지정된 데이터베이스 URL에 대한 연결을 설정
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe",
					"mystudy", "mystudypw");
			//url(jdbc:oracle:thin:@:ip:포트:SID(DB의 접속에서 확인)), 유저명, 패스워드
			
			System.out.println(">> DB연결 성공 : " + conn);
			
			//3. Statement 문 실행(SQL 문 실행)
			// .createStatement() : 보낼 개체를 생성
			stmt = conn.createStatement();
			String id = "2023002";
					
			String sql = ""
					+ "SELECT ID, NAME, KOR, ENG, MATH, TOTAL, AVG "
					+ "FROM STUDENT "
					//+ "WHERE NAME = '홍길동' "
					//+ "WHERE ID = '" + id + "' "
					+ "ORDER BY ID"; // 맨뒤에 띄어쓰기해야 sql문 오류 없음
			
			System.out.println("sql : " + sql);
			
			//.executeQuery : 단일 개체를 반환하는 지정된 SQL 문을 실행
			// ResultSet : 잔여 개체 확인
			// SELECT - executeQuery
			rs = stmt.executeQuery(sql);
			
			//4. SQL 실행 결과에 대한 처리
			//   - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
			//   - INSERT, UPDATE, DELETE : int 값(건수) 처리
			//System.out.println("rs : "+ rs);
			
			while(rs.next()) {
				//System.out.println(rs.getString(1)); // 첫번째 칼럼 값 출력
				System.out.print(rs.getString("ID") + "\t"); // 칼럼명으로 해주는 게 더 좋음
				System.out.print(rs.getString("NAME") + "\t");
				System.out.print(rs.getInt("KOR") + "\t");
				System.out.print(rs.getInt("ENG") + "\t");
				System.out.print(rs.getInt("MATH") + "\t");
				System.out.print(rs.getInt("TOTAL") + "\t");
				System.out.println(rs.getDouble("AVG") + "\t");
				
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("[예외발생] 드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5. 클로징 처리에 의한 자원 반납
			
			try {
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
