<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>서브페이지[sub.jsp]</h1>
	<a href="main.jsp">메인페이지로 이동</a>
	<h2>메인페이지 내용</h2>
	<p>.................</p>
	<p>.................</p>
	<p>.................</p>
	<p>.................</p>
	<hr><hr>
<%!
	//선언부 : 서블릿의 필드 영역에 작성되는 코드
	int globalNum = 0;
%>
<%
	// 스크립트릿 : 서블릿 service() 메소드에 작성되는 코드
	int localNum = 0;
	localNum++;
	out.print("<h2>localNum : " + localNum + "</h2>");
	
	globalNum++;
	out.print("<h2>localNum : " + globalNum + "</h2>");
 %>
	<footer>
	W3Schools is optimized for learning and training. Examples might be simplified to improve reading and learning. Tutorials, references, and examples are constantly reviewed to avoid errors, but we cannot warrant full correctness of all content. While using W3Schools, you agree to have read and accepted our terms of use, cookie and privacy policy.
	Copyright 1999-2023 by Refsnes Data. All Rights Reserved. W3Schools is Powered by W3.CSS.
	</footer>
</body>
</html>