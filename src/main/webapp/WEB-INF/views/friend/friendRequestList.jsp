<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/friendList.css" />
<style>
	
</style>
</head>
<body>
<header>
${ requestList }
  <div class="collapse bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
          <h4 class="text-white">Y2K 친구페이지</h4>     
        </div>
        <div class="col-sm-4 offset-md-1 py-4">
          <ul class="list-unstyled">
            <li><a href="#" class="text-white">메인페이지</a></li>
            <li><a href="${contextPath}/friendment.pa" class="text-white">결제페이지</a></li>
            <li><a href="${contextPath}/purchaes.pa" class="text-white">구매페이지</a></li>
            <li><a href="${contextPath}/friendList.fr" class="text-white">친구페이지</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <a href="#" class="navbar-brand d-flex align-items-center">
        
        <strong>친구</strong>
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
</header>
${ fAList }
<div class="main">
 <table class="table">
  <thead>
    <tr>
      <th scope="col" width="360px">친구 신청 목록</th>
      <th scope="col" width="360px">ID</th>
      <th scope="col" width="360px">닉네임</th>
      <th scope="col" width="360px">상세보기</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${ fList }" var="fl">
	    <tr>
	      <th scope="row">count</th>
	      <td>${ fl.username }</td>
	      <td>${ fl.nickName }</td>
	      <td><button type="button" class="btn btn-primary" onclick="window.open('friendAccept.html', 'friendAdd', 'width=460, height=570')">상세보기</button></td>
	    </tr>
    </c:forEach>
  </tbody>
</table>
<div class="search">
	 <select>
     	<option>ID</option>
        <option>닉네임</option>
     </select>
     <input type="text" placeholder="검색어 입력">
     <button class="search-btn" type="submit"><i class="fas fa-search"></i></button>
</div>

<br>
	<div class="pagingArea">
        <ul class="pagination justify-content-center">
	            <li class="page-item">
	           		<c:url var="FListFirst" value="${ loc }"> <!--  직접적으로 주소를 가져오지않아도 select주소를 가져오는것 loc -->
						<c:param name="page" value="1"/>
					</c:url>
					<c:if test="${ pi.friendCurrentPage <= 1 }">
						<a class="page-link">
	                    	<span>처음</span>
	                	</a>
					</c:if>
					<c:if test="${ pi.friendCurrentPage > 1 }">
		                <a class="page-link" href="${ FListFirst }">
		                    <span>처음</span>
		                </a>
	                </c:if>
	            </li>
	            <li class="page-item">
	            	<c:url var="FListBack" value="${ loc }">
						<c:param name="page" value="${ pi.friendCurrentPage -1 }"/>
					</c:url>
					<c:if test="${ pi.friendCurrentPage <= 1 }">
		                <a class="page-link">
	                    	<span>이전</span>
	                	</a>
	                </c:if>
	                <c:if test="${ pi.friendCurrentPage > 1 }">
						<a class="page-link" href="${ FListBack }">
	                    	<span>이전</span>
	                	</a>
					</c:if>          
	            </li>			
	            <li class="page-item">
	            	<c:forEach begin="${ pi.friendStartPage }" end="${ pi.friendEndPage }" var="p">
	            		<c:if test="${ pi.friendCurrentPage eq p }">
							<a class="page-link">
								<font color="red">${ p }</font>
							</a>
						</c:if>
						<c:if test="${ pi.friendCurrentPage ne p }">
							<c:url var="FListCheck" value="${ loc }">
								<c:param name="page" value="${ p }"/>
							</c:url>
							<li class="page-item"><a class="page-link" href="${ FListCheck }">${ p }</a></li>
						</c:if>
	            	</c:forEach>
	            </li>
	            <li class="page-item">
	            	<c:url var="FListNext" value="${ loc }"> <!--  직접적으로 주소를 가져오지않아도 select주소를 가져오는것 loc -->
						<c:param name="page" value="${ pi.friendCurrentPage + 1 }"/>
					</c:url>
					<c:if test="${ pi.friendCurrentPage >= pi.friendMaxPage }">
						<a class="page-link">
	                    	<span>다음</span>
	                	</a>
					</c:if>
					<c:if test="${ pi.friendCurrentPage < pi.friendMaxPage }">
						<a class="page-link" href="${ FListNext }">
							<span>다음</span>
						</a>
					</c:if>
	            </li>
	            <li class="page-item">
	            	<c:url var="FListLast" value="${ loc }"> <!--  직접적으로 주소를 가져오지않아도 select주소를 가져오는것 loc -->
						<c:param name="page" value="${ pi.friendMaxPage }"/>
					</c:url>
					<c:if test="${ pi.friendCurrentPage >= pi.friendMaxPage }">
						<a class="page-link">
	                    	<span>마지막</span>
	                	</a>
					</c:if>
					<c:if test="${ pi.friendCurrentPage < pi.friendMaxPage }">
						<a class="page-link" href="${ FListLast }">
							<span>마지막</span>
						</a>
					</c:if>
	            </li>
	        </ul>
    	</div>
</div>
    <br>
<br>
  
<br>
<div>
</div>
</body>
<br>
<footer class="sticky-footer bg-white" style="height: 5px;">
        <div class="main-footer d-flex p-2 px-3 bg-white border-top">
              <a href="#">Y2K</a>
        </div>
</footer>
</html>