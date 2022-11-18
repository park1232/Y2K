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
    <link rel="stylesheet" href="${contextPath}/resources/css/mainPage.css" />
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
                  <img class="profile-img" src="${contextPath}/resources/img/profile.jpg" alt="profile"/>
                  <div class="desc-wrap">
                    <p class="text-desc">
                     안녕하세요. <br> 퍼포먼스 마케터 <br>유현종입니다. <br> 제 미니홈피에 오신것을 환영합니다. </p>
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
                    <a href="${contextPath}/chat/chat.html">김지인</a>
                    <a href="${contextPath}/chat/chat.html">박규민</a>
                    <a href="${contextPath}/chat/chat.html">조소연</a>
                    <a href="${contextPath}/chat/chat.html">김민주</a>
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
                  <p class="title"><a href="#">마케팅이 좋은 사람들, 마케팅월드</a></p>
                  <div class="link-wrap">
                    <a href="https://www.instagram.com/hyunjong_yoo/" target="_blank"><span>일촌맺기</span></a>
                    <a href="https://blog.naver.com/hananharu" target="_blank"><span>팬되기</span></a>
                    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p>
                  </div>
                </div>
                <div class="main">
                  <div class="post-wrap">
                    <div class="recent">
                      <h2>최근 게시물</h2>
                      <p class="text-video">게시글이 없습니다.</p>
                      <p class="text-board"><a src="#">게시글이 없습니다.</a></p>
                      <p class="text-gallery"><a src="#">게시글이 없습니다.</a></p>
                      <p class="text-photo"><a src="#">게시글이 없습니다.</a></p>
<!--                      <p class="text-photo"><a src="#">게시글이 없습니다.</a></p>-->
          

            
                    </div>
                    <div class="menu-table">
                      <table>
                        <tr>
                          <td>쥬크박스<a href="#">0/999</a></td>
                          <td class="new-post">사진첩<a href="#">10/777</a></td>
                        </tr>
                        <tr>
                          <td class="new-post">방명록<a href="#">153/11195</a></td>
                          <td>즐겨찾기<a href="#">9/20</a></td>
                        </tr>
                        <tr>
                          <td></td>
                          <td></td>
                        </tr>
                      </table>
                    </div>
                  </div>
                  <div class="mini-room-wrap">
                    
                    <img
                      class="img-miniroom"
                      src="${contextPath}/resources/img/mini_room.gif"
                      alt="mini-room"
                    />
                    
                  </div>
                  <h2 class="friends-say">일촌평</h2>
                  <div class="friends-say-section">
                    <label for="friends-say">friends say</label>
                    <input
                      type="text"
                      placeholder="일촌과 나누고 싶은 이야기를 남겨보세요~!"
                    />
                    <button class="fr-bt">확인</button>
                  </div>
                  <div class="friends-say-list">
                    <p>안녕하세요? 구경 잘 하고 갑니다~ (퍼포마 <span>김마켓</span>)</p>
                    <p>ENFP 미니홈피 예쁘네요 ~ 일촌 맺어요~~ (MZ세대 <span>쫑이쫑E</span>)</p>
                    <p>노는게 제일좋아 !!  (ENFP <span>뽀롱뽀롱뽀로로</span>)</p>
                    <p>고돌이는 바다가 너무 좋아 !! (마스코트 <span>고돌이</span>)</p>
                    <p>안녕~나는 랑이! (아지랑이 <span>랑이</span>)</p>
                  </div>
                </div>
              </div>
              
              <a href="${contextPath}/main/mainPage.html" class="menu-item mi-1 menu-checked">홈</a>
              <div class = "menu align-center expanded text-center SMN_effect-68">
              <a href="${contextPath}/photo/photo.html" class="menu-item mi-2">사진첩</a>
              <a href="${contextPath}/diray/diary.html" class="menu-item mi-3">다이어리</a>
              <a href="${contextPath}/visit/visitBoard.html" class="menu-item mi-4">방명록</a>
              <a class="menu-item mi-5" onclick="location.href='${contextPath}/board.bo'">게시판</a>
              </div>
              

            </div>
          </div>
        </section>
      </main>
      
    </div>
     
  </body>
</html>
    