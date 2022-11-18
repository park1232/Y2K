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
    <link rel="stylesheet" href="${contextPath}/resources/css/show.css" />
    
    <title>Document</title>
</head>
<body>
    <main class="main">
        <section class="container">
            <!--전체 리스트 시작-->
            <article class="story-list" id="storyList">
                
                <!--전체 리스트 아이템-->
                <div class="story-list__item">
                    <div class="sl__item__img">
                        <img src="${contextPath}/resources/img/duck.jpg" />
                    </div>
    
                    <div class="sl__item__contents">
                       
                        <div class="modal">
                            <button onclick="location.href='/user/1/update'">수정</button>
                            <button onclick="location.href='/logout'">삭제</button>
                            <button onclick="closePopup('.modal-info')">닫기</button>
                        </div>
                        <div class="sl__item__contents__content">
                            <p>오리 꿱꿱</p>
                        </div>
    
                        <div id="storyCommentList-1">
    
                            <div class="sl__item__contents__comment" id="storyCommentItem-1">
                                <p>
                                    <b>조현재 :</b> 귀여웡.
                                </p>
                                
                                <button>
                                    <i class="fas fa-times"></i>
                                </button>
                            </div>
    
                        </div>
    
                        <div class="sl__item__input">
                            <input type="text" placeholder="댓글 달기..." id="storyCommentInput-1" />
                            <button type="button">게시</button>
                        </div>
    
                    </div>
                </div>
    
            </article>
        </section>
    </main>
    <script src="${contextPath}/resources/js/show.js"></script>
    </body>
</html>