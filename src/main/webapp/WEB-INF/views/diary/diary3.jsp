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
    <link rel="stylesheet" href="${contextPath}/resources/css/diary3.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://kit.fontawesome.com/203ce9d742.js" crossorigin="anonymous"></script>
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
                    <a class="info-name" href="#">유현종</a>
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
                  <p class="title"><a href="#">마케팅이 좋은 사람들, 마케팅월드</a></p>
                  <div class="link-wrap">
                    <a href="https://www.instagram.com/hyunjong_yoo/" target="_blank"><span>일촌맺기</span></a>
                    <a href="https://blog.naver.com/hananharu" target="_blank"><span>팬되기</span></a>
                    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p>
                  </div>
                </div>
                <div class="main">
                	<h1>2022.11.05</h1>
                	
                	<table>
                		<tr>
                			<td>
                				<div class="selectBox">
								  <select name="fruits" class="select">
								    <option disabled selected>날씨⭐</option>
								    <option value="apple">☀맑음</option>
								    <option value="orange">☁흐림</option>
								    <option value="grape">🌧비</option>
								    <option value="melon">❄눈</option>
								  </select>
								  <span class="icoArrow"></span>
								</div>
                			</td>
                			<td>
                				<div class="selectBox">
								  <select name="fruits" class="select">
								    <option disabled selected>기분💕</option>
								    <option value="apple">😄기쁨</option>
								    <option value="orange">😭슬픔</option>
								    <option value="orange">😡화남</option>
								    <option value="grape">🥱피곤</option>
								    <option value="melon">😆행복</option>
								    <option value="melon">😵바쁨</option>
								  </select>
								  <span class="icoArrow"><img src="https://freepikpsd.com/media/2019/10/down-arrow-icon-png-7-Transparent-Images.png" alt=""></span>
								</div>
                			</td>
                			<td>
                				<div class="map">위치선택</div>
                			</td>
                			<td>
                				<div class="selectBox">
								  <select name="fruits" class="select">
								    <option disabled selected>공개범위💌</option>
								    <option value="apple">전체공개</option>
								    <option value="orange">일촌공개</option>
								    <option value="grape">비공개</option>
								  </select>
								  <span class="icoArrow"><img src="https://freepikpsd.com/media/2019/10/down-arrow-icon-png-7-Transparent-Images.png" alt=""></span>
								</div>
                			</td>
                		</tr>
                	</table>
                	
					
					
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	<hr>
                	
                	<div class="diary" contenteditable="true">
                	
                	</div>
                	
                	<hr class="hr2">
                	
					<button>등록하기</button>                	

                </div>
              </div>
              <div class = "menu align-center expanded text-center SMN_effect-68">
	              <a href="home.html" class="menu-item mi-1" >홈</a>
	<!--              <a href="photo.html" class="menu-item mi-2" onclick="openPopup()">사진첩</a>-->
	
	              <a href="photo.html" class="menu-item mi-2">사진첩</a>
              </div>
              <a href="diary.html" class="menu-item mi-3 menu-checked">다이어리</a>
              <div class = "menu align-center expanded text-center SMN_effect-68">
	              <a href="visit.html" class="menu-item mi-4">방명록</a>
	              <a href="#" class="menu-item mi-5">마케팅</a>
              </div>

<!--              <div class="menu-item mi-6">게시판</div>-->
<!--              <div class="menu-item mi-7">방명록</div>-->
            </div>
          </div>
        </section>
      </main>
      
    </div>
    <script>
    //    function openPopup(){
    //        window.open("profil.html", "new", "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=1280, height=721, left=0, top=0" );
    //    }
        /* $('.dropdown-btn').on('click',function(){
            $('.dropdown-content').show();
            }); */  
            $(".mi-5").on('click', function(){

              alert('마케팅 사이트 업데이트 진행중.');

            });
            
      </script>
  </body>


</html>
    