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
		document.insertMessage.message.focus();
	}
	function checkIt() {
		if (!document.insertMessage.message.value) {
			alert("이름을 입력하지 않으셨습니다.");
			document.insertMessage.message.focus();
			return false;
		}
	}
</script>
<title>SendMessage</title>
</head>
<body>
	<div style="margin: auto; width: 500px; height: 410px; overflow: hidden;">
		<form name="insertMessage" action="/FORKI/MyPage/factor/SendMessage.do?id=${param.id}" method="post"
		onSubmit="return checkIt()">
			<div style="height: 100px;"><img src="../img/logoo.png" width="200px" height="100%"></div>
			<div style="height: 50px; text-align: right;">받는사람 : ${param.id}</div>
			<div style="width: 400; height: 200px; text-align: left; flow: left; overflow: auto; overflow-x: hidden; border: 1px solid;">
			<textarea name="message" cols="70" rows="13"></textarea></div>
			<div style="height: 60px; text-align: center;">
				<br> <input type="submit" value="보내기"> <input type="button" onclick="self.close()" value="닫기">
		</form>
	</div>
	</div>
</body>
</html>