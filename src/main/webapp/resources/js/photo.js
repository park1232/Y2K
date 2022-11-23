
const up = () =>{
 	
	window.name = "photo.ph";
	
	window.open('upload.ph','popup','width=700, height=670');
		
}

let images = document.querySelectorAll(".imgOne");

for(const img of images){
	img.addEventListener('click',function(){
	
		let photoNo = img.nextElementSibling.value;
		
		console.log(photoNo);
		
		window.open('show.ph?photoNo='+photoNo,'popup','width=600, height=650');
		});
	}

