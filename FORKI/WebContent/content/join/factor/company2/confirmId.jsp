<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>ID 중복확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<body>

<c:if test="${check == 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td height="39" >${id}이미 사용중인 아이디입니다.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="/FORKI/content/join/factor/company2/confirmId.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center">
       다른 아이디를 선택하세요.<p>
       <input type="text" size="10" maxlength="12" name="id">
       <input type="submit" value="ID중복확인">
    </td>
  </tr>
</table>
</form>
</c:if>
<c:if test="${check != 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center">
      <p>입력하신 ${id} 는 사용하실 수 있는 ID입니다. </p>
      <input type="button" value="닫기" onclick="setid()">
    </td>
  </tr>
</table>

</body>
</html>
</c:if>
<script>

function setid(){
opener.document.userinput.id.value="${id}";//opener:새로운 창을 연다.
self.close();
}

</script>
