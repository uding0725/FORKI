<%@ page contentType="text/html; charset=utf-8"%>
<%
	session.removeAttribute("compNum");
	session.setAttribute("id", "comp");
	session.setAttribute("grade", "2");
	session.setAttribute("compNum", "13800297");
%>
<script>
	alert('세션: 유치원 로그인 정보 생성');
	location.href="/FORKI/viewSession.jsp";
</script>
