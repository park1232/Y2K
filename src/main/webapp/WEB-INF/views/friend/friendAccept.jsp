<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	<form class="needs-validation" method="POST" id="acceptForm">
		<div id="area">
		<hr>
		<c:forEach items="${ mList }" var="m">
		<c:forEach items="${ fList }" var="f">
		   <div class="send">
		      보낸이 : ${ m.nickName }<a href="#"></a> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${ f.createDate }
		     <hr>
		   </div>
		   <br>
		   <div style="width:150px; height:150px; float:left;">
		      <img src="${m.path }" style="height: 150px;">
		   </div>
		   <div style="width:190px; height:150px; float:left; text-align:center;">
		      <br><a href="#">${ m.nickName }</a>님이 <p>${loginUserNickName}님에게</p> <strong>일촌맺기</strong>를 희망합니다.
		   </div>
		   <br><br><br><br><br><br><br><hr>
		   <input type="hidden" value='${ m.userNo }' name="userNo" id="userNo">
		   <div>
		      <input type="text" Placeholder="${ f.friendContent }" style="width:430px; height:100px;" readonly>
		   </div>
		   <br>
		   <div class="textarea" style="text-align:center;">
		   박규민님이 동의하시면 일촌이 맺어집니다.
		   </div>
		   <div class="buttonGroup">
		   <br> 
		   <button type="button" class="button" id="accept">수락하기</button>
		   <button type="button" class="button" onClick='window.close()'>취소</button>
		   </div>
		 </c:forEach>
		 </c:forEach>
		</div>
	</form>
	</div>
</div>
   
<script>
		/* const acceptForm = document.getElementById('acceptForm');
	    document.getElementById("accept").addEventListener('click', ()=>{
	    	console.log(acceptForm);
	    	acceptForm.action = '${contextPath}/acceptFriend.fr';
	    	acceptForm.submit();
	    	
		});
	    
	    console.log('${result}');
	    const result = '${result}';
	    if(result === 1){
	    	window.close();
	    } */
	    
	    $("#accept").click(function(){
	    	let params={
	    			userNo : $("#userNo").val(),		
	    	}
	    	 
	    	 $.ajax({
	    		 type:"POST",
	    		 url:"/acceptFriend.fr",
	    		 data:params,
	    		 success:function(res){
	    			 console.log("통신성공");
	    			 window.close();
	    		 }
	    	 });
	    }); 
</script>
</body>
</html>