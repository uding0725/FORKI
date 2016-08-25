<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${check == 1}">
	<body>
		<form method="post" action="/FORKI/content/main/main.do" name="userinput">
			<table width="270" border="0" cellspacing="0" cellpadding="5" align="center">
				<tr>
					<td align="center">
						<p>등록되었습니다. 발송된 이메일로 인증 후 이용해주세요..</p><br>
						<p>(꼭!!)이메일 인증 후 확인버튼을 눌러주세요</p>
						<meta http-equiv="Refresh" content="url=/FORKI/content/main/main.do">
					</td>
				</tr>
				<tr>
					<td align="center"><input type="submit" value="확인"></td>
				</tr>
			</table>
		</form>
	</body>
</c:if>
