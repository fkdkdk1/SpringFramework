<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h1>LIST</h1>

	<table border="1">
		<colgroup>
			<col width="50"/>
			<col width="100"/>
			<col width="300"/>
			<col width="100"/>
		</colgroup>
		<thead>
			<tr>
				<th>DEPTNO</th>
				<th>COMM</th>
				<th>SAL</th>
				<th>HIREDATE</th>
				<th>MGR</th>
				<th>JOB</th>
				<th>ENAME</th>
				<th>EMPNO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.deptno }</td>
					<td>${dto.comm }</td>
					<td>${dto.sal }</td>
					<td>${dto.hiredate }</td>
					<td>${dto.mgr }</td>
					<td>${dto.job }</td>
					<td>${dto.ename }</td>
					<td>${dto.empno }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>