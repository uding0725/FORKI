<%@ page contentType="text/html; charset=utf-8"%>
<%
	session.removeAttribute("compNum");
	session.setAttribute("id", "admin");
	session.setAttribute("grade", "0");
%>
<script>
	alert('세션: 관리자 로그인 정보 생성');
	location.href="/FORKI/viewSession.jsp";
</script>
