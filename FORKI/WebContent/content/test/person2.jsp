<%@ page contentType="text/html; charset=utf-8"%>
<%
	session.removeAttribute("compNum");
	session.setAttribute("id", "person2");
	session.setAttribute("grade", "1");
%>
<script>
	alert('세션: 개인 로그인 정보 생성');
	location.href="/FORKI/viewSession.jsp";
</script>
