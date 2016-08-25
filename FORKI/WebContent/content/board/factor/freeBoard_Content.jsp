<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script>
function deleteConfirm(){
	var selectDel = confirm("정말로 삭제하시겠습니까?")
	if (selectDel) {
		document.location.href="/FORKI/content/board/freeBoardDelete.do?num=${num}&pageNum=${pageNum}&id=${id}"
	}
}

function reDeleteConfirm(re_num,num,writer,pageNum){ 
	var reDelete = confirm("해당 댓글을 정말로 삭제하시겠습니까?")
	if (reDelete){
		document.location.href="/FORKI/content/board/frReplyDelete.do?re_num="+re_num+"&num="+num+"&writer="+writer+"&pageNum="+pageNum
	}
}
</script>

</head>
<body>



	<table width="700" cellspacing="0" cellpadding="0">
		<tr>
			<td>제목</td>
			<td width="600">${article.subject}</td>
		</tr>
		<tr>
			<td>내용
		</tr>
		<tr>
			<td colspan="2">${article.content}</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="button" value="수정하기"
				onclick="document.location.href='/FORKI/content/board/freeBoardUpdate.do?num=${num}&pageNum=${pageNum}'">
				<input type="button" value="삭제하기" onclick="deleteConfirm();">
				<input type="button" value="목록으로"
				onclick="document.location.href='/FORKI/content/board/freeBoardList.do?pageNum=${pageNum}'">
			</td>
		</tr>
	</table>



	<table width="700" cellspacing="0" cellpadding="0">
		<tr>
			<td>댓글 (${reCount}개)</td>
		</tr>
		<c:if test="${reCount>0}">
			<form name="replyForm">

				<c:forEach var="reply" items="${replyList}">

					<tr>
						<td>${reply.content} ${reply.num} ${reply.re_num}</td>
						<td><input type=hidden name=re_num value="${reply.re_num}">
							<input type=hidden name=writer value="${reply.writer}" /> <input
							type="button" value="신고"> <input type="button"
							value="삭제"
							onClick="reDeleteConfirm(${reply.re_num},${reply.num},'${reply.writer}',${pageNum});">


						</td>
					</tr>
				</c:forEach>
			</form>
		</c:if>
		<form name=reply action="/FORKI/content/board/frReplyPro.do">

			<input type=hidden name=num value="${num}" /> <input type=hidden
				name=pageNum value="${pageNum}" /> <input type=hidden name=re_num
				value="${re_max = re_max+1}"> <input type=hidden
				name=re_page value="${currentRePage}"> <input type=hidden
				name=id value="${sessionScope.id}">
			<tr>
				<td><textarea cols=70 rows=5 name="re_content"></textarea></td>
				<td><input type="submit" style="height: 80;" value="댓글달기" /></td>
			</tr>
	</table>
	</form>



	<c:if test="${reCount > 0}">
		<c:set var="rePageCount"
			value="${reCount / replySize + ( reCount % replySize == 0 ? 0 : 1)}" />

		<c:set var="rePageBlock" value="${10}" />
		<fmt:parseNumber var="result" value="${currentRePage / 10}"
			integerOnly="true" />
		<c:set var="startRePage" value="${result * 10 + 1}" />
		<c:set var="endRePage" value="${startRePage + rePageBlock-1}" />
		<c:if test="${endRePage > rePageCount}">
			<c:set var="endRePage" value="${rePageCount}" />
		</c:if>

		<c:if test="${startRePage > 10}">
			<a
				href="/FORKI/content/board/freeBoardContent.do?rePageNum=${startRePage - 10 }">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startRePage}" end="${endRePage}">
			<a
				href="/FORKI/content/board/freeBoardContent.do?num=${num}&pageNum=${pageNum}&rePageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endRePage < rePageCount}">
			<a
				href="/FORKI/content/board/freeBoardContent.do?num=${num}&pageNum=${pageNum}&rePageNum=${startRePage + 10}">[다음]</a>
		</c:if>
	</c:if>
</body>
</html>