<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
    .custom-btn {
    width: 130px;
    height: 40px;
    color: #fff;
    border-radius: 5px;
    padding: 10px 25px;
    font-family: 'Lato', sans-serif;
    font-weight: 500;
    background: transparent;
    cursor: pointer;
    transition: all 0.3s ease;
    position: relative;
    display: inline-block;
     box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
     7px 7px 20px 0px rgba(0,0,0,.1),
     4px 4px 5px 0px rgba(0,0,0,.1);
    outline: none;
  }
  
    .textBox{
      width:300px;
      height:50px;
      border-color: bisque;
      border-top: none;
      border-left: none;
      border-right: none;
      
      
    }
    #total-form{
      overflow: hidden;
    }
  
    #input-form{
      /* text-align: center; */
      margin: auto; 
      transition-duration: 10s;
      overflow: hidden;
    }
    .btn-14 {
    background: rgb(255,151,0);
    border: none;
    z-index: 1;
  }
  .btn-14:after {
    position: absolute;
    content: "";
    width: 100%;
    height: 0;
    top: 0;
    left: 0;
    z-index: -1;
    border-radius: 5px;
    background-color: #eaf818;
    background-image: linear-gradient(315deg, #eaf818 0%, #f6fc9c 74%);
     box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5)
     7px 7px 20px 0px rgba(0,0,0,.1),
     4px 4px 5px 0px rgba(0,0,0,.1);
    transition: all 0.3s ease;
  }
  .btn-14:hover {
    color: #000;
  }
  .btn-14:hover:after {
    top: auto;
    bottom: 0;
    height: 100%;
  }
  .btn-14:active {
    top: 2px;
  }
  #result{
    /* text-align: center; */
    transition: all 2s ease;
    margin-top: 800px;
    overflow-y: hidden;
    position: absolute;
  
  }
  
  #total-form{
    height: 420px;
    position: absolute;
  }
  
   .checkbox{
        float: left;
        font-size: 12px;
        color : red;
      }
   
    </style>
</head>
<body>
  <div id="total-form">
   
    <div id="email-form"> 
      <h2>이메일로 비밀번호 찾기</h2>
        <input type="hidden" id="checkDB" value=""/>
        <input type="text" id="userId" class="textBox" placeholder="Your Id" required/><br><br><br> 
        <input type="text" id="userEmail" class="textBox" placeholder="Your Email Address" required/><br><br><br>
       
        <button class="custom-btn btn-14" id="checkEmailButton" >입력</button>
        <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    </div>
    <div id="email-check">
      <h2>인증코드 확인</h2>
      <input type="hidden" id="randomNumber"/>
      <input type="text" id="certificationEmailCode" class="textBox" placeholder="인증코드" required/><br><br><br>
      <input type="hidden" id="checkCertificationEmailCode"/>
      <button class="custom-btn btn-14" id="checkCode" onclick="checkCertificationEmailCode();">입력</button>
    </div>
    

    <div id="changeByEmail">
        <br>
        <br>
        <br>
        <h2>새로운 비밀번호</h2>
      <form action="${contextPath}/new-password.lo" method="POST" id="passwordForm">
          <div>
          <input type="password" name="password" class="textBox" id="password-box" placeholder="Enter your new Password"  onblur=" passwordBlurText();" onkeyup="isValidPassword();" required/><br><br><br>
          <div id="checkPw" class="checkbox"></div>
          <input type="hidden" id="username" name="username"/>
          </div>
          <input type="hidden" id="checkPasswordResult"/>
          <div>
          <input type="password" class="textBox" id="check-password-box" placeholder="Re-enter Password"  onkeyup="isValidCheckPassword();" onblur="rePasswordBlurText();" required/><br><br><br>
          <div id="checkRePw" class="checkbox"></div>
          <br>
          </div>
          <input type="hidden" id="checkRePasswordResult"/>
          <input type="hidden" id="username"/>
          <div>
          <div>
          <button class="custom-btn btn-14" id="changeNewPwd" >변경</button>
          </div>
          </div>
        </form>
    </div>

    <script>
       
     

    </script>
    
    
  </div>
   <script>
	let authCode = '';   
