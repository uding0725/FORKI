<%@ page contentType="text/html; charset=UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<!-- <link href="../style.css" rel="stylesheet" type="text/css"> -->
</head>
<div style="width:750;">
<h2>유치원등록하기</h2>
<form  method="post" action="kiderInputForm.do" name="kiderinput" onSubmit="return ">
<table style="width:740; border: 1px solid black;">

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
		<td>
			<input type="text" name="matr_gu" size="10" maxlength="10" >
		</td>
	</tr>
	<tr>
		<td>소재동 </td>
		<td>
			<input type="text" name="dong" size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>설립</td>
		<td>
			<input type="text" name="fond" size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<input type="text" name="telno" size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>
			<input type="text" name="zip" readonly size="10" maxlength="10"> <input type="button" value="우편번호찾기">
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="adres">
		</td>
	</tr>
	<tr>
		<td>학생수</td>
		<td>
			<input type="text" name=""size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>여학생수</td> 
		<td>
			<input type="text" name=""size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>학급수</td>
		<td> 
			<input type="text" name=""size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>교직원수</td>
		<td>
			<input type="text" name=""size="10" maxlength="10">
		</td>
	<tr>
		<td>여교직원수</td> 
		<td>
			<input type="text" name=""size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>비고</td>
		<td>
			<input type="text" name="rm">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="등록신청"> &nbsp;<input type="button" value="취소">
		</td>
	</tr>
</table>
</form>
</div>
</html>