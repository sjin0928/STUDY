<%@page import="com.mystudy.vo.EmployeeVO"%>
<%@page import="java.sql.*"%>
<%@page import="com.mystudy.common.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--(실습)
	전달받은 데이터로 DB데이터 삭제 처리 후 페이지 전환
    정상처리 후 : list.jsp 이동
    예외 발생 시 : 현재 페이지에 오류 메시지 보여주기
--%>
<%
// 1. 전달받은 데이터 확인
	int sabun = Integer.parseInt(request.getParameter("sabun"));
	int result = -1;
	
	// 2. DB데이터 수정
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try{
		//1. JDBC 드라이버 로딩
		Class.forName(JdbcUtil.DRIVER);
		
		//2. DB연결 - Connection 객체 생성 <- DriverManager
		conn = JdbcUtil.getConnection();
		
		//3. Statement 문 실행(SQL 문 실행)
		//3-1. SQL문 준비
		String sql = "DELETE FROM EMPLOYEE WHERE SABUN = ? ";
		
		pstmt = conn.prepareStatement(sql);
		
		//3-2. 바인드변수(매개변수, 파라미터) 값 설정
		pstmt.setInt(1, sabun);
		
		//4. SQL 실행 결과에 대한 처리
		//4-1. SQL문 실행
		result = pstmt.executeUpdate();
		System.out.println(result);
		
	} catch(Exception e) {
		
	} finally {
		//5. 클로징처리에 의한 반납
		JdbcUtil.close(conn, pstmt);
	}
	
	//4-2. SQL실행결과에 대한 처리
	if (result > 0) {
		response.sendRedirect("list.jsp");
		
	}
	if (result == 0){ //SQL문 정상실행 + 데이터 없음
%>
		<script>
			alert("[삭제실패] 대상이 없어서 수정하지 못했습니다.\n"
					+ "목록 페이지로 이동합니다.");
			location.href = "list.jsp";
		</script>
<%		}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예외발생</title>
</head>
<body>
	<h1>[오류]사원 삭제 실패</h1>
	<p>삭제 처리를 하지 못했습니다<br>
	담당자(8282)에게 연락하세요</p>
	
	<a href="detail.jsp?sabun=<%=sabun %>">입력페이지로 이동</a>
	<a href="list.jsp">전체목록 보기</a>
</body>
</html>