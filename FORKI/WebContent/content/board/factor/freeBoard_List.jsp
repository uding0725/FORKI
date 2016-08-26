<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="../CSS/board.css?ver=1.5" rel="stylesheet" type="text/css">

 
 <html>  
<head>
<script>

function writeMessage(ids,writer) {
	url = '/FORKI/content/MyPage/WriteMessage.do?id=' + ids+"&writer="+writer
	window.open(url, 'popup',
			'scrollbars=no, resizable=no, width=530,height=450');
}
function writeReport(ids,sub,subid,loc){
	url='/FORKI/content/MyPage/WriteReport.do?id='+ids+'&sub='+sub+'&subid='+subid+'&loc='+loc
	window.open(url,'popup','scrollbars=no, resizable=no, width=530,height=450');
}

</script>
<style>
#free-wrap{
 width: 700px;
 height:790px;
 margin:0px auto;
 padding : 0px;
 border :0px solid;
 padding :0px;
 position : relative;
}
</style>
<title>게시판</title>

</head>

<body>

				
<div id="write-wrap">
	<div id="write-header">
		<div id="header">
			<img src="../img/chick/icon5.png" width="30" height="30"  style="position:relative; top:10px;"> <font size="+2" style="position: relative; top:5px; left:5px;">맘을전해요</font> 
			<span style='position: absolute; right: 10px; top: 20px;'>
				<a href="/FORKI/content/main/main.do">
				<img style="position: relative; top:3px;" src="../img/home.png" width="20" height="20"></a>
				<a href="/FORKI/content/board/notifyList.do">>게시판</a>
				<a href="">맘을전해요</a>
			</span> 
		</div>
		<hr>
		<div>
			<div style="width: 210px; position: relative; float: left;">
			총 ${count}건이 검색되었습니다.
			</div>	
			<form name="search" action="/FORKI/content/board/freeBoardList.do" 
				style="width: 520px; position: relative; float: right; margin-right: 5px; text-align: right;">
				<span style='position: relative;'> 
					<select name="type">
						<option value="0">전체</option>
						<option value="1">제목</option>
						<option value="2">내용</option>
					</select> 
					<select name="title">
						<option value="0">소곤소곤</option>
						<option value="1">유익한 경로</option>
						<option value="2">기타</option>
					</select> 
					<input type="text" name=searchn size="10">
					<input type="submit" value="검색">
					 <c:if test="${sessionScope.id != null}">
						<input type="button" value="글쓰기" onclick="document.location.href='/FORKI/content/board/freeBoardWrite.do'">
					</c:if> 
				</span>
			</form>
		</div>	
	</div>
<c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      게시판에 저장된 글이 없습니다.
    </td>
  </tr>
</table>
</c:if>

<c:if test="${count > 0}"> 
   <div id="write-content">
		<table id="board_table">
			<tr>
				<td width="100" height="30" align="center" bgcolor="">번호</td>
				<td width="300" height="30" bgcolor="" align="center">제 목</td>
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
						<td width="100" align="center" bgcolor=""><c:out value="${number}" /> <c:set var="number" value="${number-1}" /></td>
						<td width="300" align="center" bgcolor="">
						<a href="/FORKI/content/board/freeBoardContent.do?num=${article.num}&pageNum=${currentPage}">
						${article.title} ${article.subject} </a></td>
						<td width="100" align="center" bgcolor="">
						<c:if test="${sessionScope.id==null }">
				  		${article.writer}</c:if>
				  		 <c:if test="${sessionScope.id==article.id}">
				  		${article.writer}
				  		</c:if> 
					  <c:if test="${sessionScope.id!=null }"> 
						<c:if test="${sessionScope.id!=article.id}">
						<div class="menubar">
						<nav id="contentMenu">
							<ul>
								<li class="contentMenuLi"><a class="conmenuLink">${article.writer}</a>
									<ul class="contentMenusub">
										<li class="pop-up"><a onclick="writeMessage('${article.id}','${article.writer}')"
															class="consubmenuLink longLink">쪽지보내기</a></li>
									    <li class="pop-up"><a onclick="writeReport('${sessionScope.id}','${article.writer}','${article.id}','자유게시판 글')" class="consubmenuLink longLink">신고하기</a></li>
													</ul></li>
											</ul>
										</nav>
									</div>
								</c:if>
								</c:if>
							</td>
						<td width="100" align="center" bgcolor="">${article.readcount}</td>
						<td width="150" align="center" bgcolor="">${date.format(article.reg_date)}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		</div>
</c:if>

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
					<a href="/FORKI/content/board/freeBoardList.do?pageNum=${startPage - 10 }">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/FORKI/content/board/freeBoardList.do?pageNum=${i}">[${i}]</a>
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<a href="/FORKI/content/board/freeBoardList.do?pageNum=${startPage + 10}">[다음]</a>
				</c:if>
			</c:if>
		</p>
</div>
</body>
</html>

