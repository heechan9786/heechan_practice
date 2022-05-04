<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function update(){
		var params={};
		params.TITLE=$("#title").val();
		params.REG_ID=$("#reg_id").val();
		params.CONTENT=$("#content").val();
		params.ID=$("#id").val();
		
		$.ajax({
			method:"put",
			url:"/editBoard",
			data:params,
			success:function(result){
				console.log(result);
				alert("게시글 수정에 성공하셨습니다.");
				location.href="/";
			},
			error:function(result){
				console.log(result);
				alert("게시글 수정에 실패하셨습니다.");
				return;
			}
		});
	}
</script>
<div class="container">
	<input type="hidden" name="id" id="id" value="${boardDto.ID}"/>
	<div class="input-group mb-1">
  		<div class="input-group-prepend">
    		<span class="input-group-text">제목</span>
  		</div>
  		<input type="text" class="form-control" name="title" id="title" value="${boardDto.TITLE}"> 
	</div>
	<div class="input-group mb-1">
  		<div class="input-group-prepend">
    		<span class="input-group-text">작성자</span>
  		</div>
  		<input type="text" class="form-control" name="reg_id" id="reg_id" value="${boardDto.REG_ID}">
	</div>
	<div class="input-group mb-3">
  		<div class="input-group-prepend">
    		<span class="input-group-text">내용</span>
  		</div>
  		<textarea class="form-control" name="content" id="content">${boardDto.CONTENT}</textarea>
	</div>
	<div>
		<input type="button" class="btn btn-outline-secondary btn-lg btn-block" onclick="update()" value="수정">
	</div>
</div>