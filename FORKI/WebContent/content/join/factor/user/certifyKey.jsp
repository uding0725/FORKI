<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${check == 1}">
	<script>
		alert("인증되었습니다..^^");
	</script>
	<meta http-equiv="Refresh" content="0;url=/FORKI/content/main/main.do"> 
</c:if>
<c:if test="${check != 1}">
	<script>
		alert("잘못죈접근입니다.");
		histoy.go(-1);
	</script>
</c:if>