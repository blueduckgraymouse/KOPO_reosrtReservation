<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<center>
		<h2>관리자 로그인</h2>
		<br>
		<form>
			<table border=1>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id" id="id">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password" id="password">
					</td>
				</tr>
			</table>
			<br>
			<input type="button" id="submit" value="로그인">
		</form>
	</center>
	
	<script>
	    $("#submit").click(function(){
	 
	            // json 형식으로 데이터 set
	            var params = {
	                 id : $("#id").val(),
	                 password : $("#password").val()
	            }
	                
	            // ajax 통신
	            $.ajax({
	                type : "POST",            // HTTP method type(GET, POST) 형식이다.
	                url : "/KOPO_resortReservation/login.rr",      // 컨트롤러에서 대기중인 URL 주소이다.
	                data : params,            // Json 형식의 데이터이다.
	                success : function(res){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
	                	if(res == 1) {
	                		alert('관리자님 환영합니다.');
		                    location.href="/KOPO_resortReservation/userReservation.rr";
	                	} else {
	                		alert('잘못된 계정 정보입니다.');
	                	}
	                },
	                error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
	                    alert("통신 실패.");
	                }
	            });
	        });
	</script>
</body>
</html>