<%@ page contentType="text/html; charset=utf-8"%>
<%
	session.setAttribute("id", "person");
	session.setAttribute("grade", "1");
%>
<script>
	alert('세션: 개인 로그인 정보 생성');
	location.href="/FORKI/viewSession.jsp";
</script>
