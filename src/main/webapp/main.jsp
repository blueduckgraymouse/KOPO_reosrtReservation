<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat, java.net.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.container{
			width: 1200px;
			height: 500px;
		}
	</style>
	<%
		String oldLastDate = null; 
		Cookie[] cookies = request.getCookies();
		
		// 이전 방문 시간을 쿠키에서 가져오기
		for (int i = 0; i < cookies.length; i++) {
			if ("lastDate".equals(cookies[i].getName())) {
				oldLastDate = URLDecoder.decode(cookies[i].getValue(),"utf-8");
			}
		}
		
		// 지금 방문 시간을 쿠키에 저장
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		Cookie newLastDate = new Cookie("lastDate", URLEncoder.encode(sdf.format(nowDate), "utf-8"));
		newLastDate.setMaxAge(-1);
		response.addCookie(newLastDate);
	%>
</head>
<body>
	<center>
		<br>
			<div class="container">
				<img src="./img/main.jpg" width="500px" />
			<br>
			<h2>청와 리조트로 놀러오세요</h2>
			<%
				if (oldLastDate == null) {
					out.println("첫 방문을 환영합니다.");
				} else {
					out.println("최근 방문일은(" + oldLastDate + ") 입니다.");
				}
			%>
		</div>
	</center>
</body>
</html>