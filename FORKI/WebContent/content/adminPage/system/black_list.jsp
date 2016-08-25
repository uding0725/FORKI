<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>블랙리스트</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
		<c:if test="${empty Blist}">
			<table width="750" border="1" cellspacing="0" cellpadding="3" align="center">
			<tr>
				<td align="center"><br>검색된 결과가 없습니다.</td>
			</tr>
		</c:if>
		<div style="position: relative; height: 330px; width: 750px;">
			<table width="750" border="1" cellspacing="0" cellpadding="3" align="center">
				<c:if test="${!empty Blist}">

					<tr>
						<td width="100" align="center">회원 ID</td>
						<td width="80" align="center">회원구분</td>
						<td width="90" align="center">제재일</td>
						<td width="300"align="center">제재사유</td>
						<td width="50" align="center">상 태</td>
						<td width="70" align="center">비 고</td>
					</tr>

					<c:forEach var="i" items="${Blist}">
						<c:set var="temptId" value="${i.id}" />
						<c:set var="temptM_grade" value="${i.m_grade}" />
						<c:set var="temptR_date" value="${i.r_date}" />
						<c:set var="temptContent" value="${i.content}" />
						<c:set var="temptState" value="${i.state}" />

						<tr>
							<td align="center">${temptId}</td>
							<td align="center">${temptM_grade}</td>
							<td align="center"><fmt:formatDate value="${temptR_date}" pattern="yyyy-MM-dd"/></td>
							<td align="center">${temptContent}</td>
							<td align="center">${temptState}</td>
							<td align="center"><input type="button" value="자세히"
								onclick="javascript:window.open('/FORKI/content/adminPage/system/blackUCheck.do?id=${temptId}','post','toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no')"></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
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
