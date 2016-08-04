<%@ page contentType="text/html; charset=UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<link href="../style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div style="width:760;" align="center" >
<h1>유치원등록하기</h1>
<form  method="post" action="kiderInputForm.do" name="kiderinput" onSubmit="return ">
<table style="width:760; border: 1px solid black;" >

<tr>
	<td>유치원명
	<input type="text" name="schul_nm" size="10" maxlength="10" value="00" readonly>
	</td>
</tr>
<tr>
	<td>해당교육청
	<input type="text" name="ofcdc" size="15" maxlength="15">
	</td>
</tr>
<tr>
<td>소재구 <input type="text" name="matr_gu"></td>
</tr>
<tr>
<td>설립 <input type="text" name="fond"></td>
</tr>
<tr>
<td>전화번호 <input type="text" name="telno"></td>
</tr>
<tr>
<td>우편번호<input type="text" name="zip" readonly><input type="button" value="우편번호찾기"></td>
</tr>
<tr>
<td>주소 <input type="text" name="adres"></td>
</tr>
<tr>
<td>사이트주소 <input type="text" name="site"></td>
</tr>
<tr>
<td>학생수 <input type="text" name=""size="10" maxlength="10"> 
여학생수 <input type="text" name=""size="10" maxlength="10"></td>
</tr>
<tr><td>학급수 <input type="text" name=""size="10" maxlength="10">
</td></tr>
<tr>
<td>교직원수 <input type="text" name=""size="10" maxlength="10"> 
여교직원수 <input type="text" name=""size="10" maxlength="10"></td>
</tr>
<tr><td>비고 <input type="text" name="rm"></td></tr>
<tr><td align="center"><input type="submit" value="등록신청"> 
	&nbsp;<input type="button" value="취소"><td></tr>
</table>
</form>
</div>
</body>
</html>