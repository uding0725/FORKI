<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>유치원/어린이집 검색</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function schulCheck(){
		if (document.SchulForm.schul_nm.value == ""){
			alert("동이름을 입력하세요");
			document.SchulForm.schul_nm.focus();
			return;
		}
		document.SchulForm.submit();
	}
	
function sendAddress(schul_nm,schul_num){ 
	opener.document.userinput.schul_nm.value=schul_nm;
	opener.document.userinput.schul_num.value=schul_num;
	self.close();
	}
</script>
</head>
<body>
<center>
<b>유치원/어린이집 찾기</b>
<table>
<form name="SchulForm" method="post" action="/FORKI/content/join/factor/company2/SchulCheck.do">
      <tr>
        <td><br>
          유치원명 입력 : <input name="schul_nm" type="text">
          <input type="button" value="검색" onclick= "schulCheck();">
        </td>
      </tr>
     <input type="hidden" name="check" value="n">
    </form>

<c:if test="${ckeck==n}">


   <c:if test="${empty SchulList}">

   <tr><td align="center"><br>검색된 결과가 없습니다.</td></tr>
   </c:if>
   <c:if test="${!empty SchulList}">
<tr><td align="center"><br>
    ※검색 후, 아래 주소를 클릭하면 자동으로 입력됩니다.</td></tr>

<c:forEach var="i" items="${SchulList}">
<c:set var="tempSchul_nm" value="${i.schul_nm}"/>
<c:set var="tempSchul_num" value="${i.schul_num}"/>
<c:set var="tempAdres" value="${i.adres}"/>

<tr><td>
<a href="javascript:sendAddress('${tempSchul_nm}','${tempSchul_num}')">
 ${tempSchul_nm}&nbsp;${tempSchul_num}&nbsp;${tempAdres}</a><br>
</c:forEach>
</c:if>
</c:if>
</td></tr>
<tr><td align="center"><br><a href="javascript:this.close();">닫기</a><tr></td>
</table>
</center>
</body>
</html>