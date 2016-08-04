<%@ page contentType="text/html; charset=UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>유치원등록</h1>
<form method="post" action="kiderInputForm.do" name="kiderinput" onSubmit="return ">
<table border="1">
<tr>
	<td>유치원명</td>
	<td>
	<input type="text" name="schul_nm" size="10" maxlength="10" value="00" readonly>
	</td>
</tr>
<tr>
	<td>해당교육청</td>
	<td>
	<input type="text" name="ofcdc" size="15" maxlength="15">
	</td>
</tr>
<tr>
<td>소재구</td>
<td><input type="text" name="matr_gu"></td>
</tr>
<tr>
<td>설립</td>
<td><input type="text" name="fond"></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name="telno"></td>
</tr>
</table>
</form>
</body>
</html>