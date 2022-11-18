<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="short icon" href="${contextPath}/resources/img/2014.ico"/>
    <link rel="stylesheet" href="${contextPath}/resources/css/reset.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/visit.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
    <!-- <style>
    		 /* @import url('https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Hammersmith+One&family=Mukta:wght@500&display=swap');
body{font-family: 'Gamja Flower', cursive;cursor: url(${contextPath}/img/cursor.cur), auto} */
    </style> -->
</head>
<body>
	<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
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
                  <img class="profile-img" src="${contextPath}/resources/img/profile copy.jpg">
                  <div class="desc-wrap">
                    <p class="text-desc">
                     안녕하세요. <br> 조다롱입니다. <br> 제 미니홈피에 오신것을 환영합니다. </p>
                    <a class="history" href="#">HISTORY</a>
                  </div>
                  <div class="info-wrap">
                    <a class="info-name" href="#">Y2K</a>
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
                  <p class="title"><a href="#">나의 미니홈피에 온걸 환영해 :D</a></p>
                  <div class="link-wrap">
                    <a href="https://www.instagram.com/hyunjong_yoo/" target="_blank"><span>일촌맺기</span></a>
                    <a href="https://blog.naver.com/hananharu" target="_blank"><span>팬되기</span></a>
                    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p>
                  </div>
                </div>
                <div class="main">
                       <div class="visitor_card">
          <div class="visitor_title">
              <span class="visitor_number">No. 121</span> &nbsp;
              <span class="visitor_name">다람쥐</span> &nbsp;
              <i id="homepage" class="fas fa-home visitor_homepage"></i>
              <span id="visitor_date"></span>
          </div>
          <div class="visitor_content">
              <br>
              <form>
              <table>
                  <tr>
                      <td><div class="minimi-border"><img class="photo" src="${contextPath}/resources/img/minimi/0.gif"/ name="ranimage"></img></div></td>
                      <td></td><td></td>
                      <td><textarea id="writeboard" placeholder="방명록을 작성해주세요"></textarea></td>
                      <td></td>
                      <td><button id="submitReply">등록</button></td>
                  </tr>
              </table>
              </form>
          </div>
      </div>
      <hr class="hr-2">

      <div class="visitor_card">
          <div class="visitor_title">
              <span class="visitor_number">No. 121</span> &nbsp;
              <span class="visitor_name">김둘리</span> &nbsp;
              <i id="homepage" class="fas fa-home visitor_homepage"></i>&nbsp;&nbsp;
              <span id="visitor_date"></span>
          </div>
          <div class="visitor_content">
              <br>
              <table>
                  <tr>
                      <td><div class="minimi-border"><img class="photo" id="visitor3" src="${contextPath}/resources/img/duck.jpg"></img></div></td>
                      <td><div class="writeCard">
                          안녕 하이 방가루~~~~~ 김둘리 왔다감 ㅎㅎㅎㅎㅎ
                          
                      </div></td>
                      <td><i class="far fa-heart"></i></td>
                  </tr>
              </table>
          </div>
      </div>
      <hr class="hr-2">

      <div class="visitor_card">
          <div class="visitor_title">
              <span class="visitor_number">No. 121</span> &nbsp;
              <span class="visitor_name">서강준</span> &nbsp;
              <i id="homepage" class="fas fa-home visitor_homepage"></i>
              <span id="visitor_date"></span>
          </div>
          <div class="visitor_content">
              <br>
              <table>
                  <tr>
                      <td><div class="minimi-border"><img class="photo" id="visitor3" src="${contextPath}/resources/img/duck.jpg"></img></div></td>
                      <td><div class="writeCard">
                          안녕하세요 이곳은 싸이월드!
                      </div></td>
                      <td><i class="far fa-heart"></i></td>
                  </tr>
              </table>
          </div>
      </div>
      <hr class="hr-2">


      <div class="visitor_card">
          <div class="visitor_title">
              <span class="visitor_number">No. 121</span> &nbsp;
              <span class="visitor_name">곰돌이</span> &nbsp;
              <i id="homepage" class="fas fa-home visitor_homepage"></i>
              <span id="visitor_date"></span>
          </div>
          <div class="visitor_content">
              <br>
              <table>
                  <tr>
                      <td><div class="minimi-border"><img class="photo" id="visitor3" src="${contextPath}/resources/img/duck.jpg"></img></div></td>
                      <td><div class="writeCard">
                          안녕하세요 이곳은 싸이월드!
                      </div></td>
                      <td class="hreat"><i id="heart"class="fa-regular fa-heart"></i></td>
                  </tr>
              </table>
          </div>
      </div>
      <hr class="hr-2">
              </div>
              <div class = "menu align-center expanded text-center SMN_effect-68">
                <a href="mainPage.html">   <div class="menu-item mi-1"  onclick="location.href='${contextPath}'">홈</div></a>
<!--              <a href="photo.html" class="menu-item mi-2" onclick="openPopup()">사진첩</a>-->
              <a href="photo.html" class="menu-item mi-2" >사진첩</a>
              <a href="diary.html" class="menu-item mi-3">다이어리</a>
              
              <a class="menu-item mi-5" onclick="location.href='${contextPath}/board.bo'">게시판</a>
              </div>
              <a class="menu-item mi-4 menu-checked" onclick="location.href='${contextPath}/visit.bo'">방명록</a>
              <!-- <a href="#" class="menu-item mi-5">마케팅</a> -->
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

        document.ranimage.src="${contextPath}/resources/img/minimi/" + Math.round(Math.random()*3+.4)+".gif";
      </script>
</body>
</html>