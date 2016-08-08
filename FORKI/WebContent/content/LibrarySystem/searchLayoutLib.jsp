<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="layout3" >  
	<tiles:putAttribute name="menu" value="/content/template/menu2.jsp" />
	<tiles:putAttribute name="body" value="/content/LibrarySystem/factor/searchLib.jsp" /> 
</tiles:insertDefinition>