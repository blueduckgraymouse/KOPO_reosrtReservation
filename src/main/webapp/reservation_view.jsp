<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {
			width: 400px;
		}
		tr, th, td {
			border: 1px solid black;
			text-align: center;
		}
		th {
			background-color: #6791be;
		}
	</style>
</head>

<body>
	<center>
		<h2>예약 정보</h2>
		<br>
		<form>
			<table>
				<tr>
					<th width="30%">성명</th>
					<td widht="70%">
						${oneReservation.name}
						 <input type="hidden" name="_method" id="method"/>
					</td>
				</tr>
				<tr>
					<th>예약일자</th>
					<td>
						${oneReservation.resv_date}
						<input type="hidden" value="${oneReservation.resv_date}" name="date"/>
						
					</td>
				</tr>
				<tr>
					<th>예약방</th>
					<td>
						${oneReservation.room}
						<input type="hidden" value="${oneReservation.room}" name="room"/>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						${oneReservation.addr}
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						${oneReservation.telnum}
					</td>
				</tr>
				<tr>
					<th>입금자명</th>
					<td>
						${oneReservation.in_name}
					</td>
				</tr>
				<tr>
					<th>남기실 말</th>
					<td height="100px">
						${oneReservation.comment}
					</td>
				</tr>
				<tr>
					<th>처리과정</th>
					<td>
						<c:choose>
							<c:when test="${oneReservation.processing eq 1}">
								1(예약완료)
							</c:when>
							<c:when test="${oneReservation.processing eq 2}">
								2(결제완료)
							</c:when>
							<c:when test="${oneReservation.processing eq 3}">
								3(환불 진행중)
							</c:when>
						</c:choose>
					</td>
				</tr>
			</table>
			<br>
			<input type="button" onclick="goUpdateForm(this);" value="수정">
			<input type="button" onclick="goDelete(this);" value="삭제">
		</form>
	</center>
	<script>
		function goUpdateForm(targetForm) {
			targetForm.form.method = "GET";
			targetForm.form.action = "admin.rr";
			targetForm.form.submit();
		} 
		
		function goDelete(targetForm) {
			//targetForm.form.method = "DELETE";
			document.getElementById("method").value = "DELETE";
			targetForm.form.action = "admin.rr";
			targetForm.form.submit();
		} 
	</script>
</body>
</html>