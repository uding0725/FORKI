
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="../CSS/board.css?ver=1.5" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
function writeMessage(ids){
	url='/FORKI/content/MyPage/WriteMessage.do?id='+ids
	window.open(url,'popup','scrollbars=no, resizable=no, width=530,height=450');
	alert(ids);
}
</script>

<div id="write-wrap">
	<div id="write-header">
		<div id="header">
			<img src="../img/chick/icon5.png" width="30" height="30"  style="position:relative; top:10px;"> <font size="+2" style="position: relative; top:5px; left:5px;">공지사항</font> 
			<span style='position: absolute; right: 10px; top: 20px;'>
				<a href="/FORKI/content/main/main.do">
				<img style="position: relative; top:3px;" src="../img/home.png" width="20" height="20"></a>
				<a href="/FORKI/content/board/notifyList.do">>게시판</a>
				<a href="">>공지사항</a>
			</span> 
		</div>
		<hr>
		<div>
			<div style="width: 250px; position: relative; float: left;">
			총 ${count}건이 검색되었습니다.
			</div>	
			<form style="width: 400px; position: relative; float: right; margin-right: 5px; text-align: right;">
				<span style='position: relative;'> 
					<select name="searchn">
						<option value="0">전체
						<option value="1">제목
						<option value="2">내용
					</select> 
					<input type="text" style="width: 50%" name="search">
					<input type="submit" name="searching" value="검색">
					<c:if test="${sessionScope.id=='admin'}">
						<input type="button" name="write" value="글쓰기" onClick="document.location.href='/FORKI/content/board/notifyWrite.do'">
					</c:if>
				</span>
			</form>
		</div>	
	</div>
	<div id="write-content">
		<table id="board_table">
			<tr>
				<td width="100" height="30" align="center" bgcolor="">번호</td>
				<td width="300" height="30" bgcolor="" align="center">공지사항</td>
				<td width="100" height="30" bgcolor="" align="center">닉네임</td>
				<td width="100" height="30" bgcolor="" align="center">조회수</td>
				<td width="150" height="30" bgcolor="" align="center">등록일</td>
			</tr>
			<tr>

				<c:if test="${count==0}">
					<td align="center" colspan="5">게시판에 저장된 글이 없습니다.</td>
				</c:if>
			</tr>
			<c:if test="${count>0}">
				<c:forEach var="article" items="${articleList}">
					<tr>
						  	<td width="100" align="center" bgcolor="">
				  	<c:out value="${number}"/>
				  	<c:set var="number" value="${number-1}"/></td>
				  	<td width="300" align="center" bgcolor="">
				  	<a href="/FORKI/content/board/notifyContent.do?num=${article.num}&pageNum=${currentPage}" style="text-decoration:none;color:black;">
          			${article.subject}</a>
          			
				  	</td>
				  	<td width="100"align="center">
				  		${article.writer}
				  	</td>
				  	<td width="100" align="center" bgcolor="">${article.readcount}</td>
				  	<td width="150" align="center" bgcolor="">${sim.format(article.reg_date)}</td>
				  	</tr>
				</c:forEach>
			</c:if>
		</table>
		<p align="center">
			<c:if test="${count>0}">
				<c:set var="pageCount" value="${count/pageSize+(count%pageSize==0?0:1)}" />
				<c:set var="pageBlock" value="${10}" />
				<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true" />
				<c:set var="startPage" value="${result*10+1}" />
				<c:set var="endPage" value="${startPage+pageBlock-1}" />
				<c:if test="${endPage>pageCount}">
					<c:set var="endPage" value="${pageCount}" />
				</c:if>
				<c:if test="${startPage > 10}">
					<a href="/FORKI/content/board/notifyList.do?pageNum=${startPage - 10 }">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/FORKI/content/board/notifyList.do?pageNum=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/FORKI/content/board/notifyList.do?pageNum=${startPage + 10}">[다음]</a>
				</c:if>
			</c:if>
		</p>
	</div>
</div>
