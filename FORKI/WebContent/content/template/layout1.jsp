<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/global.css" rel="stylesheet" type="text/css">
<link href="../CSS/style.css?var=1.1" rel="stylesheet" type="text/css">
<title><tiles:getAsString name="title" /></title>
</head>
<body>
	<div id="box">
		<div id="top">
			<tiles:insertAttribute name="header" />
		</div>
		<div>
			<div id="content">
				<div>
					<tiles:insertAttribute name="left_top" />
				</div>
				<div>
					<tiles:insertAttribute name="left_bottom" />
				</div>
			</div>
			<div id="content">
				<div>
					<tiles:insertAttribute name="right_top" />
				</div>
				<div>
					<tiles:insertAttribute name="right_bottom" />
				</div>
			</div>
		</div>
		<div id="bottom">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>