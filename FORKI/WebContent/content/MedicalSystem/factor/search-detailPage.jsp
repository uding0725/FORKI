<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<link href="../../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../../CSS/global.css?var=1.1" rel="stylesheet"
	type="text/css">
<link href="../../CSS/style.css?var=1.4" rel="stylesheet"
	type="text/css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<script
	src="//apis.daum.net/maps/maps3.js?apikey=9c621079df04238fb4709d93de7268c5"></script>
<script>
	var x = 0;
	var y = 0;
	if (${check} == 1) {
		x = ${hel.x}
		y = ${hel.y}
	} else {
		x = ${hosp.x}
		y = ${hosp.y}
	}
</script>
<title>의료시설 상세 페이지</title>
</head>
<body>
	<div id="mddp-container">
		<p style="text-align: left;" />
		<c:if test="${check==1}">

			<font size="+1"><b>${hel.h_nm}</b></font>
			<div id="mddp-detailview">
				<p>세부정보</p>
				<p>주소 : ${hel.location}</p>
				<p>전화번호 : ${hel.tell}</p>
				<p>사이트 : ${hel.hmpg_url}</p>
				<p>진료시간 : ${hel.week_time}</p>
				<p>주말진료시간: ${hel.weekend_time}<br>
				<p>점심시간 : ${hel.break_time}</p> 
				<p>비고 : ${hel.rm}</p>
				<div class="wrapper" style="bottom: 180px;">

					<!-- 별점  -->
					<p class="star_rating">
						<a href="#" class="on">★</a> <a href="#" class="on">★</a> <a
							href="#" class="on">★</a> <a href="#">★</a> <a href="#">★</a>
					</p>
				</div>
			</div>
		</c:if>
		<c:if test="${check!=1}">

			<font size="+1"><b>${hosp.h_nm}</b></font>
			<div id="mddp-detailview">
				<p>세부정보</p>
				<p>주소 : ${hosp.gu_nm} ${hosp.dong}</p>
				<p>
					진료시간 : ${hosp.week_time}<br>
				</p>
				휴무 : ${hosp.rm} <br>
				<div class="wrapper" style="bottom: 180px;">
					<!-- 별점  -->
				</div>
			</div>
		</c:if>
		<div id="mddp-map">
		
			<div id="map" style="width: 100%; height: 100%;"></div>
		<script>
		if(${check==1}){
		// 마커 이미지의 주소 
			var markerImageUrl = '../../img/marker3.png'
		    ,markerImageSize = new daum.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };
		}
		if(${check!=1}){
			var markerImageUrl = '../../img/marker2.png'
			    ,markerImageSize = new daum.maps.Size(40, 42), // 마커 이미지의 크기
			    markerImageOptions = { 
			        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
			    };
		}
		
		var markerImage = new daum.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);
		
		</script>
		<script>
			var mapContainer = document.getElementById('map'), mapOption = {
				center : new daum.maps.LatLng(37.541, 126.986),
				level : 3
			};
			var map = new daum.maps.Map(mapContainer, mapOption);

			var markerPosition = new daum.maps.LatLng(x, y);
			var marker = new daum.maps.Marker({
				image : markerImage,
				position : markerPosition
			});
			marker.setMap(map);
			map.setCenter(markerPosition);
		</script>
		<input type="button" value="닫기">
	</div>
	</div>
</body>
</html>