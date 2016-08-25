<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="left">
	<div style="height: 160px;">
		<nav id="topmenu-side">
			<ul>
				<c:if test="${sessionScope.grade == 0}">
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/adminPage/SysMemberCare.do">회원관리</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/adminPage/SysBlack_list.do">블랙리스트</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/adminPage/SysApprobation.do">기업가입신청</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/adminPage/signUp.do">유치원등록신청</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/MyPage/ReportList.do">신고함</a></li>
				</c:if>
				<c:if test="${sessionScope.grade == 1}">
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/join/UserModify.jsp">개인정보수정</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/MyPage/MessengerList.do">쪽지함</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="#">관심유치원</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/MyPage/HealthCheck.do">예방접종문진표</a></li>
				</c:if>
				<c:if test="${sessionScope.grade == 2}">
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/join/ComModify.jsp">개인정보수정</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="#">유치원수정</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/MyPage/MessengerList.do">쪽지함</a></li>
					<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/myPage_Buss/kinderInput.do">유치원등록하기</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>
