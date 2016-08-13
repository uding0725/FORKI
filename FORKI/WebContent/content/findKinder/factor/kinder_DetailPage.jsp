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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="../../JS/kinderDetail.js"></script>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=여기에 키를 입력하셈&libraries=services"></script>
<script>
	var boy = ${studentNo - girlNo};
	var girl = ${girlNo};
	google.charts.load("current", {	packages : [ "corechart" ]});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable([ 
			[ 'Pac Man', 'Percentage' ], 
			[ '남아', boy ],
			[ '여아', girl ] 
			]);

        var options = {
 			legend: 'none',
 			title: '남아/여아 비율',
			pieStartAngle: 180,
			slices: {
				0: { color: 'blue' },
				1: { color: 'pink' }
			}
		};

		var chart = new google.visualization.PieChart(document.getElementById('chart'));
		chart.draw(data, options);
	}
	
	window.onload = function () {
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  

		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new daum.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addr2coord('${addres}', function(status, result) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === daum.maps.services.Status.OK) {
		
		        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new daum.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new daum.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${name}</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});
	}
</script>
<title>어린이집 상세 정보</title>
</head>
<body>
	<div id="mdK-container">
		<p style="text-align: left;" />
		<font size="+1"><b>${name}</b></font>
		<div id="mdK-detailview">
			<font size="+1"><b>세부정보</b></font>
			<p>주소 : ${addres}</p>
			<p>전화번호 : ${tel}</p>
			<p>학급수: ${classNo}</p>
			<p>학생수(남/여) : 총 ${studentNo}(${studentNo -girlNo}/${girlNo})</p>
			<p>전체선생님/여선생님 : ${tcherNo}/${famTcherNo}</p>
			<p>비교 : ${param.rm}</p>
			<div id="chart" style="position: relative; bottom: 130px; left: 240px; width: 180px; height: 100px;"></div>
			<div class="wrapper2">
				<!-- 별점  -->
				<p class="star_rating">
					<a href="#" class="on">★</a> <a href="#" class="on">★</a> <a href="#" class="on">★</a> <a href="#">★</a> <a href="#">★</a>
				</p>
			</div>
		</div>
		<div id="mdK-inmap">
			<div id="map" style="width:100%;height:100%;"></div>
		</div>
		<div>
			<input type="button" value="닫기">
		</div>
	</div>

</body>
</html>