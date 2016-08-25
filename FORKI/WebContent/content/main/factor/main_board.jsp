<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../CSS/board.css?ver=1.5" rel="stylesheet" type="text/css">
<div id=factor>
	<h2>게시판</h2>
	
	<c:forEach var="n" items="${n}">
	<a href="/FORKI/content/board/notifyContent.do?num=${n.num}">[공지]${n.subject}</a> <br>
	</c:forEach>	
	<c:forEach var="b" items="${b}">
	<a href="/FORKI/content/board/freeBoardContent.do?num=${b.num}">${b.title}${b.subject}</a> <br>
	</c:forEach>
</div>
