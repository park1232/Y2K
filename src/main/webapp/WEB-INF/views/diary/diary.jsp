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
    <link rel="stylesheet" href="${contextPath}/resources/css/diary.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="${contextPath}/resources/css/datepicker.css"/>
	<script>
		$( function() {
	    	$("#datepicker").datepicker({dateFormat: 'yy.mm.dd'});
	    	
	    	$("#datepicker").datepicker();
	    	
	        $("#datepicker").on("change",function(){
	    		$("#hiddenDate").val($("#datepicker").val());
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
                     <div id="sideContentDiv" class="desc-wrap text-desc"></div>
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
                  <p class="title"><div id="mainDiv" class="title title-wrap"><a href="#"></a></div></p>
                  <div class="link-wrap">
                    <a href="https://www.instagram.com/hyunjong_yoo/" target="_blank"><span>일촌맺기</span></a>
                    <a href="https://blog.naver.com/hananharu" target="_blank"><span>팬되기</span></a>
                    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p>
                  </div>
                </div>
                <div class="main">
               	 	<form action="${ contextPath }/writeDairy.di?userNo=${userNo}" method="POST">
						<div class="c">
							<h2>날짜별보기</h2>
						</div>
						
						<div class="calendar">
							<div id="datepicker">
								<input type="hidden" id="hiddenDate" name="datepicker">
							</div>
						</div>
						
						<div class="m">
							<h2>지도별보기</h2>
						</div>
						
						<div class="map">
							<img src="${ contextPath }/resources/img/map.png" id="mapImg">
						</div>
						
						
							<div class="write" <c:if test="${ loginUser.userNo ne userNo }">style="display:none;"</c:if>>
								<input type="text" id="mapValue" name="mapValue" readonly>
								<button type="submit" id="writeBtn">글쓰기</button>
							</div>
						
					</form>
					
				        <div class="diary">
				        	<c:forEach items="${ list }" var="d">
					        	<c:set var="date" value="${d.diaryDate}"/>
									<div class="diary_contents" <c:if test="${ d.privacyBounds eq 'closed'&&loginUser.userNo ne userNo }">style="display:none;"</c:if>>
						            	<table>
							            		<tr>
							            			<td width="100px;">${ fn:split(date, '.')[1] }.${ fn:split(date, '.')[2] }</td>
							            			<td style="border-right: none;">${ d.diaryContent }</td>
							            			<td style="border-left: none;">
								            			${ d.boardNo }
								            			<input type="hidden" class="privacy" value="${ d.privacyBounds }">
							            			</td>
							            		</tr>
						            	</table>
									</div>
							</c:forEach>
							
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
<!--              <div class="menu-item mi-6">게시판</div>-->
<!--              <div class="menu-item mi-7">방명록</div>-->
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
    		const diaryLists = document.getElementsByClassName('diary_contents');
			for(const diaryList of diaryLists){
				const tds = diaryList.querySelectorAll('td');
				for(const td of tds){
					td.addEventListener('click', function(){
						const trTds = this.parentElement.querySelectorAll('td');
						const boardNo = trTds[2].innerText;
						location.href='${contextPath}/selectDiary.di?bId=' + boardNo +'&userNo=' + ${userNo};
					});
				}
			}
			
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
					
					$(".bg").css({"background":"url("+skinPath+")"}); 
					
					console.log(skinPath);
					console.log(mainTitle);
					console.log(profilePath);
					console.log(sideContent);
				}
			})
			
			
    		
    	}
    	
    	const writeBtn = document.getElementById('writeBtn');
    	writeBtn.addEventListener('click', function(){
    		if($("#hiddenDate").val() == ''){
    			alert('날짜를 선택해주세요');
    			writeBtn.disabled = true;
    		}
    	});
    	
    	$("#datepicker").on("change",function(){
    	        writeBtn.disabled = false;
    	});
    	
    </script>
  </body>


</html>
    