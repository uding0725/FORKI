<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${check == 1}">
	<script>
		alert("별점주셔서 감사합니다.^^");
	</script>
	<meta http-equiv="Refresh" content="0;url=/FORKI/content/findKinder/factor/kinder_DetailPage.do?num=${num}">
</c:if>

<c:if test="${check == 0}">
	<script>
		alert("이미 참여하셨습니다.");
		history.go(-1);
	</script>
</c:if>

<c:if test="${check == -1}">
	<script>
		alert("로그인 후 이용해주세요.");
		history.go(-1);
	</script>
</c:if>