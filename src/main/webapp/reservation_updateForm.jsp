<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h2>예약 수정</h2>
		<br>
		<form method="POST" action="./admin.rr">
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
						<input type="date" name="date" id="date" value="${oneReservation.resv_date}" readonly>
					</td>
				</tr>
				<tr>
					<th>예약방</th>
					<td>
						<input type="text" name="room" id="room" value="${oneReservation.room}" readonly>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="addr" value="${oneReservation.addr}">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="tel" value="${oneReservation.telnum}">
					</td>
				</tr>
				<tr>
					<th>입금자명</th>
					<td>
						<input type="text" name="in_name" value="${oneReservation.in_name}">
					</td>
				</tr>
				<tr>
					<th>남기실 말</th>
					<td>
						<input type="text" name="comment" value="${oneReservation.comment}">
					</td>
				</tr>
				<tr>
					<th>처리과정</th>
					<td>
						<select name="processing" value="${oneReservation.processing}">
							<option value="1" id="option1">1번(예약 완료)</option>
							<option value="2" id="option2">2번(결제 완료)</option>
							<option value="3" id="option3">3번(환불 진행중)</option>
						</select>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="전송">
		</form>
		
		<script>
			function init() {
				// 위에 처리과정 수정할 때 전에 값 가져와서 default로 띄우는거 구현.
			}
		</script>
	</center>
</body>
</html>