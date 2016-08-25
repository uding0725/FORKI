<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일업로드</title>
</head>
<body>
	<h2>상품 등록</h2>
	<form action="InsertGoods" method="post" enctype="multipart/form-data">
		이미지 : <input type="file" name="img"><br> <input type="submit" value="등록"> <input type="reset" value="취소"><br>
	</form>
</body>
</html>