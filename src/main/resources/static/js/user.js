let index={
    init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
	},
	save:function(){
		//alert('user 의 save 함수 호출됨.');	
		let data={
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		
		// console.log(data); //자바스크립트 오브잭트
		// console.log(JSON.stringify(data)); //JSON 오브잭트
		
		$.ajax({
			type: "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data), // http body data
			contentType: "application/json; charset=utf-8", // body data 가 어떤 type 인지(MIME)
			dataType: "json" //요청에 대한 응답이 왔을때의 모든게 문자열 이다. 
			                 //만약 type 이 json 이면 아래 function 에 결과 값을 
			                 //javascript object 로 받을수 있다.
		}).done(function(resp){
			alert("회원가입이 완료 되었습니다.");
			console.log(resp);
			location.href="/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));	
		});
	},
	
	login:function(){
		//alert('user 의 save 함수 호출됨.');	
		let data={
			username:$("#username").val(),
			password:$("#password").val()
		};
		
		// console.log(data); //자바스크립트 오브잭트
		// console.log(JSON.stringify(data)); //JSON 오브잭트
		
		$.ajax({
			type: "POST",
			url: "/blog/api/user/login",
			data: JSON.stringify(data), // http body data
			contentType: "application/json; charset=utf-8", // body data 가 어떤 type 인지(MIME)
			dataType: "json" //요청에 대한 응답이 왔을때의 모든게 문자열 이다. 
			                 //만약 type 이 json 이면 아래 function 에 결과 값을 
			                 //javascript object 로 받을수 있다.
		}).done(function(resp){
			alert("로그인이 완료 되었습니다.");
			console.log(resp);
			location.href="/blog";
		}).fail(function(error){
			alert(JSON.stringify(error));	
		});
	}
	
	
		
}

index.init(); 
