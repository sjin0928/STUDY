<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 대이터를 DB에 입력
	 정상입력 : list.jsp 페이지로 이동(입력건수 0보다 크면 list.jsp 재요청 처리)
	 예외발생 : 현재페이지에 오류메시지 보여주기
 --%>
<%
	//1. 파라미터 값 추출(sabun, name, pay)
	int sabun = Integer.parseInt(request.getParameter("sabun"));
	String name = request.getParameter("name");
	int pay = Integer.parseInt(request.getParameter("pay"));
	
	//2. DB 입력작업
	final String DRIVER = "oracle.jdbc.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "MYSTUDY";
	final String PASSWORD = "mystudypw";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	int result = -1;
	
	try {
		// 2. DB연결 - Connection 객체 생성 <- DriverManager
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3. Statement 문 실행(SQL 문 실행)
		StringBuilder sql = new StringBuilder(); 
		sql.append("INSERT INTO EMPLOYEE ");
		sql.append(" 	   (SABUN, NAME, REGDATE, PAY) ");
		sql.append("VALUES (?, ?, SYSDATE, ?)");
		// 4. SQL 실행 결과에 대한 처리
		//    - SELECT : 조회(검색) 데이터 결과 값에 대한 처리
		//    - INSERT, UPDATE, DELETE : int 값(건수) 처리
		
		pstmt = conn.prepareStatement(sql.toString());
		
		//3-2. 바인드 변수(매개변수) 값 설정(?있을때만)
		
		int i = 1;
		pstmt.setInt(i++, sabun);
		pstmt.setString(i++, name);
		pstmt.setInt(i++, pay);
		
		//4. SQL 실행 결과에 대한 처리
		//4-1. SQL문 실행
		result = pstmt.executeUpdate();
		System.out.println(result);
		
		//3. 화면전환
		if(result > 0){
			response.sendRedirect("list.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		//5. 클로징 처리에 의한 자원 반납
		try{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {	}
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생</title>
</head>
<body>
	<h1>사원 등록 실패</h1>
	<p>입력 처리를 하지 못했습니다.<br>
	담당자(8282)에게 연락하세요</p>
	
	<a href="addForm.jsp">입력 페이지로 이동</a>
	<a href="list.jsp">전체 목록 보기</a>
	
</body>
</html>