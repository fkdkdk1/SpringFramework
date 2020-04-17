<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>GET</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
		<tr>
			<td>${dto.name}</td>
			<td>${dto.addr}</td>
			<td>${dto.phone}</td>
		</tr>
	</table>
</body>
</html>