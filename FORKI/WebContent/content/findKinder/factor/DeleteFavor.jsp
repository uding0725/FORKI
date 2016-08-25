<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${check == 1}">
	<script>
		alert("등록 취소되었습니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=/FORKI/content/findKinder/factor/kinder_DetailPage.do?num=${num}">
</c:if>

<c:if test="${check == 0}">
	<script>
		alert("실패했습니다.");
		history.go(-1);
	</script>
</c:if>
