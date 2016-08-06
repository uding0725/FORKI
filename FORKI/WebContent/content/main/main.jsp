<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="layout1" >
	<tiles:putAttribute name="left_top" value="/content/main/factor/map.jsp" />
	<tiles:putAttribute name="left_bottom" value="/content/main/factor/main_nameFind.jsp" />
	<tiles:putAttribute name="right_top" value="/content/main/factor/main_image.jsp" />
	<tiles:putAttribute name="right_bottom" value="/content/main/factor/main_board.jsp" />
</tiles:insertDefinition>