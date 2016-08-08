<%@ page contentType="text/html; charset=UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script>

function zipCheck(){
	url="";//유치원주소
	window.open(url,"post","toolbar=no,width=500,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}
</script>
<!-- <link href="../style.css" rel="stylesheet" type="text/css"> -->
</head>
<div style="width:750;">
<h2>유치원등록하기</h2>
<form  method="post" action="kiderInputPro.do" name="kiderinput" onSubmit="return ">
<table style="width:740; border: 1px solid black;">
<c:forEach var="i" items="${vecList}">
<c:set var="Tschul_nm" values="${i.schul_nm}"></c:set>
<c:set var="Tschul_num" values="${i.schul_num}"></c:set>
</c:forEach>
	<tr>
		<td>유치원명</td> 
		<td>
			<input type="text" name="schul_nm" size="10" maxlength="10" value="${Tschul_nm}" readonly>
			<input type="hidden" name="schul_num" value="${Tschul_num}">
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
			<input type="text" name="zip" readonly size="10" maxlength="10"> <input type="button" value="우편번호찾기" onClick="">
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
			<input type="text" name="stdnt_co_sm"size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>여학생수</td> 
		<td>
			<input type="text" name="grlstdn_co"size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>학급수</td>
		<td> 
			<input type="text" name="clas_co" size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>교직원수</td>
		<td>
			<input type="text" name="frl_tcher_co_sm"size="10" maxlength="10">
		</td>
	<tr>
		<td>여교직원수</td> 
		<td>
			<input type="text" name="frl_female_tcher_c"size="10" maxlength="10">
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
<input type="hidden" name="state" value="n">
</form>
</div>
</html>