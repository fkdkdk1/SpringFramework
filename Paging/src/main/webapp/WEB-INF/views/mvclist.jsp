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
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty list }">
					<tr>
						<td colspan="4" align="center">-----작성된 글이 없습니다-----</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="dto">
						<tr>
							<td>${dto.myno }</td>
							<td>${dto.myname }</td> 
							<td><a href="detail.do?myno=${dto.myno }">${dto.mytitle }</a></td>
							<td>${dto.mydate }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="글작성" onclick="location.href='insertform.do'"/>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<!-- 페이지 그룹이 1번이 아닐 시 < 생김  -->
					<c:if test="${page.pagegroup != 1 }">
						<a href="list.do?page=${page.pagescale*((page.pagegroup-1)-1)+1}">&lt;</a>
					</c:if>
					<c:forEach begin="${page.startpage}" end ="${page.endpage > page.totalpage? page.totalpage : page.endpage}" var = "pageNum">
						<a href="list.do?page=${pageNum}">${pageNum}</a>
					</c:forEach>
					<!-- 전체 페이지 수가 끝 페이지 보다 작으면 '>' 추가  --> 
					<c:if test="${page.totalpage > page.endpage}">
						<a href="list.do?page=${page.endpage + 1}">&gt;</a>
					</c:if>
				</td> 
			</tr> 
		</tfoot>
	</table>


</body>
</html>