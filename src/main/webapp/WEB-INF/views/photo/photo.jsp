<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
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
									안녕하세요. <br> 퍼포먼스 마케터 <br>유현종입니다. <br> 제 미니홈피에
									오신것을 환영합니다.
								</p>
								<a class="history" href="#">HISTORY</a>
							</div>
							<div class="info-wrap">
								<a class="info-name" href="#">조현재</a>
								<p class="text-email">nowing0108@kakao.com</p>
							</div>
							<div class="profile-dropdown">
								<div class="dropdown-btn">
									<div class="dropdown-title">친구와 채팅</div>
									<div class="triangle-down"></div>
								</div>
								<div class="dropdown-content">
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
								<a href="#">마케팅이 좋은 사람들, 마케팅월드</a>
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
							<div class="tab_content" id="tab-content">
								<button id="photo_upload" onclick="up();">사진올리기</button>
								<br><br>
								<div id="tab-1-content" class="tab-content-item show">
									<!--게시물컨 그리드배열-->
									<div class="tab-1-content-inner">

										<!--아이템들-->

										<div class="img-box">
											<img class="img" src="${contextPath}/resources/img/duck.jpg" />
										</div>

										<div class="img-box">
											<img class="img" src="${contextPath}/resources/img/duck.jpg" />
										</div>

										<div class="img-box">
											<img class="img" src="${contextPath}/resources/img/duck.jpg" />
										</div>

										<div class="img-box">
											<img class="img" src="${contextPath}/resources/img/duck.jpg" />
										</div>

										<div class="img-box">
											<img class="img" src="${contextPath}/resources/img/duck.jpg" />
										</div>

										<!--아이템들end-->
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="menu align-center expanded text-center SMN_effect-68">
						<a href="${contextPath}/mainPage.ma" class="menu-item mi-1">홈</a>
					</div>
					<a href="${contextPath}/photo.ph"
						class="menu-item mi-2 menu-checked">사진첩</a>
					<div class="menu align-center expanded text-center SMN_effect-68"></div>
					<a href="${contextPath}/diary.di" class="menu-item mi-3">다이어리</a>
					<a href="${contextPath}/visitBoard.vi"
						class="menu-item mi-4">방명록</a> <a href="#" class="menu-item mi-5">마케팅</a>
				</div>
			</div>
		</section>
		</main>
	</div>
	



	<script src="${contextPath}/resources/js/photo.js"></script>
  </body>
</html>
    