<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
function updateSave(){

if(document.updateform.title.value==""){
	 alert("말머리를 체크해주세요.");
	 document.writeform.writer.focus();
	 return false;
		}	

if(document.updateform.subject.value==""){
  alert("제목을 입력해주세요.");
  document.writeform.subject.focus();
  return false;
}

if(document.updateform.content.value==""){
  alert("내용을 입력해주세요.");
  document.writeform.content.focus();
  return false;
}
}
</script>


</head>
<body>
<form method="post" name="updateform"action="/FORKI/content/board/freeBoardUpdatePro.do?num=${article.num}&pageNum=${pageNum}"onsubmit="return updateSave()">
<table width="700"  cellspacing="0" cellpadding="0" > 
 <tr>
 <td> 제목 </td>  
 <td> <select name="title">
			<option value="0">소곤소곤</option>
			<option value="1">유익한 경로</option>
			<option value="2">기타</option>
		</select>
		</td>
 <td> <input type="text" name="subject" size="70" value="${article.subject}"></td>
 </tr>
 <tr>
 <td colspan="3" align="left"> 내용
 </tr>
 <tr>
 <td colspan="3"> 
 <textarea name="content" name="content" rows="13" cols="100" align="center" value="${article.content}"></textarea> </td>

 </tr>
 <tr>
 <td colspan="3" align="center">
 <input type="submit" value="저장하기" >
 <input type="button" value="글 삭제하기" onclick="document.location.href='/FORKI/content/board/freeBoardDelete.do?num=${article.num}&pageNum=${pageNum}'">
 <input type="button" value="취소" onclick="document.location.href='/FORKI/content/board/freeBoardList.do?pageNum=${pageNum}'">
 </td>
 </tr>
 </table>
 </form>
 

</body>
</html>