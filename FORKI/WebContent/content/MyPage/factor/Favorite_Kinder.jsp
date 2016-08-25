<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	function viewDetail(num) {
		url = "/FORKI/content/findKinder/factor/kinder_DetailPage.do?num=" + num;
		window.open(url, "post", "toolbar=no ,width=1000 ,height=700,directories=no,status=yes,scrollbars=yes,menubar=no");
	}
</script>
<img src="../img/chick/icon6.png" width="30" height="30"  style="position:relative; top:5px;"><font size="+2">관심 등록유치원</font>
<div style="width: 750px;">
	<div style="height: 30px;"></div>
	<c:if test="${articleList =='[]'}">
		<div style="width: 720px; height: 400px; margin: auto;">
			<table style="width: 720px; height: 300px; margin: auto; border: 1px solid;">
		
				<tr>
					<th>관심등록한 유치원이 없습니다.</th>
				</tr>
	
			</table>
		</div>
	</c:if>	
	<c:forEach var="favorList" items="${articleList}">
		<div style="width: 720px; height: 90px; margin: auto;">
			<div style="width:520px; position: relative; float: left; left: 10px">
				<table style="width: 520px; border: 1px solid;">
					<tr>
						<td>${favorList.schul_nm}</td>
					</tr>
					<tr>
						<td>주소 : ${favorList.adres}</td>
					</tr>
					<tr>
						<td>학급수 : ${favorList.clas_co}</td>
					</tr>
					<tr>
						<td>학생수: 총 ${favorList.stdnt_co_sm}(남:${favorList.stdnt_co_sm -favorList.grlstdn_co}/여:${favorList.grlstdn_co})</td>
					</tr>
				</table>
			</div>
			<div style="width:180px; magrin:auto; position: relative; float: right; right: 10px">
				<input type="button" onclick="javascript:viewDetail('${favorList.schul_num}')" value="상세보기" 
					style="width: 180px; height: 86px;" >
			</div>
		</div>
		<div style="width: 720px; margin: auto;"><hr></div>
	</c:forEach>
</div>