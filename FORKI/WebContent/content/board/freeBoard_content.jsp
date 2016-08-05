<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<table width=500 border=1 cellspacing=0 cellpadding=0  align=center>
					<form>
					
					<tr height=30>
						<td colspan="2" align=center width=125>글제목</td>
						<%-- <td align=center width=375 colspan=3><%=article.getSubject() %></td> --%>
					</tr>
					<tr>
						<td colspan="2" align=center width=125>글내용</td>
						<%-- <td align=center width=375 colspan=3><%=article.getContent() %></td> --%>
					</tr>
					<tr height=30>
						<td colspan=2 align=right>
							<input type=button value=글수정 >&nbsp;&nbsp;&nbsp;&nbsp;
							<input type=button value=글삭제>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type=button value=글목록 >
						<!-- 속성값을 줄바꿈하면 실행안됨 -->
						
						</td>
					</tr>
					</form>
					<form name=recom method=post action=contentPro.jsp onsubmit="return recomment()">
					<tr align=left>
						<td>댓글 (개)</td>
						
					</tr>
					<tr> 
						<td> 글의 내용이 올부분 </td>
						<td> 
						<input type=button value=신고 >&nbsp;&nbsp;&nbsp;&nbsp;
						<input type=button value=글수정>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type=button value=글삭제 >
						</td>
					</form>
					<tr>
						<td> 댓글달기 </td>
					</tr>
					<tr>
					<td>
					<input type="textarea" >  </td>
					<td>
					<input type="button" value="댓글달기"> </td>	
				</table>

</body>
</html>