<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${check==1}">
<meta http-equiv="Refresh" content="0;url=/FORKI/content/join/UserMain.do" >
</c:if>
<c:if test="${check==0}">
  비밀번호가 맞지 않습니다.
      history.go(-1);
</c:if>

<c:if test="${check==-1}">
  아이디가 맞지 않습니다.
  history.go(-1);
</c:if>