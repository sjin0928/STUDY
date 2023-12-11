<%@page import="com.mystudy.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 처리 post 방식 요청 시
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 파라미터 값 추출
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
	<h1>스크립트릿 사용방식(로컬변수)</h1>
	<h2>이름 : <%=name %></h2>
	<h2>나이 : <%=age %></h2>
	<hr>
<%--
	//아래의 jsp:useBean 액션태그의 동작방식
	PersonVO person = (PersonVO) pageContext.getAttribute("person");
	if(person == null) {
		person = new PersonVO();
		pageContext.setAttribute("person", person);
	}
	person.setName(request.getParameter("name"));
	// 아래와 같음
--%>
	<h1>액션태그 jsp:useBean 사용</h1>
	<jsp:useBean id="person" class="com.mystudy.PersonVO" scope="page" />
	<jsp:setProperty property="*" name="person"/> <%-- 모든 데이터 저장 --%> 
	
	<%--<jsp:setProperty property="name" name="person"/>
	<jsp:setProperty property="age" name="person"/> --%>
	<%-- 여러군데서 쓸거면 scope:request --%>
	<%-- setter 호출 하여 name에 person 저장, local변수, 페이지스코프(페이지 내에 저장된 것)에 저장 됨--%>
	
<%
	System.out.println(">person : " + person);
	System.out.println(">page person : " + pageContext.getAttribute("person"));
%>
	<h2>빈(Bean) 저장 값 표시</h2>
	<h2>이름(표현식) : <%=person.getName() %></h2>
	<h2>나이(표현식) : <%=person.getAge() %></h2>
	<hr>
	
	<%-- 잘 안쓰는 방식 : EL이 더 쉬움 --%>
	<h2>데이터 읽기 : getProperty 액션태그</h2>
	<h2>이름(액션태그) : <jsp:getProperty property="name" name="person"/></h2>
	<h2>나이(액션태그) : <jsp:getProperty property="age" name="person"/></h2>
	<hr><hr>
	
	<h2>EL(employee Language)의 getter 사용 방식</h2>
	<h2>이름(EL) : ${person.getName() }</h2>
	<h2>나이(EL) : ${person.getAge() }</h2>
	<p>----------------</p>
	<h2>이름(EL) : ${person.name }</h2>
	<h2>나이(EL) : ${person.age }</h2>
	
</body>
</html>