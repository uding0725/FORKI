<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>회원관리</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div style="position: relative; height: 330px; width: 750;">
	<img src="../img/chick/icon6.png" width="30" height="30"  style="position:relative; top:5px;"><font size="+2">회원관리</font>
		<table width="750" border="1" cellspacing="0" cellpadding="3" align="center">
			<form name="memForm" method="post" action="/FORKI/content/adminPage/SysMemberCare.do">
				<tr bgcolor="${title_c}">
					<td width="100" align="center">회원 ID</td>
					<td width="80" align="center">이름</td>
					<td width="40" align="center">회원구분</td>
					<td width="100" align="center">이메일</td>
					<td width="70" align="center">신고접수 횟수</td>
					<td width="100" align="center">가입일</td>
					<td width="70" align="center">비고</td>
				</tr>


				<c:forEach var="i" items="${Memlist}">
					<c:set var="temptId" value="${i.id}" />
					<c:set var="temptName" value="${i.name}" />
					<c:set var="temptM_grade" value="${i.m_grade}" />
					<c:set var="temptEmail" value="${i.email}" />
					<c:set var="temptYellow_card" value="${i.yellow_card}" />
					<c:set var="temptJoin_date" value="${i.join_date}" />
					<c:if test="${temptYellow_card==null}">
					${temptYellow_card=""}
					</c:if>


					<tr>
						<td align="center">${temptId}</td>
						<td align="center">${temptName}</td>
						<td align="center">${temptM_grade}</td>
						<td align="center">${temptEmail}</td>
						<td align="center">${temptYellow_card}</td>
						<td align="center"><fmt:formatDate value="${temptJoin_date}" pattern="yyyy-MM-dd"/></td>
						<td align="center"><input type="button" value="자세히"
							onclick="javascript:window.open('/FORKI/content/adminPage/system/UserCheck.do?id=${temptId}','post','toolbar=no ,width=500 ,height=300,directories=no,status=yes,scrollbars=yes,menubar=no')">
					</tr>
				</c:forEach>
			</form>
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
						href="/FORKI/content/adminPage/SysMemberCare.do?pageNum=${startPage - 10 }">[이전]</a>
				</c:if>

				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<a href="/FORKI/content/adminPage/SysMemberCare.do?pageNum=${i}">[${i}]</a>
				</c:forEach>

				<c:if test="${endPage < pageCount}">
					<a
						href="/FORKI/content/adminPage/SysMemberCare.do?pageNum=${startPage + 10}">[다음]</a>
				</c:if>
			</c:if>
		</div>
</body>
</html>