<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header-box">
	<div id="logo">
		<a href="../main/main.jsp"><img src="../img/logo.jpg" width="415" height="150"></a>
	</div>
	<div>
		<div id="submenu">
			<nav id="topmenu-sub">
				<ul>
					<c:if test="${sessionScope.id == null}">
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="../main/main.jsp">HOME</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="#">로그인</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/join/joinSelect.jsp"">회원가입</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="#">사이트맵</a></li>
					</c:if>
					<c:if test="${sessionScope.id != null}">
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="../main/main.jsp">HOME</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="#">로그아웃</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="/FORKI/content/MyPage/InfoModify.jsp">MyPage</a></li>
						<li class="topMenuLi-sub"><a class="menuLink-sub" href="#">사이트맵</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
		<div id="menubar">
			<nav id="topmenu">
				<ul>
					<li class="topMenuLi"><a class="menuLink" href="/FORKI/content/findKinder/findkinder.do">어린이집/유치원 찾기</a>
						<ul class="submenu">
							<li class="pop-up"><a href="/FORKI/content/findKinder/findkinder.do" class="submenuLink longLink">어린이집/유치원 찾기</a></li>
						</ul></li>
					<li class="topMenuLi"><a class="menuLink" href="/FORKI/content/MedicalSystem/searchMedi.jsp?">주변시설 찾기</a>
						<ul class="submenu">
							<li class="pop-up"><a href="/FORKI/content/MedicalSystem/searchMedi.jsp" class="submenuLink longLink">의료시설조회</a></li>
							<li class="pop-up"><a href="/FORKI/content/LibrarySystem/searchLib.do" class="submenuLink longLink">문화시설조회</a></li>
						</ul></li>
					<li class="topMenuLi"><a class="menuLink" href="/FORKI/content/board/notifyList.jsp">게시판</a>
						<ul class="submenu">
							<li class="pop-up"><a href="/FORKI/content/board/notifyList.jsp" class="submenuLink longLink">공지사항</a></li>
							<li class="pop-up"><a href="/FORKI/content/board/recommendList.do" class="submenuLink longLink">건의사항</a></li>
							<li class="pop-up"><a href="/FORKI/content/board/freeBoardList.do" class="submenuLink longLink">맘을 전해요</a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
