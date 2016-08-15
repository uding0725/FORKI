location.href=’페이지'<%@ page contentType="text/html; charset=utf-8"%>

<%
	session.invalidate();
%>
<script>
	alert('세션: 로그아웃');
	location.href="/FORKI/viewSession.jsp";
</script>
