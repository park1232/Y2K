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
	
	  <img id="cyimg" src="${contextPath}/resources/img/cyimg.png"/><span>자유게시판</span>
        <i class="fas fa-edit" onclick="location.href='${contextPath}/writeBoard.bo'"></i>
        <br>
    <table>
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
    
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>132</td>
            <td>지금은 싸이월드 테스트중이다</td>
            <td>둘리</td>
            <td>2022-02-03</td>
            <td>37</td>
        </tr>
        <tr>
            <td>131</td>
            <td>오늘은 어디로 놀러갈까?</td>
            <td>도롱뇽</td>
            <td>2022-02-03</td>
            <td>49</td>
        </tr>
        <tr>
            <td>130</td>
            <td>유니버셜 스튜디오로 떠나쟈</td>
            <td>와조스키</td>
            <td>2022-02-03</td>
            <td>3</td>
        </tr>
        <tr>
            <td>129</td>
            <td>디즈니랜드는 올렌도</td>
            <td>디즈니</td>
            <td>2022-02-03</td>
            <td>24</td>
        </tr>
        <tr>
            <td>128</td>
            <td>디즈니씨 신난다</td>
            <td>인어공주</td>
            <td>2022-02-03</td>
            <td>29</td>
        </tr>
        <tr>
            <td>127</td>
            <td>양탄자가 세상에서 제일 재밌어</td>
            <td>알라딘</td>
            <td>2022-02-03</td>
            <td>9</td>
        </tbody>
    </table>
    <br>
        <ul>  
        <li><a class="way" href="#">◀</a></li>  
        <li><a href="#">1</a></li>  
        <li><a href="#">2</a></li>  
        <li><a href="#">3</a></li>  
        <li><a href="#">4</a></li>  
        <li><a href="#">5</a></li>  
        <li><a href="#">6</a></li>  
        <li><a href="#">7</a></li>  
        <li><a href="#">8</a></li>  
        <li><a href="#">9</a></li>  
        <li><a href="#">10</a></li>  
        <li><a class="way" href="#">▶</a></li>  
    </ul>
    <br>
    <div class="search-box">
        <select>
            <option>작성자</option>
            <option>제목</option>
            <option>내용</option>
        </select>
        <span action="." method="post">
          <input class="search-txt" type="text" placeholder="검색어를 입력해 주세요">
          <button class="search-btn" type="submit"><i class="fas fa-search"></i></button>
        </span>
    </div>
    <p class="p">Web Site Shortcuts.
        <a href="https://cyworld.com" target="_blank" id="cyLink" >See cyworld MainPage</a>.</p>
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
              <!-- <a href="#" class="menu-item mi-5 menu-checked">마케팅</a> -->
<!--              <div class="menu-item mi-6">게시판</div>-->
<!--              <div class="menu-item mi-7">방명록</div>-->

            </div>
          </div>
        </section>
      </main>
     
        
    </div>

</body>
<script src="${path }/resources/js/y2k.js"></script>
</html>