<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/global.css" rel="stylesheet" type="text/css">
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<div id="box">
		<div id="top">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="left">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="bottom">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>