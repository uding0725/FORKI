<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="script.js"></script>
<script>
function writeSave(){

	if(document.writeform.title.value==""){
		 alert("말머리를 체크해주세요.");
		 document.writeform.writer.focus();
		 return false;
			}	

	if(document.writeform.subject.value==""){
	  alert("제목을 입력해주세요.");
	  document.writeform.subject.focus();
	  return false;
	}

	if(document.writeform.content.value==""){
	  alert("내용을 입력해주세요.");
	  document.writeform.content.focus();
	  return false;
	}
	}
</script>
</head>

  
<body> 

<br>
<form method="post" name="writeform" action="/FORKI/content/board/freeBoardWritePro.do" onsubmit="return writeSave()">
<input type="hidden" name="num" value="${num}">
<input type="hidden" name="writer" value="${writer}">
<input type="hidden" name="id" value="${sessionScope.id}">
<input type="hidden" name="readcount" value="0">




<table width="750" cellspacing="0" cellpadding="0"  align="center">
 <tr>
	 <td> <b>글쓰기</b> </td>
 		<td colspan="2" align="right">  
 		<a href="#"><img src="../img/home.png" width="20" height="20"></a>
		<a href="#">>게시판</a>
		<a href="#">>맘을 전해요</a>
		<a href="#">>글쓰기</a>
	</td>			 
 </tr>
  <tr>
  	<td>
  		<select name="title">
			<option value="0">소곤소곤</option>
			<option value="1">유익한 경로</option>
			<option value="2" selected>기타</option>
		</select>
    <td colspan="2">제 목
    <input type="text" size="70" name="subject" placeholder="지역구를 지정해주시면 검색이 용이합니다."></td>
	</td>
  </tr>
 
  <tr>
    <td colspan="3"    align="left" >내 용</td>
  </tr>
  <tr> 
    <td  colspan="3">
     <textarea name="content" rows="13" cols="100" align="center" ></textarea> </td>
  </tr>
  
<tr>     
<td colspan=3 align="center">
  <input type="submit" value="글쓰기" > 
  <input type="reset" value="다시작성">
  <input type="button" value="목록보기" OnClick="window.location='/FORKI/content/board/freeBoardList.do'">
</td>
</tr>
</table>   
</form>     
</body>
</html> 