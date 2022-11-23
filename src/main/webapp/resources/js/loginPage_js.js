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
	window.location.href="https://accounts.google.com/o/oauth2/v2/auth?client_id=448059245884-n0hf7sgq082enol9ag329m8g7il0qmtu.apps.googleusercontent.com&redirect_uri=http://localhost:8080/google.lo&response_type=code&scope=https://www.googleapis.com/auth/userinfo.email"
}

const naver = () =>{
	console.log('실행됨');
	window.location.href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=uW6r_E14UIndVKWQMfWp&state=STATE_STRING&redirect_uri=http://localhost:8080/naver.lo"
}

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

