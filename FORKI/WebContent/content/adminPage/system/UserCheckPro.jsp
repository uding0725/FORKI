<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${check == 1}">
	<body>
		<form method="post" action="window.close()" name="userinput">
			<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
				<tr>
					<td align="center">
						<p>블랙리스트에 등록되었습니다.</p>
						<meta http-equiv="Refresh" content="30;window.close()">
					</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</body>
</c:if>