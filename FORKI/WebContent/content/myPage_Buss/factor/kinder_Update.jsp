<%@ page contentType="text/html; charset=UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>
function zipCheck(){
	
	url="/FORKI/content/join/factor/user/ZipCheck.do?check=y";
	
	window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}

</script>
</head>
<div style="width:750;">
<h2>유치원정보 수정</h2> 
<form  method="post" action="/FORKI/content/myPage_Buss/kinderUpdatePro.do" name="userinput">
<table style="width:740; height:600; border: 1px solid black;">

	<tr>
		<td>유치원명</td> 
		<td>
			<input type="text" name="schul_nm" size="20" maxlength="20" value="${kdata.schul_nm}">
			<input type="hidden" name="schul_num" value="${kdata.schul_num}">
		</td>
	</tr>
	<tr>
		<td>해당교육청</td> 
		<td>
			<input type="text" name="ofcdc" size="20" value="${kdata.ofcdc}" maxlength="20" >
		</td>
	</tr>
	<tr>
		<td>소재구</td>
		<td>
			<input type="text" name="matr_gu" value="${kdata.matr_gu}" size="20" maxlength="20"  >
		</td>
	</tr>
	<tr>
		<td>소재동 </td>
		<td>
			<input type="text" name="dong" value="${kdata.dong}" size="20" maxlength="20" >
		</td>
	</tr>
	<tr>
		<td>설립</td>
		<td>
			<input type="text" name="fond" value="${kdata.fond}"size="20" maxlength="20" >
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<input type="text" name="telno" value="${kdata.telno}" size="20" maxlength="11">
		</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>
			<input type="text" name="zipcode" value="${kdata.zip}" size="10" maxlength="10" readonly> <input type="button" value="우편번호찾기" onClick="zipCheck()">
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="address" value="${kdata.adres}" size="50" maxlength="50" >
		</td>
	</tr>
	<tr>
		<td>학생수</td>
		<td>
			<input type="text" name="stdnt_co_sm" value="${kdata.stdnt_co_sm}" size="20" maxlength="20" >
		</td>
	</tr>
	<tr>
		<td>여학생수</td> 
		<td>
			<input type="text" name="grlstdn_co" value="${kdata.grlstdn_co}" size="20" maxlength="20">
		</td>
	</tr>
	<tr>
		<td>학급수</td>
		<td> 
			<input type="text" name="clas_co" value="${kdata.clas_co}" size="20" maxlength="20">
		</td>
	</tr>
	<tr>
		<td>교직원수</td>
		<td>
			<input type="text" name="frl_tcher_co_sm" value="${kdata.frl_tcher_co_sm}" size="20" maxlength="20">
		</td>
	<tr>
		<td>여교직원수</td> 
		<td>
			<input type="text" name="frl_female_tcher_co" value="${kdata.frl_female_tcher_co}" size="20" maxlength="20">
		</td>
	</tr>
	<tr>
		<td>비고</td>
		<td>
			<input type="text" name="rm" value="${kdata.rm}">
			
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정">
		</td>
	</tr>
</table>

</form>
</div>

</html>