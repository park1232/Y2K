// 스토리 이미지 업로드를 위한 사진 선택 로직

//img파일 선택 안 할 시 경고창
function imageChoose(obj) {
	let f = obj.files[0];
	let up = document.getElementById('upload');
	if (!f.type.match("image.*")) {
		alert("이미지를 등록해야 합니다.");
		return;
	}else{
		up.disabled = false;
	
	
//사진 선택시 미리 보여주는
	let reader = new FileReader();
	
	const preview = document.getElementById("imageUploadPreview");
	
	reader.onload = (e) => {
		preview.src = e.target.result;
	}
	reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
	
	}
	

}
