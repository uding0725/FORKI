<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<c:if test="${check==0}">
비밀번호가 다릅니다.
<br>
<a href="javascript:history.go(-1)">[돌아가기]</a>
</c:if>
<c:if test="${check==1}">
<%
	session.invalidate();
%>
<body>
<form method="post" action="/FORKI/content/join/ComMain.do" name="userinput" >
<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
  <tr>
    <td height="39" align="center">
  <font size="+1" ><b>회원정보가 삭제되었습니다.</b></font></td>
  </tr>
  <tr>
    <td align="center">
      <p>흑흑.... 서운합니다. 안녕히 가세요.</p>
      <meta http-equiv="Refresh" content="5;url=/FORKI/content/join/UserMain.do" >
    </td>
  </tr>
  <tr>
    <td align="center">
      <input type="submit" value="확인">
    </td>
  </tr>
</table>
</form>
</body>
</c:if>
</html>