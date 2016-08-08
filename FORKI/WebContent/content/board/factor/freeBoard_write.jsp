<%@ page contentType="text/html; charset=UTF-8"%>
<b>글쓰기</b> <br>
		<form method="post" name="writeform" action="writePro.jsp"
			onsubmit="return writeSave()">
			<%-- <input type="hidden" name="num" value="<%=num%>"> <input
				type="hidden" name="ref" value="<%=ref%>"> <input
				type="hidden" name="re_step" value="<%=re_step%>"> <input
				type="hidden" name="re_level" value="<%=re_level%>"> --%>
			<!-- 클라이언트가 건들면 안되는 곳은 type을 hidden으로 -->

			<table width="750" border="1" cellspacing="0" cellpadding="0"
				bgcolor="" align="center">
				<tr>
					<td align="right" colspan="2" bgcolor=""><a href="freeBoardList.jsp"> 글목록</a></td>
				</tr>
				
				<tr>
					<td width="70" bgcolor="" align="center">제 목</td>
					<%-- <td width="330">
						<%
							if (request.getParameter("num") == null) {
						%> 
						<input type="text" size="40" maxlength="50" name="subject">
					</td>
					<%
						} else {
					%>
					<input type="text" size="40" maxlength="50" name="subject"
						value="[답변]">
					</td> --%>
					<%-- <%
						}
					%> --%>
				</tr>
				<!-- <tr>
					<td width="70" bgcolor="" align="center">Email</td>
					<td width="330"><input type="text" size="40" maxlength="30"
						name="email"></td>
				</tr> -->
				<tr>
					<td width="70" bgcolor="" align="center">내 용</td>
					<td width="680"><textarea name="content" rows="13" cols="40"></textarea>
					</td>
				</tr>
				<!-- <tr>
					<td width="70" bgcolor="" align="center">비밀번호</td>
					<td width="330"><input type="password" size="8"
						maxlength="12" name="passwd"></td>
				</tr> -->
				<tr>
					<td colspan=2 bgcolor="" align="center">
					<input type="submit" value="글쓰기"> 
					<input type="reset"	value="다시작성"> 
					<input type="button" value="취소"	OnClick="window.location='freeBoard_list.jsp'"></td>
				</tr>
			</table>
			<!-- 한번에 많은 데이터 저장하기위해 useBean객체이용(writePro.jsp) -->			<%-- <%
				} catch (Exception e) {
				}
			%>  --%>
		</form>

