<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

    #editBox{
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
</style>
</head>
<body>
	<div id="edit-form">
    <form action="/edit-nickname.lo" method="post">
		<h3>처음이신가요 ? 이용하시려면 닉네임을 지정해주세요!</h3>
        <input type="text" name="nickname" id="editBox"/>
    
        <button id="editBtn">입력</button>
	</form>
</div>

</body>

<script>
window.resizeTo(200,200); // 지정한 크기로 변한다.(가로,세로)
</script>
</html>