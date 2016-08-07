<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<title>의료시설 상세 페이지</title>
<style>
#md-container {
	width: 950px;
	height: 700px;
	margin: 0px auto;
	padding: 20px;
	border: 0px solid;
	position: relative;
	margin-bottom: 20px;
}

#md-detailview {
	width: 440px;
	height: 650px;
	margin: 5px;
	padding: 10px;
	border: 1px solid;
	margin-bottom: 10px;
	float: left;
}

#md-map {
	width: 440px;
	height: 500px;
	margin: 5px;
	padding: 10px;
	border: 1px solid;
	magin-bottom: 10px;
	float: right;
}

.wrapper {
	padding: 10px;
	margin: 100px auto;
	width: 300px;
	min-height: 50px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, .1);
	position: absolute;
	top: 580px;
	left: 100px;
}

.rating {
	overflow: hidden;
	vertical-align: bottom;
	display: inline-block;
	width: auto;
	height: 20px;
}

.rating>input {
	opacity: 0;
	margin-right: -100%;
}

.rating>label {
	position: relative;
	display: block;
	float: right;
	background: url('img/star-off-big.png');
	background-size: 20px 20px;
}

.rating>label:before {
	display: block;
	opacity: 0;
	content: '';
	width: 20px;
	height: 20px;
	background: url('img/star-on-big.png');
	background-size: 20px 20px;
	transition: opacity 0.2s linear;
}

.rating>label:hover:before, .rating>label:hover ~ label:before, .rating:not (:hover ) >:checked ~ label:before {
	opacity: 1;
}
</style>
</head>
<body>
	<div id="md-container">
		<p style="text-align: left;" />
		<font size="+1"><b>의료시설 세부정보</b></font>
		<div id="md-detailview">
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
		<div id="md-map">지도 넣을 창</div>
	</div>
	<input type="button" value="닫기">
</body>
</html>