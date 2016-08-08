<%@ page contentType="text/html; charset=UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head><title>dd</title></head>
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
<c:if test="true"> 
<td colspan="6" align="center">등록 신청한 유치원이 없습니다.</td>
</c:if>
<c:if test="true">

</c:if>
</table>
<center>
<form>
    <select name="searchn">
    	<option value="0">아이디</option>
    	<option value="1">시설명</option>
    </select>
    <input type="text" name="search" size="10">
    <input type="submit"  value="검색" >
    </form>
</center>
</body>
</html>