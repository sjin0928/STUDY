<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 주문한 내역에 따라 계산하고 결과를 표시 --%>
<%
	// 주문한 내역에 따라 계산하고 결과를 표시
	// 1. 파라미터 값을 추출(확인)
	
	String coffee = "0";
	
	coffee = request.getParameter("coffe");
	if(coffee == null){
		response.sendRedirect("08_req_coffe.jsp");
	}
	int su = Integer.parseInt(request.getParameter("su"));
	int inMoney = Integer.parseInt(request.getParameter("money"));
		
	// 2. 계산 처리
	
	int price = 0;
	String menu = "선택안함";
	
	if(("1").equals(coffee)){
		price = 3000; menu = "아메리카노";
	}
	if(("2").equals(coffee)){
		price = 3500; menu = "카페모카";
	}
	if(("3").equals(coffee)){
		price = 2500; menu = "에스프레소";
	}
	if(("4").equals(coffee)){
		price = 4000; menu = "카페라떼";
	}
	/*
	switch(coffee){
		case "0" : break;
		case "1" : price = 3000; menu = "아메리카노"; break;
		case "2" : price = 3500; menu = "카페모카"; break;
		case "3" : price = 2500; menu = "에스프레소"; break;
		case "4" : price = 4000; menu = "카페라떼"; break;
	}
	*/
	int totPrice = su * price; 
	int outMoney = inMoney - totPrice;
	
	// 3. 결과 표시
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문결과</title>
</head>
<body>
	<h2>주문 계산 결과(응답-08_resp.jsp)</h2>
<%--
	커피종류 : 아메리카노
	단가 : 3000원
	수량 : 3
	구입금액 : 9000원(단가 * 수량)
	---------
	입금액 : 10000원
	잔액 : 1000원 (입금액 - 구입금액)
 --%>
	<ul>
	 	<li>커피종류 : <%=menu %></li>
	 	<li>단가 : <%=price %>원</li>
	 	<li>수량 : <%=su %>잔</li>
	 	<li>구입금액 : <%=totPrice %>원(단가 * 수량)</li>
	 	<li>--------</li>
	 	<li>입금액 : <%=inMoney %>원</li>
	 	<li>잔액 : <%=outMoney %>원(입금액 - 구입금액)</li>
	</ul>
 
</body>
</html>