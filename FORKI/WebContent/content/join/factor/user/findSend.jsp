<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<c:if test="${check != 1}">
입력하신 정보가 맞지 않습니다.

<input type="button" onclick="history.go(-1)" value="뒤로가기">

</c:if>
<c:if test="${check == 1}">
이메일 전송완료.<br>
이메일을 확인하세요.
</c:if>
</body>
</html>