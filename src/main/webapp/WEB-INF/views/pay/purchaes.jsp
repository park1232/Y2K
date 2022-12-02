<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>purchase</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/resources/css/purchaes.css" />
<script src="https://kit.fontawesome.com/7a738a6e1a.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
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
            <li><a href="${contextPath}/main.lo" class="text-white" target="_blank">메인페이지</a></li>
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
      <a href="${contextPath}/purchaes.pa" class="navbar-brand d-flex align-items-center">
        <strong>스킨</strong>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
        					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;낑깡 개수 : ${ conutOrange }    
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
		  	<!-- 게시글 foreach문 -->
		  	<c:forEach items="${ pList }" var="p">
		        <div class="col">
		          <div class="card shadow-sm">
		          <!-- 이미지 foreach문 -->
		          	<c:forEach items="${ photoList }" var="photo">
						<c:if test="${ p.productNo eq photo.productNo }">
			            		<img src="/upload/${ photo.productReNameName }" style="height: 300px;">
			            		<input type="hidden" value='${ photo.productPhotoName }' name="productPhotoName">
						</c:if>
					</c:forEach>
		            <div class="card-body">
		            <div class="productNo"></div>
		              <p class="card-text"><strong>${ p.productName }&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;${ p.productCreateDate }</strong></p>
		              <hr>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <button type="button" class="btn btn-warning" id="detailpurchaes" value="${ p.productNo }">상세보기</button>
		                </div>
		               	  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<h4>낑깡 ${ p.price }개</h4><img src="${contextPath}/resources/img/kumquat.jpg" style="height: 35px; width: 35px;">
		              </div>
		            </div>
		          </div>
		        </div>
	        </c:forEach>
	      </div>
	    </div>
	  </div>
	
		<br>
	
		<div class="pagingArea">
	        <ul class="pagination justify-content-center">
	            <li class="page-item">
	           		<c:url var="PListFirst" value="${ loc }"> <!--  직접적으로 주소를 가져오지않아도 select주소를 가져오는것 loc -->
						<c:param name="page" value="1"/>
					</c:url>
					<c:if test="${ pi.payCurrentPage <= 1 }">
						<a class="page-link">
	                    	<span>처음</span>
	                	</a>
					</c:if>
					<c:if test="${ pi.payCurrentPage > 1 }">
		                <a class="page-link" href="${ PListFirst }">
		                    <span>처음</span>
		                </a>
	                </c:if>
	            </li>
	            <li class="page-item">
	            	<c:url var="PListBack" value="${ loc }">
						<c:param name="page" value="${ pi.payCurrentPage -1 }"/>
					</c:url>
					<c:if test="${ pi.payCurrentPage <= 1 }">
		                <a class="page-link">
	                    	<span>이전</span>
	                	</a>
	                </c:if>
	                <c:if test="${ pi.payCurrentPage > 1 }">
						<a class="page-link" href="${ PListBack }">
	                    	<span>이전</span>
	                	</a>
					</c:if>          
	            </li>			
	            <li class="page-item">
	            	<c:forEach begin="${ pi.payStartPage }" end="${ pi.payEndPage }" var="p">
	            		<c:if test="${ pi.payCurrentPage eq p }">
							<a class="page-link">
								<font color="red">${ p }</font>
							</a>
						</c:if>
						<c:if test="${ pi.payCurrentPage ne p }">
							<c:url var="PListCheck" value="${ loc }">
								<c:param name="page" value="${ p }"/>
							</c:url>
							<li class="page-item"><a class="page-link" href="${ PListCheck }">${ p }</a></li>
						</c:if>
	            	</c:forEach>
	            </li>
	            <li class="page-item">
	            	<c:url var="PListNext" value="${ loc }"> <!--  직접적으로 주소를 가져오지않아도 select주소를 가져오는것 loc -->
						<c:param name="page" value="${ pi.payCurrentPage + 1 }"/>
					</c:url>
					<c:if test="${ pi.payCurrentPage >= pi.payMaxPage }">
						<a class="page-link">
	                    	<span>다음</span>
	                	</a>
					</c:if>
					<c:if test="${ pi.payCurrentPage < pi.payMaxPage }">
						<a class="page-link" href="${ PListNext }">
							<span>다음</span>
						</a>
					</c:if>
	            </li>
	            <li class="page-item">
	            	<c:url var="PListLast" value="${ loc }"> <!--  직접적으로 주소를 가져오지않아도 select주소를 가져오는것 loc -->
						<c:param name="page" value="${ pi.payMaxPage }"/>
					</c:url>
					<c:if test="${ pi.payCurrentPage >= pi.payMaxPage }">
						<a class="page-link">
	                    	<span>마지막</span>
	                	</a>
					</c:if>
					<c:if test="${ pi.payCurrentPage < pi.payMaxPage }">
						<a class="page-link" href="${ PListLast }">
							<span>마지막</span>
						</a>
					</c:if>
	            </li>
	        </ul>
	    </div>

 <!-- c:if 로 로그인 유저만 작성할 수 있게 로그인 구현되면 작성 -->
 		<c:if test="${ userRole eq 'ROLE_ADMIN' }">
	 		<div id="writerPurchaes">
		    	<button type="button" class="btn btn-primary" onclick="location.href='${ contextPath }/writePurchaes.pa'">작성하기</button>
		    </div>
		</c:if>
	    <br>

	</div>
<footer class="sticky-footer bg-white" style="height: 15px;">
        <div class="main-footer d-flex p-2 px-3 bg-white border-top">
              <a href="https://github.com/bmm522/Y2K">Y2K</a>
        </div>
</footer>	
<script>
	const datas = document.getElementsByClassName('btn btn-warning');
	for(const data of datas) {
		 data.addEventListener('click', function(){		
			const productNo = this.value;  
			const url = '${ contextPath }/selectPurchaes.pa?productNo=' + productNo + '&productPhotoName=' + "${photo.productPhotoName}";
			window.open(url , "detail", "width=630, height=530, scrollbars=no, resizable=no, toolbars=no, menubar=no");
		 });
	} 
	
	window.setTimeout('window.location.reload()', 5000);
</script>
</body>
</html>
    