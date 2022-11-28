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
    <link rel="stylesheet" href="${contextPath}/resources/css/diary2.css" />
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
                    <script src="https://kit.fontawesome.com/203ce9d742.js" crossorigin="anonymous"></script>
                  </div>
                </div>
                <form id="detailForm" method="POST">
	                <div class="main">
	                	<h1>${ d.diaryDate }</h1>
	                	<table>
	                		<tr>
	                			<td>
	                				<c:if test="${ d.weather == 'sunny' }">☀맑음</c:if>
	                				<c:if test="${ d.weather == 'cloudy' }">☁흐림</c:if>
	                				<c:if test="${ d.weather == 'rain' }"> 🌨비</c:if>
	                				<c:if test="${ d.weather == 'snow' }">❄눈</c:if>
	                			</td>
	                			<td>
	                				<c:if test="${ d.mood == 'joy' }">😄기쁨</c:if>
	                				<c:if test="${ d.mood == 'sad' }">😭슬픔</c:if>
	                				<c:if test="${ d.mood == 'mad' }">😡화남</c:if>
	                				<c:if test="${ d.mood == 'tired' }">🥱피곤</c:if>
	                				<c:if test="${ d.mood == 'happy' }">😆행복</c:if>
	                				<c:if test="${ d.mood == 'bisy' }">😵바쁨</c:if>
	                			</td>
	                			<td><i class="fa-solid fa-location-dot"></i>${ d.location }</td>
	                			<td>
	                				<c:if test="${ d.privacyBounds == 'public' }">전체공개</c:if>
	                				<c:if test="${ d.privacyBounds == 'closed' }">비공개</c:if>
	                			</td>
	                		</tr>
	                	</table>
	                	
	                	<hr>
	                	
	                	<div class="diary">
	                		${ d.diaryContent }
	                	</div>
	                	
	                	<input type="hidden" value="${ d.boardNo }" name="boardNo">
	                	
	                	<hr class="hr2">
	                	
	                	<table id="info">
	                		<tr>
		                		<td><button type="button" id="updateDiary">수정하기</button></td>
		                		<td><button type="button" id="deleteDiary">삭제하기</button></td>
		                	</tr>
	                	</table>
	                	
	                	<div class="comment">
	                		<div class="write">
	                			<textarea id="replyContent" placeholder="댓글을 작성해주세요"></textarea>
	                			<button type="button" id="replySubmit">등록하기</button>
	                		</div>
	                		<div class="comm">
	                			<table>
	                				<tbody id="replyTbody">
	                					<c:forEach items="${ list }" var="r">
			                				<tr class="replyNickName">
			                					<td width="100px">${ r.nickName }</td>
<%-- 			                					<td>${ r.rModifyDate }</td> --%>
			                				</tr>
			                				<tr class="replyContent">
			                					<td colspan="2">${ r.replyContent }</td>
			                					<td><button class="deleteReply" type="button">x</button></td>
			                				</tr>
		                				</c:forEach>
	                				</tbody>
	                			</table>
	                		</div>
	                	</div>
	              </div>
              </form>
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
          </div>
        </section>
      </main>
      
    </div>
    <script>
    	window.onload = () =>{
	    	document.getElementById('replySubmit').addEventListener('click', ()=>{
	    		$.ajax({
	    			url: '${contextPath}/insertReply.di',
	    			data: {replyContent: document.getElementById('replyContent').value,
	    				   rboardNo:${d.boardNo}, replyWriter: '${loginUser.userNo}'},
	    			success: (data)=>{
	    				console.log(data);
	    				console.log(typeof(data));
	    				const tbodys = document.getElementById('replyTbody');
	    				
	    				tbodys.innerHTML = '';
	    				
	    				for(const r of data){
	    					console.log(r);
	    					const tr1 = document.createElement('tr');
	    					const tr2 = document.createElement('tr');
	    					
	    					const writerTd = document.createElement('td');
	    					writerTd.innerText = r.nickName;
	    					const contentTd = document.createElement('td');
	    					contentTd.innerText = r.replyContent;
	    					
	    					tr1.append(writerTd);
	    					tr2.append(contentTd);
	    					
	    					tbodys.append(tr1);
	    					tbodys.append(tr2);
	    				}
	    				document.getElementById('replyContent').value = '';
	    			},
	    			error: (data)=>{
	    				console.log(data);
	    			}
	    		});
	    	});
	    	
	    	const upd = document.getElementById('updateDiary');
	    	if(upd != null){
	    		upd.addEventListener('click', ()=>{
	    			form.action = '${contextPath}/updateForm.di';
	    			form.submit();
	    		});
	    	}
    		
	    	const form = document.getElementById('detailForm');
	       	document.getElementById('deleteDiary').addEventListener('click', ()=>{
	    		if(confirm('정말로 삭제하시겠습니까?')){
	    			form.action = 	'${contextPath}/deleteDiary.di';
	    			form.submit();
	    		}
	    	});
       	
    	}
    </script>
  </body>


</html>
