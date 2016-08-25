<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
			<%
				session.invalidate();
			%>
<tiles:insertDefinition name="layout2" >
	<tiles:putAttribute name="body" value="/content/join/factor/user/loginForm.jsp" />
</tiles:insertDefinition>