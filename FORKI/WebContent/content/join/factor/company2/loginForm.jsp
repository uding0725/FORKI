<%@ page  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>로그인</title>
<link href="style.css" rel="stylesheet" type="text/css">

   <script>

       function begin(){
         document.myform.id.focus();
       }
       function checkIt(){
         if(!document.myform.id.value){
           alert("이름을 입력하지 않으셨습니다.");
           document.myform.id.focus();
           return false;
         }
         if(!document.myform.passwd.value){
           alert("비밀번호를 입력하지 않으셨습니다.");
           document.myform.passwd.focus();
           return false;
         }
         
       }
    
   </script>
</head>
<BODY onload="begin()">
<form name="myform" action="/FORKI/content/join/factor/company2/loginPro.do" method="post" onSubmit="return checkIt()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
 
  <TR height="30">
    <TD colspan="2" align="middle"><STRONG>회원로그인</STRONG></TD></TR>
 
  <TR height="30">
    <TD width="110" align=center>아이디</TD>
    <TD width="150" align=center>
       <INPUT type="text" name="id" size="15" maxlength="12"></TD></TR>
  <TR height="30">
    <TD width="110" align=center>비밀번호</TD>
    <TD width="150" align=center>
      <INPUT type=password name="passwd"  size="15" maxlength="12"></TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle">
      <INPUT type=submit value="로그인">
      <INPUT type=reset value="다시입력">
      <input type="button" value="회원가입" 
      onclick="document.location.href='/FORKI/content/join/factor/company2/inputForm.do'"></TD></TR>
</TABLE>
</form>
</BODY>
</HTML>