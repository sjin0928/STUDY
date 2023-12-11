<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언부 전역변수</title>
</head>
<body>
<%!
	//선언부(declaration)는 필드영역에 작성되는 코드
	//static 처럼 사용됨
	int globalNum = 0;
%>
<%
	//스크립트릿 - service()메소드 영역(로컬영역), 호출할 때마다 실행됨
	int localNum = 0; 
	localNum++;
	globalNum++;
	
	System.out.println("globalNum : " + globalNum);
	System.out.println("localNum : " + localNum);
%>
	<h1>선언부/스트립트릿 변수값 확인</h1>
	<h2>globalNum : <%= globalNum %></h2>
	<h2>localNum : <%= localNum %></h2>
</body>
</html>