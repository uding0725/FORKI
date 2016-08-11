<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 
 <html>
<head>
<title>게시판</title>

</head>

<body>
<center><b>글목록(전체 글:${count})</b>
<table width="700">
  <tr>
    <td align="right" >
       <a href="/FORKI/content/board/freeBoardWrite.do">글쓰기</a>
    </td>
  </tr>
</table>

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
	<table border="1" width="700" cellpadding="0" cellspacing="0" align="center">
    <tr height="30">
      <td align="center"  width="50"  >번 호</td>
      <td align="center"  width="250" >제   목</td>
      <td align="center"  width="100" >닉네임</td>
      <td align="center"  width="150" >조회수</td>
      <td align="center"  width="50" >등록일</td>  
    </tr>
 	</table>   

    <c:forEach var="article" items="${articleList}">
   <table witdh="700" cellpadding="0" cellspacing="0" align="center">
   <tr height="30">
    <td align="center"  width="50" >
  	<c:out value="${number}"/>
 	 <c:set var="number" value="${number - 1}"/>  
	</td>
    <td  width="250" >
   
      <a href="/FORKI/content/board/freeBoardContent.do?num=${article.num}&pageNum=${currentPage}">
          ${article.subject}</a> 
          <%-- <c:if test="${article.readcount >= 20}">
            <img src="images/hot.gif" border="0"  height="16">
  </c:if> --%>
</td>
    <td align="center"  width="100">
       ${article.writer}</a>
</td>
    <td align="center"  width="150">${article.readcount}
</td>
    <td align="center"  width="50">${article.reg_date}</td>
   
  </tr>
  </c:forEach>
</table>
</c:if>

<c:if test="${count > 0}">
   <c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}"/>
   <c:set var="pageBlock" value="${10}"/>
   <fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
   <c:set var="startPage" value="${result * 10 + 1}" />
   <c:set var="endPage" value="${startPage + pageBlock-1}"/>
   <c:if test="${endPage > pageCount}">
        <c:set var="endPage" value="${pageCount}"/>
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

</center> 
</body>
</html>
