<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 <h2>태그에 작성해서 응답처리 --%>
<%
	//파라미터 값 추출(한글 넣으면 이미 깨진 데이터를 받음)
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>

	<h2>이름 : <%=name %></h2>
	<h2>나이 : <%=age %></h2>
