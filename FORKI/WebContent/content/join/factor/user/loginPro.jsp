<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${blackCheck == black}">
	<script>
		alert("다음과 같은 사유로 현제 이용이 중지된 계정입니다 :: ${content}");
		history.go(-1);
	</script>
</c:if>
<c:if test="${check==1}">
	<c:if test="${grade==0}">
		<meta http-equiv="Refresh" content="0;url=/FORKI/content/main/main.do">
	</c:if>

	<c:if test="${grade==1}">
		<c:if test="${certi==1}">
			<meta http-equiv="Refresh" content="0;url=/FORKI/content/main/main.do">
		</c:if>

		<c:if test="${certi==0}">
			<script>
				alert("인증이 되지 않았습니다.\n 이메일 인증후 이용해주세요.${certi}");
				history.go(-1);
			</script>
		</c:if>

	</c:if>
	<c:if test="${grade==2}">
		<c:if test="${certi==1}">
			<c:if test="${reg_check==1}">
				<meta http-equiv="Refresh" content="0;url=/FORKI/content/main/main.do">
			</c:if>
			<c:if test="${reg_check==0}">
				<%-- <%
			session.invalidate();
		%> --%>
				<script>
					alert("인증이 되지 않았습니다.\n 관리자의 승인후 이용가능합니다.${reg_check}");
					history.go(-1);
				</script>
			</c:if>

		</c:if>

		<c:if test="${certi==0}">
			<script>
				alert("인증이 되지 않았습니다.\n 이메일 인증후 이용해주세요.${certi}");
				history.go(-1);
			</script>
		</c:if>
	</c:if>

</c:if>

<c:if test="${check==0}">
	<script>
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
	</script>
</c:if>