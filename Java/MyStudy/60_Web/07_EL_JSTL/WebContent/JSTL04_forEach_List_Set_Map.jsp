<%@page import="com.mystudy.PersonVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL forEach</title>
</head>
<body>
	<h1>JSTL forEach : Array, List, Set, Map</h1>
	<h2>Array 출력 =============</h2>
	<p>출력대상 : {"a", "ab", "abc", "abcd"}</p>
<%
	String[] strs = {"a", "ab", "abc", "abcd"};
	pageContext.setAttribute("arr", strs);
%>

	<p>배열데이터 : <%=Arrays.toString(strs) %></p>
	<c:forEach var="str" items="${arr }">
		<p>${str }</p>
	</c:forEach>
	
	<h3>배열(Array) 일부 데이터만 사용(2, 3번째 : 1,2인덱스)</h3>
	<h3>c:forEach var="str" items="/${arr }" begin="1" end="2"</h3>
	<ul>
	<c:forEach var="str" items="${arr }" begin="1" end="2">
		<li>${str }</li>
	</c:forEach>
	</ul>
	<hr><hr>
	
	<%-- ======= List 출력 ========= --%>
	<h2>List 출력===========</h2>
<%
	List<Integer> list = new ArrayList<Integer>();
	list.add(123);
	list.add(45);
	list.add(678);
	list.add(90);
	pageContext.setAttribute("alist", list);
%>
	<ul>
	<c:forEach var="listItem" items="${alist }">
		<li>${listItem }</li>
	</c:forEach>
	</ul>
	
	<hr><hr>
	
	<%-- ====== Set 출력 ===== --%>
	<h2>Set 사용 ===========</h2>
<%
	Set<String> set = new HashSet<>();
	set.add("홍길동");
	set.add("김유신");
	set.add("강감찬");
	set.add("을지문덕");
	set.add("을지문덕");
	System.out.println("set : " + set);
	System.out.println("set.size() : " + set.size());
	System.out.println("set.contains(\"홍길동\") : " + set.contains("홍길동"));
	pageContext.setAttribute("hset", set);
%>
	<p>hset : ${hset }</p>
	<p>hset.size : ${hset.size() }</p>
	<p>hset.contains("홍길동") : ${hset.contains("홍길동") }</p>
	<p>hset.toString() : ${hset.toString() }</p>
	
	<ul>
		<c:forEach var="name" items="${hset }">
			<li>${name }</li>
		</c:forEach>
	</ul>
	
	<ol><%-- 어떤 데이터 올지몰라서 잘 안씀 --%>
		<c:forEach var="name" items="${hset }" begin="1" end="2">
			<li>${name }</li>
		</c:forEach>
	</ol>
	
	<%-- ======== Map key-Value 데이터 출력 ======= --%>
	<h2>Map 사용 ===========</h2>
<%
	Map<String, String> map = new HashMap<>();
	map.put("k1", "a");
	map.put("k2", "ab");
	map.put("k3", "abc");
	map.put("k4", "abcd");
	System.out.println("map : " + map);
	pageContext.setAttribute("hmap", map);
%>
	<p>--- Map 특정 데이터 key 값으로 조회 ---</p>
	<p>EL문법</p>
	\${hmap.k1 } : ${hmap.k1 }<br>
	\${hmap.k2 } : ${hmap.k2 }<br>
	\${hmap["k3"] } : ${hmap["k3"] }<br>
	\${hmap['k3'] } : ${hmap['k3'] }<br>
	
	<p>=== Map 전체 데이터 조회 ===</p>
	<c:forEach var="mapData" items="${hmap }">
		<p>
		\${mapData } : ${mapData }<br>
		\${mapData.key } : ${mapData.key }<br>
		\${mapData.value } : ${mapData.value }<br>
		</p>
	</c:forEach>
	<p>--------------------</p>
	
	<p>hmap.keySet() 사용 key 값 확인</p>
	<c:forEach var="key" items="${hmap.keySet() }">
		${key }
	</c:forEach>
	<p>-----------</p>
	<p>hmap.values() 사용 key 값 확인</p>
	<c:forEach var="value" items="${hmap.values() }">
		${value }
	</c:forEach>
	<%-- ============== --%>
	<h1>VO가 담긴 List 사용</h1>
<%
	List<PersonVO> listBean = new ArrayList<>();
	listBean.add(new PersonVO("홍길동", "27"));
	listBean.add(new PersonVO("김유신", "33"));
	listBean.add(new PersonVO("강감찬", "40"));
	listBean.add(new PersonVO("을지문덕", "50"));
	
	System.out.println("listBean : " + listBean);
	//pageContext.setAttribute("persons", listBean);
	
	listBean = null;
	pageContext.setAttribute("persons", listBean);
%>
	<%-- (실습) persons에 있는 PersonVO 객체의 이름, 나이 화면 출력 --%>
	\${persons } : ${persons }
	\${empty persons} : ${empty persons} <br>
	<c:if test="${empty persons }">
		데이터가 없습니다.(\${empty persons} : ${empty persons})
	</c:if>
	
	
	<c:forEach var="person" items="${persons }">
		<p>이름 : ${person.name }, 나이 : ${person.age }</p>
	</c:forEach>
	
</body>
</html>