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
              <form>
              <table>
              	  <thead>
                  <tr>
                      <td><div class="minimi-border"><img id="writeImage" src="${contextPath}/resources/img/duck.jpg"></img></div></td>
                      <td></td><td></td>
                      <td><textarea id="writeVisit" placeholder="방명록을 작성해주세요"></textarea></td>
                      <td></td>
                      <td><button id="submitVisit" >등록</button></td>
                  </tr>
                  </thead>
              </table>
              </form>
          </div>
      </div>
      <hr class="hr-2">
      
      <div class="visitLists">
      <c:forEach items="${list}" var="v">
       <div class="visitor_card">
       	<input type="hidden" value="${v.visitNo}" name="visitNo">  
          <div class="visitor_title">
              <span class="visitor_number" id="span1">No. ${v.visitNo}</span> &nbsp;
              <span class="visitor_name" id="span2">${v.nickName }</span> &nbsp;
              <i id="homepage" class="fas fa-home visitor_homepage"></i>
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
                      <td><div onclick="Toggle4()" id="btnh" class="btn"><i class="far fa-heart"></i></div></td>
                  </tr>
                  </tbody>
                  <tr><td><button id="deleteVisit">삭제하기</button></td></tr>
              </table>
          </div>
      </div>
      <hr class="hr-2">
	</c:forEach>
	</div>
	<br><br>
                 
    </div>         
		
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
     $(document).ready(function(){
 		let skinPath = "";
 		let mainTitle = "";
 		let profilePath = "";
 		let sideContent = "";
 		let myUserNo = "";

 		
 		
 		
 		
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
 		
 		
 		
 		
 	});
     
     

 			const ranimage = document.getElementsByClassName('ranimage');
            	console.log(ranimage); //console에서는 src 다 다르게 뜨는데 view에서 적용 x
            for( var i of ranimage) { 
            	console.log(i);
        		ranimage.src="${contextPath}/resources/img/minimi/" + Math.round(Math.random()*3+.4)+".gif";     	
            }

     
            var btnvar4 = document.getElementById('btnh');
            function Toggle4(){
              if(btnvar4.style.color=="red"){
                btnvar4.style.color="grey";
                btnvar4.innerHTML = '<i class="far fa-heart"></i>';
              } else {
                btnvar4.style.color = "red";
                btnvar4.innerHTML = '<i class="fas fa-heart"></i>';
              }
            }
            
	    
      
      //방명록 등록
     /*   document.getElementById('submitVisit').addEventListener('click',  */
    	$("#submitVisit").click(function(){
    	  console.log(document.getElementById('writeVisit').value);
    	  console.log('${loginUser.userNo}');
    	   $.ajax({
    		  url:'${contextPath}/insertVisit.vi',
    		  data:{visitContent:document.getElementById('writeVisit').value,
    			  	visitWriter:'${loginUser.userNo}'},
    		  success: (data) => {
    			  console.log(data);
//     			  const visitLists = document.getElementById('visitLists');
//     			  visitLists.innerHTML = '';
    			  
//     			  for(const v of data) {
    				  
//     			  } +=4
    		  },
    		  error: (data)=>{
    			  console.log(data);
    		  }
  
    		  
    	  })
       });  
      
      
      
/*       $("document").ready(function(){
    	 
    	  
    	  $.ajax({
    		  url : "/selectVisit.vi",
    		 success:(res) => {
    			 document.getElementById("span1").innerHTML = res.content;
    			 document.getElementById("span1").innerHTML = res.writer;
    			 
    			 
    		 }
    	  })
      }) */
      </script>
</body>
</html>