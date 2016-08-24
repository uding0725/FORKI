<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link href="../../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../../CSS/global.css?var=1.1" rel="stylesheet" type="text/css">
<link href="../../CSS/style.css?var=1.3" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".star_rating a").click(function() {
			$(this).parent().children("a").removeClass("on");
			$(this).addClass("on").prevAll("a").addClass("on");
			return false;
		});
	});
</script>
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
			<div class="wrapper">
			
				<!-- 별점  -->
				<p class="star_rating">
					<a href="#" class="on">★</a> <a href="#" class="on">★</a> <a href="#" class="on">★</a> <a href="#">★</a> <a href="#">★</a>
				</p>
			</div>
		</div>
		<div id="mddp-map">지도 넣을 창</div>
	</div>
	<input type="button" value="닫기">
</body>
</html>