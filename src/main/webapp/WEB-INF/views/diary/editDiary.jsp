<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="stylesheet" href="${contextPath}/resources/css/diary3.css?after" />
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

                </div>
                <div class="profile">
                  <p class="todayis">
                    TODAY IS .. <i>♥</i><span> 행복</span>
                  </p>
                  <img class="profile-img" src="${contextPath}/resources/img/profile.jpg" alt="profile" id="profileImage"/>
                  <div class="desc-wrap">
                    <p class="text-desc">
                     <div id="sideContentDiv" class="desc-wrap text-desc"></div>
                    <a class="history" href="#">HISTORY</a>
                  </div>
                   <div class="info-wrap" id="ownerNickname">
                    <a class="info-name" href="#"></a>
               <!--      <p class="text-email">guswhd956@naver.com</p> -->
                  </div>
                  <div class="profile-dropdown">
                    <div class="dropdown-btn">
                      <div class="dropdown-title">친구로 파도타기</div>
                      <div class="triangle-down"></div>
                    </div>
                     <div class="dropdown-content" <c:if test="${ loginUser.userNo ne userNo }">style="display:none;"</c:if>>
                    	<c:forEach var="friendList" items="${sessionScope.friendPathList}">
                    		<a href="${friendList.friendPath}"  target="_blank">${friendList.friendNickname }</a>
                    	</c:forEach>
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
                  <p class="title"><div id="mainDiv" class="title title-wrap"><a href="#"></a></div></p>
                  <div class="link-wrap">
                      <a href="${contextPath}/mypage.my"><span>Mypage&nbsp&nbsp</span></a><br>
                    <a href="${contextPath}/friendList.fr"><span>Friend&nbsp&nbsp</span></a>
                   
                  </div>
                </div>
                <div class="main">
                	<form action="${ contextPath }/updateDiary.di?userNo=${ userNo }" method="POST">
                	<h1>${ d.diaryDate }</h1>
                	<input type="hidden" id="diaryDate" name="diaryDate" value="${ d.diaryDate }">
                	<input type="hidden" id="boardNo" name="boardNo" value="${ d.boardNo }">
                	<table>
                		<tr>
                			<td>
                				<div class="selectBox">
								  <select name="weather" class="select">
								    <option disabled selected>날씨⭐</option>
								    <option value="sunny" <c:if test="${ d.weather == 'sunny' }">selected</c:if>>☀맑음</option>
								    <option value="cloudy" <c:if test="${ d.weather == 'cloudy' }">selected</c:if>>☁흐림</option>
								    <option value="rain" <c:if test="${ d.weather == 'rain' }">selected</c:if>>🌧비</option>
								    <option value="snow" <c:if test="${ d.weather == 'snow' }">selected</c:if>>❄눈</option>
								  </select>
								  <span class="icoArrow"></span>
								</div>
                			</td>
                			<td>
                				<div class="selectBox">
								  <select name="mood" class="select">
								    <option disabled selected>기분💕</option>
								    <option value="joy" <c:if test="${ d.mood == 'joy' }">selected</c:if>>😄기쁨</option>
								    <option value="sad" <c:if test="${ d.mood == 'sad' }">selected</c:if>>😭슬픔</option>
								    <option value="mad" <c:if test="${ d.mood == 'mad' }">selected</c:if>>😡화남</option>
								    <option value="tired" <c:if test="${ d.mood == 'tired' }">selected</c:if>>🥱피곤</option>
								    <option value="happy" <c:if test="${ d.mood == 'happy' }">selected</c:if>>😆행복</option>
								    <option value="bisy" <c:if test="${ d.mood == 'bisy' }">selected</c:if>>😵바쁨</option>
								  </select>
								  <span class="icoArrow"><img src="https://freepikpsd.com/media/2019/10/down-arrow-icon-png-7-Transparent-Images.png" alt=""></span>
								</div>
                			</td>
                			<td>
                				<div class="map" id="mapValue">${ d.location }</div>
                				<input type="hidden" id="location" name="location">
                			</td>
                			<td>
                				<div class="selectBox">
								  <select name="privacyBounds" class="select">
								    <option disabled selected>공개범위💌</option>
								    <option value="public" <c:if test="${ d.privacyBounds == 'public' }">selected</c:if>>전체공개</option>
								    <option value="closed" <c:if test="${ d.privacyBounds == 'closed' }">selected</c:if>>비공개</option>
								  </select>
								  <span class="icoArrow"><img src="https://freepikpsd.com/media/2019/10/down-arrow-icon-png-7-Transparent-Images.png" alt=""></span>
								</div>
                			</td>
                		</tr>
                	</table>
                	
                	<hr>
                	
                	<textarea class="diary" name="diaryContent">${ d.diaryContent }</textarea>
                	
                	
                	<hr class="hr2">
                	
						<button id="editBtn" type="submit">수정하기</button>
					</form>
                </div>
              </div>
              <div class = "menu align-center expanded text-center SMN_effect-68">
	              <a href="${contextPath}/mainPage.ma?userNo=${userNo}" class="menu-item mi-1" >홈</a>
	<!--              <a href="photo.html" class="menu-item mi-2" onclick="openPopup()">사진첩</a>-->
	
	              <a href="${contextPath}/photo.ph?userNo=${userNo}" class="menu-item mi-2">사진첩</a>
              </div>
              <a href="${contextPath}/diary.di?userNo=${userNo}" class="menu-item mi-3 menu-checked">다이어리</a>
              <div class = "menu align-center expanded text-center SMN_effect-68">
	              <a href="${contextPath}/visit.vi?userNo=${userNo}" class="menu-item mi-4">방명록</a>
	              <a href="${contextPath}/boardList.bo?userNo=${userNo}" class="menu-item mi-5">게시판</a>
              </div>

            </div>
          </div>
        </section>
      </main>
      
    </div>
    <script>
	    $(".map").click(function(){
			var url = "map.di";
			var name = "map popup"
			var option = "width= 610, height= 560"
			window.open(url, name, option);
		});
	    
window.onload = () =>{
    		
    		let skinPath = "";
    		let mainTitle = "";
    		let profilePath = "";
    		let sideContent = "";
    		let myUserNo = "";
    		
    		if("${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.userNo}" != "${userNo}"){
    			myUserNo = "${userNo}";
    		} else {
    			myUserNo = "${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.member.userNo}";
    		}
    		console.log("boardList : " + myUserNo);
    		let params={
    				userNo : myUserNo
    		}
    		
    		$.ajax({
    			type:"GET",
    			url:"/onload.my",
    			data : params,
    			success:function(res){
    				skinPath = res.skinPath;
    				mainTitle = res.mainTitle;
    				profilePath = res.profilePath;
    				sideContent = res.sideContent;
    				document.getElementById('sideContentDiv').innerHTML = sideContent;
    				document.getElementById('mainDiv').innerHTML = mainTitle;
    				document.getElementById('ownerNickname').innerHTML = res.ownerNickname;
    				$(".bg").css({"background":"url("+skinPath+")"}); 
    				jQuery('#profileImage').attr("src", profilePath);
    				console.log(skinPath);
    				console.log(mainTitle);
    				console.log(profilePath);
    				console.log(sideContent);
    			}
    		});
}
	    
    </script>
  </body>


</html>
    