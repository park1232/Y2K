<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/upload.css" />
    <title>Document</title>
</head>
<body>
    <!--사진 업로드페이지 중앙배치-->
    <main class="uploadContainer">
        <!--사진업로드 박스-->
         <section class="upload">
            
            <!--사진업로드 로고-->
             <div class="upload-top">
                 <a href="" class="">
                     <img src="" alt="">
                 </a>
                 <p>사진 업로드</p>
             </div>
             <!--사진업로드 로고 end-->
             
             <form class="upload-form" action="/image" method="post" enctype="multipart/form-data">
                    <input  type="file" name="file"  onchange="imageChoose(this)" />
                    <div class="upload-img">
                        <img src="../resources/img/duck.jpg" alt="" id="imageUploadPreview" />
                    </div>
                 
                 <!--사진설명 + 업로드버튼-->
                 <div class="upload-form-detail">
                       <input type="text" placeholder="사진설명" name="photoComent" >  <!-- key=value로 날라감 -->
                     <button class="cta blue"  id="upload" disabled='disabled' onClick='window.close()'>업로드</button>
                 </div>
                 <!--사진설명end-->
                 
             </form>
             <!--사진업로드 Form-->
         </section>
         <!--사진업로드 박스 end-->
     </main>
     
     <script src="${contextPath}/resources/js/upload.js"></script>
</body>
</html>