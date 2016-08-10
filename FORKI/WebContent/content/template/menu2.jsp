<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="left">
	<div style="height:120px;">
		<nav id="topmenu-side">
			<ul>
				<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/MedicalSystem/searchLayout.jsp">의료시설조회</a></li>
				<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/LibrarySystem/searchLib.jsp">문화시설조회</a></li>
			</ul>
		</nav>
	</div>
	<!-- 의료시설조회라면 -->
	<c:if test="${param.medi != null}">
	<div>
		<div id="md-sidebar">
			<p>
				시간별<br>이용가능한<br>시설조회
			</p>
			<input type="range" name="range" min="1" max="12" step="1" /> <br> <br> <select name="select">
				<option value="">전체</option>
				<option value="병원">병원</option>
				<option value="보건소">보건소</option>
			</select> <input type="button" name="검색" value="검색">
		</div>
	</div>
	<!-- 문화시설조회라면 -->
	<!-- md-sidebar 미출력 -->
	</c:if>
</div>
