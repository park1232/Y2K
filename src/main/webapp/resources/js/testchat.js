let websocket;

function connect(){
		//웹소켓 주소
		let wsUri = "ws://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/chat/user.do";
		//소켓 객체 생성/chat/user.do
		websocket = new WebSocket(wsUri);
		//웹 소켓에 이벤트가 발생 했을 때 호출될 함수 등록
		websocket.onopen  = onOpen;
		websocket.onmessage = onMessage;
}
	//${pageContext.request.serverName}: = localhost:
	//${pageContext.request.serverPort} = 8080
	//${pageContext.request.contextPath} = /
	
	
//웹 소켓에 연결 되었을 때 호출 될 함수
function onOpen(){
	console.log("연결됨");
}

//1. 메세지 전송
function sendMessage(message){
}

//2. 메세지 수신
function onMessage(evt){
}

