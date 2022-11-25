<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> --%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html lang="kor">
<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/loginPage_css.css" />
    <script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	  .checkbox{
        float: left;
        font-size: 12px;
        color : red;
      }
      
       #emailAuth{
      	/* float:left; */
        color: darkgoldenrod;
        font-size : 10px;
        border: 1px solid wheat;
        border-radius: 10px;
      	
      }
      
      #emailAuth:hover{
      	font-weight: bold;
      	 border: 3px solid wheat;
      }
    	
</style>
</head>
<body>




    <div id="container" class="container">
        <!-- FORM SECTION -->
        <div class="row">
          <!-- SIGN UP -->
          <div class="col align-items-center flex-col sign-up">
            <div class="form-wrapper align-items-center">
              <div class="form sign-up">
              <form action="${contextPath}/register.lo" method="POST"  id="signupform" >
                <div class="input-group">
               
	                  <i class='bx bxs-user'></i>
	                  <input type="text"  name="username" placeholder="Enter your new ID" onblur="idBlurText();" id="id-box"  minlengh="4" required>
	                  <div id="checkId" class="checkbox"></div>
	                  <input type="hidden" id="checkIdResult" value="none"/>
	                   
	                </div>
	                <div class="input-group">
	                  <i class='bx bxs-lock-alt'></i>
	                  <input type="password"  name="password" placeholder="Enter your new Password" id="password-box" onblur=" passwordBlurText();" onkeyup="isValidPassword();" required>
					  <div id="checkPw" class="checkbox"></div>
					  <input type="hidden" id="checkPasswordResult"/>
	                </div>
	                <div class="input-group">
	                    <i class='bx bxs-lock-alt'></i>
	                    <input type="password" placeholder="Re-enter Password" id="check-password-box" onkeyup="isValidCheckPassword();" onblur="rePasswordBlurText();" required>
						<div id="checkRePw" class="checkbox"></div>
						<input type="hidden" id="checkRePasswordResult"/>
	                  </div>
	                <div class="input-group">
	                    <i class='bx bx-mail-send'></i>
	                    <input type="text" name="nickName" placeholder="Enter your new NickName" id="nickname-box" onblur="nicknameBlurText();" required>
	                    <div id="checkNickname" class="checkbox"></div>
	                    <input type="hidden" id="checkNicknameResult"/>
	                  </div>
	                  <div class="input-group">
	                    <i class='bx bx-mail-send'></i>
	                    <div>
	                    <input type="text" name="email" placeholder="Enter your Email" id="email-box" onkeyup="isVaildEmail();" onblur="emailBlurText();"  required>
	                    
	                    <div id="checkEmail" class="checkbox"></div>
	                    <input type="hidden" id="emailAuthCode" />
	                    <input type="hidden" id="checkEmailResult"/>
	                    <div>
	                    	
	                    </div>
	                    </div>
	                  </div>
	                  <a id="emailAuth">이메일로 코드값 전송</a>
	                  <br>
	                  <br>
	                  <div class="input-group" id="auth-div">
	                    <i class='bx bx-mail-send'></i>
	                    <input type="text" name="checkEmailAuth" placeholder="Enter EmailAuth Code" id="auth-box" onkeyup="isValidAuthCode();" onblur="authBlurText();" required>
	                    <div id="checkAuth" class="checkbox"></div>
	                    <input type="hidden" id="checkAuthResult"/>
	                  </div>
	                
	     
	                <button>
	                  Sign up
	                </button>
                </form>
                <p>
                  <span>
                    이미 계정이 있으신가요?
                  </span>
                  <b onclick="toggle()" class="pointer">
                    로그인하기
                  </b>
               
                </p>
              </div>
            </div>
          
          </div>
          <!-- END SIGN UP -->
          <!-- SIGN IN -->
          <div class="col align-items-center flex-col sign-in" >
            <div class="form-wrapper align-items-center" id="loginForm">
              <div class="form sign-in">
                <form action="/login" method="POST">
	                <div class="input-group">
	                  <i class='bx bxs-user'></i>
	                  <input type="text" name="username" placeholder="Your Id">
	                </div>
	                <div class="input-group">
	                  <i class='bx bxs-lock-alt'></i>
	                  <input type="password" name="password" placeholder="Your Password">
	                </div>
                <button id="loginBtn" >
                  Login
                </button>
                <input type="hidden" name="type" vlaue="local"/>
                </form>
                <br>
         		<button class="Kakao" onclick="kakao();">Kakao</button>
         		<br>
         		<button class="Kakao" onclick="naver();">Naver</button>
         		<br>
         		<div class="g-signin2" data-onsuccess="onSignIn"></div>

                <p>
                  <b>
                  </b>
                </p>
                <p>
                  <span>
                    회원이 아니신가요?
                  </span>
                  <b onclick="toggle()" class="pointer">
                    회원가입하기
                  </b>
                  <br>
                  <br>
                  <br>
                  <span>
                    아이디를 잊으셨나요?
                  </span>
                  <b class="pointer">
                    아이디 찾기
                  </b>
                  <br>
                  <br>
                  <br>
                   <span>
                    비밀번호를 잊으셨나요?
                  </span>
                  <b class="pointer" >
                    <a id="lookPwd">비밀번호 찾기</a>
                  </b>
                </p>
              </div>
            </div>
            
            
           
           </div> 

          
          <!-- </div> -->
          <!--  -->
          <!-- END SIGN IN -->
          
        </div>
        
        <!-- END FORM SECTION -->
        <!-- CONTENT SECTION -->
        <div class="row content-row">
          <!-- SIGN IN CONTENT -->
          <div class="col align-items-center flex-col">
            <div class="text sign-in">
              <h2>
                Welcome
              </h2>
      
            </div>
            <div class="img sign-in">
        
            </div>
          </div>
          <!-- END SIGN IN CONTENT -->
          <!-- SIGN UP CONTENT -->
          <div class="col align-items-center flex-col">
            <div class="img sign-up">
            
            </div>
            <div class="text sign-up">
              <h2>
                Join with us
              </h2>
      
            </div>
          </div>
          <!-- END SIGN UP CONTENT -->
        </div>
        <!-- END CONTENT SECTION -->
        
      </div>

      <div id="r1">
        <a href="#" data-text="button" id="hrefBtn">Button</a>
      </div>
