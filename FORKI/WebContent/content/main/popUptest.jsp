<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link href="../CSS/popup.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/popup.js"></script>
<title>Insert title here</title>
</head>
<body>
	<a href="#" class="btn-example" onclick="layer_open('layer2');return false;">예제-2 보기</a>
	<div class="layer">
		<div class="bg"></div>
		<div id="layer2" class="pop-layer">
			<div class="pop-container">
				<div class="pop-conts">
					<!--content //-->
					<form name="inform" method="port" action="/FORKI/content/join/factor/user/loginPro.do" onSubmit="return checkIt();">
						<div style="text-align: center;">
							아이디<br> <input type="text" name="id" size="15" maxlength="10"><br> 비밀번호<br> <input type="password" name="passwd"
								size="15" maxlength="10"><br>
						</div>
						<div class="btn-r">
							<a href="#" onclick="onSubmit()" class="btn">로그인</a> <a href="#" class="cbtn">뒤로가기</a>
						</div>
						<div style="font-size: 9pt; text-align: center; margin: 10px 0 0px;">
							<a href="#">비밀번호가 기억이 안나세요?</a>
						</div>
					</form>
					<!--// content-->
				</div>
			</div>
		</div>
	</div>
</body>
</html>