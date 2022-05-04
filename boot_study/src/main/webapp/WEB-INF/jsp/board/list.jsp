<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	function go_write(){
		location.href="/post";
	}
	
	function deleteBoard(){
		if($("input:checkbox[name=check_board]:checked").length == 0){
			alert("삭제할 게시물을 선택해주시기 바랍니다.");
			return;	
		}
		
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		
		var checkArr = [];
		$("input:checkbox[name=check_board]:checked").each(function(){
			checkArr.push($(this).val()); 
		});

		console.log(checkArr);
		
		$.ajax({
			method:"delete",
			url:"/deleteBoard",
			data:{
				checkArr:checkArr
			},
			success:function(result){
				console.log(result);
				alert("게시글이 삭제되었습니다.");
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
	<table class="table">
	    <thead class="thead-dark">
		    <tr>
		    	<th scope="col">#</th>
		        <th scope="col">글제목</th>
		        <th scope="col">작성자</th>
		    </tr>
	    </thead>
	    <tbody>
	    	<c:forEach var="board" items="${ boardList }">
	    		<tr>
	    			<th scope="row"><input type="checkbox" name="check_board" value="${board.ID}"></th>
	    			<td><a class="text-info" href="/post/${board.ID}">${board.TITLE}</a></td>
	    			<td>${board.REG_ID}</td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
	</table>
	
	<div>
		<input type="button" class="btn btn-outline-info" onclick="go_write()" value="글쓰기">
		<input type="button" class="btn btn-outline-danger" onclick="deleteBoard()" value="삭제">
	</div>
</div>