<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
  <script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
	
    body{
        background-color: yellow;
    }
    #edit-form{
        display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
    }

    .editBox{
        border:2px solid black;
        border-radius: 10px;
        width: 200px;
        height: 30px;
     }

     #editBtn{
        border:2px solid black;
        border-radius: 10px;
        background-color: aliceblue;
        height: 39px;
     }

     #editBtn:hover{
        background-color: black;
        color: white;
     }
     
         .checkbox{
        float: left;
        font-size: 12px;
        color : red;
      }
</style>
</head>
<body>
	<div id="edit-form">
    <div>
    <form action="/edit-nickname.lo" method="post" id="nicknameform">
		<h3>처음이신가요 ? 이용하시려면 닉네임을 지정해주세요!</h3>
        <input type="text" name="nickname" class="editBox"  id="nickname-box" onblur="nicknameBlurText();" required/>
    	
		<input type="hidden" id="checkNicknameResult"/>
        <button id="editBtn">입력</button>
	</form>
	<div id="checkNickname" class="checkbox"></div>
	</div>
	
</div>


</body>

<script>
window.resizeTo(200,200); // 지정한 크기로 변한다.(가로,세로)

$("#nickname-box").keyup(function(){
	let checkNicknameResult = $("#checkNicknameResult").val();	
		
	let params={
			  inputNickname : $("#nickname-box").val()
	  } 
	  $.ajax({
		  type:"GET",
		  url:"/check-nickname.lo",
		  data : params,
	/* 	  contentType : "application/text; charset:UTF-8", */
		  success:function(res){			  
			  console.log(res);
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
	 checkNicknameDiv.innerHTML = '닉네임은 최소 2글자 이상이어야 합니다.';
	 checkNicknameDiv.style.color = 'red';
	 document.getElementById('checkNicknameResult').value = "fail";
}


const nicknameSuccessText = () => {
	 let checkNicknameDiv = document.getElementById('checkNickname');
	 checkNicknameDiv.innerHTML = '사용가능합니다.';
	 checkNicknameDiv.style.color = 'green';
	 document.getElementById('checkNicknameResult').value = "success";
}

const nicknameFailText = () => {
	 let checkNicknameDiv = document.getElementById('checkNickname');
	 checkNicknameDiv.innerHTML = '중복된 닉네임 입니다.';
	 checkNicknameDiv.style.color = 'red';
	 document.getElementById('checkNicknameResult').value = "fail";
}

const nicknameBlurText = () => {
	 let checkNicknameDiv = document.getElementById('checkNickname');
	 checkNicknameDiv.innerHTML = '&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp';
	 
}

$("#nicknameform").submit(function(){
	
	if($("#checkNicknameResult").val()=="fail"){
		alert("닉네임 확인 바랍니다.");
		return false;
	}
	return true;
});

</script>
</html>