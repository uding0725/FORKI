<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>공지사항</title>
<style>
#write-wrap {
	width: 750px;
	height: 750px;
	margin: 0px auto;
	padding: 0px;
	border: 0px solid;
	padding: 20px; 
	position: relative;
}
#write-header {

    width : 700px;
    height : 150px;
	margin-bottom: 50px;
	border: 0px solid;
}

#write-content {
	width: 700px;
	height : 400px;
	margin-top:10px;
	margin-bottom: 10px;
	border: 0px;
}
a {
	text-decoration: none;
}
table{ 
       width : 700px;
       border-left: 1px solid; 
       border-right: 1px solid; 
       border-top: 1px solid; 
       border-bottom: 1px solid; 
       text-align:center"
}

</style>
</head>
<body>
<div id="write-wrap">
  <div id="write-header">
  <font size="+2">공지사항</font> 
   <span style='position: absolute; right: 60px'> 
    <a href="#"><img src="img/home.png" width="20" height="20"></a> 
    <a href="#">>게시판</a>
    <a href="#">>공지사항</a> 
   </span>
   <br>
   <br>
     총  ${count} 건이 검색되었습니다.
   <form align="right">
  
   <span style='position:relative;'>
   <c:if test="${sessionScope.id=='admin'}">
   <input type="button" name="write" value="글쓰기" onClick="document.location.href='/FORKI/content/board/notifyWrite.do'">
   </c:if>
   <select name="searchn">
   <option value="0">전체
   <option value="1">제목
   <option value="2">내용
   </select>
   <input type="text" style="width:10%" name="search">
   <input type="button" name="searching" value="검색">
   </span>
   </form>
  <div id="write-content">
   <table> 

				<tr>
					<td width="100" height="30" align="center" bgcolor="">번호 </td>
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
				  	<a href="/FORKI/content/board/notifyContent.do?num=${article.num}&pageNum=${currentPage}">
          			${article.subject}</a>
				  	</td>
				  	<td width="100" align="center" bgcolor="">${article.writer}</td>
				  	<td width="100" align="center" bgcolor="">${article.readcount}</td>
				  	<td width="150" align="center" bgcolor="">${sim.format(article.reg_date)}</td>
				  	</tr>
				</c:forEach>
				</c:if>
			</table>
			<c:if test="${count>0}"	>
		<c:set var="pageCount" value="${count/pageSize+(count%pageSize==0?0:1)}"/>
		<c:set var="pageBlock" value="${10}"/>
		<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true"/>
		<c:set var="startPage" value="${result*10+1}"/>
		<c:set var="endPage" value="${startPage+pageBlock-1}"/>
		<c:if test="${endPage>pageCount}">
			<c:set var="endPage" value="${pageCount}"/>
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
   </div>
   </div>
</div>   

</body>
</html>