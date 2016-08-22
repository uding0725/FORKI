<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	function viewDetail(num) {
		url = "/FORKI/content/findKinder/factor/kinder_DetailPage.do?num=" + num;
		window.open(url, "post", "toolbar=no ,width=1000 ,height=700,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	var title =new Array();
	var coord = new Array();
	
</script>
<div id="mdK-wrap">
<font size="+2">유치원찾기</font>
		<span style='position:absolute; right:0px'>
		<a href="#"><img src="../img/home.png" width="20" height="20"></a>
		<a href="">>유치원찾기</a>	
		</span>
	<div id="mdK-container">
		<div id="mdK-header">
		
			<table border="1" cellpadding=0 cellspacing=0 width="890" height="100">
				<tr>
					<td width="50" align="center">
					<strong> <h5>조회</h5> </strong>
					</td>
				<form>	
					<td colspan="1" align="center"> 
				서울 특별시 시/읍/구 <select name="gu">
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
					읍/면/동<input type="text" name="dong" autofocus placeholder="동을 입력하세요"> 
						<br>
						또는 기관명<input type="text" name="schul_nm" autofocus placeholder="기관명을 입력하세요"> 
						<input type="submit" value="찾기">
						</td>
			</form>
				</tr>
			</table>
			
		</div>
		<p>총 검색 건수 : ${count} 건 </p>
		<div id="mdK-content" style="overflow: auto; overflow-x: hidden">
        	<!-- 추후 검색된 리스트를 링크로 나열하기 위한 코드 -->
        	<c:if test="${count==0}">
        		검색 결과가 없습니다.
        	</c:if>
        	<c:forEach var="kinder" items="${vecList}">
        	<a href="javascript:viewDetail('${kinder.schul_num}')">${kinder.schul_nm}</a> ${kinder.telno}<br>	
        	${kinder.adres}<br>
        	<script>
        	title.push('${kinder.schul_nm}');
        	coord.push('${kinder.adres}')
        	
        	</script>
        	</c:forEach>
			<%-- <c:forEach var="kinderGarten" items="${searchList}">
			<a href="javascript:sendAddress('${number}')">${name}</a>
         	</c:forEach> --%>
		</div>
			
		<div id="mdK-inmap">
			<!-- 지도 시작 -->
			<div id="map" style="width:100%;height:100%;"></div>
			<!-- 지도 종료 -->
		</div>
		<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9c621079df04238fb4709d93de7268c5&libraries=services"></script>

		<script>

			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	   		mapOption = {

	       // center: new daum.maps.LatLng(37.450701, 126.570667), // 지도의 중심좌표

	        center: new daum.maps.LatLng(37.541, 126.986), // 지도의 중심좌표

	        level: 3 // 지도의 확대 레벨
					    };  
			// 지도를 생성합니다    

			var map = new daum.maps.Map(mapContainer, mapOption); 
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new daum.maps.services.Geocoder();
			var addx =new Array();


			for(var i=0; i<coord.length;i++){


	// 주소로 좌표를 검색합니다
	geocoder.addr2coord(coord[i], function(status, result) {

		
	    	// 정상적으로 검색이 완료됐으면 
	     	if (status === daum.maps.services.Status.OK) {
			
	        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new daum.maps.Marker({
	            map: map,
	            position: coords,
	        });      

	        marker.setMap(map);
	        
	        }

	    	

	        }	    

	);

	    	   
	

	geocoder.addr2coord(coord[0], function(status, result) {
			
	    // 정상적으로 검색이 완료됐으면 
	     if (status === daum.maps.services.Status.OK) {
			
	        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
	        
	        map.setCenter(coords);
	     }
	});

		</script>
	</div>
</div>
