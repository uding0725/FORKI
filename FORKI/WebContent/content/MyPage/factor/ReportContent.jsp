<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
	moveTo(300, 200)
</script>
<title>Message</title>
</head>
<body>
	<div style="margin: auto; width: 500px; height: 410px; overflow: hidden;">
		<div style="height: 100px;">
			<table>
				<tr>
					<td height="30">신고자</td>
					<td>${reporter}</td>
				</tr>
				<tr>
					<td height="30">신고대상</td>
					<td>${sub_report}</td>
				</tr>
				<tr>
					<td height="30">신고위치</td>
					<td>${location}</td>
				</tr>
			</table>
		</div>
		<div style="width: 400; height: 200px; text-align: left; flow: left; overflow: auto; overflow-x: hidden; border: 1px solid;">${content}</div>
		<div style="height: 60px; text-align: center;">
			<br> 
			<input type="button" onclick="#" value="탈퇴시키기">
			<input type="button" onclick="document.location.href='DeleteReport.do?num=${param.num}'" value="삭제하기"> 
			<input type="button" onclick="self.close()" value="닫기">
		</div>
	</div>
</body>
</html>