<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<style>
.custom-btn {
  width: 130px;
  height: 40px;
  color: #fff;
  border-radius: 5px;
  padding: 10px 25px;
  font-family: 'Lato', sans-serif;
  font-weight: 500;
  background: transparent;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  display: inline-block;
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  outline: none;
}

  .textBox{
    width:300px;
    height:50px;
    border-color: bisque;
    border-top: none;
    border-left: none;
    border-right: none;
    
    
  }
  #total-form{
    overflow: hidden;
  }

  #input-form{
    /* text-align: center; */
    margin: auto; 
    transition-duration: 10s;
    overflow: hidden;
  }
  .btn-14 {
  background: rgb(255,151,0);
  border: none;
  z-index: 1;
}
.btn-14:after {
  position: absolute;
  content: "";
  width: 100%;
  height: 0;
  top: 0;
  left: 0;
  z-index: -1;
  border-radius: 5px;
  background-color: #eaf818;
  background-image: linear-gradient(315deg, #eaf818 0%, #f6fc9c 74%);
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5)
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  transition: all 0.3s ease;
}
.btn-14:hover {
  color: #000;
}
.btn-14:hover:after {
  top: auto;
  bottom: 0;
  height: 100%;
}
.btn-14:active {
  top: 2px;
}
#result{
  /* text-align: center; */
  transition: all 2s ease;
  margin-top: 800px;
  overflow-y: hidden;
  position: absolute;

}

#total-form{
  height: 600px;
  position: absolute;
}
 
</style>
<body>
  <div id="total-form">
   
    <div id="input-form"> 
      <h2>아이디 찾기</h2>
        <input type="hidden" id="searchIdResult"/>
        <input type="text" id="searchEmail" class="textBox" placeholder="Your Email Address" required/><br><br><br>
        <button class="custom-btn btn-14" id="searchId">아이디 찾기</button>
      </div>
      <div id="result-form">
        
        <div id="result">
          <h2>아이디 찾기결과</h2>
          <div id="re"></div>
          <button class="custom-btn btn-14" id="mainBtn">메인으로</button>
        </div>

      </div>
    
  </div>
</body>

<script>
$("#searchId").click(function(){
	var params={
		email : $("#searchEmail").val()
	}
	$.ajax({
		type: "POST",
		url: "/search-id-from-email.lo",
		data : params,
		success:function(res){
			document.getElementById('searchIdResult').value = res.searchIdResult;
			resultOfSearchId();
			search();
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("오류")
        }
	});
});

const resultOfSearchId = () =>{
	let searchIdResult = document.getElementById('searchIdResult').value;
	if(document.getElementById('searchIdResult').value == 'notExist'){
		document.getElementById('re').innerHTML = "검색 결과가 없습니다.";
	} else {
		document.getElementById('re').innerHTML = "회원님의 아이디는 "+searchIdResult+" 입니다";
	}
}



const search=()=>{
  var inputForm = document.getElementById('input-form');
  var resultForm = document.getElementById('result');
  inputForm.style.transform="translateY(-700px)";
  inputForm.style.transition="2s";
  
  result.style.transform="translateY(-900px)";
  result.style.transition="2s";
  let size = document.getElementById('total-form');
  size.style.height='480px';
  size.style.overflowY='hidden';
  result.style.overflowY='hidden';
  // inputForm.style.display="none";
  
  
}

$("#mainBtn").click(function(){
	window.close(); 
	window.open('/','Y2K');
});
</script>
</html>