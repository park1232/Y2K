<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/mypage.css" />
    <title>Document</title>
    <script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
    <style>
    @import url(https://fonts.googleapis.com/css?family=Roboto+Slab:400,700);
html {
  height: 100%
}

body {
  font-family:'Roboto Slab', "Gill Sans", "Gill Sans MT", "Myriad Pro", "DejaVu Sans Condensed", Helvetica, Arial, sans-serif;
  background-color: #f5eeb4;
  color: #838689;
  margin: 0;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

/* Based on http://www.456bereastreet.com/archive/201105/styling_ordered_list_numbers/ */
div {
  max-width: 700px;
  margin: 0 auto;
  display: block;
}
/* #1- Larger numbers */
ol.large-numbers {
  counter-reset:li; /* Initiate a counter */
  margin-left:0; /* Remove the default left margin */
  padding-left:0; /* Remove the default left padding */
  line-height: 1.25;
}
ol.large-numbers > li {
  position:relative; /* Create a positioning context */
  list-style:none; /* Disable the normal item numbering */
  margin: 1rem 0 1rem 2rem;
  padding: 0 0 0 1rem;
}
ol.large-numbers > li:before {
  content:counter(li); /* Use the counter as content */
  counter-increment:li; /* Increment the counter by 1 */
  /* Position and style the number */
  position:absolute;
  top: -0.3em; /* move numbers up or down as needed */
  left:-0.9em;
  width: 1em;
  text-align:center;
  -moz-box-sizing:border-box;
  -webkit-box-sizing:border-box;
  box-sizing:border-box;
  font-size: 2em;
  font-weight: bold;
  font-weight: 700;
  color: #262726;
  text-shadow:
       3px 3px 0 #838689,
     -1px -1px 0 #838689,  
      1px -1px 0 #838689,
      -1px 1px 0 #838689,
       1px 1px 0 #838689;
}
ol.large-numbers li:hover:before {
  color: #EBE3AA;
}

#title_inputbox{
    height: 30px;
    border-radius: 10px;
    border:1px solid wheat;
}

#title_submit{
    height:40px;
    border-radius: 10px;
    border:1px solid wheat;
    background-color: #EBE3AA;
}

#content_inputbox{
    height: 30px;
    border-radius: 10px;
    border:1px solid wheat;
}

#content_submit{
    height:40px;
    border-radius: 10px;
    border:1px solid wheat;
    background-color: #EBE3AA;
}

#background-select{
    height:40px;
    width: 100px;
    border: 1px solid wheat;
    border-radius: 10px;
}

#update_inputbox{
    height: 30px;
    border-radius: 10px;
    border:1px solid wheat;
}

#update_submit{
    height:40px;
    border-radius: 10px;
    border:1px solid wheat;
}

#logout_submit{
	height:40px;
    border-radius: 10px;
    border:1px solid wheat;
}

#member-delete-submit{
	height:40px;
    border-radius: 10px;
    border:1px solid wheat;
}

#title-rayout{
    display: none;
    transition: 2s;
}
#profile-rayout{
    display: none;
    /* opacity: 0; */
    /* transform: scaleY(10); */
    /* transform-origin: 0px 0px; */
    /* transition: width 1s ease 0.5s, margin-top 1s ease-out 0.5s; */
}
#background-rayout{
    display: none;
}

#content-rayout{
    display: none;
}
#update-rayout{
    display: none;
}

#logout-rayout{
    display: none;
}

#member-delete-rayout{
	display: none;
}
/* 
@keyframes fade-in {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }
  
  @keyframes fade-out {
    from {
      opacity: 1;
  
    }
    to {
      opacity: 0;
    }
  }

  .appear {
    animation: fade-in 1s;
    animation-fill-mode: forwards;
    display: flex;
  }
  
  .disappear {
    animation: fade-out 1s;
    animation-fill-mode: forwards;
  } */
    </style>
</head>

