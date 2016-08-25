<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>상세보기</title>
</head>
<body>
<form method="post" action="/FORKI/content/adminPage/system/blackUCheckPro.do?id=${id}">
<table width="400" border="1" cellspacing="0" cellpadding="3" align="center">
	
<tr>
<td width="100">아이디</td>
<td>${id}</td>
</tr>
<tr>
<td width="100">회원구분</td>
<c:set var="grade" value="${m_grade}"/>
<c:choose>
<c:when test="${grade == 1}">
<td>개인</td>
</c:when>
<c:when test="${grade == 2}">
<td>기업</td>
</c:when>
</c:choose>
</tr>

<tr>
<td width="100">제재일</td>
<td><fmt:formatDate value="${r_date}" pattern="yyyy-MM-dd"/></td>
</tr>

<tr>
<td colspan="2" width="100">제재사유</td>
</tr>
<tr>
<td colspan="2" width="400" height="100">
${content}
</td>
</tr>

</table>
<div align="center">
<input type="submit" name="confirm" value="블랙리스트제외" >
<input type="button" value="계정삭제" onclick="document.location.href='/FORKI/content/adminPage/system/blackUDel.do?id=${id}&m_grade=${m_grade}'">
<input type="button" value="닫기" onclick="self.close()">
</div>
</body>
</html>