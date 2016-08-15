<%@ page contentType="text/html; charset=utf-8"%>
<%
	session.setAttribute("id", "comp");
	session.setAttribute("grade", "2");
%>
<script>
	alert('세션: 유치원 로그인 정보 생성');
	location.href="/FORKI/viewSession.jsp";
</script>
