<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 품목을 장바구니에 담기 --%>
<%
	// 1. 전달받은 데이터 확인(추출)
	String product = request.getParameter("product");

	// 2. 장바구니에 담기 : ArrayList에 저장
	// 세션에 있으면 사용, 없으면 List 만들기(한개의 장바구니만 만들어야 함)
	ArrayList<String> list = (ArrayList<String>) session.getAttribute("product_list");
	if(list == null){ // 세션에 데이터가 없으면
		list = new ArrayList<String>();
		session.setAttribute("product_list", list);
	}
	list.add(product);
	System.out.println("list : " + list);
	
	
	
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>장바구니 담기</title>
<script>
	//3. 쇼핑페이지로 이동(페이지 전환)
	alert("[<%=product%>] 추가되었습니다.");
	history.back(); // 이전페이지로 이동(뒤로이동)
	//history.go(-1); 같은 의미
</script>
</head>
<body>
	
</body>
</html>