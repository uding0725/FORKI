<%@ page import="java.io.File"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일업로드</title>
</head>
<body>
	<div>
		<table border="1" width="750" cellpadding="0" cellspacing="0" align="center">
				<tr height="30"">
					<td align="center" width="50">순번</td>
					<td align="center" width="100">파일이름</td>
					<td align="center" width="500">내용</td>
					<td align="center" width="100">삭제</td>
				</tr>
				
				<c:forEach var="article" items="${imgList}">
					<tr height="30">
						<td align="center" width="50"><c:out value="${number}" /> <c:set var="number" value="${number + 1}" /></td>
						<td align="center" width="100">${article.file_name}</td>
						<td align="center" width="550">${article.message}</td>
						<td align="center" width="100">
							<a href="DeleteImg.do?name=${article.file_name}" >삭제</td>

					</tr>
				</c:forEach>
				<c:if test="${check == 0}">
					<tr height="30">
						<td align="center" width="750" colspan="4">등록된 이미지가 없습니다.</td>
					</tr>
				</c:if>
			</table>
	</div>
	<h2>이미지 등록</h2>${check}
	<form action="/FORKI/content/findKinder/factor/UploadImg.do" method="post" enctype="multipart/form-data">
		이미지 : <input type="file" name="img">
		<hr>
		메세지 : <input type="text" name="message" required><br> 
		<input type="submit" value="등록"> <input type="reset" onclick="document.location.href='/FORKI/content/findKinder/factor/kinder_DetailPage.do?num=${sessionScope.schul_num}'" value="뒤로가기"><br>
	</form>
</body>
</html>