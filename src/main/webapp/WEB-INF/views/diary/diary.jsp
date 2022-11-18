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
    <link rel="stylesheet" href="${contextPath}/resources/css/diary.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="${contextPath}/resources/css/datepicker.css"/>
	<script>
		$( function() {
	    	$( "#datepicker" ).datepicker();
	    	$("#datepicker").val();
	        
	        $("#datepicker").on("change",function(){
	            var selected = $(this).val();
	            alert(selected);
	        });
	  	} );

	</script>
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
                  <div class="home_contents">
			<div class="c">
			<h2>날짜별보기</h2>
			</div>
			
			<div class="calendar">
				<div id="datepicker"></div>
			</div>
			
			<div class="m">
				<h2>지도별보기</h2>
			</div>
			
			<div class="map">
			</div>
        <div class="diary">
			<div class="diary_contents">
            	<table>
            		<tr>
            			<td width="100px;">30</td>
            			<td>안녕!</td>
            		</tr>
            	</table>
			</div>
			<div class="diary_contents">
            	<table>
            		<tr>
            			<td width="100px;">25</td>
            			<td>오늘은 경복궁감</td>
            		</tr>
            	</table>
			</div>
			<div class="diary_contents">
            	<table>
            		<tr>
            			<td width="100px;">15</td>
            			<td>초밥먹음</td>
            		</tr>
            	</table>
			</div>
			<div class="diary_contents">
            	<table class="test111">
            		<tr>
            			<td width="100px;">11</td>
            			<td>오늘은 DB모델링 다 끝냈다~</td>
            		</tr>
            	</table>
			</div>
			<div class="diary_contents">
            	<table>
            		<tr>
            			<td width="100px;">7</td>
            			<td>야호</td>
            		</tr>
            	</table>
			</div>
		</div>
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
    