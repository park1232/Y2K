// (1) 스토리 이미지 업로드를 위한 사진 선택 로직
function imageChoose(obj) {
	let f = obj.files[0];

	if (!f.type.match("image.*")) {
		alert("이미지를 등록해야 합니다.");
		return;
	}

	let reader = new FileReader();
	console.log(reader);
	const preview = document.getElementById("imageUploadPreview");
	
	reader.onload = (e) => {
		preview.src = e.target.result
	}
	reader.readAsDataURL(f); // 이 코드 실행시 reader.onload 실행됨.
}

// (2) 업로드 버튼 누를 시 화면 닫히기

function windowClose() {
	$(".cta blue").css("display", "none");
	location.reload();
}