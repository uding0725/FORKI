<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#m_frame {
	width: 750px;
	height: 700px;
}

#m_list {
	width: 750px;
	height: 620px;
}
</style>
<div id="m_frame">
	<div style="height: 10px;"></div>
	<div style="height: 30px; text-align: center;">
		<B>쪽지함</B>
	</div>
	<div style="height: 40px; text-align: right;">
		쪽지수: ${list.size + 0}
		<hr />
	</div>
	<div id="m_list">
		<c:if test="${count == 0}">
			<table width="750" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">쪽지가 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<table border="1" width="750" cellpadding="0" cellspacing="0" align="center">
				<tr height="30" bgcolor="${value_c}">
					<td align="center" width="50">번 호</td>
					<td align="center" width="100">보낸사람</td>
					<td align="center" width="500">내용</td>
					<td align="center" width="100">자세히</td>
				</tr>

				<c:forEach var="article" items="${articleList}">
					<tr height="30">
						<td align="center" width="50"><c:out value="${number}" /> <c:set var="number" value="${number - 1}" /></td>
						<td align="center" width="100">${article.writer}</td>
						<td align="center" width="500">${article.content}</td>
						<td align="center" width="100"><a href="/content/MyPage/factor/m_content.jsp?num=${article.m_num}">자세히</td>

					</tr>
				</c:forEach>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<c:set var="pageCount" value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
			<c:set var="pageBlock" value="${10}" />
			<fmt:parseNumber var="result" value="${currentPage / 10}" integerOnly="true" />
			<c:set var="startPage" value="${result * 10 + 1}" />
			<c:set var="endPage" value="${startPage + pageBlock-1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>

			<c:if test="${startPage > 10}">
				<a href="/JulJSP/MVC/list.do?pageNum=${startPage - 10 }">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/JulJSP/MVC/list.do?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="/JulJSP/MVC/list.do?pageNum=${startPage + 10}">[다음]</a>
			</c:if>
		</c:if>
	</div>
</div>