<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/global.css" rel="stylesheet" type="text/css">
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
</head>
<div id=factor>
	<div>
	<h2>빠른유치원 찾기</h2>
	</div>
	<div>
		<form method="post" action="/FORKI/content/findKinder/findkinder.do"> 
		<input type="hidden" name="dong" value="">
		<input type="hidden" name="gu" value="0">
		<input type="text" name="schul_nm" autofocus placeholder="기관명을 입력하세요" size="30" /> 
		<input type="submit" value="찾기" />
	<%-- 	onclick="document.location.href='/FORKI/content/findKinder/findkinder.do?schul_nm=${schul_nm}'" --%>
		</form>
	</div>
</div>