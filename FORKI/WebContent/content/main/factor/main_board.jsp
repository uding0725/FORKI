<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../CSS/board.css?ver=1.5" rel="stylesheet" type="text/css">
<div id=factor>
	<font size="+2">게시판</font>&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 
	<a href="/FORKI/content/board/notifyList.do">[+더보기]</a><br>           
	
	<table width="300">
	
	<c:forEach var="n" items="${n}">
	<tr >
	<td width="50">
	*공지 
	</td>
	<td width="100">
	<a href="/FORKI/content/board/notifyContent.do?num=${n.num}"> ${n.subject} </a> </td>
	<td width="50"> ${n.writer} </td> </tr> 
	</c:forEach>	
	<c:forEach var="b" items="${b}">
	<tr> <td width="50">
	*자유게시판 
	</td>
	<td width="100">
	<a href="/FORKI/content/board/freeBoardContent.do?num=${b.num}">${b.title}${b.subject}</a> </td>
	<td width="50"> ${b.writer}</td></tr>
	</c:forEach>
	</table>
</div>
