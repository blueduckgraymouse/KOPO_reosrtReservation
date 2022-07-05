<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="init();">
	<form method="post" action="./reservation.rr">
		<table>
			<tr>
				<th>성명</th>
				<td>
					<input type="text" name="name" required>
				</td>
			</tr>
			<tr>
				<th>예약일자</th>
				<td>
					<input type="date" name="date" id="date" value="2022-07-03" readonly>
				</td>
			</tr>
			<tr>
				<th>예약방</th>
				<td>
					<select name="room" id="room">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="addr" required>
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="tel" required>
				</td>
			</tr>
			<tr>
				<th>입금자명</th>
				<td>
					<input type="text" name="in_name" required>
				</td>
			</tr>
			<tr>
				<th>남기실 말</th>
				<td>
					<input type="text" name="comment" required>
				</td>
			</tr>
		</table>
		
		<input type="submit" value="전송">
	</form>
	
	<script>
	    let params = {};  
	    
	    window.location.search.replace(/[?&]+([^=&]+)=([^&]*)/gi, 
	    	function(str, key, value) { 
	        	params[key] = value; 
	        }
	    );    
	
		function init() {
			for(let key in params) {
				let rooms = document.getElementById(key);
				rooms.value = params[key];
			}

		}
	</script>
</body>
</html>