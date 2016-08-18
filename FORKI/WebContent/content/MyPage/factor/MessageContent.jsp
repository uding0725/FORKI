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
	<div style="margin:auto; width: 500px; height: 410px; overflow: hidden;">
		<div style="height: 100px;"> 로고가 들어갈 자리</div>
		<div style="height: 50px; text-align: left;"> 보낸사람 : ${id}</div>
		<div style="width: 400; height: 200px; text-align: left; flow: left; overflow: auto; overflow-x: hidden; border: 1px solid;">${content}</div>
		<div style="height: 60px; text-align: center;">
			<br>
			<input type="button" onclick="#" value="신고하기">
			<input type="button" onclick="document.location.href='WriteMessage.jsp?id=${id}'" value="답장하기">
			<input type="button" onclick="document.location.href='DeleteMessage.do?num=${param.num}'" value="삭제하기">
			<input type="button" onclick="self.close()" value="닫기">
		</div>
	</div>
</body>
</html>