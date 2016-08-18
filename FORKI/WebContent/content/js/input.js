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