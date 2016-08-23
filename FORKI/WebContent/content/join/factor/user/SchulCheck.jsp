<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>유치원/어린이집 검색</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function dongCheck(){
		if (document.SchulForm.dong.value == ""){
			alert("동이름을 입력하세요");
			document.SchulForm.dong.focus();
			return;
		}
		document.SchulForm.submit();
	}
	
function sendAddress(schul_nm,adres){
var Schul_nm =schul_nm;
opener.document.userinput.kinderName${param.num}.value=Schul_nm;
self.close();
	}
</script>
</head>
<body>
<center>
<b>유치원/어린이집 찾기</b>
<table>
<form name="SchulForm" method="post" action="/FORKI/content/join/factor/user/SchulCheck.do?num=${param.num}">
      <tr>
        <td><br>
          도로명 주소 입력 : <input name="dong" type="text">
          <input type="button" value="검색" onclick= "dongCheck();">
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
<c:set var="temptAdres" value="${i.adres}"/>

<tr><td>
<a href="javascript:sendAddress(
'${tempSchul_nm}','${temptAdres}')">
 ${tempSchul_nm}&nbsp;${temptAdres}</a><br>
</c:forEach>
</c:if>
</c:if>
</td></tr>
<tr><td align="center"><br><a href="javascript:this.close();">닫기</a><tr></td>
</table>
</center>
</body>
</html>