<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>web study</title>
</head>
<body>
<h1>#로그인 해주세요!</h1>

<form action="Login" method="post">
    #아이디 : <input type="text" name="id"> <br>
    #비밀번호 : <input type="text" name="password"><br>
    <button type = "submit">확인</button>
</form>

</body>
</html>