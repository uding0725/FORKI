<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/global.css?var=1.1" rel="stylesheet" type="text/css">
<link href="../CSS/style.css?var=1.3" rel="stylesheet" type="text/css">
<title>의료시설 상세 페이지</title>
</head>
<body>
	<div id="mddp-container">
		<p style="text-align: left;" />
		<font size="+1"><b>의료시설 세부정보</b></font>
		<div id="mddp-detailview">
			<p>세부정보</p>
			<br>
			<p>주소 :</p>
			<br>
			<p>전화번호 :</p>
			<br>
			<p>사이트 :</p>
			<br>
			<p>진료시간</p>
			<br>
			<div class="wrapper"> <!-- 별점  -->
	            <span class="rating">
	                <input id="rating5" type="radio" name="rating" value="5">
	                <label for="rating5">5</label>
	                <input id="rating4" type="radio" name="rating" value="4">
	                <label for="rating4">4</label>
	                <input id="rating3" type="radio" name="rating" value="3">
	                <label for="rating3">3</label>
	                <input id="rating2" type="radio" name="rating" value="2" checked>
	                <label for="rating2">2</label>
	                <input id="rating1" type="radio" name="rating" value="1">
	                <label for="rating1">1</label>
	            </span>
	                <select name="average">
	                <option value="">평점주기</option>
	                <option value="1">1</option>
	                <option value="2">2</option>
	                <option value="3">3</option>
	                <option value="4">4</option>
	                <option vlaue="5">5</option>
	                </select>
		        </div>
		</div>
		<div id="mddp-map">지도 넣을 창</div>
	</div>
	<input type="button" value="닫기">
</body>
</html>