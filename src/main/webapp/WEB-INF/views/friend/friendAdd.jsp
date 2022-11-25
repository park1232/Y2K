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
			<form class="needs-validation" method="POST" id="friendAdd2"> 
				<c:forEach items="${ mList }" var="m">
					<hr>
					   <div class="send" >
					   		보낸이 : ${ m.nickName } &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; ${ now }
					     	<hr>
					   </div>
					   
					   <br>
					   <input type="hidden" value='${ m.userNo }' name="userNo" id="userNo">
					   <div style="width:150px; height:150px; float:left;">
					      <img src="${contextPath}/resources/img/profil1.jpg" style="height: 150px;">
					   </div>
					   
					   <div style="width:190px; height:150px; float:left; text-align:center;">
					      <br><br><input type="text" class="form-control" id="nickName" name="nickName" required><label id="nickNameCheckResult"></label>
					      <div>님께<br> <strong>일촌맺기</strong>를 희망합니다.</div>
					   </div>
					   
					   <br><br><br><br><br><br><br><hr>
					   <div>
					      <input type="text" Placeholder="일촌 신청 문구 입력" style="width:430px; height:100px;" id="friendContent" name="friendContent" required>
					   </div>
					   
					   <br>
					   
					   <div class="textarea" style="text-align:center;">
					   		상대방이 동의하시면 일촌이 맺어집니다.
					   </div>
					   
					   <div class="buttonGroup">			   
						   <br>			    
						   <button type="submit" class="button" id="submit">보내기</button>
						   <button type="submit" class="button" onClick='window.close()'>취소</button>
					   </div>
				</c:forEach>
			</form>
		</div>
	</div>
</div>
   
<script>

	window.onload = () => {
		
	    document.getElementById("nickName").addEventListener('change', function(){
			const nickNameResult = document.getElementById('nickNameCheckResult');
			if(this.value.trim() == '') {
				nickNameResult.innerText = ' ';
				nickNameResult.style.color = 'black';
			} else {
				$.ajax({ // ajax 필수 url, data , type을 따로 지정안하면 get방식으로 넘어감 success나 error는 확인할 수 있게 항상 console.log를 찍어보는 습관
					url: '${contextPath}/checkNickName.fr',
					data: {nickName:this.value},
					success: (data)=>{
						console.log(data);
						if(data.trim() == 'O'){
							nickNameResult.innerText = 'O';
							nickNameResult.style.color = 'green';
						} else if(data.trim() == 'X') {
							nickNameResult.innerText = "X";
							nickNameResult.style.color = 'red';
						}
					},
					error: (data)=>{
						console.log(data);
					}
				});
			}
		}); 
	    
	    const friendAddForm = document.getElementById('friendAdd2');
    	document.getElementById("submit").addEventListener('click', ()=>{
    		friendAddForm.action = '${contextPath}/friendAdd2.fr';
    		friendAddForm.submit();
    	});
	}
</script>
</body>
</html>