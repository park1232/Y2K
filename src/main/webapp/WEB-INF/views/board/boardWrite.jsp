<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"
	scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="short icon" href="${contextPath}/resources/img/2014.ico" />
<link rel="stylesheet" href="${contextPath}/resources/css/reset.css" />
<link rel="stylesheet" href="${contextPath}/resources/css/style.css" />
<link rel="stylesheet" href="${contextPath}/resources/css/write.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://kit.fontawesome.com/7a738a6e1a.js"
	crossorigin="anonymous"></script>
<style>
</style>
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
									TODAY IS .. <i>♥</i><span> 행복</span>
								</p>
								<img class="profile-img"
									src="${contextPath}/resources/img/profile.jpg" alt="profile"
									id="profileImage" />
								<div class="desc-wrap">
									<p class="text-desc">
									<div id="sideContentDiv" class="desc-wrap text-desc"></div>
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
							<%-- <input type="hidden" name="userNo" value="${userNo}"/> --%>
							<div class="main">
								<div>
									<hr class="hrB">
								</div>
								<br>
								<form action="${contextPath}/insertBoard.bo?userNo=${userNo}"
									method="post">
									<div id="writeDiv">
										<table>
											<thead>
												<tr style="text-align: center;">

													<td width="50px"><select name="category" id="category">
															<option>잡담</option>
															<option>유머</option>
															<option>정보</option>
															<option>기타</option>
													</select></td>

													<th width="55px"
														style="border-right: 2px dashed rgb(11, 82, 0); font-size: 12px;">제목</th>
													<td><input type="text" name="boardTitle" size="30"
														id="boardTitle"></td>
												</tr>
											</thead>
										</table>
										<br>
										<div>
											<hr class="hrB">
										</div>
										<br>
										<textarea id="boardContent" name="boardContent"
											placeholder="게시글 내용을 입력해주세요"></textarea>
										<br> <br>
										<div id="writeButton">
											<button class="button btnBorder btnOrange">등록</button>
										</div>
									</div>
								</form>
								<br> <br> <br> <br>

							</div>
							<div class="menu align-center expanded text-center SMN_effect-68">
								<a href="${contextPath}/mainPage.ma?userNo=${userNo}"
									class="menu-item mi-1">홈</a>
								<!--              <a href="photo.html" class="menu-item mi-2" onclick="openPopup()">사진첩</a>-->
								<a href="${contextPath}/photo.ph?userNo=${userNo}"
									class="menu-item mi-2">사진첩</a> <a
									href="${contextPath}/diary.di?userNo=${userNo}"
									class="menu-item mi-3">다이어리</a>
							</div>
							<div class="menu align-center expanded text-center SMN_effect-68">
								<a class="menu-item mi-4"
									onclick="location.href=${contextPath}/visit.vi?userNo=${userNo}'">방명록</a>
							</div>
							<a class="menu-item mi-5 menu-checked"
								onclick="location.href='${contextPath}/boardList.bo?userNo=${userNo}'">게시판</a>

							<!-- <a href="#" class="menu-item mi-5">마케팅</a> -->
							<!--              <div class="menu-item mi-6">게시판</div>-->
							<!--              <div class="menu-item mi-7">방명록</div>-->
						</div>
					</div>
			</section>
		</main>

	</div>

</body>
<script>
window.onload = () => {
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
console.log("boardList : " + myUserNo);
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
</html>