<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>메인페이지[main.jsp]</h1>
	<a href="sub.jsp">서브페이지로 이동</a>
	<h2>메인페이지 내용</h2>
	<p>.................</p>
	<p>.................</p>
	<p>.................</p>
	<p>.................</p>
	<hr><hr>
	
	<%--디렉티브(지시어) include 사용 : 복사 & 붙여넣기 형태로 적용됨 --%>
	<%@ include file="footer.jsp" %>
	
	<hr>
	<footer>
	W3Schools is optimized for learning and training. Examples might be simplified to improve reading and learning. Tutorials, references, and examples are constantly reviewed to avoid errors, but we cannot warrant full correctness of all content. While using W3Schools, you agree to have read and accepted our terms of use, cookie and privacy policy.
	Copyright 1999-2023 by Refsnes Data. All Rights Reserved. W3Schools is Powered by W3.CSS.
	</footer>
</body>
</html>