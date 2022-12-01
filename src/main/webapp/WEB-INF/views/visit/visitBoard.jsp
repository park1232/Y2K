<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="short icon" href="${contextPath}/resources/img/2014.ico"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/reset.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/visit.css" />

    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
    <!-- <style>
    		 /* @import url('https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Hammersmith+One&family=Mukta:wght@500&display=swap');
body{font-family: 'Gamja Flower', cursive;cursor: url(${contextPath}/img/cursor.cur), auto} */
    </style> -->
</head>
<body>
	<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
    <div class="bg">
      <main>
        <section class="pf-st">
          <div class="pf-side">
            <div class="pf-back">
              <div class="profile-wrap">
                <div class="visitor-counter">
                  <p class="today">999</p>
                  <p class="today-count">1213042</p>
                </div>
                <div class="profile">
                  <p class="todayis">
                    TODAY IS .. <i>♥</i><span> 행복</span>
                  </p>
                  <img class="profile-img" src="${contextPath}/resources/img/profile copy.jpg">
                  <div class="desc-wrap">
                    <p class="text-desc">
                     <div id="sideContentDiv" class="desc-wrap text-desc"></div>
                    <a class="history" href="#">HISTORY</a>
                  </div>
                  <div class="info-wrap">
                    <a class="info-name" href="#">Y2K</a>
                    <p class="text-email">guswhd956@naver.com</p>
                  </div>
                  <div class="profile-dropdown">
                    <div class="dropdown-btn">
                      <div class="dropdown-title">Related SNS Link</div>
                      <div class="triangle-down"></div>
                    </div>
                    <div class="dropdown-content">
                        <a href="https://bit.ly/3IUmQTC" target="_blank">Instagram</a>
                        <a href="https://bit.ly/3IWxs4u" target="_blank">FaceBook</a>
                        <a href="https://bit.ly/3IOwM0W" target="_blank">Blog</a>
                    </div>
                  </div>
                </div>
                <div class="side side1"></div>
                <div class="side side2"></div>
                <div class="side side3"></div>
                <div class="side side4"></div>
              </div>
            </div>
          </div>
        </section>
        <section class="main-section">
          <div class="main-dot">
            <div class="main-paper">
              <div class="main-wrap">
                <div class="title-wrap">
                  <p class="title"><div id="mainDiv" class="title title-wrap"><a href="#"></a></div></p>
                  <div class="link-wrap">
                    <a href="https://www.instagram.com/hyunjong_yoo/" target="_blank"><span>일촌맺기</span></a>
                    <a href="https://blog.naver.com/hananharu" target="_blank"><span>팬되기</span></a>
                    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p>
                  </div>
                </div>
             <!--  <form method="post"> -->
                <div class="main">
       <div class="visitor_card">
          <div class="visitor_title">
              <span class="visitor_number">No. 121</span> &nbsp;
              <span class="visitor_name">${loginUser.nickName }</span> &nbsp;
              <i id="homepage" class="fas fa-home visitor_homepage"></i>
              <span id="visitor_date"></span>
          </div>
          <div class="visitor_content">
              <br>
              <table>
              	  <thead>
                  <tr>
                      <td><div class="minimi-border"><img src="${contextPath}/resources/img/minimi/0.gif" class="ranimage"></img></div></td>
                      <td></td><td></td>
                      <td><textarea id="writeVisit" placeholder="방명록을 작성해주세요"></textarea></td>
                      <td></td>
                      <td><button id="submitVisit" type='button' <c:if test="${ loginUser.userNo eq userNo }">style="display:none;"</c:if>>등록</button></td>
                  </tr>
                  </thead>
              </table>

          </div>
      </div>
      <hr class="hr-2">

      <div class="visitLists">
      <c:forEach items="${list}" var="v">
       <div class="visitor_card">
       	  
          <div class="visitor_title">
              <span class="visitor_number" id="span1">No. ${v.visitNo}</span> &nbsp;
              <span class="visitor_name" id="span2">${v.nickName }</span> &nbsp;
              <a href="${v.path }" target="_blank"><i id="homepage" class="fas fa-home visitor_homepage"></i></a>
              <span id="visitor_date">${v.createDate}</span>
          </div>
          <div class="visitor_content">
              <br>
              <table>
              	  <tbody>
                  <tr>
                      <td><div class="minimi-border"><img src="${contextPath}/resources/img/minimi/0.gif" class="ranimage"></img></div></td>
                      <td></td><td></td>
                      <td><textarea id="visitContent" readonly>${v.visitContent}</textarea></td>
	                      <td></td>

                  </tr>
                  <tr><td>
                  <div>
                  <form action='delete-visit.vi?userNo=${userNo}'>
                  <div id="deleteButton">
                  	<button class="deleteVisit" id="deleteBtn" <c:if test="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.userNo ne v.visitWriter}">style="display:none;"</c:if>>삭제하기</button>
                  </div>
                  <input type="hidden" value="${v.visitNo}" name="visitNo" id="visithidden">
                  </form>
                 	</div>
                  </td></tr>
                  </tbody>
              </table>
					
					
          </div>
      </div>
      <hr class="hr-2">
	</c:forEach>
	</div>
	<input type="hidden" name="realVisitDelete"> 
	<br><br>
                 
    </div>         
