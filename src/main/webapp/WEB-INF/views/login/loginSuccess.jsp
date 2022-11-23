<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ import = import javax.servlet.http.HttpServletRequest %> --%>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<%-- <%
String userId = request.getParameter("userId");
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="${contextPath}/resources/css/loginSuccess.css" />
    <script src="//code.jquery.com/jquery-3.4.1.min.js"></script>
<title>moveMainPage</title>
</head>
<body>

<div class="button_container">
        <p class="description">Move Y2K World</p>
        <button class="btn" id="move-main-btn"><span>Y2K World</span></button>
        <br>
        <br>
        <br>
        <br>
       
        <br>
        <p class="description">Move Purchaes Page</p>
        <button class="btn" id="move-purchaes-btn"><span>Purchaes</span></button>
        <!--<p class="link">
          Design by 
          <a href="https://dribbble.com/skytrip" target="_blank">SkyTrip</a>
        </p>-->
      </div>

</body>
<script>


$('#move-main-btn').click(function(){
  window.open('/mainPage.ma?userId='+${userId},'Y2K World','width=1289, height=703, scrollbars=no, resizable=no, toolbars=no, menubar=no');
  window.close();

  
});

$('#move-purchaes-btn').click(function(){
	  window.open('/purchaes.pa','Y2K Purchaes Page','width=1289, height=703, scrollbars=no, resizable=no, toolbars=no, menubar=no');
	  window.close();  
	});
</script>

</html>