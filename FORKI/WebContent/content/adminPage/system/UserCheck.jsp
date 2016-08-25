<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/FORKI/content/adminPage/system/UserCheckPro.do?id=${id}">
<table width="400" border="1" cellspacing="0" cellpadding="3" align="center">
	
<tr>
<td width="100">아이디</td>
<td>${id}</td>
<td width="100">닉네임</td>
<td>${nickname}</td>
</tr>

<tr>
<td>성별</td>
<td width="100">${sex}</td>
<td>경고수</td>
<td width="100">${yellow_card}</td>
</tr>

<tr>
<td>가입일</td>
<td colspan="3"><fmt:formatDate value="${join_date}" pattern="yyyy-MM-dd"/></td>
</tr>

<tr>
<td>이메일</td>
<td colspan="3">${email}</td>
</tr>

<tr>
<td>주소</td>
<td colspan="3">${address}</td>
</tr>

</table>
<div align="center">
<input type="submit" name="confirm" value="블랙리스트" >
<input type="button" value="닫기" onclick="self.close()">
</div>
</body>
</html>