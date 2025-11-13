<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css"/>
</head>
<body>
	<h1>책 목록 페이지</h1>
	<a href="/mvc">메인 화면으로</a>&nbsp;&nbsp;&nbsp;
	<a href="/mvc/books/regist">등록하기</a><br>
	<table>
		<thead>
			<tr>
				<th>고유번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
				<tr>
					<td>${book.id }</td>
					<td><a href="/mvc/books/detail?id=${book.id }">${book.title }</a></td>
					<td>${book.author }</td>
					<td>${book.price }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>