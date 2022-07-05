<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<%
		String id = (String)session.getAttribute("MEMBERID");	// MEMBERID에 저장된 값을 id에 저장
	
		if((id!=null) && (id!="") && (id.length()!=0))	// 사용자가 입력했을 id가 null이면 접속x / 아니면 접속중
		{
			
		}
	%>
</head>
<body>
	<center>
		<form method="post" action="admin.rr">
			<table border=1>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="id">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password">
					</td>
				</tr>
			</table>
			
			<input type="submit" value="로그인">
		</form>
	</center>
</body>
</html>