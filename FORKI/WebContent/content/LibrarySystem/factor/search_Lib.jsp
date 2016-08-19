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
			<table border="1" cellpadding=0 cellspacing=0 width="685"
				height="100">
				<tr>
					<td width="50" align="center"><strong>
							<h5>조회</h5>
					</strong></td>

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
		<div id="lib-content">
	<c:if test="${count==0 }">
		검색 결과가 없습니다.
	</c:if>
	<c:if test="${count>0}">
		<c:forEach var="v" items="${vt}">
			${v.park_nm}			
			검색결과 나올창<br> <a target="_blank" href="#"
				onclick="window.open(this.href,'_blank','width=1000,height=780, scrollbars=yes');return false;"></a>
		</c:forEach>
	</c:if>	
		</div>
	
		<div id="lib-map">지도 띄울 창</div>
	</div>
</div>
</html>