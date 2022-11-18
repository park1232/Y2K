// 좋아요, 안좋아요
function toggleLike() {
	let likeIcon = $("#storyLikeIcon-1");
	if (likeIcon.hasClass("far")) {
		likeIcon.addClass("fas");
		likeIcon.addClass("active");
		likeIcon.removeClass("far");
	} else {
		likeIcon.removeClass("fas");
		likeIcon.removeClass("active");
		likeIcon.addClass("far");
	}
}

// (4) 댓글쓰기
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

// (5) 댓글 삭제
function deleteComment() {

}

//modal
function modalInfo() {
	$(".modal-info").css("display", "none");
}

// (3) 좋아요, 안좋아요
function toggleLike(imageId) { //` ` 로 바꿔주기 뺵틱
	let likeIcon = $(`#storyLikeIcon-${imageId}`);
	
	
	
	if (likeIcon.hasClass("far")) { //좋아요를 하겠다
		
		$.ajax({
			type:"post",
			url:`/api/image/${imageId}/likes`,
			dataType: "json"
		}).done(res=>{
		
		let likeCountStr = $(`#storyLikeCount-${imageId}`).text();
		let likeCount = Number(likeCountStr)	+1;
		$(`#storyLikeCount-${imageId}`).text(likeCount);
		
		likeIcon.addClass("fas");
		likeIcon.addClass("active");
		likeIcon.removeClass("far");
		}).fail(error=>{
			console.log("오류", error);
		});
		
		
	} else { //좋아요취소하겠다
	
	$.ajax({
			type:"delete",
			url:`/api/image/${imageId}/likes`,
			dataType: "json"
		}).done(res=>{
			
		let likeCountStr = $(`#storyLikeCount-${imageId}`).text();
		let likeCount = Number(likeCountStr)	-1;
		$(`#storyLikeCount-${imageId}`).text(likeCount);	
					
		likeIcon.removeClass("fas");
		likeIcon.removeClass("active");
		likeIcon.addClass("far");
		}).fail(error=>{
			console.log("오류", error);
		});

	}
}

// (4) 댓글쓰기
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

