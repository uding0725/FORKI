<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>


</head>
<body>


<form>
<table width="700"  cellspacing="0" cellpadding="0" > 
 <tr>
 <td> 제목 </td>  
 <td width="600"> ${article.subject} </td>
 </tr>
 <tr>
 <td> 내용
 </tr>
 <tr>
 <td colspan="2"> ${article.content} </td>
 </tr>
 <tr>
 <td colspan="2" align="right">
 <input type="button" value="수정하기" onclick="document.location.href='/FORKI/content/board/freeBoardUpdate.do?num=${num}&pageNum=${pageNum}'">
 <input type="button" value="삭제하기">
 <input type="button" value="목록으로" onclick="document.location.href='/FORKI/content/board/freeBoardList.do?pageNum=${pageNum}'">
 </td>
 </tr>
 </table>
 </form>
 
 <form>
 <table width="700"  cellspacing="0" cellpadding="0" >
 <tr>
 <td> 댓글 ((count el로)개) </td>
 </tr>
 <tr>
 <td> 댓글내용 el로</td>
 <td> 
 <input type="button" value="신고" >
 <input type="button" value="수정">
 <input type="button" value="삭제">
</td>
</tr>
<tr>
<td> 댓글달기 </td>
</tr>
<tr>
<td> <textarea cols=70 rows=5 ></textarea> </td>
<td> <input type="button" style=height:80; value="댓글달기"/> </td>	
</tr> 
 </table>
  </form>     
</body>
</html>