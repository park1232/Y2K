<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/friendAdd.css" />
<style>

</style>

</head>
<body>
<div class="main">
	<div id="solid">
	<div id="header">
	   		<h2>일촌 신청</h2>   
	</div>
		<div id="area">
		<hr>
		   <div class="send">
		      보낸이 : <a href="#">박규민</a> (2022.11.07)
		     <hr>
		   </div>
		   <br>
		   <div style="width:150px; height:150px; float:left;">
		      <img src="${contextPath}/resources/img/profil1.jpg" style="height: 150px;">
		   </div>
		   <div style="width:190px; height:150px; float:left; text-align:center;">
		      <br><br><a href="#">박규민</a>님께<br> <strong>일촌맺기</strong>를 희망합니다.
		   </div>
		   <br><br><br><br><br><br><br><hr>
		   <div>
		      <input type="text" Placeholder="일촌 신청 문구 입력" style="width:430px; height:100px;">
		   </div>
		   <br>
		   <div class="textarea" style="text-align:center;">
		   상대방이 동의하시면 일촌이 맺어집니다.
		   </div>
		   <div class="buttonGroup">
		   <br> 
		   <button type="submit" class="button" id="submit" onclick="submit()">보내기</button>
		   <button type="submit" class="button" onclick="close1()">취소</button>
		   </div>
		</div>
	</div>
</div>
   
<script>
    function submit(){
        alert("친구 신청이 완료되었습니다.")
        close();
    }
    function close1(){
       close();
    }
</script>
</body>
</html>