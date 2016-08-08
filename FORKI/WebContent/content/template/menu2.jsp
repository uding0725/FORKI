<%@ page contentType="text/html; charset=utf-8"%>

<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/global.css" rel="stylesheet" type="text/css">
<link href="../CSS/style.css" rel="stylesheet" type="text/css">
<style>
#md-sidebar {
	width: 150px;
	margin: auto;
	float: none;
	border: 1px solid;
	text-align: center;
}
</style>
</head>
<div id="left">
	<div>
		<nav id="topmenu-side">
			<ul>
				<li class="topMenuLi-side"><a class="menuLink-side" href="#">어린이집</a></li>
				<li class="topMenuLi-side"><a class="menuLink-side" href="#">어린이집</a></li>
				<li class="topMenuLi-side"><a class="menuLink-side" href="#">어린이집</a></li>
			</ul>
		</nav>
	</div>
	<div id="left">
		<div id="md-sidebar">
			<p>
				시간별<br>이용가능한<br>시설조회
			</p>
			<input type="range" name="range" min="1" max="12" step="1" /> <br> <br> <select name="select">
				<option value="">전체</option>
				<option value="병원">병원</option>
				<option value="보건소">보건소</option>
			</select> <input type="button" name="검색" value="검색">
		</div>
	</div>
</div>