<body>

    <div>
        <ol class="large-numbers">
          <li id="profile-click">프로필 사진 변경</li>
            <div id="profile-rayout">
                <a href="${contextPath}/profile-upload.my">프로필 사진 선택</a>
            </div>
            
          <li id="title-click">타이틀 제목 변경</li>
            <div id="title-rayout">
                <form action="/title-change.my">
                
                    <input type ="text" id="title_inputbox" name="inputTitle">
                    <input type="submit" id="title_submit">
                </form>
            </div>
            
             <li id="content-click">담벼락 변경</li>
            <div id="content-rayout">
                <form action="/content-change.my">            
                    <input type ="textarea" id="content_inputbox" name="inputContent" >
                    <input type="submit" id="title_submit">
                </form>
            </div>
          <li id="background-click">배경색 변경</li>
            <div id="background-rayout">
                <form action="/background-change.my">
                    <select name="skinName" id="background-select">
                        <c:forEach var="skinList" items="${ skinList}">
                        	<option value="${skinList.skinName }" >${skinList.skinKoreaName }</option>
                        </c:forEach>

                    </select>
                    <input type="submit" id="update_submit" value="변경">
                </form>

            </div>
          <li id="update-click">닉네임 수정</li>
          <div id="update-rayout">  
        <form action="edit-nickname.lo" method="post">
            <input type="text" name="nickname" id="update_inputbox">
            <input type="submit" id="update_submit" value="변경">
        </form>
        </div>
         <li id="logout-click">로그아웃</li>
          <div id="logout-rayout">  
        <form action="/logout">
            <input type="submit" id="logout_submit" value="로그아웃 하기">
        </form>
        </div>
         <li id="member-delete-click">회원탈퇴</li>
          <div id="member-delete-rayout">  
        <form action="/member-delete.lo" id="form-id">
            <button id="member-delete-submit" >회원탈퇴 하기</button>
        </form>
        </div>
        </ol>
      </div>
    
</body>

<script>   
    document.getElementById('profile-click').addEventListener("click",function(){ 
        console.log('실행');
        var profile = document.getElementById('profile-rayout');
         if(profile.style.display == 'none'){
             profile.style.display='block';
         } else {
             profile.style.display='none';
         }

       
    });
    document.getElementById('title-click').addEventListener("click",function(){ 
        var title = document.getElementById('title-rayout');
         if(title.style.display == 'none'){
             title.style.display='block';
         } else {
             title.style.display='none';
         }

       
    });
    document.getElementById('background-click').addEventListener("click",function(){ 
        var background = document.getElementById('background-rayout');
         if(background.style.display == 'none'){
            background.style.display='block';
         } else {
            background.style.display='none';
         }

       
    });
    document.getElementById('update-click').addEventListener("click",function(){ 
        var update = document.getElementById('update-rayout');
         if(update.style.display == 'none'){
             update.style.display='block';
         } else {
             update.style.display='none';
         }

       
    });
    
    document.getElementById('logout-click').addEventListener("click",function(){ 
        var logout = document.getElementById('logout-rayout');
         if(logout.style.display == 'none'){
             logout.style.display='block';
         } else {
             logout.style.display='none';
         }

       
    });
    
    document.getElementById('member-delete-click').addEventListener("click",function(){ 
        var memberDelete = document.getElementById('member-delete-rayout');
         if(memberDelete.style.display == 'none'){
        	 memberDelete.style.display='block';
         } else {
        	 memberDelete.style.display='none';
         }

       
    });
    
    document.getElementById('content-click').addEventListener("click",function(){ 
        var contentRayout = document.getElementById('content-rayout');
         if(contentRayout.style.display == 'none'){
        	 contentRayout.style.display='block';
         } else {
        	 contentRayout.style.display='none';
         }

       
    });
    
    
    
    $("#form-id").submit(function(){
    	console.log("실행");
    	let result = window.confirm("정말 삭제하시겠습니까?");
    	if(result){
    		console.log("삭제");
    		return true;
    	}
    	console.log("삭제안함");
    	return false;
    });
    
   

    

    

</script>
</html>