/*    let userIdd = document.getElementById('username'); */
   
   $('#checkEmailButton').click(function(){
	   let params={
				username : $("#userId").val(),
				email : $("#userEmail").val()
		}
		$.ajax({
			type:"POST",
			url:"/check-email.lo",
			data:params,
			success:function(res){
 				console.log('실행됨');
				let result = res.result;
				if(result == 'Not User'){
 					alert('등록되지 않은 아이디입니다.');
 					console.log(result);
 				} else if(result == 'Not Matching Email'){
 					alert('등록된 이메일과 일치하지 않습니다.');
 					console.log(result);
 				}  else if(result == 'success'){
 					alert('이메일에 인증코드를 전송했습니다.');
 					authCode = res.authCode;
 					em();
 				}
				
			}
		})
	});
   
   const checkCertificationEmailCode = () =>{
	   let inputAuthCode = document.getElementById('certificationEmailCode').value;
	   if(inputAuthCode == authCode){
		   dm();
	   } else {
		   alert('코드가 일치하지 않습니다.');
	   }
   }
   
   
   
	
   const em=()=>{
      console.log('em 실행됨');
      var e = document.getElementById('email-form');
       var c = document.getElementById('email-check');
       e.style.transform="translateY(-1000px)";
       e.style.transition="2s";
       c.style.transform="translateY(-400px)";
       c.style.transition="2s";
       
   }

   const dm=()=>{
   	var e = document.getElementById('email-check');
       var c = document.getElementById('changeByEmail');
       e.style.transform="translateY(-1000px)";
       e.style.transition="2s";
       c.style.transform="translateY(-700px)";
       c.style.transition="2s";

   }
   

   const isValidPassword = () =>{
   	let inputPassword = document.getElementById('password-box').value;
   	console.log(inputPassword);
   	let checkPasswordResult = document.getElementById('checkPw');
   	 var pw = inputPassword;
   	 console.log("pw : " + pw);
   	 var num = pw.search(/[0-9]/g);
   	 var eng = pw.search(/[a-z]/ig);
   	 var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
   	 if(pw.length < 8 || pw.length > 20){
   		 console.log(1);
   		 checkPasswordResult.innerHTML= '8자리~20자리 이내로 입력하세요';
   		 checkPasswordResult.style.color='red';
   		 document.getElementById('checkPasswordResult').value = "fail";
   	 }
   	 else if(pw.search(/\s/) != -1){
   		 console.log(2);
   		 checkPasswordResult.innerHTML= '공백은 허용되지 않습니다.';
   		 checkPasswordResult.style.color='red';
   		 document.getElementById('checkPasswordResult').value = "fail";
   	 }
   	 else if(num < 0 || eng < 0 || spe < 0 ){
   		 console.log(3);
   		 checkPasswordResult.innerHTML= '영문,숫자,특수문자를 혼합하여 입력해주세요.';
   		 checkPasswordResult.style.color='red';
   		 document.getElementById('checkPasswordResult').value = "fail";
   	 }
   	 else{
   	 checkPasswordResult.innerHTML= '올바른 비밀번호 형식입니다.';
   		 checkPasswordResult.style.color='green';
   		 document.getElementById('checkPasswordResult').value = "success";
   	 }
   	
   }

   const passwordBlurText = () => {
   	 let checkPasswordResult = document.getElementById('checkPw');
   	 checkPasswordResult.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
   	 
   }



   const isValidCheckPassword = () =>{
   	let checkRePassword = document.getElementById('check-password-box').value;
   	let checkPassword = document.getElementById('password-box').value;
   	let checkRePw = document.getElementById('checkRePw');

   	if(checkRePassword == checkPassword){
   		checkRePw.innerHTML="일치합니다.";
   		checkRePw.style.color = "green";
   		document.getElementById('checkRePasswordResult').value = "success";
   	} else {
   		checkRePw.innerHTML="일치하지 않습니다.";
   		checkRePw.style.color = "red";
   		document.getElementById('checkRePasswordResult').value = "fail";
   	}
   }

   const rePasswordBlurText = () => {
   	let checkRePw = document.getElementById('checkRePw');
   	checkRePw.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
   }

  
   $("#passwordForm").submit(function(){
	   document.getElementById('username').value=document.getElementById('userId').value;
		if($("#checkPasswordResult").val()=="fail"){
			alert("비밀번호를 형식에 맞게 작성해주세요.");
			return false;
		}
		
		if($("#checkRePasswordResult").val()=="fail"){
			alert("비밀번호가 일치하지 않습니다.")
			return false;
		}
		alert('변경되었습니다. 다시 로그인 해주세요.');
		
		 window.open('/','Y2K');
  
		return true;
	});





   </script>
</body>
</html>