<!-- 	</form> -->
		
	</div>
   <div class = "menu align-center expanded text-center SMN_effect-68">
           <a href="${contextPath}/mainPage.ma?userNo=${userNo}">   <div class="menu-item mi-1"  onclick="location.href='${contextPath}'">홈</div></a>
<!--              <a href="photo.html" class="menu-item mi-2" onclick="openPopup()">사진첩</a>-->

              <a href="${contextPath}/photo.ph?userNo=${userNo}" class="menu-item mi-2" >사진첩</a>
              <a href="${contextPath}/diary.di?userNo=${userNo}" class="menu-item mi-3">다이어리</a>
 </div>
             
             
                <a class="menu-item mi-4 menu-checked" onclick="location.href='${contextPath}/visit.vi?userNo=${userNo}'">방명록</a>
      <div class = "menu align-center expanded text-center SMN_effect-68">
               <a class="menu-item mi-5 " onclick="location.href='${contextPath}/boardList.bo?userNo=${userNo}'">게시판</a>
 </div>
            </div>
          </div>
        </section>
      </main> 
   </div>
     <script>
/*      $(document).ready(function(){
 		let skinPath = "";
 		let mainTitle = "";
 		let profilePath = "";
 		let sideContent = "";
 		let myUserNo = "";
		let hiddenUserNo = "";
 		
 		
 		
 		
 		if("${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.userNo}" != "${userNo}"){
 			myUserNo = "${userNo}";
 		} else {
 			myUserNo = "${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.userNo}";
 		}
 		
 		let params={
 				userNo : myUserNo
 		}
 		
 		$.ajax({
 			type:"GET",
 			url:"/onload.my",
 			data : params,
 			success:function(res){
 				skinPath = res.skinPath;
 				mainTitle = res.mainTitle;
 				profilePath = res.profilePath;
 				sideContent = res.sideContent;
 				document.getElementById('sideContentDiv').innerHTML = sideContent;
 				document.getElementById('mainDiv').innerHTML = mainTitle;
 				
 				$(".bg").css({"background":"url("+skinPath+")"}); 
 				
 				console.log(skinPath);
 				console.log(mainTitle);
 				console.log(profilePath);
 				console.log(sideContent);
 			}
 		})
 		
 		
 		
 		
 	}); */
     
     

 			const ranimage = document.getElementsByClassName('ranimage');
            for( var i of ranimage) { 
 
        		i.src="${contextPath}/resources/img/minimi/" + Math.round(Math.random()*7+.8)+".gif";     	
            }

     
            var btnvar4 = document.getElementsByClassName('btn1');
            
            function Toggle4(){
            	
            for(var i of btnvar4) {
              if(i.style.color=="red"){
                i.style.color="grey";
                i.innerHTML = '<i class="far fa-heart"></i>';
              } else {
                i.style.color = "red";
                i.innerHTML = '<i class="fas fa-heart"></i>';
              }
            }
            }
            
            
	    
      
      //방명록 등록
     /*   document.getElementById('submitVisit').addEventListener('click',  */
    	$("#submitVisit").click(function(){
    	  console.log(document.getElementById('writeVisit').value);
    	  console.log('${loginUser.userNo}');
    	   $.ajax({
    		  url:'${contextPath}/insertVisit.vi?userNo='+"${userNo}",
    		  data:{visitContent:document.getElementById('writeVisit').value,
    			  	visitWriter:'${loginUser.userNo}',
    			  	userNo : '${userNo}'},
    		  success: (res) => {
    			  console.log("통신성공");
    			  console.log(res);
    			  
//     			  const visitLists = document.getElementById('visitLists');
//     			  visitLists.innerHTML = '';
    			   /* location.href='http://localhost:8080/visit.vi?userNo='+"${userNo}"; */
//     			  for(const v of data) {
    				 
//     			  } +=4
    		  },
    		  error: (data)=>{
    			  console.log(data);
    		  }
    	  })
     	  renew(); 
       });  
      
     
     const renew = () => {
    	console.log("renew 실행됨");
    	 window.location.reload();
     }      
      
/*       $("document").ready(function(){
    	 
    	  
    	  $.ajax({
    		  url : "/selectVisit.vi",
    		 success:(res) => {
    			 document.getElementById("span1").innerHTML = res.content;
    			 document.getElementById("span1").innerHTML = res.writer;
    			 
    			 
    		 }
    	  })
      }) */
      

    	  
      
      
      
      /* const deleteVisit = document.getElementsByClassName('deleteVisit');
      for(var i of deleteVisit) {
    	  i.addEventListener('click', function(){
    		  const realVisitDelete = this.parentNode.querySelector('input').value;
    		  console.log(realVisitDelete);
    		  document.getElementsByName('realVisitDelete')[0].value = realVisitDelete;
    		  form.action = '${contextPath}/deleteVisit.vi?userNo="${userNo}"';
    		  form.submit();
    	  });
    	  
      } */
      
      
     /*  $('#deleteBtn').click(function(){
    	  let params={
    			  visitNo : $("#visithidden").val()
    	  }
    	  $.ajax({
    		  type:"GET",
    		  url:"/delete-visit.vi",
    		  data:params,
    		  success:function(res){
    			  console.log("삭제성공");
    			  renew();
    		  }
    	  })
      }); */
   
      
      </script>
      
      
</body>
</html>