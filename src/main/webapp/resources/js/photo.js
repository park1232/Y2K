
const up = () =>{
 	
	window.name = "photo.ph";
	
	window.open('upload.ph','popup','width=700, height=670');
		
}

let images = document.querySelectorAll(".imgOne");

for(const img of images){
	img.addEventListener('click',function(){
	
		let boardNo = img.nextElementSibling.value;
		
		console.log(boardNo);
		
		window.open('show.ph?boardNo='+boardNo,'popup','width=600, height=650');
		});
	}

  