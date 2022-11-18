<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/modal.css" />
    <title>Document</title>
</head>
<body>

<main class="main">
	<section class="container">
		<!--전체 리스트 시작-->
		<article class="story-list" id="storyList">

			<!--전체 리스트 아이템-->
			<div class="story-list__item">
				<div class="sl__item__header">
					
					<div>TherePrograming</div>
				</div>

				<div class="sl__item__img">
					<img src="${contextPath}/resources/img/duck.jpg" />
				</div>

				<div class="sl__item__contents">
					<div class="sl__item__contents__icon">

						<button>
							<i class="fas fa-heart active" id="storyLikeIcon-1" onclick="toggleLike()"></i>
						</button>
					</div>

					<span class="like"><b id="storyLikeCount-1">3 </b>likes</span>

					<div class="sl__item__contents__content">
						<p>등산하는 것이 너무 재밌네요</p>
					</div>

					<div id="storyCommentList-1">

						<div class="sl__item__contents__comment" id="storyCommentItem-1"">
							<p>
								<b>Lovely :</b> 부럽습니다.
							</p>

							<button>
								<i class="fas fa-times"></i>
							</button>

						</div>

					</div>

					<div class="sl__item__input">
						<input type="text" placeholder="댓글 달기..." id="storyCommentInput-1" />
						<button type="button" onClick="addComment()">게시</button>
					</div>

				</div>
			</div>

		</article>
	</section>
</main>
<script src="/js/modal.js"></script>


</body>
</html>