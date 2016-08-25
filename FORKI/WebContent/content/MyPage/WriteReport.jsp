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
			alert("내용을 입력하지 않으면 신고할 수 없습니다.");
			document.insertMessage.message.focus();
			return false;
		}
	}
</script>
<title>SendMessage</title>
</head>
<body>
	<div style="margin: auto; width: 500px; height: 450px; overflow: hidden;">
		<form name="insertReport" action="/FORKI/content/MyPage/reportPro.do?id=${sessionScope.id}&sub=${param.subid}" method="post"
		onSubmit="return checkIt()">
			<div style="height: 100px;"><img src="../img/logoo.png" width="415" height="110"></div>
			신고대상 : 아이디 - ${param.subid} 닉네임 - ${param.sub}<br>
			신고위치 : ${param.loc} <br>
			신고사유 : <br>
			<div style="width: 400; height: 200px; text-align: left; flow: left; overflow: auto; overflow-x: hidden; border: 1px solid;">
			<textarea name="content" cols="70" rows="13"></textarea></div>
			<div style="height: 60px; width: 100%; text-align: center;">
				
				
				<br> <input type="submit" value="보내기"> <input type="button" onclick="self.close()" value="닫기">
			</div>
			<input type="hidden" name="loc" value="${param.loc}" >
			<input type="hidden" name="subid" value="${param.subid}" >
		</form>
	
	</div>
</body>
</html>