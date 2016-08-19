<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty id}">
alert("입력하신 정보가 맞지 않습니다.");
	history.go(-1);
</c:if>
<c:if test="${!empty id}">
		
		요청하신 id는 ${id}입니다.
		<br><a href="javascript:this.close();">닫기</a>
</c:if>
</body>
</html>