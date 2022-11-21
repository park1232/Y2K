// 댓글쓰기
// function addComment() {

// 	let commentInput = document.getElementById("#storyCommentInput-1");
// 	let commentList = document.getElementById("#storyCommentList-1");

// 	let data = {
// 		// content: commentInput.val()
// 	}

// 	if (data.content === "") {
// 		alert("댓글을 작성해주세요!");
// 		return;
// 	}

// 	let content = `
// 			  <div class="sl__item__contents__comment" id="storyCommentItem-2""> 
// 			    <p>
// 			      <b>GilDong :</b>
// 			      댓글 샘플입니다.
// 			    </p>
// 			    <button><i class="fas fa-times"></i></button>
// 			  </div>
// 	`;
// 	commentList.prepend(content);
// 	commentInput.val("");
// }

// 댓글 삭제
function deleteComment() {

}

//modal
function modalInfo() {
	$(".modal-info").css("display", "none");
}


// 댓글쓰기
function addComment() {

	let commentInput = $("#storyCommentInput-1");
	let commentList = $("#storyCommentList-1");

	let data = {
		content: commentInput.val()
	}

	if (data.content === "") {
		alert("댓글을 작성해주세요!");
		return;
	}

	let content = `
			  <div class="sl__item__contents__comment" id="storyCommentItem-2""> 
			    <p>
			      <b>GilDong :</b>
			      댓글 샘플입니다.
			    </p>
			    <button><i class="fas fa-times"></i></button>
			  </div>
	`;
	commentList.prepend(content);
	commentInput.val("");
}

// (6) 사용자 정보(회원정보, 로그아웃, 닫기) 모달
function modalInfo() {
	$(".modal-info").css("display", "none");
}




