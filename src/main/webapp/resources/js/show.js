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
			      <b>싼토 :</b>
			      되어라 얍
			    </p>
			    <button><i class="fas fa-times"></i></button>
			  </div>
			`;
	commentList.prepend(content);
	commentInput.val("");
}

// 댓글 삭제
function deleteComment() {

}



// (6) 사용자 정보(회원정보, 로그아웃, 닫기) 모달
function popup(obj) {
	$(obj).css("display", "flex");
}

function modalInfo() {
	$(".modal-info").css("display", "none");
}


window.onload=()=>{
			const upd = document.getElementById('updateForm');
			const form = document.getElementById('detailForm');
			if(upd != null){
				upd.addEventListener('click', ()=>{
					
					form.action = 'edit.ph';
					form.submit();
					
					window.close();
				});
			}
			
			const deleteModal = document.getElementById('deleteModal');
			
			if(deleteModal != null){
				document.getElementById('deleteModal').addEventListener('click', ()=>{
					console.log(document.getElementById('deleteModal'));
					
					form.action = 'delete.ph';

					form.submit();
				 	
				 	window.close();
				});
				
			
			}




}


