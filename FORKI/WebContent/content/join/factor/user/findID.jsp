<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty id}">
<script>
	alert("입력하신 정보가 맞지 않습니다.");
	history.go(-1);
</script>
</c:if>
<c:if test="${!empty id}">
<script>
	alert("요청하신 id는 '${id}'입니다.");
	history.go(-1);
</script>
</c:if>
</body>
</html>