<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<link href="../CSS/popup.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/popup.js?ver=1.1"></script>
<script>
	function checkIt2() { 
		inputForm = eval("document.inform");
		if (!inputForm.id.value) {
			alert("아이디를 입력하세요.");
			inputForm.id.focus();
			return false;
		} else if (!inputForm.passwd.value) {
			alert("비밀번호를 입력하세요.");
			inputForm.passwd.focus();
			return false;
		}
	}
	function infoCheck() {
		window
				.open("/FORKI/content/join/factor/user/findInfo.jsp", "post",
						"toolbar=no ,width=500 ,height=500,directories=no,status=yes,scrollbars=yes,menubar=no");
	}

	$(function() {
		$(".btn").bind("click", function() {
			$('#inform').attr('action', '/FORKI/content/join/factor/user/loginPro.do').submit();
		});
	});

	$(document).ready(function() {
		$("#findInfo").load("/FORKI/content/join/factor/user/findInfo.jsp");
	});
</script>
</head>
<div id="header-box">
	<div id="logo">
		<a href="/FORKI/content/main/main.do"><img style="position: relative; top:30px;" src="../img/logoo.png" width="415" height="110"></a>
	</div>
	<div>
		<div id="submenu">
			<nav id="topmenu-sub">
				<ul>
					<c:if test="${sessionScope.id == null}">
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/main/main.do">HOME</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="#" onclick="layer_open('layer2');return false;">로그인</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/join/joinSelect.jsp">회원가입</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/siteMap/siteMap.do">사이트맵</a></li>
					</c:if>
					<c:if test="${sessionScope.id != null}">
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/main/main.do">HOME</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/join/factor/user/logout.do">로그아웃</a></li>
						<c:if test="${sessionScope.grade == 0}">
							<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/adminPage/SysMemberCare.do">MyPage</a></li>
						</c:if>
						<c:if test="${sessionScope.grade == 1}">
							<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/join/UserModify.jsp">MyPage</a></li>
						</c:if>
						<c:if test="${sessionScope.grade == 2}">
							<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/join/ComModify.jsp">MyPage</a></li>
						</c:if>

						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/siteMap/siteMap.do">사이트맵</a></li>
					</c:if>
				</ul>
			</nav>
			<div id="displyUser">	
				<c:if test="${sessionScope.id != null}">
					<c:if test="${sessionScope.grade == 0}"><img src="../img/chick4.png"></c:if>
					<c:if test="${sessionScope.grade == 1}"><img src="../img/chick3.png"></c:if>
					<c:if test="${sessionScope.grade == 2}"><img src="../img/chick2.png"></c:if>
					${sessionScope.id}님 환영합니다.
				</c:if>
			</div>
		</div>
		<div id="menubar">
			<nav id="topmenu">
				<ul>
					<li class="topMenuLi"><a class="menuLink" href="/FORKI/content/findKinder/findkinder.do">유치원 찾기</a>
						<ul class="submenu">
							<li class="pop-up"><a href="/FORKI/content/findKinder/findkinder.do" class="submenuLink longLink">유치원 찾기</a></li>
						</ul></li>
					<li class="topMenuLi"><a class="menuLink" href="/FORKI/content/MedicalSystem/searchMedi.do">주변시설 찾기</a>
						<ul class="submenu">
							<li class="pop-up"><a href="/FORKI/content/MedicalSystem/searchMedi.do" class="submenuLink longLink">의료시설조회</a></li>
							<li class="pop-up"><a href="/FORKI/content/LibrarySystem/searchLib.do" class="submenuLink longLink">문화시설조회</a></li>
						</ul></li>
					<li class="topMenuLi"><a class="menuLink" href="/FORKI/content/board/notifyList.do">게시판</a>
						<ul class="submenu">
							<li class="pop-up"><a href="/FORKI/content/board/notifyList.do" class="submenuLink longLink">공지사항</a></li>
							<li class="pop-up"><a href="/FORKI/content/board/recommendList.do" class="submenuLink longLink">건의사항</a></li>
							<li class="pop-up"><a href="/FORKI/content/board/freeBoardList.do" class="submenuLink longLink">맘을 전해요</a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
	</div>
</div>

<div class="layer">
	<div class="bg"></div>
	<div id="layer2" class="pop-layer">
		<div class="pop-container">
			<div class="pop-conts">
				<!--content //-->
				<div style="text-align: center;">
					<form id="inform" name="inform" method="post" onSubmit="return checkIt2();">
						아이디<br> <input type="text" name="id" size="15" maxlength="10"><br> 비밀번호<br> <input type="password" name="passwd"
							size="15" maxlength="10"><br>
					</form>
				</div>
				<div class="btn-r">
					<a class="btn">로그인</a> <a href="#" class="cbtn">뒤로가기</a>
				</div>
				<div style="font-size: 9pt; text-align: center; margin: 10px 0 0px;">
					<a href="#" onclick="layer2_open('layer4');return false;">비밀번호가 기억이 안나세요?</a>
				</div>
				<!--// content-->
			</div>
		</div>
	</div>
</div>

<div class="layer3">
	<div class="bg3"></div>
	<div id="layer4" class="pop-layer3">
		<div class="pop-container3">
			<div class="pop-conts3">
				<!--content //-->
				<div style="height:50px; position: relative; top:10px;"><b>아이디/비밀번호 찾기</b></div>
				<div id="findInfo" style="margin: auto; width: 300px; height: 270px;"></div>
				<div class="btn-r3">
					<a href="#" class="cbtn3">뒤로가기</a>
				</div>
				<!--// content-->
			</div>
		</div>
	</div>
</div>

