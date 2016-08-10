<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>건의사항 비밀글 화면</title>
<style>
#secret-wrap{
 width : 930px;
 height : 700px;
 padding : 0px auto;
 border : 1px solid;
 position : relative;
}
#secret-header{
width : 940px;
height : 100px;
padding : 0px auto;
margin : 10px;
}
#secret-conline{
width :900px;
height : 480px;
border : 0px solid;
padding : 0px auto;
margin : 10px;
}
#secret-content{
width :850px;
height : 450px;
border : 1px solid;
}
#secret-footer{
width :850px;
height :100px;
border : 0px;
text-align :center;
margin :5px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
<div id="secret-wrap">
 <div id="secret-header">
  <font size="+2" >글쓰기</font>
   <span style='position: absolute; right: 60px'> 
    <a href="#"><img src="img/home.png" width="20" height="20"></a> 
    <a href="#">>게시판</a>
    <a href="#">>건의사항</a>
    <a href="#">>글쓰기</a> 
    </span>
    
   <p>제목    <input type="text" size="130" ></p>
   
</div>
  <div id="secret-conline">
   <p>내용</p>
    <div id="secret-content">
  <textarea rows="25" cols="125" name="contents"></textarea>
    </div>
      <div id="secret-footer">
    <input type="button" value="글쓰기" name="write" >
    <input type="button" value="취소" name="cancle">
  
      </div>
  </div>

</div>

</body>
</html>