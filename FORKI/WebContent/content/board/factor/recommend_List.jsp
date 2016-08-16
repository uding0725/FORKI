<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>건의사항</title>
<style>
#write-wrap {
	width: 750px;
	height: 750px;
	margin: 0px auto;
	padding: 5px;
	border: 0px solid;
	padding: 20px;
	position: relative;
}

#write-header {

    width : 700px;
    height : 150px;
	border: 0px solid;
}


#write-content {
	width: 700px;
	height : 400px;
	margin-top:10px;
	margin-bottom: 20px;
	border: 0px;
}

a {
	text-decoration: none;
}
table{ 
       width : 700px;
       height:700px; 
       border-left: 1px solid; 
       border-right: 1px solid; 
       border-top: 1px solid; 
       border-bottom: 1px solid; 
       text-align:center"
}

</style>
</head>
<body>
<div id="write-wrap">
  <div id="write-header">
  <font size="+2">건의사항</font> 
   <span style='position: absolute; right: 60px'> 
    <a href="#"><img src="../img/home.png" width="20" height="20"></a> 
    <a href="#">>게시판</a>
    <a href="#">>건의사항</a> 
   </span>
   <br>
   <br>
     총  ${count}건이 검색되었습니다.
<span style='position:relative; left:275px' >
   <select name="all">
   <option value="">전체  
   <option value="제목">제목
   <option value="내용">내용
   </select>
   <input type="text" style="width:10%" name="search">
   <input type="button" name="searching" value="검색">
   <input type="button" name="write" value="글쓰기">
</span>

<div id="write-content"> 
   <table> 
               
				<tr>
					<td width="100" height="30" align="center" bgcolor="">번호 </td>
				    <td width="300" height="30" bgcolor="" align="center">공지사항</td>
				    <td width="100" height="30" bgcolor="" align="center">닉네임</td>
				    <td width="100" height="30" bgcolor="" align="center">조회수</td>
					<td width="150" height="30" bgcolor="" align="center">등록일</td>
				</tr>
				<tr>
				<c:if test="${count==0}">
				<td align="center">게시판에 저장된 글이 없습니다.</td>
				</c:if>
				<c:if test="${count>0}">
				  <c:forEach var="article" items="${articleList}">
				  	<td width="100" align="center" bgcolor="">${article.num}</td>
				  	<td width="300" align="center" bgcolor="">${article.subject}</td>
				  	<td width="100" align="center" bgcolor="">${article.writer}</td>
				  	<td width="100" align="center" bgcolor="">${article.readcount}</td>
				  </c:forEach>
				 </c:if>
			</table>
   </div>
   </div>
   </div>

</body>
</html>