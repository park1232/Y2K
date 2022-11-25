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

