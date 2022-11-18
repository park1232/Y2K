let container = document.getElementById('container')

toggle = () => {
  container.classList.toggle('sign-in')
  container.classList.toggle('sign-up')
}

setTimeout(() => {
  container.classList.add('sign-in')
}, 200)

const e = document.getElementById('enterBtn');

/*
*$('#loginBtn').click(function(){
*  window.open('test3.html','tistory','width=1289, height=703, scrollbars=no, resizable=no, toolbars=no, menubar=no');
*  window.close();
*
*  
*});
*/
