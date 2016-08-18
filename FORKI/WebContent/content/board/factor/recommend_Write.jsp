<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>건의사항 글 화면</title>
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
  <font size="+2" >글쓰기</font>
   <span style='position: absolute; right: 60px'> 
    <a href="#"><img src="img/home.png" width="20" height="20"></a> 
    <a href="#">>게시판</a>
    <a href="#">>건의사항</a>
    <a href="#">>글쓰기</a> 
    </span>
  </div> 
<div id="secret-wrap">
    
  <div id="secret-conline">
   <form method="post" name="writeform" action="/FORKI/content/board/recommendWritePro.do">
   <input type="hidden" name="num" value="${num}">
   <input type="hidden" name="ref" value="${ref}">
   <input type="hidden" name="re_step" value="${re_step}">
   <input type="hidden" name="re_level" value="${re_level}">
   <input type="hidden" name="writer" value="${writer}">
   <p>제목 
   <c:if test="${num==0}">
   <input type="text" size="70" name="subject"></p>
	</c:if> 
	  <c:if test="${num!=0}">
   <input type="text" size="70" name="subject" value="[답변]"></p>
	</c:if>  
   <p>내용</p>
    <div id="secret-content">
  <textarea style="height:100%; width:100%;resize:none;" rows="18"  cols="80"  name="content"></textarea>
    </div>
      <div id="secret-footer">
    <input type="submit" value="글쓰기">
    <input type="reset" value="다시작성">
    <input type="button" value="취소" OnClick="window.location='/FORKI/content/board/recommendList.do'">
      </div>
      </form>
  </div>

</div>

</body>
</html>