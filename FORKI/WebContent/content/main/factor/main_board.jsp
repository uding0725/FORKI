<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../CSS/board.css?ver=1.5" rel="stylesheet" type="text/css">
<div id=factor>
<br>
	<font size="+2">게시판</font>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 
	<a href="/FORKI/content/board/notifyList.do">[+더보기]</a><br>           
	
	<table width="400">
	<hr>
	
	<c:forEach var="n" items="${n}">
	<tr >
	<td width="70">
	*공지 
	</td>
	<td width="200">
	<a href="/FORKI/content/board/notifyContent.do?num=${n.num}"> ${n.subject} </a> </td>
	<td width="80"> ${n.writer} </td> </tr> 
	</c:forEach>	
	<c:forEach var="b" items="${b}">
	<tr> <td width="70">
	*자유
	</td>
	<td width="200">
	<a href="/FORKI/content/board/freeBoardContent.do?num=${b.num}">${b.title}${b.subject}</a> </td>
	<td width="80"> ${b.writer}</td></tr>
	</c:forEach>
	</table>
	<br>
</div>
