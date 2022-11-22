<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="POST" id="frm">
		<input type="hidden" id="a" name="username" value="${username}"/>
		<input type="hidden" id="b" name="password" value="${password}"/>
	</form>


</body>

<script type="text/javascript">
	$(document).ready(function(){
		console.log(document.getElementById('a').value);
		console.log(document.getElementById('b').value);
		console.log("실행됨됨");
		document.getElementById('frm').submit();
	});
	
</script>
</html>