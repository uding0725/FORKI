<%@ page  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>회원탈퇴</title>
<link href="style.css" rel="stylesheet" type="text/css">

   <script>
    
       function begin(){
         document.myform.passwd.focus();
       }

       function checkIt(){
 if(!document.myform.passwd.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.passwd.focus();
           return false;
         }
   }  
    
   </script>
</head>
<BODY onload="begin()">
<form name="delform" action="/FORKI/content/join/factor/company2/deletePro.do" 
method="post" onSubmit="return checkIt()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
 
  <TR height="30">
    <TD colspan="2" align="middle">
  <font size="+1" ><b>회원 탈퇴</b></font></TD></TR>
 
  <TR height="30">
    <TD width="110" align=center>비밀번호</TD>
    <TD width="150" align=center>
      <INPUT type=password name="passwd"  size="15" maxlength="12">
      <input type="hidden" name="passwd" value="${passwd}">
      </TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle">
      <INPUT type=submit value="회원탈퇴">
      <input type="button" value="취  소" 
      onclick="document.location.href='/FORKI/content/join/factor/company2/main.do'">
      </TD></TR>
</TABLE>
</form>
</BODY>
</HTML>