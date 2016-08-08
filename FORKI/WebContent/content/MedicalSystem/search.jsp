<%@ page contentType="text/html; charset=UTF-8"%>

<head>
<link href="../CSS/reset.css" rel="stylesheet" type="text/css">
<link href="../CSS/global.css" rel="stylesheet" type="text/css">
<link href="../CSS/style.css?var=1.1" rel="stylesheet" type="text/css">
</head>
	<div id="md-wrap">
		<font size="+2">의료시설</font>
		<span style='position:absolute; right:-20px'>
		<a href="#"><img src="../img/home.png" width="20" height="20"></a>
		<a href="#">>주변시설</a>
		<a href="#">>의료시설 조회</a>		
		</span>	
	<div id="md-container">
		<div id="md-header">
			<table border="1" cellpadding=0 cellspacing=0 width="685" height="100">
				<tr>
					<td width="50" align="center">
					<strong> <h5>조회</h5> </strong></td>
					<td colspan="1" align="center">
					<input type="radio" name="select" value="all">전체 
					<input type="radio" name="select" value="hospital">병원 
					<input type="radio" name="select" value="hcenter">보건소 <br> 
					서울 특별시 시/읍/구 <select name="place"><option value="">선택하세요</option></select> 
					읍/면/동<input type="text" name="username" autofocus placeholder="동을 입력하세요" required><br>
					또는 기관명<input type="text" name="username" autofocus placeholder="기관명을 입력하세요" required> 
					<a href="#"><img src="../img/submit.jpg" width="30" height="30"></a></td>
				</tr>
			</table>
		</div>
		<p>총 검색 건수 : ? 건 </p>
		<div id="md-content">
			검색결과 나올창<br>
			<a target="_blank" href="detailPage.jsp" onclick="window.open(this.href,'_blank','width=1000,height=780, scrollbars=yes');return false;">용산구 순천향대학병원</a> 
		</div>
		<div id="md-map">지도 띄울 창
		</div>
	</div>
</div>