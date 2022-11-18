function friendMenu(){
	let size = document.getElementsByClassName('form-wrap');
	size[0].style.height = '480px';
	size[0].style.overflowY='hidden';
}

function payMenu(){
	let size = document.getElementsByClassName('form-wrap');
	size[0].style.height = '800px';
	size[0].style.overflowY='scroll';
}
        const payDiv = document.getElementById('payDiv');
        const friendDiv = document.getElementById('friendDiv');
        const payBtn = document.getElementById('payBtn');
        const friendBtn = document.getElementById('friendBtn');
        const asideForm = document.getElementById('asideForm');
        const test = () =>{
        friendDiv.style.display="none";
          payBtn.style.border= "none";
          payBtn.style.color = "black";
        //   payBtn.style.fontWeight = 700;
          friendBtn.style.border = "1px solid lightgray";
          friendBtn.style.color="gray";
          asideForm.style.height="300px";
          asideForm.style.transition="1s";
        }

        const test2 = () =>{
   
        document.getElementById('friendDiv').style.display="block";
          friendBtn.style.border= "none";
          friendBtn.style.color = "black";
        //   friendBtn.style.fontWeight = 700;
          payBtn.style.border = "1px solid lightgray";
          payBtn.style.color="gray";
          asideForm.style.height="150px";
          asideForm.style.transition="1s";
        }

    //    function openPopup(){
    //        window.open("profil.html", "new", "toolbar=no, menubar=no, scrollbars=no, resizable=no, width=1280, height=721, left=0, top=0" );
    //    }
    /* $('.dropdown-btn').on('click',function(){
        $('.dropdown-content').show();
        }); */  
          $(".fr-bt").on('click', function(){

          alert('미구현 기능입니다. (업데이트 예정일 : 2022/00/00)');

          });
          $(".mi-5").on('click', function(){

          alert('마케팅 사이트 업데이트 진행중.');

          });