<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#m_frame {
	width: 750px;
	height: 450px;
}

#m_list {
	width: 750px;
	height: 370px;
}
</style>
<div id="m_frame">
	<div style="height: 10px;"></div>
	<div style="height: 30px; text-align: center;">
		<B>신고함</B>
	</div>
	<div style="height: 40px; text-align: right;">
		신고수: ${list.size + 0}
		<hr />
	</div>
	<div id="m_list">
		<c:if test="${count == 0}">
			<table width="750" border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">접수된 신고가 없습니다.</td>
				</tr>
			</table>
		</c:if>

		<c:if test="${count > 0}">
			<table border="1" width="750" cellpadding="0" cellspacing="0" align="center">
				<tr height="30" bgcolor="${value_c}">
					<td align="center" width="50">번 호</td>
					<td align="center" width="100">신고자</td>
					<td align="center" width="100">신고대상</td>
					<td align="center" width="100">신고위치</td>
					<td align="center" width="150">신고내용</td>
					<td align="center" width="180">신고일</td>
					<td align="center" width="70">자세히</td>
				</tr>

				<c:forEach var="article" items="${articleList}">
					<tr height="30">
						<td align="center" width="50"><c:out value="${number}" /> <c:set var="number" value="${number - 1}" /></td>
						<td align="center" width="100">${article.reporter}</td>
						<td align="center" width="100">${article.sub_report}</td>
						<td align="center" width="100">${article.location}</td>
						<td align="center" width="150">${article.content}</td>
						<td align="center" width="180">${article.r_date}</td>
						<td align="center" width="70"><a href="#"
							onClick="javascript:window.open('/FORKI/content/MyPage/factor/ReportContent.do?num=${article.num}','popup','scrollbars=no, resizable=no, width=530,height=450')">자세히</td>

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
				<a href="/FORKI/content/MyPage/ReportList.do?pageNum=${startPage - 10 }">[이전]</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/FORKI/content/MyPage/ReportList.do?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="/FORKI/content/MyPage/ReportList.do?pageNum=${startPage + 10}">[다음]</a>
			</c:if>
		</c:if>
	</div>
</div>