<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	function go_update(){
		location.href="/go_edit/"+$("#id").val();
	}
	
	
</script>
<div class="container">
	<input type="hidden" name="id" id="id" value="${boardDto.ID}"/>
	<table class="table table-bordered">
		<tr>
			<th class="bg-info">제목</th>
			<td>${boardDto.TITLE}</td>
		</tr>
		<tr>
			<th class="bg-info">작성자</th>
			<td>${boardDto.REG_ID}</td>
		</tr>
		<tr>
			<th colspan="2" class="bg-info">내용</th>
			
		</tr>
		<tr>
			<td colspan="2">
				<span style="white-space: pre-line;">${boardDto.CONTENT }</span>
			</td>
		</tr>
	</table>
	<!-- 수정/삭제 -->
	<div>
		<input type="button" class="btn btn-outline-info" onclick="go_update()" value="수정">
	</div>
</div>