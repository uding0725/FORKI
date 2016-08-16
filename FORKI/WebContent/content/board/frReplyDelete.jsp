<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh"
		content="0;url=/FORKI/content/board/freeBoardContent.do?num=${num}&pageNum=${pageNum}">
</c:if>