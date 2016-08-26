<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function viewDetail(num,i) {
		url = "/FORKI/content/MedicalSystem/factor/searchdetailPage.do?num=" + num+"&check="+i;
		window.open(url, "post", "toolbar=no ,width=1000 ,height=700,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	var title =new Array();
	var title2 =new Array();
	var x = new Array();
	var y = new Array();
var title1=new Array();
</script>
<div id="md-wrap">
	<div id="md-title">
		<img src="../img/chick1.png"style="position:relative; top:10px;" width="35" height="35"> <font size="+2">의료시설</font>
		<span style="position:absolute; right: 5px; top: 5px;">
			<a href="/FORKI/content/main/main.do">
			<img style="position: relative; top: 2px;" src="../img/home.png" width="20" height="20"></a>
			<a style="text-decoration: none;color:black;" href="/FORKI/content/MedicalSystem/searchMedi.do">>주변시설</a>
			<a style="text-decoration: none;color:black;" href="">>의료시설 조회</a>		
		</span>	
	</div>
	<div id="md-container">
		<div id="md-header">
				<form method="post" name="searchmediform"action="/FORKI/content/MedicalSystem/searchMedi.do">
			<table border="1" cellpadding=0 cellspacing=0 width="740" height="100">
				<tr>
					<td width="80" align="center">
					<strong> <h3>조회</h3> </strong>
					</td>
					<td colspan="1" align="center">
					<input type="hidden" name="check" value="0">
					<input type="radio" name="select" value="all" checked="checked">전체 
					<input type="radio" name="select" value="hospital">병원 
					<input type="radio" name="select" value="hcenter">보건소 <br> 
					서울 특별시 시/읍/구 <select name="gu_nm">
							<option value="0">전체</option>
							<option value="1">강남구</option>
							<option value="2">강동구</option>
							<option value="3">강북구</option>
							<option value="4">강서구</option>
							<option value="5">관악구</option>
							<option value="6">광진구</option>
							<option value="7">구로구</option>
							<option value="8">금천구</option>
							<option value="9">노원구</option>
							<option value="10">도봉구</option>
							<option value="11">동대문구</option>
							<option value="12">동작구</option>
							<option value="13">마포구</option>
							<option value="14">서대문구</option>
							<option value="15">서초구</option>
							<option value="16">성동구</option>
							<option value="17">성북구</option>
							<option value="18">송파구</option>
							<option value="19">양천구</option>
							<option value="20">영등포구</option>
							<option value="21">용산구</option>
							<option value="22">은평구</option>
							<option value="23">종로구</option>
							<option value="24">중랑구</option>
							<option value="25">중구</option>
					</select>  
					읍/면/동<input type="text" name="dong" autofocus placeholder="동을 입력하세요"><br>
					또는 기관명<input type="text" name="h_nm" autofocus placeholder="기관명을 입력하세요"> 
					<input style="position: relative; top: 9px;" type="image" src="../img/submit.jpg" width="30" height="30">
				</tr>
			</table>
			</form>
		</div>
		<div style="height: 30px; width:740px; margin: auto; bottom: 10px;">
			<p>총 검색 건수 : ${count} 건 </p>
		</div>
		<div id="md-content" style="overflow: auto; overflow-x: hidden">
			<c:if test="${count==0}">
				검색 결과가 없습니다. 
			</c:if>
			<c:if test="${count>=0}">
				<c:if test="${!empty vecList2}">
					<c:forEach var="health" items="${vecList2}">
						명칭 : <a href="javascript:viewDetail('${health.num}',1)">${health.h_nm}</a>
						<br>
						주소 : 	${health.location}<br>
						<script>
					title.push('${health.h_nm}')
					title1.push('${health.h_nm}')
					x.push('${health.x}');
					y.push('${health.y}');
					</script>
					</c:forEach>
				</c:if>
				<c:if test="${!empty vecList}">
					<c:forEach var="hosp" items="${vecList}">
						명칭 : <a href="javascript:viewDetail('${hosp.num}',2)">${hosp.h_nm}</a>
						<br>
						주소 : 서울특별시	${hosp.gu_nm} ${hosp.dong}<br>
						<script>
						title.push('${hosp.h_nm}')
					title2.push('${hosp.h_nm}')
					x.push('${hosp.x}');
					y.push('${hosp.y}');
					</script>
					</c:forEach>
				</c:if>
			</c:if>

		</div>
		<div id="md-map">
			<div style="height: 35px; width: 100%; border-bottom: 1px solid"> 
				<img src="../img/marker3.png" style="position: relative; top: 0px;" width="25" height="25">: 보건소 
				<img src="../img/marker2.png" style="position: relative; top: 2px;" width="25" height="25">: 병원
			</div>
				
			<div id="map" style="width: 100%; height: 564px;"></div>

		</div>
		<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9c621079df04238fb4709d93de7268c5&libraries=services"></script>
		<script>

		if(${count}==0){
			var mapContainer =document.getElementById('map'),
			mapOption={
					center: new daum.maps.LatLng(37.541,126.986),
					level:4
			}
		}else{
			var mapContainer =document.getElementById('map'),
			mapOption={
					center: new daum.maps.LatLng(x[0],y[0]),
					level:4
			}
		}
		var map = new daum.maps.Map(mapContainer,mapOption);
		</script>
		<script>
		// 지도에 마커를 생성하고 표시한다
		if(title1.length>0){
			var markerImageUrl = '../img/marker3.png'
			    ,markerImageSize = new daum.maps.Size(40, 42), // 마커 이미지의 크기
			    markerImageOptions= { 
			        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
			    };
			var markerImage = new daum.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);
		for(i=0; i<title1.length; i++){
			
			var	mposition = new daum.maps.LatLng(x[i], y[i]);
			
			var marker = new daum.maps.Marker({
		  	 	position: mposition, // 마커의 좌표
		   		image : markerImage, //마커이미지
		  	 	map: map // 마커를 표시할 지도 객체
				});
		
			 var iwContent = title[i]; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		
			// 인포윈도우를 생성합니다
			var infowindow = new daum.maps.InfoWindow({
		    	content : iwContent,
		    	position : mposition
					}); 
		
		daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
	    daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		
	  	//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	    function makeOverListener(map, marker, infowindow) {
	        return function() {
	            infowindow.open(map, marker);
	        };
	    }

	    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	    function makeOutListener(infowindow) {
	        return function() {
	            infowindow.close();
	        };
	    }
	    
		}
	}
		</script>
			<script>
		
		if(title2.length>0){
			var markerImageUrl = '../img/marker2.png'
			    ,markerImageSize= new daum.maps.Size(40, 42), // 마커 이미지의 크기
			    markerImageOptions = { 
			        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
			    };
			var markerImage = new daum.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);
			for(i=title1.length; i<(title1.length+title2.length); i++){
				
				var	mposition = new daum.maps.LatLng(x[i], y[i]);
				
				var marker = new daum.maps.Marker({
			  	 	position: mposition, // 마커의 좌표
			   		image : markerImage, //마커이미지
			  	 	map: map // 마커를 표시할 지도 객체
					});
			
				 var iwContent = title[i]; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
			
				// 인포윈도우를 생성합니다
				var infowindow = new daum.maps.InfoWindow({
			    	content : iwContent,
			    	position : mposition
						}); 
			
			daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
			
		  	//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		    function makeOverListener(map, marker, infowindow) {
		        return function() {
		            infowindow.open(map, marker);
		        };
		    }

		    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		    function makeOutListener(infowindow) {
		        return function() {
		            infowindow.close();
		        };
		    }
		    
			}
		}
		
		</script>
	</div>
</div>