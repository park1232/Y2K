//let boardId = $("#boardNo").val();
//let rNickName = $("#rNickName").val();


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


