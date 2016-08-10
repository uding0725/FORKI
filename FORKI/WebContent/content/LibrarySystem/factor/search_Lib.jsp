<%@ page contentType="text/html; charset=UTF-8"%>


<html>
<head>
<style>
#md-wrap{
 width: 700px;
 height:790px;
 margin:0px auto;
 padding : 0px;
 border :0px solid;
 padding :0px;
 position : relative;
}
#md-container {
	width: 680px;
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
	width: 380px;
	height : 300px;
	padding: 10px;
	margin: auto;
	margin-bottom: 10px;
	float: right;
	border: 1px solid;
}
a{
text-decoration: none;
}

</style>
</head>
<div id="md-wrap">
<font size="+2">문화시설</font>
		<span style='position:absolute; right:-20px'>
		<a href="#"><img src="../img/home.png" width="20" height="20"></a>
		<a href="#">>주변시설</a>
		<a href="#">>문화시설 조회</a>		
		</span>
	<div id="lib-container">	
		<div id="lib-header">
			<table border="1" cellpadding=0 cellspacing=0 width="685" height="100">
				<tr>
					<td width="50" align="center">
					<strong> <h5>조회</h5> </strong>
					</td>
					
					<td colspan="1" align="center">
					<input type="radio" name="select" value="all">전체 
					<input type="radio" name="select" value="hospital">산/공원
					<input type="radio" name="select" value="hcenter">도서관
					<input type="radio" name="select" value="toy">장난감 도서관
					<br> 
					서울 특별시 시/읍/구 <select name="place">
							<option value="">선택하세요</option>
					              </select> 
					읍/면/동<input type="text" name="username" autofocus
						placeholder="동을 입력하세요" required> 
						<br>
						또는 기관명<input type="text" name="username" autofocus placeholder="기관명을 입력하세요" required> 
						<a href="#"><img src="../img/submit.jpg" width="30" height="30"></a>
						</td>
				</tr>
			</table>
		</div>
		<p>총 검색 건수 : ? 건 </p>
		<div id="md-content">
			검색결과 나올창<br>
			<a target="_blank" href="detailPage.jsp" onclick="window.open(this.href,'_blank','width=1000,height=780, scrollbars=yes');return false;"></a> 
		</div>
		
		<div id="md-map">지도 띄울 창</div>
	</div>
</div>
</html>