<%@ page contentType="text/html; charset=UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${check==-1}">
<script>
alert("유치원 등록되어있지 않습니다 유치원을 등록해주세요");
history.go(-1);
</script>
</c:if>
<c:if test="${check==0}">
<script>
alert("승인대기중 입니다.");
history.go(-1);
</script>
</c:if>
<!-- <link href="../style.css" rel="stylesheet" type="text/css"> -->
</head>
<c:if test="${check==1}">
<div style="width:750;">
<h2>유치원보기</h2>
<form  method="post" action="/FORKI/content/myPage_Buss/kinderUpdate.do" name="userinput">
<table style="width:740; height:600; border: 1px solid black;">

	<tr>
		<td>유치원명</td> 
		<td>
			<input type="text" name="schul_nm" size="20" maxlength="20" value="${kdata.schul_nm}" readonly>
			<input type="hidden" name="schul_num" value="${schul_num}">
		</td>
	</tr>
	<tr>
		<td>해당교육청</td> 
		<td>
			<input type="text" name="ofcdc" size="20" value="${kdata.ofcdc}" maxlength="20" readonly>
		</td>
	</tr>
	<tr>
		<td>소재구</td>
		<td>
			<input type="text" name="matr_gu" value="${kdata.matr_gu}" size="20" maxlength="20" readonly >
		</td>
	</tr>
	<tr>
		<td>소재동 </td>
		<td>
			<input type="text" name="dong" value="${kdata.dong}" size="20" maxlength="20" readonly>
		</td>
	</tr>
	<tr>
		<td>설립</td>
		<td>
			<input type="text" name="fond" value="${kdata.fond}"size="20" maxlength="20" readonly>
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td>
			<input type="text" name="telno" value="${kdata.telno}" size="20" maxlength="11" readonly>
		</td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td>
			<input type="text" name="zip" value="${kdata.zip}" size="10" maxlength="10" readonly> <!-- <input type="button" value="우편번호찾기" onClick="zipCheck()"> -->
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td>
			<input type="text" name="adres" value="${kdata.adres}" size="50" maxlength="50"  readonly>
		</td>
	</tr>
	<tr>
		<td>학생수</td>
		<td>
			<input type="text" name="stdnt_co_sm" value="${kdata.stdnt_co_sm}" size="20" maxlength="20" readonly>
		</td>
	</tr>
	<tr>
		<td>여학생수</td> 
		<td>
			<input type="text" name="grlstdn_co" value="${kdata.grlstdn_co}" readonly size="20" maxlength="20">
		</td>
	</tr>
	<tr>
		<td>학급수</td>
		<td> 
			<input type="text" name="clas_co" value="${kdata.clas_co}" readonly size="20" maxlength="20">
		</td>
	</tr>
	<tr>
		<td>교직원수</td>
		<td>
			<input type="text" name="frl_tcher_co_sm" value="${kdata.frl_tcher_co_sm}" readonly size="20" maxlength="20">
		</td>
	<tr>
		<td>여교직원수</td> 
		<td>
			<input type="text" name="frl_female_tcher_co" value="${kdata.frl_female_tcher_co}" readonly size="20" maxlength="20">
		</td>
	</tr>
	<tr>
		<td>비고</td>
		<td>
			<input type="text" name="rm" value="${kdata.rm}" readonly>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정하기">
		</td>
	</tr>
</table>

</form>
</div>
</c:if>
</html>