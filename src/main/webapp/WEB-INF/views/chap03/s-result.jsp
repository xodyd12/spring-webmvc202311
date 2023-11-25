<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>web study</title>
</head>
<body>
<p>ID : ${id}</p>
<p>password : ${password}</p>
<p>${LoginResult}</p>
<a href="/Login/inputLogin">로그 아웃 후 다시 입력하기</a>


</body>
</html>