</body>
<script src="${contextPath}/resources/js/loginPage_js.js"></script>

<script>

let emailAuthCode = "";
$("#auth-div").hide();

$('#lookPwd').click(function(){
	  window.open('/change-pwd.lo','lookPwd','width=600, height=500, scrollbars=no, resizable=no, toolbars=no, menubar=no');
	  window.close();	  
	});


const emailBlurText = () =>{
	document.getElementById('checkEmail').innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
}

const isVaildEmail =  () => {
	let email = document.getElementById('email-box').value;
	const exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	let checkEmail = document.getElementById('checkEmail');
		if(exptext.test(email)==false){
			checkEmail.innerHTML= '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp이메일 형식이 올바르지 않습니다.';
			checkEmail.style.color='red';
			document.getElementById('checkEmailResult').value = "fail";
		} else{
			checkEmail.innerHTML= '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp올바른 형식입니다.';
			checkEmail.style.color='green';
			document.getElementById('checkEmailResult').value = "success";
		}
}


$('#emailAuth').click(function(){
	
	var params={
			email : $("#email-box").val(),
	}
	$.ajax({
		type:"POST",
		url:"/email-auth.lo",
		data:params,
		success:function(res){
			alert('이메일에 코드를 전송하였습니다.');
			emailAuthCode = res.authCode;
			showEmailAuthDiv();
		}
	});
});

const showEmailAuthDiv = () => {
	$("#auth-div").show();
}

const isValidAuthCode = () => {
	let authCode = document.getElementById('auth-box').value;
	let checkAuth = document.getElementById('checkAuth');
	if(emailAuthCode != authCode){
		checkAuth.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp코드가 일치하지 않습니다.';
		checkAuth.style.color = 'red';
		document.getElementById('checkAuthResult').value = "fail";
	} else {
		checkAuth.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp코드가 일치 합니다.';
		checkAuth.style.color = 'green';
		document.getElementById('checkAuthResult').value = "success";
	}
}

const authBlurText = () =>{
	document.getElementById('checkAuth').innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
}

</script>



</html>