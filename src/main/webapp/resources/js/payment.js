$(document).ready(function(){
		$("#iamportPayment1").click(function(){
		payment(); // 버튼 클릭하면 호출
		});
	})
	var date = new Date().getTime();
	
	function payment(data) {
		IMP.init("imp78311764"); // 가맹점 식별코드
		IMP.request_pay({// param
			pg: "kakaopay.TC0ONETIME", // pg사명 or pg사명.CID
			pay_method: "card", // 지불방법
			merchant_uid: "import" + date, // 가맹점 주문번호(아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
			// 결제할때마다 계속 주문번호가 달라져야함 중복되면 이미 결제완료된 주문번호라고 결제 실패함
			name: "도토리", // 결제창에 노출된 상품명
			amount: 15000, //금액
			buyer_email: "testiamport@naver.com",
			buyer_name: "홍길동",
			buyer_tel: "01012341234"
		}, function (rsp) { //callback
			if(rsp.success) {
				alert("완료 -> imp_uid : "+rsp.imp_uid+" / merchant_uid(orderKey) : " +rsp.merchant_uid);
			} else {
				alert("실패 : 코드("+rsp.error_code+") / 메세지(" + rsp.error_msg + ")");	
			}	
		});
	}
	$(document).ready(function(){
		$("#iamportPayment2").click(function(){
		payment(); // 버튼 클릭하면 호출
		});
	})
	
	function payment(data) {
		IMP.init("imp78311764"); // 가맹점 식별코드
		IMP.request_pay({// param
			pg: "kakaopay.TC0ONETIME", // pg사명 or pg사명.CID
			pay_method: "card", // 지불방법
			merchant_uid: "dsalkjlsa1d", // 가맹점 주문번호(아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
			// 결제할때마다 계속 주문번호가 달라져야함 중복되면 이미 결제완료된 주문번호라고 결제 실패함
			name: "도토리", // 결제창에 노출된 상품명
			amount: 15000, //금액
			buyer_email: "testiamport@naver.com",
			buyer_name: "홍길동",
			buyer_tel: "01012341234"
		}, function (rsp) { //callback
			if(rsp.success) {
				alert("완료 -> imp_uid : "+rsp.imp_uid+" / merchant_uid(orderKey) : " +rsp.merchant_uid);
			} else {
				alert("실패 : 코드("+rsp.error_code+") / 메세지(" + rsp.error_msg + ")");	
			}	
		});
	}
	$(document).ready(function(){
		$("#iamportPayment3").click(function(){
		payment(); // 버튼 클릭하면 호출
		});
	})
	
	function payment(data) {
		IMP.init("imp78311764"); // 가맹점 식별코드
		IMP.request_pay({// param
			pg: "kakaopay.TC0ONETIME", // pg사명 or pg사명.CID
			pay_method: "card", // 지불방법
			merchant_uid: "987wieas", // 가맹점 주문번호(아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
			// 결제할때마다 계속 주문번호가 달라져야함 중복되면 이미 결제완료된 주문번호라고 결제 실패함
			name: "도토리", // 결제창에 노출된 상품명
			amount: 15000, //금액
			buyer_email: "testiamport@naver.com",
			buyer_name: "홍길동",
			buyer_tel: "01012341234"
		}, function (rsp) { //callback
			if(rsp.success) {
				alert("완료 -> imp_uid : "+rsp.imp_uid+" / merchant_uid(orderKey) : " +rsp.merchant_uid);
			} else {
				alert("실패 : 코드("+rsp.error_code+") / 메세지(" + rsp.error_msg + ")");	
			}	
		});
	}