<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%
		session.removeAttribute("authUser");
	%>
	<script>
		alert("로그아웃되었습니다.");
		location.href="main.jsp";
	</script>
<body>

</body>
</html>