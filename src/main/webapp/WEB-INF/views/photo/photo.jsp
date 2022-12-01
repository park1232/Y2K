<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<body>

	<div class="bg">
		<main>

			<section class="pf-st">
				<div class="pf-side">
					<div class="pf-back">
						<div class="profile-wrap">
							<div class="visitor-counter">

							</div>
							<div class="profile">
								<p class="todayis">

								</p>
								<img class="profile-img"
									src="${contextPath}/resources/img/profile.jpg" alt="profile" id="profileImage"  />
								<div class="desc-wrap">
									<p class="text-desc">
										<div id="sideContentDiv" class="desc-wrap text-desc"></div>
									</p>
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
									<div id="mainDiv" class="title title-wrap"><a href="#"></a></div>
								</p>
								<div class="link-wrap">
									<a href="${contextPath}/mypage.my"><span>Mypage&nbsp&nbsp</span></a><br>
									<a href="${contextPath}/friendList.fr"><span>Friend&nbsp&nbsp</span></a>
									<!--    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p> -->
								</div>
							</div>
							<div class="main">
								
								<input type="hidden" value="${userNo}" name=userNo id="userNo">
								<div class="tab_content" id="tab-content">
									  <c:if test="${ loginUser.userNo == userNo }">  
									<button id="photo_upload" onclick="up();">사진올리기</button>
									 </c:if>  
									<br>
									<br>
									<div id="tab-1-content" class="tab-content-item show">
										<!--게시물컨 그리드배열-->
										<div class="tab-1-content-inner">
												
											<!--${dto.member.userNo} -->
											<%-- ${dto.member} --%>
											<%-- ${images} --%>
											<input type="hidden" name="nickName"
												value="${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.nickName}">
											<c:forEach var="image" items="${images}">

												<div class="img-box">
													<img id="imgOne" class="imgOne"
														src="/upload/${image.renameName}" /> <input type="hidden"
														name="boardNo" id="boardNo" value=${image.boardNo }>
													<!--<div class="comment"></div>-->
												</div>

											</c:forEach>
											<!--아이템들end-->
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="menu align-center expanded text-center SMN_effect-68">
							<a href="${contextPath}/mainPage.ma?userNo=${userNo}" class="menu-item mi-1">홈</a>
						</div>
						<a href="${contextPath}/photo.ph?userNo=${userNo}"
							class="menu-item mi-2 menu-checked">사진첩</a>
						<div class="menu align-center expanded text-center SMN_effect-68">
							<a href="${contextPath}/diary.di?userNo=${userNo}" class="menu-item mi-3">다이어리</a>
							<a href="${contextPath}/visit.vi?userNo=${userNo}" class="menu-item mi-4">방명록</a>
							<a href="${contextPath}/boardList.bo?userNo=${userNo}" class="menu-item mi-5">게시판</a>
						</div>
					</div>
				</div>
			</section>

		</main>
	</div>






	<script src="${contextPath}/resources/js/photo.js"></script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>

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
				document.getElementById('ownerNickname').innerHTML = res.ownerNickname;
				$(".bg").css({"background":"url("+skinPath+")"}); 
				jQuery('#profileImage').attr("src", profilePath);
				console.log(skinPath);
				console.log(mainTitle);
				console.log(profilePath);
				console.log(sideContent);
			}
		})
		
		
		
		
	});
	
</script>

</html>
