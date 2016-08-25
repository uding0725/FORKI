<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
textarea {
	resize: none;
}
</style>
<script>
	moveTo(300, 200)
	window.onload = function begin() {
		document.insertReport.content.focus();
	}
	function checkIt() {
		if (!document.insertReport.content.value) {
			alert("내용을 입력하지 않으셨습니다.");
			document.insertMessage.message.focus();
			return false;
		}
	}
</script>
<title>SendMessage</title>
</head>
<body>
	<div style="margin: auto; width: 500px; height: 410px; overflow: hidden;">
		<form name="insertReport" action="/FORKI/content/MyPage/reportPro.do?id=${param.id}&sub=${param.sub}" method="post"
		onSubmit="return checkIt()">
			<div style="height: 100px;"><img src="../img/logoo.png" width="415" height="110"></div>
			<div style="height: 50px; text-align: left;">받는사람 : ${param.sub}</div>
			<div style="width: 400; height: 200px; text-align: left; flow: left; overflow: auto; overflow-x: hidden; border: 1px solid;">
			신고사유 : <br>
			<textarea name="content" cols="70" rows="13"></textarea></div>
			<div style="height: 60px; text-align: center;">
				<br> <input type="submit" value="보내기"> <input type="button" onclick="self.close()" value="닫기">
		</form>
	</div>
	</div>
</body>
</html>