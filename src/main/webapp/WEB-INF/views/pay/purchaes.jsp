<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>purchase</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/resources/css/purchaes.css" />
<script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
    <style>
    
    </style> 
  </head>  
<body>
<header>
  <div class="collapse bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
          <h4 class="text-white">Y2K 구매페이지</h4>     
        </div>
        <div class="col-sm-4 offset-md-1 py-4">
          <ul class="list-unstyled">
            <li><a href="#" class="text-white">메인페이지</a></li>
            <li><a href="payment.html" class="text-white">결제페이지</a></li>
            <li><a href="${contextPath}/friend/friendList.html" class="text-white">친구페이지</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <a href="#" class="navbar-brand d-flex align-items-center">
        
        <strong>스킨</strong>
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
</header>

<div class="main">
  <div class="album py-5">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
            <img src="${contextPath}/resources/img/mainSkin1.jpg" style="height: 300px;">

            <div class="card-body">
              <p class="card-text"><strong>별빛 스킨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2022-11-12</strong></p>
              <hr>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-warning" onclick="window.open('detailPurchaes.html', 'detail', 'width=605, height=510')">상세보기</button>
                </div>
               	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h4>낑깡 50개</h4><img src="${contextPath}/resources/img/kumquat.jpg" style="height: 35px; width: 35px;">
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            <img src="${contextPath}/resources/img/mainSkin2.jpg" style="height: 300px;">
            <div class="card-body">
              <p class="card-text"><strong>초록색 스킨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2022-11-12</strong></p>
              <hr>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-warning" onclick="window.open('detailPurchaes.html', 'detail', 'width=605, height=510')">상세보기</button>
                </div>
               	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h4>낑깡 50개</h4><img src="${contextPath}/resources/img/kumquat.jpg" style="height: 35px; width: 35px;">
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            <img src="${contextPath}/resources/img/mainSkin3.jpg" style="height: 300px;">

            <div class="card-body">
              <p class="card-text"><strong>빨간색 스킨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2022-11-12</strong></p>
              <hr>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-warning" onclick="window.open('detailPurchaes.html', 'detail', 'width=605, height=510')">상세보기</button>
                </div>
               	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h4>낑깡 50개</h4><img src="${contextPath}/resources/img/kumquat.jpg" style="height: 35px; width: 35px;">
              </div>
            </div>
          </div>
        </div>

        <div class="col">
          <div class="card shadow-sm">
            <img src="${contextPath}/resources/img/mainSkin4.jpg" style="height: 300px;">

            <div class="card-body">
              <p class="card-text"><strong>파란색 스킨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2022-11-12</strong></p>
              <hr>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-warning" onclick="window.open('detailPurchaes.html', 'detail', 'width=605, height=510')">상세보기</button>
                </div>
               	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h4>낑깡 50개</h4><img src="${contextPath}/resources/img/kumquat.jpg" style="height: 35px; width: 35px;">
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            <img src="${contextPath}/resources/img/mainSkin5.jpg" style="height: 300px;">

            <div class="card-body">
              <p class="card-text"><strong>보라색 스킨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2022-11-12</strong></p>
              <hr>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-warning" onclick="window.open('detailPurchaes.html', 'detail', 'width=605, height=510')">상세보기</button>
                </div>
               	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h4>낑깡 50개</h4><img src="${contextPath}/resources/img/kumquat.jpg" style="height: 35px; width: 35px;">
              </div>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="card shadow-sm">
            <img src="${contextPath}/resources/img/mainSkin6.jpg" style="height: 300px;">

            <div class="card-body">
              <p class="card-text"><strong>분홍색 스킨&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;2022-11-12</strong></p>
              <hr>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-warning" onclick="window.open('detailPurchaes.html', 'detail', 'width=605, height=510')">상세보기</button>
                </div>
                  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h4>낑깡 50개</h4><img src="${contextPath}/resources/img/kumquat.jpg" style="height: 35px; width: 35px;">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
 <div class="search">
	  <select>
     	<option>제목</option>
        <option>설명</option>
     </select>
     <input type="text" placeholder="검색어 입력">
     <button class="search-btn" type="submit"><i class="fas fa-search"></i></button>
</div>

	<br>

	<div>
        <ul class="pagination justify-content-center">
            <li class="page-item disabled">
                <a class="page-link"
                   href="#">
                    <span>처음</span>
                </a>
            </li>
            <li class="page-item disabled">
                <a class="page-link"
                   href="#">
                    <span>이전</span>
                </a>
            </li>
            <li class="page-item active">
                <a class="page-link"
                   href="#">1</a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="#">2</a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="#">3</a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="#">
                    <span>다음</span>
                </a>
            </li>
            <li class="page-item">
                <a class="page-link"
                   href="#">
                    <span>마지막</span>
                </a>
            </li>
        </ul>
    </div>
    <br>
</div>
<footer class="sticky-footer bg-white">
        <footer class="footer d-flex p-2 px-3 bg-white border-top">
              <a href="https://github.com/likelion-backendschool/DAMDA_project" rel="nofollow" target="_blank">Y2K</a>
        </footer>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>
    