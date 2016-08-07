<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>시간 조회시 나오는 페이지</title>
<style>
#md-wrap {
	width: 550px;
	height: 750px;
	margin: 0px auto;
	padding: 0px;
	border: 0px solid;
	padding: 20px;
	position: relative;
}

#md-container {
	width: 540px;
	height: 700px;
	margin: 0px auto;
	padding: 20px;
	border: 1px solid;
}

#md-content {
	width: 240px;
	height: 400px;
	padding: 5px;
	margin-bottom: 10px;
	float: left;
	border: 1px solid;
}

#md-map {
	width: 240px;
	height: 300px;
	padding: 10px;
	margin-bottom: 10px;
	float: right;
	border: 1px solid;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="md-wrap">
		<font size="+2">의료시설</font> <span
			style='position: absolute; right: -10px'> <a href="#"><img
				src="img/home.png" width="20" height="20"></a> <a href="#">>주변시설</a>
			<a href="#">>의료시설 조회</a> <a href="#">>병원</a>
		</span>


		<div id="md-container">
			<p>총 검색 건수 : ?건</p>
			<div id="md-content"></div>

			<div id="md-map">지도</div>

		</div>
		<!-- 안에 내용 감싸주는 div끝남 -->
	</div>
	<!-- 전체 틀  감싸주는 div -->
</body>
</html>