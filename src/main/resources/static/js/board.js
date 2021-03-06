let index={
    init:function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		
		$("#btn-update").on("click",()=>{
			this.updateById();
		});
		
		$("#btn-delete").on("click",()=>{
			this.deleteById();
		});
	},
	save:function(){
		let data={
			title:$("#title").val(),
			content:$("#content").val()
		};
		
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(resp){
			alert("글쓰기가 완료 되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));	
		});
	},
	updateById:function(){
		let id=$("#id").val();
		
		let data={
			title:$("#title").val(),
			content:$("#content").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/api/board/"+id,
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(resp){
			alert("글수정이 완료 되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));	
		});
	},
	deleteById:function(){
		let id = $("#id").text();
		
		$.ajax({
			type: "DELETE",
			url: "/api/board/"+id,
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 
		}).done(function(resp){
			alert("삭제가 완료 되었습니다.");
			location.href="/";
		}).fail(function(error){
			alert(JSON.stringify(error));	
		});
	},
}

index.init(); 
