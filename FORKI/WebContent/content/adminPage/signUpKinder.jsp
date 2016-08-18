<%@ page contentType="text/html; charset=UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head><title>dd</title>

</head>
<body>
<b>유치원 등록신청</b>
<table border="1" width="760" cellpadding="0" cellspacing="0" align="center">
<tr>
<td align="center"  width="50">번호</td>
<td align="center"  width="100">I D</td>
<td align="center"  width="150">시설명</td>
<td align="center"  width="150">사업자번호</td>
<td align="center"  width="150">신청일</td>
<td align="center"  width="150">승인란</td>
</tr>
<c:if test="${count==0 }"> 
<td colspan="6" align="center">등록 신청한 유치원이 없습니다.</td>
</c:if>
<c:if test="${count!=0}">
<c:forEach var="i" items="${vecList}" >
<tr>
<td align="center"  width="50">
<c:out value="${number}"/>
<c:set var="number" value="${number-1 }"/>
</td>
<td align="center"  width="100">${i.kdb.id}</td>
<td align="center"  width="150">${i.schul_nm}</td>
<td align="center"  width="150">${i.schul_num}</td>
<td align="center"  width="100">${i.reg_date}</td>

<td align="center"  width="150">   
<input type="button" name="btnacc" value="승인" onclick="document.location.href='/FORKI/content/adminPage/updateState.do?schul_num=${i.schul_num}'">
<input type="button" name="btncan" value="거절" onclick="document.location.href='/FORKI/content/adminPage/deleteKinder.do?schul_num=${i.schul_num}'">
</td>
</tr>
</c:forEach>
</c:if>
</table>
<span di>
<center>
<c:if test="${count>0 }">
<c:set var="pageCount" value="${count/pageSize==0?0:1}"/>
<c:set var="pageBlock" value="${10}"/>
<fmt:parseNumber var="result" value="${currentPage/10}" integerOnly="true"/>
<c:set var="startPage" value="${result *10+1}"/>
<c:set var="endPage" value="${startPage+pageBlock-1}"/>
<c:if test="${endPage>pageCount}">
<c:set var="endPage" value="${pageCount}"/>
</c:if>
<c:if test="${startPage>10}">
	<a href="/FORKI/content/adminPage/signUp.do?pageNum=${startPage-10}">[이전]</a>
</c:if>
<c:forEach var="i" begin="${startPage}" end="${endPage}">
<a href="/FORKI/content/adminPage/signUp.do?pageNum=${i}">[${i}]</a>
</c:forEach>
<c:if test="${endPage<pageCount}">
	<a href="/FORKI/content/adminPage/signUp.do?pageNum=${startPage+10}">[다음]</a>
</c:if>
</c:if>
</center>
<form align="right">
    <select name="searchn">
    	<option value="0">아이디</option>
    	<option value="1">시설명</option>
    </select>
    <input type="text" name="search" size="10">
    <input type="submit"  value="검색" >
    </form>
</span>
</body>
</html>