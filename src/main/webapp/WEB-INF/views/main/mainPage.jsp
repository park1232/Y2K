<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"
	scope="application" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
<title>홈피</title>
<link rel="short icon" href="${contextPath}/resources/img/2014.ico">
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css" />
<link rel="stylesheet" href="${contextPath}/resources/css/style.css" />
<link rel="stylesheet" href="${contextPath}/resources/css/photo.css" />
<link rel="stylesheet" href="${contextPath}/resources/css/mainPage.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
</head>
<body>
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
								<img class="profile-img"
									src="${contextPath}/resources/img/profile.jpg" alt="profile" />
								<div class="desc-wrap">
									<p class="text-desc">
										<div id="sideContentDiv" class="desc-wrap text-desc"></div>
									</p>
									<a class="history" href="#">HISTORY</a>
								</div>
								<div class="info-wrap">
									<a class="info-name" href="${contextPath}/mainPage.ma?userNo=${member.userNo}" >${member.nickName}</a>
									<p class="text-email">nowing0108@kakao.com</p>
								</div>
								<div class="profile-dropdown">
									<div class="dropdown-btn">
										<div class="dropdown-title">친구와 채팅</div>
										<div class="triangle-down"></div>
									</div>
									<div class="dropdown-content" id="chatList">
										<a href="${contextPath}/chat/chat.html">김지인</a> <a
											href="${contextPath}/chat/chat.html">박규민</a> <a
											href="${contextPath}/chat/chat.html">조소연</a> <a
											href="${contextPath}/chat/chat.html">김민주</a>
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
								<p class="title">
									<div id="mainDiv" class="title title-wrap"><a href="#"></a></div>
								</p>
								<div class="link-wrap">
									<a href="https://www.instagram.com/hyunjong_yoo/"
										target="_blank"><span>일촌맺기</span></a> <a
										href="https://blog.naver.com/hananharu" target="_blank"><span>팬되기</span></a>
									<p>
										<a href="#">https://www.cyowrld.com/marketer_JJ</a>
									</p>
								</div>
							</div>
							<div class="main">
								<div class="post-wrap">
									<div class="recent">
										<h2>최근 게시물</h2>
										<p class="text-video">게시글이 없습니다.</p>
										<p class="text-board">
											<a src="#">게시글이 없습니다.</a>
										</p>
										<p class="text-gallery">
											<a src="#">게시글이 없습니다.</a>
										</p>
										<p class="text-photo">
											<a src="#">게시글이 없습니다.</a>
										</p>
										<!--                      <p class="text-photo"><a src="#">게시글이 없습니다.</a></p>-->



									</div>
									<div class="menu-table">
										<table>
											<tr>
												<td>사진첩<a href="#">0/999</a></td>
												<td class="new-post">다이어리<a href="#">10/777</a></td>
											</tr>
											<tr>
												<td class="new-post">방명록<a href="#">153/11195</a></td>
												<td>게시판 ${bList }<a href="#">9/20</a></td>
											</tr>
											<tr>
												<td></td>
												<td></td>
											</tr>
										</table>
									</div>
								</div>
								<div class="mini-room-wrap">
									<img class="img-miniroom"
										src="${contextPath}/resources/img/mini_room.gif"
										alt="mini-room">
									
								</div>
								
								<div class="mini-room-wrap">
									<img class="img-miniroom"
										src="${contextPath}/resources/img/mini_room2.gif"
										alt="mini-room" />
								</div>

								<div class="mini-room-wrap">
									<img class="img-miniroom"
										src="${contextPath }/resources/img/mini_room3.gif"
										alt="mini-room" />
								</div> 


								<h2 class="friends-say">일촌평</h2>
								<div class="friends-say-section">
									<label for="friends-say">friends say</label> <input type="text"
										placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!" id="storyCommentInput"
										name="content" />
									<button type="button" class="fr-bt" id="replySubmit">확인</button>
								</div>

								<%-- <input type="hidden" id="nickName"
									value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.nickName}"> --%>
								<%-- <input type="hidden" id="replyWriter" name="replyWriter"
									value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.userNo}"> --%>
								<input type="hidden" id="login"
									value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.userNo}"
									name="userNo">


								<c:forEach items="${ list }" var="r">
									<div class="friends-say-list" id="storyCommentList-${ r.replyNo}">
										<input type="hidden" id="replyNo" value="${r.replyNo}">
										<p>${r.content}:
											<span>${r.nickName}</span>
											<button id="delRe">
												<i class="fas fa-times"></i>
											</button>
											<input type="hidden" id="replyWriter"
												value="${r.replyWriter}">

										</p>



									</div>
								</c:forEach>
							</div>
						</div>

						<a href="${contextPath}/mainPage.ma?userNo=${userNo}"
							class="menu-item mi-1 menu-checked">홈</a>
						<div class="menu align-center expanded text-center SMN_effect-68">
							<a href="${contextPath}/photo.ph?userNo=${userNo}" class="menu-item mi-2">사진첩</a>
							<a href="${contextPath}/diary.di?userNo=${userNo}" class="menu-item mi-3">다이어리</a>
							<a href="${contextPath}/visit.vi?userNo=${userNo}" class="menu-item mi-4">방명록</a>
							<a href="${contextPath}/boardList.bo?userNo=${userNo}" class="menu-item mi-5">게시판</a>
						</div>


					</div>
				</div>
			</section>
		</main>

	</div>

	<script>
     	
 

    	
    	 
    		 let commentInput = $("#storyCommentInput");
    		let commentList = $("#storyCommentList");
    	 	let replyWriter = $("#replyWriter");
    	 	
    	 	
    	 	window.onload=()=>{
    	    	 
    	 let contentt = "";
   		let nickNamee = "";
   		let boardNoo = "";
 		  /* 	 document.getElementById('replySubmit') */
    	$("#replySubmit").on('click', function(){
    			event.preventDefault();
	    		let data = {
	       			 	content : $("#storyCommentInput").val(),
	     				nickName : $("#nickName").val(),
	     				replyWriter : $("#replyWriter").val(),	
	     				own : "${userNo}"
	     		}
	    		console.log(data);
    		 $.ajax({
    			type: "POST",
    	 		url:"/insertReply.ma",
    	 		data: data,
    	 		success:(data)=>{
    	 			contentt = data.content;
    	 			nickName = data.nickName;
    	 			boardNoo = data.boardNo;
    	 			
    	 			
    	 			console.log(contentt);
    	 			console.log("성공");
    	 			
    	 			const newComment =document.createElement('p');
    	 			newComment.innerHTML = '<p>'+contentt + '('+$("#nickName").val() + ')</p>';
    	 			
    	 			commentList.prepend(newComment);
    	 		}
    	 		
    	 		
    	 		});
    	 
	    		commentInput.val(""); 
	    		
				
     		});
    	
    	
    	
    	 let userNo =$("#login").val();
    	 let replyWr = $("#replyWriter").val();
    	 //console.log(replyWr);
    	 //console.log(userNo);
 		 let ps = document.querySelectorAll('.friends-say-list');
 		  //console.log(ps);
 		 for(const p of ps){
 			  
 			 const replyNo = p.querySelector('#replyNo').value;
 			 const button = p.querySelector('button');
 			 
 			
 			 
 			 button.addEventListener('click', ()=>{
 				 //console.log(replyNo);
				if(userNo !=replyWr){
					alert("안댐");
					return false;
				}else{
 			 	$.ajax({
 			 		type:"post",
 			 		url:"/deleteReply.ma",
 			 		data: {
 			 			replyNo : replyNo
 			 		},
 			 		success:(data)=>{
 			 			
 			 			console.log("성공");
 			 			
 			 			$('storyCommentList-${ r.replyNo}').remove();
 			 		}
 			 		
 			 	})
 			 	window.location.reload();
				}
 			 
 			 
 			 })
 			 
 		 }
 		  
 		  

 		
     
     //사진 로테이션
     let slideIndex = 0;
     showSlides();

     function showSlides(){
	       let i;
	       let slides = document.getElementsByClassName("mini-room-wrap");
		console.log(slides);
		     for(i = 0; i<slides.length; i++){
		        slides[i].style.display = "none";
		     }  
		     slideIndex ++;
		     if (slideIndex > slides.length) {slideIndex = 1}
		     slides[slideIndex-1].style.display = "block";  
		     setTimeout(showSlides, 8000);
		     
     } 
       
     
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
		console.log("myUserNo : " + myUserNo);
		
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
  	  
     
     
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
     
     }
     
     
     
     
     </script>




















</body>
</html>
