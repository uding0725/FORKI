<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<meta name="description"
	content="Camera a free jQuery slideshow with many effects, transitions, adaptive layout, easy to customize, using canvas and mobile ready">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet' id='camera-css' href='../../CSS/camera.css' type='text/css' media='all'>
<link href="../../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../../CSS/global.css?var=1.1" rel="stylesheet" type="text/css">
<link href="../../CSS/style.css?var=1.7" rel="stylesheet" type="text/css">
<style>
body {
	margin: 0;
	padding: 0;
}

a {
	color: #09f;
}

a:hover {
	text-decoration: none;
}

#score {
	clear: both;
	padding-top: 0px;
	padding-bottom: 0px;
	padding-right: 0px;
	padding-left: 0px;
	background: url(../../img/icon_star2.gif) 0px 0px;
	float: left;
	margin: 0px;
	width: 90px;
	height: 18px;
}

#score_over {
	padding-right: 0px;
	padding-left: 0px;
	background: url(../../img/icon_star.gif) 0px 0px;
	padding-bottom: 0px;
	margin: 0px;
	padding-top: 0px;
	height: 18px;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9c621079df04238fb4709d93de7268c5&libraries=services"></script>
<script type="text/javascript" src="../../js/script.js"></script>
<script type='text/javascript' src='../../js/jquery.min.js'></script>
<script type='text/javascript' src='../../js/jquery.mobile.customized.min.js'></script>
<script type='text/javascript' src='../../js/jquery.easing.1.3.js'></script>
<script type='text/javascript' src='../../js/camera.min.js'></script>
<script>	
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
	
	$(document).ready(function() {
		$(function() {
			$("#score_over").css("width", "${totalPer}");
		});
	});
	
	$(function() {
		$("#1").bind("click", function() {
			$("#1").attr("src", "../../img/icon_star.gif");
			$("#2").attr("src", "../../img/icon_star2.gif");
			$("#3").attr("src", "../../img/icon_star2.gif");
			$("#4").attr("src", "../../img/icon_star2.gif");
			$("#5").attr("src", "../../img/icon_star2.gif");
			$("input").attr("onclick","document.location.href='/FORKI/content/findKinder/factor/InsertScore.do?num=${param.num}&score=1'");
		});
		$("#2").bind("click", function() {
			$("#1").attr("src", "../../img/icon_star.gif");
			$("#2").attr("src", "../../img/icon_star.gif");
			$("#3").attr("src", "../../img/icon_star2.gif");
			$("#4").attr("src", "../../img/icon_star2.gif");
			$("#5").attr("src", "../../img/icon_star2.gif");
			$("input").attr("onclick","document.location.href='/FORKI/content/findKinder/factor/InsertScore.do?num=${param.num}&score=2'");
		});
		$("#3").bind("click", function() {
			$("#1").attr("src", "../../img/icon_star.gif");
			$("#2").attr("src", "../../img/icon_star.gif");
			$("#3").attr("src", "../../img/icon_star.gif");
			$("#4").attr("src", "../../img/icon_star2.gif");
			$("#5").attr("src", "../../img/icon_star2.gif");
			$("input").attr("onclick","document.location.href='/FORKI/content/findKinder/factor/InsertScore.do?num=${param.num}&score=3'");
		});
		$("#4").bind("click", function() {
			$("#1").attr("src", "../../img/icon_star.gif");
			$("#2").attr("src", "../../img/icon_star.gif");
			$("#3").attr("src", "../../img/icon_star.gif");
			$("#4").attr("src", "../../img/icon_star.gif");
			$("#5").attr("src", "../../img/icon_star2.gif");
			$("input").attr("onclick","document.location.href='/FORKI/content/findKinder/factor/InsertScore.do?num=${param.num}&score=4'");
		});
		$("#5").bind("click", function() {
			$("#1").attr("src", "../../img/icon_star.gif");
			$("#2").attr("src", "../../img/icon_star.gif");
			$("#3").attr("src", "../../img/icon_star.gif");
			$("#4").attr("src", "../../img/icon_star.gif");
			$("#5").attr("src", "../../img/icon_star.gif");
			$("input").attr("onclick","document.location.href='/FORKI/content/findKinder/factor/InsertScore.do?num=${param.num}&score=5'");
		});
	});
 
