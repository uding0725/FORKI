<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
#score {
	clear: both;
	padding-top: 0px;
	padding-bottom: 0px;
	padding-right: 0px;
	padding-left: 0px;
	background: url(../img/icon_star2.gif) 0px 0px;
	float: left;
	margin: 0px;
	width: 90px;
	height: 18px;
}

#score_over {
	padding-right: 0px;
	padding-left: 0px;
	background: url(../img/icon_star.gif) 0px 0px;
	padding-bottom: 0px;
	margin: 0px;
	padding-top: 0px;
	height: 18px;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
	function viewDetail(num) {
		url = "/FORKI/content/findKinder/factor/kinder_DetailPage.do?num=" + num;
		window.open(url, "post", "toolbar=no ,width=1000 ,height=700,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	var title =new Array();
	var x = new Array();
	var y = new Array();
	var coords;
</script>
<style>
#score {
	clear: both;
	padding-top: 0px;
	padding-bottom: 0px;
	padding-right: 0px;
	padding-left: 0px;
	background: url(../img/icon_star2.gif) 0px 0px;
	float: left;
	margin: 0px;
	width: 90px;
	height: 18px;
}

#score_over {
	padding-right: 0px;
	padding-left: 0px;
	background: url(../img/icon_star.gif) 0px 0px;
	padding-bottom: 0px;
	margin: 0px;
	padding-top: 0px;
	height: 18px;
}
</style>
<div id="mdK-wrap">
	<div style="width: 940px; height: 40px; margin:auto; position:relative; font-family: 'Jeju Gothic', serif;">
		<img src="../img/chick2.png"style="position:relative; top:10px;" width="35" height="35"> <font size="+2">유치원찾기</font>
		<span style='position: absolute; right: 0px'>
		<a href="/FORKI/content/main/main.do">
		<img src="../img/home.png" width="20" height="20"></a>
		<a style="text-decoration: none;color:black;" href="">>유치원찾기</a>
		</span>
	</div>
	<div id="mdK-container">
		<div id="mdK-header">
			<table border="1" cellpadding=0 cellspacing=0 width="940" height="100">
				<tr>
					<td width="80" align="center"><strong>
							<h3>조회</h3>
					</strong></td>
					<form>
						<td colspan="1" align="center">서울 특별시 구 <select name="gu">
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
						</select> 동 <input type="text" name="dong" autofocus placeholder="동을 입력하세요"> <br> 또는 기관명<input type="text" name="schul_nm" autofocus
							placeholder="기관명을 입력하세요"> <input type="submit" value="찾기">
						</td>
					</form>
				</tr>
			</table>

		</div>
		<div style="height: 30px; bottom: 10px;">
			<p> 총 검색 건수 : ${count} 건</p>
		</div>
		<div id="mdK-content" style="overflow: auto; overflow-x: hidden">
			<!-- 추후 검색된 리스트를 링크로 나열하기 위한 코드 -->
			<c:if test="${count==0}">
        		 검색 결과가 없습니다.
        	</c:if>
        	<c:if test="${count>0}">
			<c:forEach var="kinder" items="${vecList}">
			<c:set var="number" value="${number+1}"/>
			명칭 : <a href="javascript:viewDetail('${kinder.schul_num}')">${kinder.schul_nm}</a><br>
        	주소 : ${kinder.adres}<br>
        	전화번호 : ${kinder.telno }<br>
        	<div id="score" ><p id="score_over" class="score_over${number}"></p></div>&nbsp; 참여자수:(${kinder.tsdata.count}) <br>	
			<script>
			$(function(){
				$(".score_over${number}").css("width", "${kinder.tsdata.t_score}");
			});
        	title.push('${kinder.schul_nm}');
        	if(${kinder.x}!=null){
        	x.push('${kinder.x}');
        	y.push('${kinder.y}');
        	}else{
        		coords='${kinder.adres}'
        	}
        	</script>
			</c:forEach>
			<%-- <c:forEach var="kinderGarten" items="${searchList}">
			<a href="javascript:sendAddress('${number}')">${name}</a>
         	</c:forEach> --%>
         	</c:if>
		</div>

		<div id="mdK-inmap">
			<!-- 지도 시작 -->
			<div id="map" style="width: 100%; height: 100%;"></div>
			<!-- 지도 종료 -->
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
		// 지도에 마커를 생성하고 표시한다
		if(x.length>0){
		for(i=0; i<title.length; i++ ){
			
			var	mposition = new daum.maps.LatLng(x[i], y[i]);
			
			var marker = new daum.maps.Marker({
		  	 	position: mposition, // 마커의 좌표
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
		}else{
			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new daum.maps.services.Geocoder();
			
			// 주소로 좌표를 검색합니다
			geocoder.addr2coord(coord, function(status, result) {
			
			    // 정상적으로 검색이 완료됐으면 
			     if (status === daum.maps.services.Status.OK) {
			
			        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
			
			        // 결과값으로 받은 위치를 마커로 표시합니다
			        var marker = new daum.maps.Marker({
			            map: map,
			            position: coords
			        });
			
			        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			        map.setCenter(coords);
			    } 
			});
		}
		
		</script>
	</div>
</div>
