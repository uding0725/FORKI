<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body bgcolor="${bodyback_c}">
	<font size="+1"><b>관리자</b></font>
	<br>


		<tr>
			<td><input type="button" name="member_care" value="회원관리"
				onclick="
				document.location.href='/FORKI/content/adminPage/SysMemberCare.do'">
			</td>
		</tr><br>

		<tr>
			<td><input type="button" name="member_care" value="블랙리스트"
				onclick="
				document.location.href='/FORKI/content/adminPage/SysBlack_list.do'">
			</td>
		</tr><br>

		<tr>
			<td><input type="button" name="member_care" value="기업가입신청"
				onclick="
				document.location.href='/FORKI/content/adminPage/SysApprobation.do'">
			</td>
		</tr><br>

		<tr>
			<td><input type="button" name="member_care" value="유치원등록"
				onclick="
				document.location.href='/FORKI/content/adminPage/MemberCare.do'">
			</td>
		</tr><br>
		
		<tr>
			<td><input type="button" name="member_care" value="신고함"
				onclick="
				document.location.href='/FORKI/content/adminPage/MemberCare.do'">
			</td>
		</tr><br>

		<tr>
			<td><input type="button" name="member_care" value="탈퇴회원"
				onclick="
				document.location.href='/FORKI/content/adminPage/MemberCare.do'">
			</td>
		</tr>

</body>
</html>