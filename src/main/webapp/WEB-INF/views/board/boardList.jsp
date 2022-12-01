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
    <link rel="stylesheet" href="${contextPath}/resources/css/board.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
	<style>body{margin:0; padding:0;} td{cursor: pointer;}</style>
</head>
<body id="b_body">
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
                  <p class="title"><div id="mainDiv" class="title title-wrap"><a href="#"></a></div></p>
                  <div class="link-wrap">
                    <a href="https://www.instagram.com/hyunjong_yoo/" target="_blank"><span>일촌맺기</span></a>
                    <a href="https://blog.naver.com/hananharu" target="_blank"><span>팬되기</span></a>
                    <p><a href="#">https://www.cyowrld.com/marketer_JJ</a></p>
                  </div>
                </div>
	<div class="main">
	
	  <img id="cyimg" src="${contextPath}/resources/img/cyimg.png"/><br>
	  <div id="boardMain" onclick="location.href='${contextPath}/boardList.bo?userNo=${userNo}'">Y2K WORLD</div>
        <div id="writeStyle" <c:if test="${ loginUser.userNo eq userNo }">style="display:none;"</c:if>><i class="fas fa-edit" onclick="location.href='${contextPath}/boardWrite.bo?userNo=${userNo}'"></i></div>
        <input hidden="hidden" value="${userNo}" name="userNo">
        <br>
    <table>
        <thead>
	        <tr>
	            <th>글번호</th>
	            <th>제목</th>
	            <th>작성자</th>
	            <th>작성일</th>
	            <th>조회수</th>
	    
	        </tr>
    	</thead>
        <tbody>
        	<c:forEach items="${list}" var="b">	
	        <tr>
	            <td>${b.boardNo}</td>
	            <td>${b.boardTitle}</td>
	            <td>${b.nickName}</td>
	            <td>${b.createDate}</td>
	            <td>${b.boardCount}</td>
	        </tr>
        	</c:forEach>
        </tbody>
    </table>
    <br>
        <ul>  
        <li>
        <c:url var="back" value="${loc}">
        	<c:param name="page" value="${pi.currentPage - 1}"></c:param>
        	<c:param name="userNo" value="${userNo}"/>
        </c:url>
        <a class="way" href="${back}">◀</a>
        </li>    
        
        
         <li>
            	<c:forEach begin="${pi.startPage}" end="${pi.endPage}" var="p">
            		<c:if test="${ pi.currentPage eq p }">
						<li><a>${ p }</a></li>
					</c:if>
					<c:if test="${ pi.currentPage ne p }">
						<c:url var="goNum" value="${ loc }">
							<c:param name="page" value="${ p }"/>
							<c:param name="userNo" value="${userNo}"/>
						</c:url>
	            		<li class="page-item"><a class="page-link" href="${goNum}">${ p }</a></li>
					</c:if>
            	</c:forEach>
         </li>
	                      
        <li>
        <c:url var="next" value="${loc}">
        	<c:param name="page" value="${pi.currentPage + 1}"></c:param>
        	<c:param name="userNo" value="${userNo}"/>
        </c:url>
        <a class="way" href="${next}">▶</a>
        </li>  
    </ul>
    <br>
    <div class="searchArea">
        <select id="searchCondition" name="searchCondition">
            <option>---------</option>
            <option value="writer">작성자</option>
            <option value="title">제목</option>
            <option value="content">내용</option>
        </select>
        
          <input id="searchValue" type="search" placeholder="검색어를 입력해 주세요">
          <button id="searchBoardButton" onclick="searchBoard();"><i class="fas fa-search"></i></button>
    </div>
    <p class="p">Web Site Shortcuts.
        <a href="https://cyworld.com" target="_blank" id="cyLink" >See cyworld MainPage</a>.</p>
	</div>
			
	</div>
   <div class = "menu align-center expanded text-center SMN_effect-68">
           <a href="${contextPath}/mainPage.ma?userNo=${userNo}">   <div class="menu-item mi-1"  onclick="location.href='${contextPath}'">홈</div></a>
<!--              <a href="photo.html" class="menu-item mi-2" onclick="openPopup()">사진첩</a>-->

              <a href="${contextPath}/photo.ph?userNo=${userNo}" class="menu-item mi-2" >사진첩</a>
              <a href="${contextPath}/diary.di?userNo=${userNo}" class="menu-item mi-3">다이어리</a>
 </div>
  <div class = "menu align-center expanded text-center SMN_effect-68">
 <a class="menu-item mi-4" onclick="location.href='${contextPath}/visit.vi?userNo=${userNo}'">방명록</a>
             </div>
              <a class="menu-item mi-5 menu-checked" onclick="location.href='${contextPath}/boardList.bo?userNo=${userNo}'">게시판</a>
             
             
                
              
              <!-- <a href="#" class="menu-item mi-5 menu-checked">마케팅</a> -->
<!--              <div class="menu-item mi-6">게시판</div>-->	
<!--              <div class="menu-item mi-7">방명록</div>-->

            </div>
          </div>
        </section>
      </main>
    </div>
	<script>
    	window.onload = () => {
    		
    		
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
    				
    				$(".bg").css({"background":"url("+skinPath+")"}); 
    				
    				console.log(skinPath);
    				console.log(mainTitle);
    				console.log(profilePath);
    				console.log(sideContent);
    			}
    		})
    		
    		
    		
    		
    		
    		
    		const tbody = document.querySelector('tbody');
    		const tds = tbody.querySelectorAll('td');
    		for(const td of tds) {
    			td.addEventListener("click", function(){
    				const trTds = this.parentElement.querySelectorAll('td'); //세로 한줄 td
    				const boardNo = trTds[0].innerText;
    				const writer = trTds[2].innerText;
    				location.href='${contextPath}/selectBoard.bo?bNo=' + boardNo + '&writer=' + writer + '&page=' + ${pi.currentPage} + '&userNo=' + ${userNo};
    			});
    		}
    	
    		
    	}
		const searchBoard = () => {
				
				 const searchCondition = document.getElementById("searchCondition").value;
				 const searchValue = document.getElementById("searchValue").value;
				 
				 location.href='${contextPath}/search.bo?searchCondition=' + searchCondition + "&searchValue=" + searchValue;
				
		}
		
		

	
		
		
    </script>

</body>
</html>