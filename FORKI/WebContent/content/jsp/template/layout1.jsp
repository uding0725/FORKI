<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<table>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td rowspan="2"><tiles:insertAttribute name="body" /></td>
			<td><tiles:insertAttribute name="side_top" /></td>
		</tr>
		<tr>
			<td><tiles:insertAttribute name="side_bottom" /></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>