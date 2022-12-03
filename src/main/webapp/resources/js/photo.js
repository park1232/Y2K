
const up = () =>{
 	
	window.name = "photo.ph";
	
	window.open('upload.ph?userNo='+userNo,'popup','width=700, height=670');
		
}

let images = document.querySelectorAll(".imgOne");
let userNo = document.getElementById("userNo").value;
for(const img of images){
	img.addEventListener('click',function(){
	
		let boardNo = img.nextElementSibling.value;
		
		//console.log(boardNo);
		console.log(userNo);
		window.open('show.ph?boardNo='+boardNo,'popup','width=1200, height=850');
		});
	}

  