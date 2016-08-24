<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<img src="../img/chick/icon6.png" width="30" height="30"  style="position:relative; top:5px;"><font size="+2">회원관리</font>
	<table width="800" border="1" cellspacing="0" cellpadding="3" align="center">
	<form name="memForm" method="post" action="/FORKI/content/adminPage/SysMemberCare.do">

		<tr bgcolor="${title_c}">
			<td>회원 ID</td>
			<td>이름</td>
			<td>회원구분</td>
			<td>이메일</td>
			<td>신고접수 횟수</td>
			<td>가입일</td>
			<td>비고</td>
		</tr>
		
		
<c:forEach var="i" items="${Memlist}">
<c:set var="temptId" value="${i.id}"/>
<c:set var="temptName" value="${i.name}"/>
<c:set var="temptM_grade" value="${i.m_grade}"/>
<c:set var="temptEmail" value="${i.email}"/>
<c:set var="temptYellow_card" value="${i.yellow_card}"/>
<c:set var="temptJoin_date" value="${i.join_date}"/>
<c:if test="${temptYellow_card==null}">
${temptYellow_card=""}
</c:if>


<tr>
<td>${temptId}</td>
<td>${temptName}</td>
<td>${temptM_grade}</td>
<td>${temptEmail}</td>
<td>${temptYellow_card}</td>
<td>${temptJoin_date}</td>
<td><input type="button" value="자세히" onclick="javascript:window.open('/FORKI/content/adminPage/system/UserCheck.do?id=${temptId}','post','toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no')">
</tr>
</c:forEach>


		<%-- <tr>
			<td>${id}</td>
			<td>${name}</td>
			<td>${m_grade}</td>
			<td>${email}</td>
			<td>${yellow_card}</td>
			<td>${join_date}</td>
			<td><input type="button" value="자세히" onclick="userCheck()"> </td>
		</tr> --%>
		</form>
	</table>
</body>
</html>