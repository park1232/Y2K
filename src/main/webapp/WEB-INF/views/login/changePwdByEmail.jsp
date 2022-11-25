<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" href="../css/SearchPwd.css">
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
      
          <input type="text" class="textBox" id="newPwd" placeholder="Enter your new Password" required/><br><br><br>
          <input type="text" class="textBox" id="checkNewPwd" placeholder="Re-enter Password" required/><br><br><br>
          <button class="custom-btn btn-14" id="changeNewPwd" onclick="checkPwd();">변경</button>
        
    </div>

    <script>
       
     

    </script>
    
    
  </div>
   <script src="../js/ChangePwdByEmail.js"></script> 
   <script>
   

   

   const em=()=>{
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
       c.style.transform="translateY(-600px)";
       c.style.transition="2s";

   }

  






   </script>
</body>
</html>