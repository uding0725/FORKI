<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:if test="${x==1}"> 
	비밀번호가 변경되었습니다.
		<br><a href="/FORKI/content/join/UserMain.do">메인으로</a>
</c:if>
</body>
</html>