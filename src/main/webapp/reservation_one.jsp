<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body onload="init();">
	<center>
		<h2>예약하기</h2>
		<br>
		<table>
			<tr>
				<th>성명</th>
				<td>
					<input type="text" name="name" value="${oneReservation.name}">
				</td>
			</tr>
			<tr>
				<th>예약일자</th>
				<td>
					<input type="date" name="date" id="date"  value="${oneReservation.resv_date}">
				</td>
			</tr>
			<tr>
				<th>예약방</th>
				<td>
					<input type="text" name="room" id="room" value="${oneReservation.room}">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="addr"  value="${oneReservation.addr}">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="tel"  value="${oneReservation.telnum}">
				</td>
			</tr>
			<tr>
				<th>입금자명</th>
				<td>
					<input type="text" name="in_name"  value="${oneReservation.in_name}">
				</td>
			</tr>
			<tr>
				<th>남기실 말</th>
				<td>
					<input type="text" name="comment"  value="${oneReservation.comment}">
				</td>
			</tr>
			<tr>
				<th>예약신청일</th>
				<td>
					<input type="text" name="comment"  value="${oneReservation.write_date}">
				</td>
			</tr>
			<tr>
				<th>진행상황</th>
				<td>
					<c:choose>
					    <c:when test="${oneReservation.processing eq '1'}">
							<td>예약완료</td>
					    </c:when>
					    <c:when test="${oneReservation.processing eq '2'}">
							<td>입금완료</td>
					    </c:when>
					    <c:when test="${oneReservation.processing eq '3'}">
							<td>완불요청</td>
					    </c:when>
					</c:choose>
				</td>
			</tr>
		</table>
		
		<input type="button" value="수정" onclick="location.href='./reservation_updateForm.jsp?'"/>
	</center>
</body>
</html>