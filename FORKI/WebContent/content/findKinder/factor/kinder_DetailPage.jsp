<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link href="../../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../../CSS/global.css?var=1.1" rel="stylesheet" type="text/css">
<link href="../../CSS/style.css?var=1.6" rel="stylesheet" type="text/css">
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
<title>어린이집 상세 정보</title>
</head>
<body>
	<div id="mdK-container">
		<p style="text-align: left;" />
		<font size="+1"><b>${param.name}</b></font>
		<div id="mdK-detailview">
			<font size="+1"><b>세부정보</b></font>
			<p>주소 : ${param.adres}</p>
			<p>전화번호 : ${param.tel}</p>
			<p>학급수: ${param.classNo}</p>
			<p>학생수(남/여) : 총 ${param.studentNo}(${param.studentNo - param.girlNo}/${param.girlNo})</p>
			<p>전체선생님/여선생님 : ${param.tcherNo}/${param.famTcherNo}</p>
			<p>비교 : ${param.rm}</p>
			<div style="width:30;height:30;border:1px solid black;padding:7px;background-color:red;position:absolute;top:310px;left:250px;">도표</div> 
			<div class="wrapper2">
				<!-- 별점  -->
				<p class="star_rating">
					<a href="#" class="on">★</a> <a href="#" class="on">★</a> <a href="#" class="on">★</a> <a href="#">★</a> <a href="#">★</a>
				</p>
			</div>
		</div>
		<div id="mdK-inmap">지도 넣을 창</div>
		<div><input type="button" value="닫기"></div>
	</div>
	
</body>
</html>