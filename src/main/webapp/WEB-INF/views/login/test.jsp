<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.nickName}</h1>
${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.nickName}

<h1>ㅁㄴㅇㄹㄴㅁㅇㄹㄴㅇㅁㄹㄴㅇㅁㄹ</h1>
</body>
</html>