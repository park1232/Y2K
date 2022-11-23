<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/edit.css" />
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
             
             <form  name="popupClose();" class="upload-form" action="/update" method="post" 
             			target="photo.ph" enctype="multipart/form-data">
                    <input  type="file" name="file"  accept=".jpg, .jpeg" onchange="imageChoose(this)" />
                  	
                    <div class="upload-img">
                        <img src="/upload/${photo.renameName}"  alt="" id="imageUploadPreview"  />
                        <input type="hidden" name="renameName" id="renameName" value="${photo.renameName }" >
                        <input type="hidden" name="photoName" id="photoName" value="${photo.photoName }" >
                        <input type="hidden" name="photoNo" id="photoNo" value="${photo.photoNo }" >
                    </div>
                 
                 
                 <!--사진설명 + 업로드버튼-->
                 <div class="upload-form-detail">
                       <input type="text" value="${photo.photoComent }" name="photoComent" >  <!-- key=value로 날라감 -->
                     <button type="submit" class="cta blue"  id="upload" onclick="window.close();">수정</button>
                 </div>
                 <!--사진설명end-->
                 
             </form>
             <!--사진업로드 Form-->
         </section>
         <!--사진업로드 박스 end-->
     </main>
     
     <script src="${contextPath}/resources/js/edit.js"></script>
 
      
</body>
</html>