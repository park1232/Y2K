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
  <div class="collapse bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
          <h4 class="text-white">Y2K 친구페이지</h4>     
        </div>
        <div class="col-sm-4 offset-md-1 py-4">
          <ul class="list-unstyled">
            <li><a href="#" class="text-white">메인페이지</a></li>
            <li><a href="${contextPath}/pay/payment.html" class="text-white">결제페이지</a></li>
            <li><a href="${contextPath}/pay/purchaes.html" class="text-white">구매페이지</a></li>
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
<div class="main">
   <table class="table">
  <thead>
    <tr>
      <th scope="col">인원목록</th>
      <th scope="col">이름</th>
      <th scope="col">닉네임</th>
      <th scope="col">나이</th>
      <th scope="col">친구삭제</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">3</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">4</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">5</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">6</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">7</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">8</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">9</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
    <tr>
      <th scope="row">10</th>
       <td>박규민</td>
      <td>KH</td>
      <td>28</td>
      <td><input type="checkbox" id="friend" name="using"></td>
    </tr>
  </tbody>
</table>
<div class="search">
	 <select>
     	<option>이름</option>
        <option>닉네임</option>
        <option>나이</option>
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
    <div class="friendOption">
	    <button type="button" class="btn btn-primary" onclick="window.open('friendAdd.html', 'friendAdd', 'width=460, height=570')">친추추가</button>
	    <button type="button" class="btn btn-primary">친구삭제</button>
    </div>
</div>
</body>
<br><br><br><br><br><br><br><br>
<footer class="sticky-footer bg-white">
        <footer class="main-footer d-flex p-2 px-3 bg-white border-top">
              <a>Y2K</a>
        </footer>
</footer>
</html>