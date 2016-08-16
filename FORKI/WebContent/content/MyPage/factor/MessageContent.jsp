<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Message</title>
</head>
<body>
	<div style="margin:auto; width: 500px; height: 500px; overflow: hidden;">
		<div style="height: 100px;">로고가 들어갈 자리</div>
		<div style="height: 50px; text-align: left;">보낸사람 : ${id}</div>
		<div style="width: 400; height: 200px; text-align: left; flow: left; overflow: auto; overflow-x: hidden">${content}</div>
		<div style="height: 50px; text-align: center;">
			<input type="button" onclick="#" value="신고하기">
			<input type="button" onclick="#" value="답장하기">
			<input type="button" onclick="#" value="닫기">
		</div>
	</div>
</body>
</html>