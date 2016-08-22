<%@ page contentType="text/html; charset=UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${check==1}">
<script>
alert("등록된 유치원 입니다.");
history.go(-1);
</script>
</c:if>
<c:if test="${check==0}">
<script>
alert("승인대기중 입니다.");
history.go(-1);
</script>
</c:if>
<script>

function zipCheck(){
	
	url="/FORKI/content/join/factor/user/ZipCheck.do?check=y";
	
	window.open(url,"post","toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no");
}
</script> 
<!-- <link href="../style.css" rel="stylesheet" type="text/css"> -->
</head>
<c:if test="${check==-1}">
<div style="width:750;">
<h2>유치원등록하기</h2>
<form  method="post" action="/FORKI/content/myPage_Buss/kinderInputPro.do" name="userinput">
<table style="width:740; height:600; border: 1px solid black;">

	<tr>
		<td>유치원명</td> 
		<td>
			<input type="text" name="schul_nm" size="10" maxlength="10" value="${ketc.schul_nm}" readonly>
			<input type="hidden" name="schul_num" value="${ketc.schul_num}">
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
			<input type="text" name="zipcode"  size="10" maxlength="10" readonly> <input type="button" value="우편번호찾기" onClick="zipCheck()">
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="address">
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
			<input type="text" name="frl_female_tcher_co"size="10" maxlength="10">
		</td>
	</tr>
	<tr>
		<td>비고</td>
		<td>
			<input type="text" name="rm">
			<input type="hidden" name="state" value="n">
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
</c:if>
</html>