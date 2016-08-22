<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="left">
	<div style="height:120px;">
		<nav id="topmenu-side">
			<ul>
				<li class="topMenuLi-side"><a class="menuLink-side" href="/FORKI/content/MedicalSystem/searchMedi.jsp">의료시설조회</a></li>
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
			<form method="post" action="/FORKI/content/MedicalSystem/searchMedi.do">
			<input type="range" name="start" min="0" max="24" step="2" value="0" onchange="updateValue(this.value)"/>
			<span id="textInput">0시~24시</span>
			<script>
				function updateValue(val) {
   				 document.getElementById('textInput').innerHTML=val+"시~ 24시"; 
  				}
			</script>
				<input type="hidden" name="check" value="1">
			 <br> <select name="search">
				<option value="0">전체</option>
				<option value="1">병원</option>
				<option value="2">보건소</option>
			</select> <input type="submit" name="검색" value="검색">
			</form>		
		</div>
	</div>
	<!-- 문화시설조회라면 -->
	<!-- md-sidebar 미출력 -->
	</c:if>
</div>
