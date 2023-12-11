<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	// 한글 처리를 위한 설정(forward 요청 전 설정)
	System.out.println("request.getCharacterEncoding() : " + request.getCharacterEncoding());
	// 한글 처리 post 방식 요청 시
    request.setCharacterEncoding("UTF-8");
	System.out.println("request.getCharacterEncoding() : " + request.getCharacterEncoding());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫페이지(first)</title>
</head>
<body>
<%
	// 파라미터 값 추출
	String name = request.getParameter("name");
	String age = request.getParameter("age");
%>
	<h1>[ ex02_first.jsp ]</h1>
	<h2>이름 : <%=name %></h2>
	<h2>나이 : <%=age %></h2>
	<hr>

	
	<!-- ===== 액션태그 forward ===== -->
	<h2>파라미터 전달 forward(액션태그)</h2>
	<%-- 최초 요청시 전달 된 파라미터 값 자동 전달 --%>
	<%-- <jsp:forward page="ex02_second.jsp" /> --%>
	
	<%-- 추가로 전달할 파라미터 데이터 추가 전달 --%>
	<jsp:forward page="ex02_second.jsp">
		<jsp:param name="name2" value="<%=name + \"-forward1\" %>"/>
		<jsp:param name="age2" value='<%=age + "-forward2" %>'/>
	</jsp:forward>
</body>
</html>