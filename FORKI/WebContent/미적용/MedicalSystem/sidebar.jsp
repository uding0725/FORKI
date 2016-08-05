<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Side Menu Test</title>
<style>
#md-sidebar {
	width: 140px;
	padding: 5px;
	margin-bottom: 20px;
	float: left;
	border: 1px solid;
}
</style>
</head>
<body>
	<table id="md-sidebar">
		<tr>
			<td>
				<p style="text-align: center;">
					시간별<br>이용가능한<br>시설조회
				</p> <input type="range" name="range" min="1" max="12" step="1" /> <br>
				<br> <select name="select">
					<option value="">전체</option>
					<option value="병원">병원</option>
					<option value="보건소">보건소</option>
			         </select> 
			<input type="button" name="검색" value="검색">

			</td>
	</table>
</body>
</html>