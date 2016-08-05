<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>의료시설 조회</title>

<style>
#md-wrap{
 width: 550px;
 height:750px;
 margin:0px auto;
 padding : 0px;
 border :0px solid;
 padding :20px;
 position : relative;
}
#md-container {
	width: 560px;
	height: 700px; 
	margin : 0px auto;
	padding: 20px;
	border: 1px solid;
	
}

#md-header {

    width : 550px;
	margin-bottom: 20px;
	border: 0px solid;
}

#md-content {
	width: 250px;
	height : 400px;
	padding: 5px;
	margin-bottom: 10px;
	float: left;
	border: 1px solid;
}

#md-map {
	width: 250px;
	height : 300px;
	padding: 10px;
	margin-bottom: 10px;
	float: right;
	border: 1px solid;
}
a{
text-decoration: none;
}

</style>
</head>
<body>
<div id="md-wrap">
<font size="+2">의료시설</font>
		<span style='position:absolute; right:-40px'>
		<a href="#"><img src="img/home.png" width="20" height="20"></a>
		<a href="#">>주변시설</a>
		<a href="#">>의료시설 조회</a>		
		</span>
		
		
	<div id="md-container">
   
		
		<div id="md-header">
			<table border="1" cellpadding=0 cellspacing=0 width="555" height="100">
				<tr>
					<td width="50" align="center">
					<strong> <h5>조회</h5> </strong>
					</td>
					
					<td colspan="1" align="center">
					<input type="radio" name="select" value="all">전체 
					<input type="radio" name="select" value="hospital">병원 
					<input type="radio" name="select" value="hcenter">보건소 
					<br> 
					서울 특별시 시/읍/구 <select name="place">
							<option value="">선택하세요</option>
					              </select> 
					읍/면/동<input type="text" name="username" autofocus
						placeholder="동을 입력하세요" required> 
						<br>
						또는 기관명<input type="text" name="username" autofocus placeholder="기관명을 입력하세요" required> 
						<a href="#"><img src="img/submit.jpg" width="30" height="30"></a>
						</td>
				</tr>
			</table>
		</div>
		<p>총 검색 건수 : ? 건 </p>
		<div id="md-content">검색결과 나올창</div>
		
		<div id="md-map">지도 띄울 창</div>
	</div>
</div>
</body>
</html>