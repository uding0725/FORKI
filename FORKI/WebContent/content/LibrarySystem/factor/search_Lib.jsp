<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<style>
#lib-wrap {
	width: 700px;
	height: 790px;
	margin: 0px auto;
	padding: 0px;
	border: 0px solid;
	padding: 0px;
	position: relative;
}

#lib-container {
	width: 680px;
	height: 700px;
	margin: 0px auto;
	padding: 20px;
	border: 1px solid;
}

#lib-header {
	width: 550px;
	margin-bottom: 20px;
	border: 0px solid;
}

#lib-content {
	width: 250px;
	height: 400px;
	padding: 5px;
	margin-bottom: 10px;
	float: left;
	border: 1px solid;
}

#lib-map {
	width: 380px;
	height: 300px;
	padding: 10px;
	margin: auto;
	margin-bottom: 10px;
	float: right;
	border: 1px solid;
}

a {
	text-decoration: none;
}
</style>

<script>
	function viewDetail(adres,select) {
		url = "/FORKI/content/LibrarySystem/factor/lib_detailPage.do?adres=" + adres+"&select="+select;
		window.open(url, "post", "toolbar=no ,width=1000 ,height=700,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
	var x =new Array();
	var y = new Array();
	var title = new Array();
	var coord = new Array();
</script>	
</head>
<div id="lib-wrap">
	<font size="+2">문화시설</font> <span
		style='position: absolute; right: -20px'> <a href="#"><img
			src="../img/home.png" width="20" height="20"></a> <a href="#">>주변시설</a>
		<a href="#">>문화시설 조회</a>
	</span>
	<div id="lib-container">
		<form name=search_libForm aciton="/FORKI/content/LibrarySystem/searchLib.do">
		<div id="lib-header">
			<table border="1" cellpadding=0 cellspacing=0 width="685" height="100">
				<tr>
					<td width="50" align="center">
					<strong>
							<h5>조회</h5>
					</strong>
					</td>

					<td colspan="1" align="center">
					<input type="radio" name="select" value="all">전체 &nbsp; &nbsp; 
					<input type="radio" name="select" value="tourism_list">산/공원&nbsp; 
					<input type="radio" name="select" value="pub_lib">도서관 &nbsp; 
					<input type="radio" name="select" value="toy_lib">장난감 도서관 
						<br>
						 서울 특별시 구 &nbsp;&nbsp;
						<select name="gu_nm">
							<option value="0">선택하세요</option>
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
					<input type="text" name="dongName" autofocus placeholder="동을 입력하세요"> <br> 기관명 &nbsp; 
					<input type="text" name="searchName" autofocus placeholder="기관명을 입력하세요">
					<!--  <a href="#"><img src="../img/submit.jpg" width="30" height="30"></a></td> -->
				<!-- <a href="javascript:document.search_libForm.onsubmit()"><img src="../img/submit.jpg" width="30" height="30"></a>
				<input  TYPE="IMAGE" src="/img/bt_over.gif" name="Submit" value="Submit"  align="absmiddle"> -->
				<input type="image" src="../img/submit.jpg" name="submit" width="30" height="30" >
				</td>
				</tr>
			</table>
		</div>
		</form>
		<p>총 검색 건수 : ${count} 건</p>
		<div id="lib-content" style="overflow:auto">
	
	<c:if test="${count==0 }">
		검색 결과가 없습니다.
	</c:if>
	<c:if test="${count>0}">
		<c:if test="${select=='all'}">
			<c:if test="${!empty vTour}">
			-산 / 공원
		<c:forEach var="tour" items="${vTour}">
		-명칭 : [${tour.park_se}] ${tour.park_nm} <br>
		 주소 : ${tour.adres} <br>
		 </c:forEach>
		 </c:if>
		
		 <c:if test="${!empty vPub}">
			-도서관
		<c:forEach var="p" items="${vPub}">
		-명칭 : [${p.libry_se}] ${p.libry_name}<br>
		 주소 : ${p.adres} <br>
		 전화번호 : ${p.tel} <br>
				<a href="javascript:viewDetail('${p.adres}','${select}')">[상세정보 보기]</a>
				<br>
				<script>
        			x.push('${p.x_loc}');
        			y.push('${p.y_loc}')
        	
        		</script>
		 </c:forEach>
		 </c:if>
		 
		 <c:if test="${!empty vToy}">
			-장난감 도서관
		
		<c:forEach var="toy" items="${vToy}">
		-명칭 : ${toy.lib_nm} <br>
		 주소 : ${toy.adres} <br>
		 전화번호 : ${toy.tel}  <br>	
				<a href="javascript:viewDetail('${toy.adres}','${select}')">[상세정보 보기]</a>
				<br>	
				<script>
        			x.push('${toy.x}');
        			y.push('${toy.y}')
        	
        		</script>	
		 </c:forEach>
		 </c:if>
		 
		</c:if>
		
		<c:forEach var="v" items="${vt}">
			<c:if test="${select=='tourism_list'}">
				-명칭 :[${v.park_se}] ${v.park_nm}			
				<a target="_blank" href="#"
				onclick="window.open(this.href,'_blank','width=1000,height=780, scrollbars=yes');return false;"></a> <br>
				 주소 : ${v.adres} <br>
				
				 <script>
        			title.push('${v.park_nm}');
        			coord.push('${v.adres}')
        		</script>
			</c:if>
			 <c:if test="${select=='pub_lib'}">
				-명칭 : [${v.libry_se}] ${v.libry_name}			
				<a target="_blank" href="#"
				onclick="window.open(this.href,'_blank','width=1000,height=780, scrollbars=yes');return false;"></a> <br>
				주소 : ${v.adres} <br>
				전화번호 : ${v.tel} <br>
				<a href="javascript:viewDetail('${v.adres}','${select}')">[상세정보 보기]</a>
				<br>
				<script>
        			x.push('${v.x_loc}');
        			y.push('${v.y_loc}')
        	
        		</script>
			</c:if>
			
			<c:if test="${select=='toy_lib'}">
				-명칭 : ${v.lib_nm}			
				 <a target="_blank" href="#"
				onclick="window.open(this.href,'_blank','width=1000,height=780, scrollbars=yes');return false;"></a> <br>
				주소 : ${v.adres} <br>
				전화번호 : ${v.tel}  <br>	
				<a href="javascript:viewDetail('${v.adres}','${select}')">[상세정보 보기]</a>
				<br>	
				<script>
        			x.push('${v.x}');
        			y.push('${v.y}')
        	
        		</script>		
			</c:if> 
			
		</c:forEach>
	</c:if>	
	
		</div>
	<div id="lib-map">
	<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=9c621079df04238fb4709d93de7268c5"></script>
<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new daum.maps.LatLng(37.541,126.986), // 지도의 중심좌표
		        level: 4, // 지도의 확대 레벨
		        mapTypeId : daum.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new daum.maps.Map(mapContainer, mapOption); 
		// 마커 이미지의 주소
			var markerImageUrl = '../img/toy.png'
		    ,markerImageSize = new daum.maps.Size(40, 42), // 마커 이미지의 크기
		    markerImageOptions = { 
		        offset : new daum.maps.Point(20, 42)// 마커 좌표에 일치시킬 이미지 안의 좌표
		    };

		// 마커 이미지를 생성한다
		var markerImage = new daum.maps.MarkerImage(markerImageUrl, markerImageSize, markerImageOptions);

		// 지도에 마커를 생성하고 표시한다
		for(i=0; i<x.length; i++ ){
		var marker = new daum.maps.Marker({
		    position: new daum.maps.LatLng(x[i], y[i]), // 마커의 좌표
		    image : markerImage, // 마커의 이미지
		    map: map // 마커를 표시할 지도 객체
		});
		}
	</script>

	</div>
	</div>
	</div>
	</html>
	