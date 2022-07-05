<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.rr.service.ReservationService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table.status {
		border: 1px solid black;
		width: 800px;
		heigh: 10px;
		text-align: center;
		font-size: 15px;
	}
	th {
		background-color: #6791be;
	}
	td {
		height: 2rem;
	}
	a {
		color:skyblue;
		text-decoration: none;
	}
	a.reserved {
		color:grey;
		text-decoration: none;
	}
	a:hover {
		color:black;
	}
</style>
</head>
<body>
	<center>
		<h2>예약 현황</h2>
		<table class="status">			
			<tr>	
				<th width="25%">	
					날짜
				</th>
				<th width="25%">			
					1번 방
				</th>		
				<th width="25%">					
					2번 방
				</th>		
				<th width="25%">					
					3번 방
				</th>			
			</tr>
			<c:forEach var="oneDay" items="${monthReservation}">
				<tr>
					<td>${oneDay.date}</td>
					<c:choose> 
						<c:when test="${oneDay.room1 == '예약가능'}">
							<td>
								<a href="./reservation_inputform.jsp?room=1&date=${oneDay.date}">${oneDay.room1}</a>
							</td>
						</c:when>
						<c:otherwise> 
							<c:choose>
							    <c:when test="${sessionScope.userid eq 'admin'}">
									<td><a class="reserved" href="./admin.rr?room=1&date=${oneDay.date}">${oneDay.room1}</a></td>
							    </c:when>
							    <c:otherwise>
									<td>${oneDay.room1}</td>
							    </c:otherwise>
							</c:choose>
						</c:otherwise> 
					</c:choose>
					<c:choose> 
						<c:when test="${oneDay.room2 == '예약가능'}">
							<td>
								<a href="./reservation_inputform.jsp?room=2&date=${oneDay.date}">${oneDay.room2}</a>
							</td>
						</c:when>
						<c:otherwise> 
							<c:choose>
							    <c:when test="${sessionScope.userid eq 'admin'}">
									<td><a class="reserved" href="./admin.rr?room=1&date=${oneDay.date}">${oneDay.room2}</a></td>
							    </c:when>
							    <c:otherwise>
									<td>${oneDay.room2}</td>
							    </c:otherwise>
							</c:choose>
						</c:otherwise> 
					</c:choose>
					<c:choose> 
						<c:when test="${oneDay.room3 == '예약가능'}">
							<td>
								<a href="./reservation_inputform.jsp?room=3&date=${oneDay.date}">${oneDay.room3}</a>
							</td>
						</c:when>
						<c:otherwise> 
							<c:choose>
							    <c:when test="${sessionScope.userid eq 'admin'}">
									<td><a class="reserved" href="./admin.rr?room=1&date=${oneDay.date}">${oneDay.room3}</a></td>
							    </c:when>
							    <c:otherwise>
									<td>${oneDay.room3}</td>
							    </c:otherwise>
							</c:choose>
						</c:otherwise> 
					</c:choose>
				<tr>
			</c:forEach>
		</table>
	<center>
</body>
</html>