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
    <link rel="stylesheet" href="${contextPath}/resources/css/board.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/write.css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
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
	 <div><hr class="hrB" id="up"></div>
        <br>
        <table>
        <thead>
            <tr id="titlebar" style="text-align: center;">
                <td>말머리</td>
                <th width="50px" style="border-right : 1px dashed rgb(11, 82, 0);"></th>
                <td>Spring이란 무엇일까요? </td>
                <th width="50px" style="border-right : 1px dashed rgb(11, 82, 0);">조회수</th>
                <td width="50px">72</td>
                <th width="50px" style="border-right : 1px dashed rgb(11, 82, 0);">작성자</th>
                <td width="50px">흰둥이</td>
            </tr>
        </thead>
        </table>
        <br>
        <div><hr class="hrB"></div>
        <br><br>
        <div id="boardContent">
            <p id="spring">Spring 이란?<br>

                JAVA의 웹 프레임워크로 JAVA 언어를 기반으로 사용한다.<br>
                JAVA로 다양한 어플리케이션을 만들기 위한 프로그래밍 틀이라 할 수 있다.<br>
                
                JAVA의 활용도가 높아지면서, JAVA를 이용한 기술이 <br>
                JSP, Mybatis, JPA 등의 기술이 생겨났다.<br>
                Spring은 다른 사람의 코드를 참조하기 쉽고 편리한 구조로<br>
                앞서 말한 기술들을 더 쉽게 사용해주는 오픈소스 프레임워크 이다.<br>
                API(Application Programming Interface)란 무엇일까?<br>

                응용 프로그램에서 운영 체제나 프로그래밍 언어가 제공하는 기능을 제어 할 수 있는 인터페이스<br>

                URI를 통해 데이터를 전달 받는 형태가 많고, 구현 혹은 다른 코드와 독립적으로 사용방법이 정의 되어 있다.
                
                </p>
                <br><br>
            <div id="good"><i class="fas fa-hand-holding-heart"></i></div>
             <br><br>
             <div class="sns">
                <span class="facebook">
                <a href="#n" onclick="fn_sendFB('facebook');return false;" class="facebook" target="_self" title="페이스북 새창열림"><img src="${contextPath}resources/img/icon-facebook.png"; width="30px"></a>
                </span>
                <span class="twitter">
                <a href="#n" onclick="fn_sendFB('twitter');return false;" class="twitter" target="_self" title="트위터 새창열림"><img src="${contextPath}resources/img/icon-twitter.png"; width="30px"></a>
                </span>
                <span class="band">
                <a href="#n" onclick="fn_sendFB('band');return false;" class="band" target="_self" title="네이버밴드 새창열림"><img src="${contextPath}resources/img/icon-line.png"; width="30px"></a>
                </span>
             </div>
            <div class="scrollbar">
              <a href="#up"><i class="fa-solid fa-circle-up"></i></a><br><br>
            <!-- <i class="fa-solid fa-circle-down"></i><br><br> -->
            <a href="#down"><i class="fa-solid fa-circle-down"></i></a><br><br>
            <a href="#reply"><i class="far fa-comment-dots"></i></a>
            
            </div>
        </div>
         <hr>
         
         <div id="replyDiv">
            <table>
                <tr>
                    <td colspan="2">
                        <textarea id="reply" rows="3" cols="50" id="replyContent" style="resize: none;"readonly placeholder='일촌에게 댓글을 작성해보세요!'></textarea>
                    </td>
                    <td>
  					    <div id="replyButton"><button class="button btnBorder btnOrange">등록</button></div>
                    </td>
                </tr>
                <tbody id="replyList">

                            <tr>
                                <td width="80px">곰돌이</td>
                                <td>정말 즐거운 내용이구나!</td>
                                <td>2022-02-03</td>
                            </tr>
                            <tr>
                                <td width="80px">강아지</td>
                                <td>오늘도 나는 사료와 간식을 먹는다</td>
                                <td>2022-02-07</td>
                            </tr>
                            <tr>
                                <td width="80px">고양이</td>
                                <td>츄르는 정말 맛있어!</td>
                                <td>2022-05-19</td>
                            </tr>
                            <tr>
                                <td width="80px">조다롱</td>
                                <td>오늘도 나는 산책을 두번 간다 ㅎㅎ</td>
                                <td>2022-11-09</td>
                            </tr>
                            <tr>
                                <td width="80px">조하루</td>
                                <td>나는 잠이 너무 많아</td>
                                <td>2022-07-15</td>
                            </tr>
                </tbody>
            </table>
            <div><hr class="hrB" id="down"></div>
        </div>
     </div>
			
	</div>
  <div class = "menu align-center expanded text-center SMN_effect-68">
    <a href="mainPage.html">   <div class="menu-item mi-1"  onclick="location.href='${contextPath}'">홈</div></a>
<!--              <a href="photo.html" class="menu-item mi-2" onclick="openPopup()">사진첩</a>-->
              <a href="photo.html" class="menu-item mi-2" >사진첩</a>
              <a href="diary.html" class="menu-item mi-3">다이어리</a>
      </div>
              <a class="menu-item mi-5 menu-checked" onclick="location.href='${contextPath}/board.bo'">게시판</a>
              <div class = "menu align-center expanded text-center SMN_effect-68">
              <a class="menu-item mi-4" onclick="location.href='${contextPath}/visit.bo'">방명록</a>
              </div>
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
      </script>
</body>
</html>