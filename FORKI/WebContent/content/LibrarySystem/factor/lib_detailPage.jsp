<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<title>문화시설 상세 페이지</title>
<style>
#lb-container {
	width: 950px;
	height: 700px;
	margin: 0px auto;
	padding: 20px;
	border: 0px solid;
	position: relative;
	margin-bottom: 20px;
}

#lb-detailview {
	width: 440px;
	height: 500px;
	margin: 5px;
	padding: 10px;
	border: 1px solid;
	margin-bottom: 10px;
	float: left;
}

#lb-map {
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
	<div id="lb-container">
		<p style="text-align: left;" />
		<font size="+1"><b>문화시설 세부정보</b></font>
		<div id="lb-detailview">
		
		 <c:if test="${type=='tour'}">
		  <h2> 세부정보 </h2>
		  <br>
		  	<p>구분 : ${article.park_se}</p>
		  	<br>
			<p>명칭: ${article.park_nm}</p>
			<br>
			<p>주소 : ${article.adres}</p>
			<br>
			
			 <script>
			 var x = '${article.x}';
			 var y = '${article.y}';
			 var title = '${article.park_nm}'
			 </script>
			
		  </c:if>
		 
		 
		 
		 
		 
		  <c:if test="${type=='toy'}">
		  <h2> 세부정보 </h2>
		  <br>
			<p>명칭: ${article.lib_nm}
			<br>
			<p>주소 : ${article.adres}</p>
			<br>
			<p>전화번호 : ${article.tel}</p>
			<br>
			<p>사이트 :<a href="${article.website}">${article.website}</a></p>
			<br>
			 <script>
			 var x = '${article.x}';
			 var y = '${article.y}';
			 var title = '${article.lib_nm}'
			 </script>
			
		  </c:if>
		  <c:if test="${type=='p'}">   
		 
		  <h2> 세부정보 </h2>
		  <br>
		  <p>구분 : ${article.libry_se}
		  <br>
			<p>명칭: ${article.libry_name}
			<br>
			<p>주소 : ${article.adres}</p>
			<br>
			<p>전화번호 :${article.tel}</p> 
			<br>
			<p>사이트 :<a href="${article.website}">${article.website}</a></p>
			<br>
			<p>휴관일 : ${article.libry_close_date}</p>
			<br>
			<script>
			 var x = '${article.x_loc}';
			 var y = '${article.y_loc}';
			 var title = '${article.libry_name}'
			 </script>
			</c:if>   
		</div> 
		
		<div id="lb-map">
		<div id="map" style="width:100%;height:100%;"></div>

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9c621079df04238fb4709d93de7268c5"></script>
<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapCenter = new daum.maps.LatLng(x, y),
			mapOption = {
		        center: mapCenter, // 지도의 중심좌표
		        level: 4, // 지도의 확대 레벨
		        mapTypeId : daum.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new daum.maps.Map(mapContainer, mapOption); 
		</script>
		<script>
		if(${type=='tour'}){
		// 마커 이미지의 주소
			var markerImageUrl = '../../img/marker3.png'
		    ,markerImageSize = new daum.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };
		}
		if(${type=='p'}){
			var markerImageUrl = '../../img/marker2.png'
			    ,markerImageSize = new daum.maps.Size(40, 42), // 마커 이미지의 크기
			    markerImageOptions = { 
			        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
			    };
		}
		if(${type=='toy'}){
			var markerImageUrl = '../../img/marker4.png'
			    ,markerImageSize = new daum.maps.Size(40, 42), // 마커 이미지의 크기
			    markerImageOptions = { 
			        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
			    };
		}
		</script>
		<script>

		// 마커 이미지를 생성한다
		var markerImage = new daum.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);

		// 지도에 마커를 생성하고 표시한다
		
		var marker = new daum.maps.Marker({
		    position: mapCenter, // 마커의 좌표
		    image : markerImage, // 마커의 이미지
		    map: map // 마커를 표시할 지도 객체
		});
		
		var mLabel = new daum.maps.InfoWindow({
		    position: mapCenter, // 지도의 중심좌표에 올립니다.
		    content: title // 인포윈도우 내부에 들어갈 컨텐츠 입니다.
		});
		mLabel.open(map, marker); 
	
	</script>

	</div>
	</div>
	
	

</body>
</html>