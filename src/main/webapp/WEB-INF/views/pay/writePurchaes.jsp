<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>purchaes</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="${contextPath}/resources/css/detailPurchaes.css" />
    <style>
        
    </style>
</head>
<body>
<header>
  <div class="collapse bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
          <h4 class="text-white">Y2K 구매 글쓰기 페이지</h4>     
        </div>
        <div class="col-sm-4 offset-md-1 py-4">
          <ul class="list-unstyled">
            <li><a href="${contextPath}/loginSuccess.lo" class="text-white">메인페이지</a></li>
            <li><a href="${contextPath}/payment.pa" class="text-white">결제페이지</a></li>
            <li><a href="${contextPath}/friendList.fr" class="text-white">친구페이지</a></li>
            <li><a href="${contextPath}/friendRequestList.fr" class="text-white">친구 요청 페이지</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <a href="${contextPath}/writerPurchaes.pa" class="navbar-brand d-flex align-items-center">
        
        <strong>구매 게시글 글쓰기</strong>
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
</header>
<br>
	<div class="main">
		<form class="needs-validation" action="${ contextPath }/insertPurchaes.pa" method="POST" enctype="multipart/form-data" id="purchaesForm"> <!-- 사진을 넣을 곳을 설정하려면 enctype 타입을 설정해 줘야한다 -->
			<div class="row g-3">
				<div class="col-12">
					<label for="productName" class="form-label">제목</label>
					<input type="text" class="form-control" id="productName" name="productName">
				</div>

			<div class="col-12">
				<div class="input-group">
		         	<span class="input-group-text">내용</span>
			        <textarea class="form-control" rows="10" name="productContent" style="resize: none;"></textarea>
				</div>
			</div>
						
			<div class="col-12">
					<label for="purchaesPrice" class="form-label">가격</label>
					<input type="text" class="form-control" id="price" name="price">
			</div>
						
			<div id="fileArea">
				<div class="mb-3">
					<input type="file" class="form-control form-control-lg" name="file">
				</div>
					</div>
						<br><br><br>
						
			<div class="orderBtn">
				<button class="btn btn-primary">작성하기</button>
				<button type="button" class="btn btn-primary" onclick="javascript:history.back();">취소하기</button>
			</div>
				</div>
		</form>
	</div>
				
	<script>		
		const form = document.getElementById('purchaesForm');
		document.getElementById('submitPurchaes').addEventListener('click', ()=>{
			const files = document.getElementsByName('file');
			let isEmpty = true;
			for(const f of files){
				if(f.value != ''){
					isEmpty = false;
				}
			}
		
			if(isEmpty){
				alert('사진을 첨부하지 않으셨습니다.');
			} else {
				form.submit();
			}
		}); 
    </script>

</body>
</html>