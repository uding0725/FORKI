<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

</head>
<body>
<form action="/FORKI/content/join/factor/company2/findID.do" method="post">
<table border="1" width="300">
<tr>
<td colspan="2">이름과 주민번호를 입력해주세요</td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="name" size="15" maxlength="10">
</td>
</tr>
<tr>
<td>이메일</td>
<td><input type="text" name="email" size="25" maxlength="25"></td>
</tr>
<tr>
<td colspan="2" align="right">
<input type="submit" name="confirm" value="찾 기"> 
</td>				
</tr>
</table>
</form>
<hr>
<form action="/FORKI/content/join/factor/company2/findSend.do" method="post">
<table border="1"  width="300">
<tr>
<td colspan="2">ID,이름과 주민번호를 입력해주세요</td>
</tr>
<tr>
<td>사용자 ID</td>
<td><input type="text" name="id" size="10" maxlength="12">
</td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="name" size="15" maxlength="10">
</td>
</tr>
<tr>
<td>이메일</td>
<td><input type="text" name="email" size="25" maxlength="25"></td>
</tr>
<tr>
<td colspan="2" align="right">
<input type="submit" name="confirm" value="찾 기"> 
</td>				
</tr>
</table>
</form>
</body>
</html>