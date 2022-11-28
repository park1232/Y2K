<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>

<head>
  <title>What's App</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
    integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/chat.css">
  <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  
  <script type="text/javascript" 
  src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js">
  </script>


</head>

<body>
  
  <div id="messageArea"></div>
 <input type="text" id="message"/>
 <input type="button" id="sendBtn" value="submit"/>
 
  
  <%-- <script src="${contextPath}/resources/js/testchat.js"></script> --%>


	<script type="text/javascript">
		$("#sendBtn").click(function(){
			sendMessage();
			$('#message').val(' ')
			
			
		});
	
		let sock = new SockJS("http://localhost:8080/echo/")
	
		sock.onmessage = onMessage;
		sock.onclose = onClose;
		
		//메세지전송
		function sendMessage(){
			sock.send($("#message").val());
		}
	
		//서버로부터 메세지 받을때
		function onMessage(msg){
			let data = msg.data;
			$("#messageArea").append(data + "<br/>");
			
		}
	
		// 서버와 연결을 끊었을 때
		function onClose(evt){
			$("#messageArea").append("연결 끊김");
		}
		
		
	
	</script>
















</body>

</html>