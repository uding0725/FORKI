<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function deleteConfirm(){
	var selectDel = confirm("정말로 삭제하시겠습니까?")
	if (selectDel) {
		document.location.href="/FORKI/content/board/notifyDelete.do?pageNum=${pageNum}&num=${num}"
	}
}
</script>
<link href="../CSS/board.css?ver=1.5" rel="stylesheet" type="text/css">
<head>
<title>공지사항</title>
<style>
#secret-wrap{
 width : 750px;
 height : 610px;
 padding : 0px auto;
 border : 1px solid;
 position : relative;
}
#secret-header{
width : 750px;
height : 40px;
padding : 0px auto;

margin : 0px auto;
}
#secret-conline{
width :740px;
height : 560px;
border : 0px solid;
padding : 0px auto;
margin : 0px auto;
}
#secret-content{
width :740px;
height : 450px;
border : 1px solid;
margin: 0px auto;
}
#secret-footer{
width :740px;
height :40px;
border : 0px;

text-align :center;
margin :5px auto;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
<div id="secret-header">
  <img src="../img/chick/icon5.png" width="30" height="30"  style="position:relative; top:5px;"> <font size="+2" >공지사항 글</font>
   <span style='float:right;'> 
    <a href="/FORKI/content/main/main.do"><img src="../img/home.png" width="20" height="20"></a> 
    <a href="/FORKI/content/board/notifyList.do">>게시판</a>
    <a href="/FORKI/content/board/notifyList.do?pageNum=${pageNum}">>공지사항</a>
    <a href="">>공지사항 글</a> 
    </span>
  </div> 
<div id="secret-wrap">
 	<div id="secret-conline">
 
 			 <p>제목 <input type="text" size="70" name="subject" value="${article.subject}" readonly>
 			 </p>
 			 <p>작성자 ${article.writer} &nbsp;&nbsp;작성일 ${article.reg_date}</p>
 		<div id="secret-content">
 		 <p>내용</p>
  		<textarea style="height:87%; width:100%;resize:none;" rows="18"  cols="80"  name="content" readonly>${article.content}</textarea>
    	</div>
 		   <div id="secret-footer" align="right">
				<c:if test="${article.id==sessionScope.id}">
						 <input type="button" value="수정하기" onclick="document.location.href='/FORKI/content/board/notifyUpdate.do?pageNum=${pageNum}&num=${num}'">
 					  	<input type="button" value="삭제하기" onclick="deleteConfirm();">
  					  	<input type="button" value="목록으로" onclick="document.location.href='/FORKI/content/board/notifyList.do?pageNum=${pageNum}'">
				</c:if>
				<c:if test="${article.id!=sessionScope.id}">
  					  	<input type="button" value="목록으로" onclick="document.location.href='/FORKI/content/board/notifyList.do?pageNum=${pageNum}'">
				</c:if> 		   	
 		   </div>
 	</div>
</div>
</form>
</body>

</html>