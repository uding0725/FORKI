<%@ page contentType="text/html; charset=UTF-8"%>

<div id="mdK-wrap">
<font size="+2">어린이집/유치원찾기</font>
		<span style='position:absolute; right:0px'>
		<a href="#"><img src="../img/home.png" width="20" height="20"></a>
		<a href="#">>어린이집유치원찾기</a>	
		</span>
	<div id="mdK-container">
		<div id="mdK-header">
			<table border="1" cellpadding=0 cellspacing=0 width="890" height="100">
				<tr>
					<td width="50" align="center">
					<strong> <h5>조회</h5> </strong>
					</td>
					
					<td colspan="1" align="center">
					<input type="radio" name="select" value="all">전체 
					<input type="radio" name="select" value="hospital">어린이집
					<input type="radio" name="select" value="hcenter">유치원
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
		<div id="mdK-content">검색결과 나올창<br>
		<a target="_blank" href="detailPage.jsp" onclick="window.open(this.href,'_blank','width=1000,height=780, scrollbars=yes');return false;">용산구 이태원동 이태원어린이집</a> 
		</div>
			
		<div id="mdK-map">지도 띄울 창</div>
	</div>
</div>
