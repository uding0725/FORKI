<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>메인입니다.</title>
<link href="style.css" rel="stylesheet" type="text/css">
<!-- 로그인 되지 않았을 경우 -->
<c:if test="${id==null}">

<script>
function focusIt()
{
	document.inform.id.focus();//내가 작업하고 있는 문서의 inform이라는 곳에 id에 커서를 가져다줌
}
function checkIt()
{
	inputForm=eval("document.inform");
	if(!inputForm.id.value){
	alert("아이디를 입력하세요.");
	inputForm.id.focus();
	return false;
	}
	if(!inputForm.passwd.value){
	alert("비밀번호를 입력하세요.");
	inputForm.passwd.focus();
	return false;
	}
}
function infoCheck(){

	window.open("/FORKI/content/join/factor/company2/findInfo.jsp","post","toolbar=no ,width=500 ,height=500,directories=no,status=yes,scrollbars=yes,menubar=no");
}
</script>
</head>
<body onLoad="focusIt();">
<table width="500" cellpadding="0" cellspacing="0" align="center" border="1">
<tr>
<td width="300" height="20">
&nbsp;
</td>
<form name="inform" method="port" action="/FORKI/content/join/factor/company2/loginPro.do" onSubmit="return checkIt();">
<td width="100" align="right">아이디</td>
<td width="100">
<input type="text" name="id" size="15" maxlength="10"></td>
</tr>
<tr>
<td rowspan="2" width="300">메인입니다.</td>
<td width="100" align="right">비밀번호</td>
<td width="100">
<input type="password" name="passwd" size="15" maxlength="10"></td>
</tr>
<tr>
<td colspan="3" align="center">
<input type="submit" name="Submit" value="로그인">
<input type="button"  value="회원가입" 
onclick="document.location.href='/FORKI/content/join/joinSelect.jsp'">
<input type="button"  value="id/pwd찾기"  onclick="infoCheck();">
</td>
</form>
</tr>
</table>
</c:if>
<c:if test="${id!=null}">
<table width=500 cellpadding="0" cellspacing="0"  align="center" border="1" >
<tr>
<td width="300" height="20">하하하</td>
<td rowspan="3" align="center">
<%=session.getAttribute("id")%>님이 <br>
방문하셨습니다
<form  method="post" action="/FORKI/content/join/factor/company2/logout.do"> 
<input type="submit"  value="로그아웃">
<input type="button" value="회원정보변경" 
onclick="javascript:window.location='/FORKI/content/join/ComModify.jsp'">
</form>
</td>
</tr>
<tr >
<td rowspan="2" width="300" >메인입니다.</td>
</tr>
</table>
<br>
</c:if>
</body>
</html>