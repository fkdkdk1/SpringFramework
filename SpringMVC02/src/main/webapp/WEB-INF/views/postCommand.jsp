<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>POST</h1>
	
	<table border="1">
		<tr>
			<th>�̸�</th>
			<th>�ּ�</th>
			<th>��ȭ��ȣ</th>
		</tr>
		<tr>
			<td>${dto.name}</td>
			<td>${dto.addr}</td>
			<td>${dto.phone}</td>
		</tr>
	</table>
</body>
</html>