</script>
<title>어린이집 상세 정보</title>
</head>
<body>
	<div id="mdKd-container">
		<div style="text-align: left; height: 30px;">
		<font size="+1" style="position: relative; top: 6px; left: 10px;"><b>${name}</b></font>
		</div>
		<div id="mdKd-detailview">
			<font size="+1"><b>세부정보</b></font>
			<br><br><p>주소 : ${addres}</p>
			<br><p>전화번호 : ${tel}</p>
			<br><p>학급수: ${classNo}</p>
			<br><p>학생수(남/여) : 총 ${studentNo}(${studentNo -girlNo}/${girlNo})</p>
			<br><p>전체선생님/여선생님 : ${tcherNo}/${famTcherNo}</p>
			<br><p>비교 : ${param.rm}</p>
			<!-- 이미지 슬라이드 시작 -->
			<div class="fluid_container">
				<div class="camera_wrap camera_azure_skin" id="camera_wrap">
					<!-- 데모 이미지 -->
					<c:if test="${check == 0}">
						<div data-src="../../images/slides/demo1.png">
							<div class="camera_caption fadeFromBottom">이미지를 등록해주세요</div>
						</div>
						<div data-src="../../images/slides/demo2.png">
							<div class="camera_caption fadeFromBottom">이미지를 등록해주세요</div>
						</div>
						<div data-src="../../images/slides/demo3.png">
							<div class="camera_caption fadeFromBottom">이미지를 등록해주세요</div>
						</div>
						<div data-src="../../images/slides/demo4.png">
							<div class="camera_caption fadeFromBottom">이미지를 등록해주세요</div>
						</div>
					</c:if>
					<!-- 데모 이미지 끝 -->
					
					<!-- 목록을 불러와 이미지 슬라이드 생성 -->
					<c:if test="${check >= 1}">
						<c:forEach var="article" items="${imgList}">
							<div data-src="../../images/slides/${article.file_name}">
								<div class="camera_caption fadeFromBottom">${article.message}</div>
							</div>
						</c:forEach>
					</c:if>
					<!-- 이미지 로딩 종료 -->
				</div>
			</div>
			<!-- 이미지 슬라이드 종료 -->
		</div>
		<div id="mdKd-inmap">
			<!-- 지도 시작 -->
			<div id="map" style="width:100%;height:100%;"></div>
			<!-- 지도 종료 -->
		</div>
		<div id="mdKd-menu">
			<div style="float: left; width: 5%;"><br></div>
			<div style="float: left; width: 6%;"> <b>유치원별점</b> </div>
			<div style="float: left; width: 15%;"><div id="score"><p id="score_over"></p></div></div>
			<div style="float: left; width: 6%;"> <b>별점주기</b> </div>
			<div style="float: left; width: 12%;">
				   <img id="1" src="../../img/icon_star.gif"><!--  
				--><img id="2" src="../../img/icon_star.gif"><!-- 
				--><img id="3" src="../../img/icon_star.gif"><!-- 
				--><img id="4" src="../../img/icon_star2.gif"><!-- 
				--><img id="5" src="../../img/icon_star2.gif">
			</div>
			<div style="float: left; width: 10%;"><input id="input" type="button" onclick="document.location.href='/FORKI/content/findKinder/factor/InsertScore.do?num=${param.num}&score=1'" value="입력"></div>
			<div style="float: left; width: 46%; text-align: right;">
				<c:if test="${sessionScope.grade == 1}">
					<input type="button" onclick="document.location.href='/FORKI/content/findKinder/factor/InsertFavor.do?num=${param.num}'" value="관심유치원으로 등록">
				</c:if>
				<c:if test="${param.num == sessionScope.schul_num}">		
					<input type="button" onclick="document.location.href='/FORKI/content/findKinder/factor/ModifyImg.do?num=${param.num}'" value="수정">
				</c:if>
				<input type="button" onclick="self.close()" value="닫기">
			</div>
			
		</div>
	</div>

</body>
</html>