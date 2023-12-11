<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 요청한 사이트에 따라 재요청 처리 --%>
<%
	//요청한 사이트에 따라 재요청 처리
	String site = request.getParameter("site");

	//재요청 처리
	switch(site) {
		case "naver" : //네이버 웹페이지로 이동 처리 (재요청)
			response.sendRedirect("http://www.naver.com");
			break;
			// http://localhost:8080/02_JSP/09_resp_redirect.jsp?site=naver에서
			// http://www.naver.com로 변경됨
		case "daum" : 
			response.sendRedirect("http://www.daum.net");
			break;
			
			
					
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답페이지</title>
</head>
<body>
	<h1>응답페이지(09_resp_redirect.jsp)</h1>
	<h3>이동할 웹 사이트 : <%=site %></h3>
</body>
</html>