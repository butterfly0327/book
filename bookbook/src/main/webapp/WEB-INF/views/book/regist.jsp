<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 등록</title>
</head>
<body>
	<h1>책 등록 페이지</h1>
	<form action="/mvc/books/add" method="post">
		<fieldset>
			<label>제목 <input type="text" name="title">  </label>	<br>
			<label>저자 <input type="text" name="author">  </label><br>
			<label>가격 <input type="number" name="price">  </label><br>
			<label>설명 <input type="text" name="description">  </label><br>
			<input type="submit" value="등록">
			<br>
		</fieldset>
	</form>
</body>
</html>