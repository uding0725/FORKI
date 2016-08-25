<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:if test="${re == 1}">
		<script>
			alert("등록되었습니다.");
		</script>
		<meta http-equiv="Refresh" content="0;url=/FORKI/content/findKinder/factor/ModifyImg.do" >
	</c:if>
	<c:if test="${re == 0}">
		<script>
			alert("등록에 실패하였습니다.");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>