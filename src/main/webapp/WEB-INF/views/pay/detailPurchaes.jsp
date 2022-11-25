<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<div class="main">
	<form class="needs-validation" method="POST" id="detailForm">
			<div class="wrap">
			    <div class="productImg">
				    <c:if test="${ p.productNo eq photo.productNo }">
				        <c:if test="${ fn:containsIgnoreCase(photo.productReNameName, 'jpg') or fn:containsIgnoreCase(photo.productReNameName, 'png') }">
				        	<img src="/upload/${ photo.productReNameName }" style="width: 600px; height: 300px;" alt="My Image">
				    	</c:if>
					</c:if>
			    </div>
			    <input type="hidden" value='${ p.productNo }' name="productNo">
			    <input type="hidden" value='${ p.price }' name="price">
			    <hr>
			    <h3>${ p.productName } &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			    &emsp;&emsp;&emsp;&emsp;&emsp;<img src="${contextPath}/resources/img/kumquat.jpg" style="width: 30px; height: 30px;"><span class="price">낑깡 ${ p.price }개</span></h3>

			    <hr>
			    <div id="area">
			    	<p>${ p.productContent } <br> 지금 구매하세요!</p>        
			    </div>
			</div>
			    <div class="orderBtn">
			        <button type="button" class="btn btn-primary" id="order">구매하기</button>
			        <button type="button" class="btn btn-primary" onClick='window.close()'>취소하기</button>
			        <!-- 로그인 구현되면 if:test넣기 -->
					<c:if test="${ userRole eq ROLE_ADMIN }">
			        	<button type="button" class="btn btn-primary" id="delete">삭제하기</button>
			        	<button type="button" class="btn btn-primary" id="update">수정하기</button>
			        </c:if>        
		    	</div>
	</form>
</div>
	<script>
        window.onload = () =>{
        	const deleteForm = document.getElementById('detailForm');
        	document.getElementById("delete").addEventListener('click', ()=>{
				deleteForm.action = '${contextPath}/deletePurchaes.pa';
				deleteForm.submit();
        	});
			
        	const orderForm = document.getElementById('detailForm');
		    document.getElementById("order").addEventListener('click', ()=>{
				orderForm.action = '${contextPath}/orderPurchaes.pa';
				orderForm.submit();
			});
		    
		    const updateForm = document.getElementById('detailForm');
		    document.getElementById("update").addEventListener('click', ()=>{
				updateForm.action = '${contextPath}/updatePurchaes.pa';
				updateForm.submit();
			});		
        } 
    </script>

</body>
</html>