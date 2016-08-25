<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>블랙리스트</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<img src="../img/chick/icon6.png" width="30" height="30"  style="position:relative; top:5px;"><font size="+2">블랙리스트</font>
<table width="700" border="1" cellspacing="0" cellpadding="3" align="center">

<c:if test="${empty Blist}">
   <tr><td align="center"><br>검색된 결과가 없습니다.</td></tr>
</c:if>
<c:if test="${!empty Blist}">

<tr>
<td>회원 ID</td>
<td>회원구분</td>
<td>제재일</td>
<td>제재사유</td>
<td>상  태</td>
<td>비  고</td>
</tr>

<c:forEach var="i" items="${Blist}">
<c:set var="temptId" value="${i.id}"/>
<c:set var="temptM_grade" value="${i.m_grade}"/>
<c:set var="temptR_date" value="${i.r_date}"/>
<c:set var="temptContent" value="${i.content}"/>
<c:set var="temptState" value="${i.state}"/>

<tr>
<td>${temptId}</td>
<td>${temptM_grade}</td>
<td>${temptR_date}</td>
<td>${temptContent}</td>
<td>${temptState}</td>
<td><input type="button" value="자세히" onclick="javascript:window.open('/FORKI/content/adminPage/system/blackUCheck.do?id=${temptId}','post','toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no')"></td>
</tr>
</c:forEach>
</c:if>
</table>
</body>
</html>    