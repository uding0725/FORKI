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
 <td> <select name="title">
			<option value="0">소곤소곤</option>
			<option value="1">유익한 경로</option>
			<option value="2">기타</option>
		</select>
		</td>
 <td> <input type="text" size="70" > <%-- value="${article.subject}" --%> </td>
 </tr>
 <tr>
 <td colspan="3" align="left"> 내용
 </tr>
 <tr>
 <td colspan="3"> 
 <textarea name="content" rows="13" cols="100" align="center" ></textarea> </td>
<%--  value="${article.content}" --%>
 </tr>
 <tr>
 <td colspan="3" align="center">
 <input type="button" value="저장하기">
 <input type="button" value="삭제하기">
 <input type="button" value="취소">
 </td>
 </tr>
 </table>
 </form>
 

</body>
</html>