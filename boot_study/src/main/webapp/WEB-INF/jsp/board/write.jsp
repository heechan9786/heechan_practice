<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function save(){
		var params={};
		params.TITLE=$("#title").val();
		params.REG_ID=$("#reg_id").val();
		params.CONTENT=$("#content").val();
		
		$.ajax({
			type:"post",
			url:"/post",
			data:params,
			success:function(result){
				console.log(result);
				alert("게시글 작성에 성공하셨습니다.");
				location.href="/";
			},
			error:function(result){
				console.log(result);
				alert("게시글 작성에 실패하셨습니다.");
				return;
			}
		});
	}
</script>
<div class="container">
	<div class="input-group mb-1">
  		<div class="input-group-prepend">
    		<span class="input-group-text">제목</span>
  		</div>
  		<input type="text" class="form-control" name="title" id="title">
	</div>
	<div class="input-group mb-1">
  		<div class="input-group-prepend">
    		<span class="input-group-text">작성자</span>
  		</div>
  		<input type="text" class="form-control" name="reg_id" id="reg_id">
	</div>
	<div class="input-group mb-3">
  		<div class="input-group-prepend">
    		<span class="input-group-text">내용</span>
  		</div>
  		<textarea class="form-control" name="content" id="content"></textarea>
	</div>
	<div>
		<input type="button" class="btn btn-outline-secondary btn-lg btn-block" onclick="save()" value="등록">
	</div>
	<form  action="/post" method="post">
		
        <input type="submit" value="등록">
	</form>
</div>