<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${check != 1}">
잘못된 접근입니다.
<input type="button" onclick="history.go(-1)" value="뒤로가기">
</c:if>
<c:if test="${check == 1}">
<form action="/FORKI/content/join/UserUpdatePWD.do" method="post">
<table border="1" align="center">
<tr>
<td colspan="2">비밀번호 변경</td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="text" name="passwd" size="15" maxlength="10"></td>
</tr>
<tr align="right">
<td colspan="2">
<input type="hidden" name="id"  value="${id}">
<input type="submit" value="변경"></td>
</tr>
</table>
</form>
</c:if>
</body>
</html>