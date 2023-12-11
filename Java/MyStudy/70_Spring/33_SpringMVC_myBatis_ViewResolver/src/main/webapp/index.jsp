<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	function getJasonBoardList() {
		alert("getJasonBoardList() 실행~");
		
		$.ajax("getJasonBoardList.do", {
			// 전달할 데이터
			type: "get",
			dataType: "json",
			// 파라미터 변수 data는 이름바꿔도 됨
			success: function(data){
				alert("성공!");
				console.log(data);
				
				let dispTag = "<ul>";
				// 받아온 data가 배열임
				for (board in data) {
					dispTag += "<li>";
					dispTag += board.seq + ", ";
					dispTag += board.title + ", ";
					dispTag += board.writer + ", ";
					dispTag += board.content + ", ";
					dispTag += board.regdate;					
					dispTag += "</li>";
				}
				dispTag += "</ul>";
				// id가 listDisp인 곳에 dispTag로 변경
				$("#listDisp").html(dispTag);
			},
			error: function(){
				alert("실패!");
			}
		});
	}
	function getJasonBoard(){
		
	}
</script>

</head>
<body>

<div id="container">
	<h1>게시판 프로그램</h1>
	<hr>
	<p>
		<a href="user/login.do">로그인 페이지로 이동(GET)</a>
	</p>
	<hr><hr>
	
	<h2>Ajax 요청처리</h2>
	<p><a href="javascript:getJasonBoardList()">JSON 데이터 가져오기(BoardList)</a></p>
	<p><a href="javascript:getJasonBoard()">JSON 데이터 가져오기(Board)</a></p>
	<hr>
	<div id="listDisp">
		<ul>
			<li>데이터 가져와서 출력하기</li>
		</ul>
	</div>
</div>
<script>

	function getJasonBoard(){
		alert("getJasonBoard() 실행~")
		// 넘겨줄 데이터
		//let vo = { seq : 1};
		let vo = {};
		vo.seq = 10;
		
		console.log(vo);
		console.log(JSON.stringify(vo)); //JSON 형식 문자열로 만들기
		
		$.ajax("getJasonBoard.do", {
			type: "post", // url이 아닌 body 영역에 데이터 전달
			data: JSON.stringify(vo), //JSON 형식 문자열
			contentType : "application/json", // 서버로 전송하는 컨텐츠 유형(JSON 형식)
			dataType : "json",  //서버로부터 응답받을 데이터 형식
			success : function (data) {
				alert("성공~");
				
				let dispTag = "<ul>";
				dispTag += "<li>";
				dispTag += data.seq + ", ";
				dispTag += data.title + ", ";
				dispTag += data.writer + ", ";
				dispTag += data.content + ", ";
				dispTag += data.regdate;					
				dispTag += "</li>";
				dispTag += "</ul>";
			
				$("#listDisp").html(dispTag);
			}, 
			error : function () {
				alert("실패~");
			}
		});
	}
</script>
</body>
</html>