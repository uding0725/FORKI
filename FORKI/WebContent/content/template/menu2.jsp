<%@ page contentType="text/html; charset=utf-8"%>
<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<style>
#md-sidebar {
	width: 140px;
	padding: 5px;
	margin: auto;
	margin-bottom: 20px;
	float: left;
	border: 1px solid;
}
</style>
</head>
<div id="menu">
	<ul>
		<li><a href="#">주변시설</a></li>
	</ul>
	<ul>
		<li><a href="#">의료시설조회</a></li>
		<li><a href="#">문화시설조회</a></li>
	</ul>
</div>
<!-- 의료시설조회라면 -->
<table id="md-sidebar">
	<tr>
		<td>
			<p style="text-align: center;">
				시간별<br>이용가능한<br>시설조회
			</p> <input type="range" name="range" min="1" max="12" step="1" /> <br> <br> <select name="select">
				<option value="">전체</option>
				<option value="병원">병원</option>
				<option value="보건소">보건소</option>
		</select> <input type="button" name="검색" value="검색">

		</td>
</table>

<!-- 문화시설조회라면 -->
<!-- md-sidebar 테이블 삭제 -->
