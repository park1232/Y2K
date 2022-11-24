let container = document.getElementById('container')

toggle = () => {
  container.classList.toggle('sign-in')
  container.classList.toggle('sign-up')
}

setTimeout(() => {
  container.classList.add('sign-in')
}, 200)

const e = document.getElementById('enterBtn');

const kakao = () =>{
	console.log('실행됨');
	window.location.href="https://kauth.kakao.com/oauth/authorize?client_id=505e36c739260bba34b117ded3d8b963&redirect_uri=http://localhost:8080/kakao.lo&response_type=code"
}

const google = () =>{
	console.log('실행됨');
	window.location.href="https://accounts.google.com/o/oauth2/v2/auth?scope=https%3A//www.googleapis.com/auth/drive.metadata.readonly&access_type=offline&include_granted_scopes=true&response_type=code&state=STATE_STRING&redirect_uri=http://localhost:8080/google.lo&client_id=250224335070-67ol1mh21l40c1cq7pb8p471o7v9sg9s.apps.googleusercontent.com"
}

const naver = () =>{
	console.log('실행됨');
	window.location.href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=uW6r_E14UIndVKWQMfWp&state=STATE_STRING&redirect_uri=http://localhost:8080/naver.lo"
}

const facebook = () =>{
	console.log('실행됨');
	window.location.href="http://www.facebook.com/v15.0/dialog/oauth?client_id=641158651025103&redirect_uri=http://localhost:8080/httpsfacebook.lo&state=STATE_STRING"
}


$("#id-box").keyup(function(){
	let checkIdResult = $("#checkIdResult").val();	
		
	let params={
			  inputId : $("#id-box").val()
	  } 
	  $.ajax({
		  type:"GET",
		  url:"/check-id.lo",
		  data : params,
		  success:function(res){			  
			  if($("#id-box").val().length>4){
				  if(res===0){
				  idSuccessText();
				} else if(res ===1){
					idFailText();
					 console.log(checkIdResult);
				}
			 } else{
				 isIdVaildText();
			 }
		  }
	  })
}); 

const isIdVaildText = () =>{
	 let checkIdDiv = document.getElementById('checkId');
	 checkIdDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp아이디는 최소 4글자 이상이어야 합니다.';
	 checkIdDiv.style.color = 'red';
	 document.getElementById('checkIdResult').value = "fail";
}


const idSuccessText = () => {
	 let checkIdDiv = document.getElementById('checkId');
	 checkIdDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp사용가능합니다.';
	 checkIdDiv.style.color = 'green';
	 document.getElementById('checkIdResult').value = "success";
}

const idFailText = () => {
	 let checkIdDiv = document.getElementById('checkId');
	 checkIdDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp중복된 아이디 입니다.';
	 checkIdDiv.style.color = 'red';
	 document.getElementById('checkIdResult').value = "fail";
}

const idBlurText = () => {
	 let checkIdDiv = document.getElementById('checkId');
	 checkIdDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
	 
}
/* 
$("#id-box").keyup(function(){
	isValidPassword();
}); */

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
		 checkPasswordResult.innerHTML= '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp8자리~20자리 이내로 입력하세요';
		 checkPasswordResult.style.color='red';
		 document.getElementById('checkPasswordResult').value = "fail";
	 }
	 else if(pw.search(/\s/) != -1){
		 console.log(2);
		 checkPasswordResult.innerHTML= '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp공백은 허용되지 않습니다.';
		 checkPasswordResult.style.color='red';
		 document.getElementById('checkPasswordResult').value = "fail";
	 }
	 else if(num < 0 || eng < 0 || spe < 0 ){
		 console.log(3);
		 checkPasswordResult.innerHTML= '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp영문,숫자,특수문자를 혼합하여 입력해주세요.';
		 checkPasswordResult.style.color='red';
		 document.getElementById('checkPasswordResult').value = "fail";
	 }
	 else{
	 checkPasswordResult.innerHTML= '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp올바른 비밀번호 형식입니다.';
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
		checkRePw.innerHTML="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp일치합니다.";
		checkRePw.style.color = "green";
		document.getElementById('checkRePasswordResult').value = "success";
	} else {
		checkRePw.innerHTML="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp일치하지 않습니다.";
		checkRePw.style.color = "red";
		document.getElementById('checkRePasswordResult').value = "fail";
	}
}

const rePasswordBlurText = () => {
	let checkRePw = document.getElementById('checkRePw');
	checkRePw.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
}


$("#nickname-box").keyup(function(){
	let checkNicknameResult = $("#checkNicknameResult").val();	
		
	let params={
			  inputNickname : $("#nickname-box").val()
	  } 
	  $.ajax({
		  type:"GET",
		  url:"/check-nickname.lo",
		  data : params,
		  success:function(res){			  
			  if($("#nickname-box").val().length>1){
				  if(res===0){
				  nicknameSuccessText();
				} else if(res ===1){
					nicknameFailText();
				}
			 } else{
				 isNicknameVaildText();
			 }
		  }
	  })
}); 

const isNicknameVaildText = () =>{
	 let checkNicknameDiv = document.getElementById('checkNickname');
	 checkNicknameDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp닉네임은 최소 2글자 이상이어야 합니다.';
	 checkNicknameDiv.style.color = 'red';
	 document.getElementById('checkNicknameResult').value = "fail";
}


const nicknameSuccessText = () => {
	 let checkNicknameDiv = document.getElementById('checkNickname');
	 checkNicknameDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp사용가능합니다.';
	 checkNicknameDiv.style.color = 'green';
	 document.getElementById('checkNicknameResult').value = "success";
}

const nicknameFailText = () => {
	 let checkNicknameDiv = document.getElementById('checkNickname');
	 checkNicknameDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp중복된 닉네임 입니다.';
	 checkNicknameDiv.style.color = 'red';
	 document.getElementById('checkNicknameResult').value = "fail";
}

const nicknameBlurText = () => {
	 let checkNicknameDiv = document.getElementById('checkNickname');
	 checkNicknameDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
	 
}







$("#signupform").submit(function(){
	
	if($("#checkIdResult").val()=="fail"){
		alert("아이디 확인 바랍니다.");
		return false;
	}
	
	if($("#checkPasswordResult").val()=="fail"){
		alert("비밀번호를 형식에 맞게 작성해주세요.");
		return false;
	}
	
	if($("#checkRePasswordResult").val()=="fail"){
		alert("비밀번호가 일치하지 않습니다.")
		return false;
	}
	
	if($("#checkNicknameResult").val()=="fail"){
		alert("닉네임 확인 바랍니다.");
		return false;
	}
	return true;
});


/*
*$('#loginBtn').click(function(){
*  window.open('test3.html','tistory','width=1289, height=703, scrollbars=no, resizable=no, toolbars=no, menubar=no');
*  window.close();
*
*  
*});
*/

/*
*window.onload = function(){
* 
*	window.open('/mainPage.ma','Y2K','width=1289, height=703, scrollbars=no, resizable=no, toolbars=no, menubar=no');
*  window.close();
*  opener.close();
*
 * 
*};
*/

