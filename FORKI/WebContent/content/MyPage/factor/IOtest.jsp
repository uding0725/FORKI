<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../../js/var.js?var=1.6"></script>
</head>

<body>
	<div style="">
		<form method="post" action="#" name="kidList">
			<input type="button" id="btn-add-row" value="아이추가"> <input type="button" id="btn-delete-row" value="아이삭제">
			<hr>
			<table id="mytable" border="1" cellspacing="0">
				<tr>
					<th>아이이름</th>
					<th>유치원이름</th>
					<th>유치원검색</th>
				<tbody></tbody>
				</tr>
			</table>
			<div>
				<input type="submit" value="저장">
			</div>
		</form>
	</div>
</body>
</html>
