<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<title><tiles:getAsString name="title" /></title>
</head>
<body>

	<table id="layout">
		<tr>
			<td colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td style="width: 480;"><tiles:insertAttribute name="left_top" /></td>
			<td style="width: 480;"><tiles:insertAttribute name="right_top" /></td>
		</tr>
		<tr>
			<td><tiles:insertAttribute name="left_bottom" /></td>
			<td><tiles:insertAttribute name="right_bottom" /></td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>