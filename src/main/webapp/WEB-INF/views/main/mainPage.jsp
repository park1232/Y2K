<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<!-- 								<p class="today">999</p>
								<p class="today-count">1213042</p> -->
							</div>
							<div class="profile">
								<p class="todayis">
	<!-- 								TODAY IS .. <i>♥</i><span> 행복</span> -->
								</p>
								<img class="profile-img"
									src="${contextPath}/resources/img/profile.jpg" alt="profile"  id="profileImage" />
								<div class="desc-wrap">
									<p class="text-desc">
									<div id="sideContentDiv" class="desc-wrap text-desc"></div>
									</p>
									<!-- <a class="history" href="#">HISTORY</a> -->
								</div>
								<div class="info-wrap" id="ownerNickname">
									<a class="info-name" href="#"></a>
									<!--      <p class="text-email">guswhd956@naver.com</p> -->
								</div>
								<div class="profile-dropdown">
									<div class="dropdown-btn">
										<div class="dropdown-title">친구로 파도타기</div>
										<div class="triangle-down"></div>
									</div>
									<div class="dropdown-content"
										<c:if test="${ loginUser.userNo ne userNo }">style="display:none;"</c:if>>
										<c:forEach var="friendList"
											items="${sessionScope.friendPathList}">
											<a href="${friendList.friendPath}" target="_blank">${friendList.friendNickname }</a>
										</c:forEach>

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
								<div id="mainDiv" class="title title-wrap">
									<a href="#"></a>
								</div>
								</p>
								<div class="link-wrap">
									<a href="${contextPath}/mypage.my"><span>Mypage&nbsp&nbsp</span></a><br>
									<a href="${contextPath}/friendList.fr"><span>Friend&nbsp&nbsp</span></a>
									<!--    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p> -->
								</div>
							</div>
							<div class="main">
								<div class="post-wrap">
									<div class="recent">
										<h2>최근 게시물</h2>
										<c:forEach items="${dList}" var="d">
											<c:if test="${d.DIARY_CONTENT==null}">
												<p class="text-video">게시글이 없습니다.</p>
											</c:if>
											<c:if test="${d!=null}">
												<p class="text-video">${d.DIARY_CONTENT}</p>
											</c:if>
										</c:forEach>
										<c:forEach items="${bList}" var="b">
											<c:if test="${b==null}">
												<p class="text-video">게시글이 없습니다.</p>
											</c:if>
											<c:if test="${b!=null}">
												<p class="text-board">${b.BOARD_CONTENT}</p>
											</c:if>
										</c:forEach>

										<c:forEach items="${vList}" var="v">
											<c:if test="${v=null}">
												<p class="text-video">게시글이 없습니다.</p>
											</c:if>
											<c:if test="${v!=null}">
												<p class="text-board">${v.VISIT_CONTENT}</p>
											</c:if>
										</c:forEach>
										<c:forEach items="${pList}" var="p">
											<c:if test="${p==null}">
												<p class="text-photo">게시글이 없습니다.</p>
											</c:if>
											<c:if test="${p!=null}">
												<p class="text-photo">${p.PHOTOCOMENT}</p>
											</c:if>
										</c:forEach>



									</div>
									<div class="menu-table">
										<table>
											<tr>
												<td>사진첩<a
													href="${contextPath}/photo.ph?userNo=${userNo}">${pCount }</a></td>
												<td>다이어리<a
													href="${contextPath}/diary.di?userNo=${userNo}">${dCount}</a></td>
											</tr>
											<tr>
												<td>방명록<a
													href="${contextPath}/visit.vi?userNo=${userNo}">${vCount}</a></td>
												<td>게시판 <a
													href="${contextPath}/boardList.bo?userNo=${userNo}">${bCount}</a></td>
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
									name="loginUser">


								<c:forEach items="${ list }" var="r">
									<div class="friends-say-list"
										id="storyCommentList-${ r.replyNo}">
										<input type="hidden" id="replyNo" value="${r.replyNo}">
										<p>${r.content}:
											<span>${r.nickName}</span>
											<button id="delRe"
												<c:if test="${ r.nickName ne loginUser.nickName }">style="display:none;"</c:if>>
												> <i class="fas fa-times"></i>
											</button>
											<input type="hidden" id="replyWriter"
												value="${r.replyWriter}">

										</p>



									</div>
								</c:forEach>
							</div>
						</div>
						<input type="hidden" value="${userNo}" name="userNo" /> <a
							href="${contextPath}/mainPage.ma?userNo=${userNo}"
							class="menu-item mi-1 menu-checked">홈</a>
						<div class="menu align-center expanded text-center SMN_effect-68">
							<a href="${contextPath}/photo.ph?userNo=${userNo}"
								class="menu-item mi-2">사진첩</a> <a
								href="${contextPath}/diary.di?userNo=${userNo}"
								class="menu-item mi-3">다이어리</a> <a
								href="${contextPath}/visit.vi?userNo=${userNo}"
								class="menu-item mi-4">방명록</a> <a
								href="${contextPath}/boardList.bo?userNo=${userNo}"
								class="menu-item mi-5">게시판</a>
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
	    		//console.log(data);
    		 $.ajax({
    			type: "POST",
    	 		url:"/insertReply.ma",
    	 		data: data,
    	 		success:(data)=>{
    	 			contentt = data.content;
    	 			nickName = data.nickName;
    	 			boardNoo = data.boardNo;
    	 			
    	 			
    	 			//console.log(contentt);
    	 			//console.log("성공");
    	 			
    	 			const newComment =document.createElement('p');
    	 			newComment.innerHTML = '<p>'+contentt + '('+$("#nickName").val() + ')</p>';
    	 			
    	 			commentList.prepend(newComment);
    	 			window.location.reload();
    	 		}
    	 		
    	 		
    	 		});
    	 
	    		commentInput.val(""); 
	    		form.submit();
	    		window.location.reload();
     		});
    	
    	
    	
    	 let loginUser =$("#login").val();
    	 let replyWr = $("#replyWriter").val();
    	// console.log(replyWr);
    	 //console.log(userNo);
 		 let ps = document.querySelectorAll('.friends-say-list');
 		  //console.log(ps);
 		 for(const p of ps){
 			  
 			 const replyNo = p.querySelector('#replyNo').value;
 			 const button = p.querySelector('button');
 			 
 			
 			 
 			 button.addEventListener('click', ()=>{
 				 //console.log(replyNo);
 				
				if(loginUser !=replyWr){
					alert("안댐");
					
				}else{
 			 	$.ajax({
 			 		type:"post",
 			 		url:"/deleteReply.ma",
 			 		data: {
 			 			replyNo : replyNo,
 			 			
 			 				
 			 		},
 			 	
 			 		success:(data)=>{
 			 			
 			 			console.log("성공");
 			 			console.log(data);
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
		//console.log(slides);
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
				document.getElementById('ownerNickname').innerHTML = res.ownerNickname;
				$(".bg").css({"background":"url("+skinPath+")"}); 
				jQuery('#profileImage').attr("src", profilePath);
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
