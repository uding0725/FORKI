<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>공지사항 글 수정</title>
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
  <font size="+2" >공지사항 글수정</font>
   <span style='position: absolute; right: 60px'> 
    <a href="#"><img src="img/home.png" width="20" height="20"></a> 
    <a href="#">>게시판</a>
    <a href="/FORKI/content/board/notifyList.do?pageNum=${pageNum}">>공지사항</a>
    <a href="#">>공지사항 글수정</a> 
    </span>
  </div> 
<div id="secret-wrap">
 	<div id="secret-conline">
 	<form method="post" action="/FORKI/content/board/notifyUpdatePro.do?num=${article.num}&pageNum=${pageNum}">
 			 <p>제목 <input type="text" size="70" name="subject" value="${article.subject}">
 			 </p>
 			 <p>작성자 ${article.writer} &nbsp;&nbsp;작성일 ${article.reg_date}</p>
 		<div id="secret-content">
 		 <p>내용</p>
  		<textarea style="height:87%; width:100%;resize:none;" rows="18"  cols="80"  name="content" >${article.content}</textarea>
    	</div>
 		   <div id="secret-footer" align="right">
						 <input type="submit" value="수정하기">
  					  	<input type="button" value="목록으로" onclick="document.location.href='/FORKI/content/board/notifyList.do?pageNum=${pageNum}'">  	
 		   </div>
 	</form>
 	</div>
</div>

</body>
</html>
