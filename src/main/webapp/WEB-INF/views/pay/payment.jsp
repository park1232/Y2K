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
<div class="main">
	<div class="wrap">
	    <div class="productImg">
	        <img src="${contextPath}/resources/img/mainSkin1.jpg" style="width: 600px; height: 300px;" alt="My Image">
	    </div>
	    <hr>
	    
	    <h3>별빛 바탕 화면의 스킨 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	    <img src="${contextPath}/resources/img/kumquat.jpg" style="width: 30px; height: 30px;"><span class="price">낑깡 50개</span></h3>
	    
	    <hr>
	    <div id="area">
	    	<p>밤 하늘 별빛 은하수가 보이는 스킨 <br> 지금 구매하세요!</p>
	    </div>
	</div>
	    <div class="orderBtn">
	        <button type="button" class="btn btn-primary" onclick="order()">구매하기</button>
	        <button type="button" class="btn btn-primary" onClick='window.close()'>취소하기</button>
    	</div>
</div>
	<script>
        function order(){
            alert("구매가 완료되었습니다.")
            close();
        }
    </script>

</body>

</html>