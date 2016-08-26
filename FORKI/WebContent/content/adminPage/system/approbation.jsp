<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html>
<head>
<title>기업승인</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>

	<c:if test="${count == 0}">
		<table width="750" border="1" cellpadding="0" cellspacing="0" align="center">
			<tr>
				<td align="center">접수된 신청이 없습니다.</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${count > 0}">
<div style="position:relative; height: 380px; width: 750px;">
	<img src="../img/chick/icon6.png" width="30" height="30"  style="position:relative; top:5px;"><font size="+2">기업 승인 신청</font>
		<table width="750" border="1" cellspacing="0" cellpadding="3" align="center">
			<form name="memForm" method="post"
				action="/FORKI/content/adminPage/SysApprobation.do">

				<tr>
					<td width="80" align="center">회원 ID</td>
					<td width="120" align="center">사업자번호</td>
					<td width="350" align="center">유치원명</td>
					<td width="80" align="center">등록여부</td>
					<td width="70" align="center">비고</td>
				</tr>


				<c:forEach var="i" items="${articleList}">
					<c:set var="temptId" value="${i.id}" />
					<c:set var="temptSchul_num" value="${i.schul_num}" />
					<c:set var="temptSchul_nm" value="${i.schul_nm}" />
					<c:set var="temptReg_check" value="${i.reg_check}" />


					<tr>
						<td align="center">${temptId}</td>
						<td align="center">${temptSchul_num}</td>
						<td align="center">${temptSchul_nm}</td>
						<td align="center">${temptReg_check}</td>
						<td align="center"><input type="button" value="승인"
							onclick="document.location.href='/FORKI/content/adminPage/SysApproPro.do?id=${temptId}&schul_num=${temptSchul_num}'">
							<input type="button" value="거절"
							onclick="document.location.href='/FORKI/content/adminPage/SysApproDel.do?id=${temptId}'">
						</td>
					</tr>
				</c:forEach>

			</form>
		</table>
	</c:if>
</div>
<div style="text-align: center;">
	<c:if test="${count > 0}">
		<c:set var="pageCount"
			value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="${10}" />
		<fmt:parseNumber var="result" value="${currentPage / 10}"
			integerOnly="true" />
		<c:set var="startPage" value="${result * 10 + 1}" />
		<c:set var="endPage" value="${startPage + pageBlock-1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<c:if test="${startPage > 10}">
			<a
				href="/FORKI/content/adminPage/SysApprobation.do?pageNum=${startPage - 10 }">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<a href="/FORKI/content/adminPage/SysApprobation.do?pageNum=${i}">[${i}]</a>
		</c:forEach>

		<c:if test="${endPage < pageCount}">
			<a
				href="/FORKI/content/adminPage/SysApprobation.do?pageNum=${startPage + 10}">[다음]</a>
		</c:if>
	</c:if>
</div>
</body>
</html>