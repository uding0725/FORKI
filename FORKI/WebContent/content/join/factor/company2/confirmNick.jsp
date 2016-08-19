<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>NickName 중복확인</title>
<link href="style.css" rel="stylesheet" type="text/css">
<body>

<c:if test="${check == 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td height="39" >${nickname}이미 사용중인 닉네임입니다.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="/FORKI/content/join/factor/company2/confirmNick.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center">
       다른 아이디를 선택하세요.<p>
       <input type="text" size="10" maxlength="12" name="id">
       <input type="submit" value="NickName중복확인">
    </td>
  </tr>
</table>
</form>
</c:if>
<c:if test="${check != 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center">
      <p>입력하신 ${nickname} 는 사용하실 수 있는 NickName입니다. </p>
      <input type="button" value="닫기" onclick="setnickname()">
    </td>
  </tr>
</table>
<a href="javascript:history.go(-1)">[돌아가기]</a>
</c:if>
</body>
</html>
<script>

function setnickname(){
opener.document.userinput.nickname.value="${nickname}";//opener:새로운 창을 연다.
self.close();
}

</script>