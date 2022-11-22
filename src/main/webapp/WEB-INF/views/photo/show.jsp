<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"
	scope="application" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${contextPath}/resources/css/show.css" />
<!-- Fontawesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>Document</title>
</head>
<body>
	<main class="main">
		<section class="container">
			<form method="POST" id="detailForm" target="self">
			<!--전체 리스트 시작-->
			<article class="story-list" id="storyList">
			
				<button type="button" class="modi" onclick="popup('.modal-info')">
					<i class="fas fa-cog"></i>
				</button>
				<!--전체 리스트 아이템-->
				<div class="story-list__item">

					<div class="sl__item__img">
						<img src="/upload/${photo.renameName}" />
					</div>
					<input type="hidden" value=' ${ photo.photoNo }' name="photoNo">

					<div class="sl__item__contents">
						
						<div class="modal-info" onclick="modalInfo()">
							<div class="modal"> 
								<button type="button" id="updateForm">수정</button>
								<button type="submit" id="deleteModal" >삭제</button>
								<button type="button" onclick="closePopup('.modal-info')">닫기</button>
							</div>
						</div>
						<div class="sl__item__contents__content" name="photoComent">
							<p >${photo.photoComent}</p>

						</div>

						<div id="storyCommentList-1">

							<div class="sl__item__contents__comment" id="storyCommentItem-1">
								<p>
									<b>조현재 :</b> 제발 되어라..
								</p>
								<button type="button">
									<i class="fas fa-times" id="change"></i>
								</button>
							</div>
						</div>

						<div class="sl__item__input">
							<input type="text" placeholder="댓글 달기..."
								id="storyCommentInput-1" />
							<button type="button" id="have">게시</button>
						</div>


					</div>
				</div>

			</article>
			</form>
		</section>
	</main>

	<script src="${contextPath}/resources/js/show.js"></script>


</body>
</html>