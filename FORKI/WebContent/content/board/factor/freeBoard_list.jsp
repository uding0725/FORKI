<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="DAO_DTO.FreeBoardDBBean"%>
<%@ page import="DAO_DTO.FreeBoardDataBean"%>
<%@ page import = "DAO_DTO.FrReplyDBBean" %>
<%@ page import = "DAO_DTO.FrReplyDataBean" %>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%-- <%
    int pageSize = 10; //하나의 페이지에서 보여줄 행의 수.
    SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<%
    String pageNum = request.getParameter("pageNum");
	String search = request.getParameter("search");	
	int searchn = 0;
	
    if (pageNum == null) {
        pageNum = "1";
    }//pagenum이 parameter값으로 넘어오지 않았다면, 맨 첫번째 페이지로.
    
    if(search == null)
	{
		search = "";
	}
	else
	{
		searchn = Integer.parseInt(request.getParameter("searchn"));
	}

    int currentPage = Integer.parseInt(pageNum);
    //System.out.println(currentPage);
    int startRow = (currentPage * 10) - 9;
    int endRow = currentPage * pageSize;
    int count = 0;
    int number=0;

    List articleList = null;
    BoardDBBean dbPro = BoardDBBean.getInstance();
    if(search.equals("") || search == null)
		count = dbPro.getArticleCount();
	else
		count = dbPro.getArticleCount(searchn,search);
    
    CommentDBBean cdb=CommentDBBean.getInstance();
    
    if (count > 0) {
    	if(search.equals("") || search == null)
			articleList = dbPro.getArticles(startRow, endRow);
		else
			articleList = dbPro.getArticles(startRow, endRow, searchn, search);
    }

	number=count-(currentPage-1)*pageSize;
           // 11 -(2-1)*3 =8
%> --%>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<%-- <body bgcolor="<%=bodyback_c%>"> --%>
<body>
<center><b>글목록(전체 글:)</b>
<table width="600">
<tr>
    <td align="right" bgcolor="green">
    <a href="freeBoard_write.jsp">글쓰기</a>
    </td>
</table>

<%-- <%
    if (count == 0) {
%>
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
    <td align="center">
    게시판에 저장된 글이 없습니다.
    </td>
</table> --%>

<%-- <%  } else {    %> --%>
<table border="1" width="600" cellpadding="0" cellspacing="0" align="center">
    <tr height="30">
      <td align="center"  width="50"  >번 호</td>
      <td align="center"  width="250" >제   목</td>
      <td align="center"  width="100" >닉네임</td>
      <td align="center"  width="150" >조회수</td>
      <td align="center"  width="50" >등록일</td>
      
    </tr>
<%-- <% 
        for (int i = 0 ; i < articleList.size() ; i++) {
          BoardDataBean article = (BoardDataBean)articleList.get(i);
          int com_count=cdb.getCommentCount(article.getNum());
%>
   <tr height="30">
    <td align="center"  width="50" > <%=number--%><!-- </td>
    <td  width="250" > -->
<%-- <%
      int wid=0;
      if(article.getRe_level()>0){ //답변글이라면...
        wid=5*(article.getRe_level());
%>
  <img src="images/level.gif" width="<%=wid%>" height="16">
  <img src="images/re.gif">
<%}else{%>
  <img src="images/level.gif" width="<%=wid%>" height="16">
<%}%>
          
      <a href="content.jsp?num=<%=article.getNum()%>&pageNum=<%=currentPage%>">
           <%=article.getSubject()%>[<%=com_count %>]</a>
          <% if(article.getReadcount()>=10){%>
         <img src="images/hot.gif" border="0"  height="16"><%}%> </td>
    <td align="center"  width="100">
       <a href="mailto:<%=article.getEmail()%>"><%=article.getWriter()%></a></td>
    <td align="center"  width="150"><%= sdf.format(article.getReg_date())%></td>
    <td align="center"  width="50"><%=article.getReadcount()%></td>
    <td align="center" width="100" ><%=article.getIp()%></td>
  </tr>
     <%}%>
</table>
<%}%>
 --%>
<%-- <%
    if (count > 0) {
    //전체 페이지의 수를 연산
        int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);

        int startPage = (int)(currentPage/5)*5+1;
		int pageBlock=5;
        int endPage = startPage + pageBlock-1;
        if (endPage > pageCount) endPage = pageCount;
       
        if (startPage > 5) {    
        //이전 페이지
			if(search.equals("") || search == null)
			{
%>
				<a href="list.jsp?pageNum=<%=startPage - 5 %>">[이전]</a>
<%
			}
			else
			{
%>
			<a href="list.jsp?pageNum=<%=startPage - 5 %>&search=<%=search %>&searchn=<%=searchn %>">[이전]</a>
<%      }
        }
        for (int i = startPage ; i <= endPage ; i++) {  //해당페이지로 이동
			if(search.equals("") || search == null)
			{
%>
			<a href="list.jsp?pageNum=<%=i %>">[<%=i %>]</a>
<%
			}
			else
			{
%>
			<a href="list.jsp?pageNum=<%=i %>&search=<%=search %>&searchn=<%=searchn %>">[<%=i %>]</a>
<%
        	}
        }
        if (endPage < pageCount) {  //다음페이지
			if(search.equals("") || search == null)
			{
%>
			<a href="list.jsp?pageNum=<%=startPage + 5 %>">[다음]</a>
<%
			}
			else
			{
%>
			<a href="list.jsp?pageNum=<%=startPage + 5 %>&search=<%=search %>&searchn=<%=searchn %>">[다음]</a>
<%
			}
        }
    }
%> --%>
 
<form align="right">
<select name="searchType">
<option value="0">전체</option>
<option value="1">제목</option>
<option value="2">내용</option>
</select>

<select name="searchCat">
<option value="0">소곤소곤</option>
<option value="1">유익한 경로</option>
<option value="2">기타</option>
</select>

<input type="text" name="search" size="15" maxlength="50" /> 
<input type="submit" value="검색" />
</form>
<br></br>
</center>
</body>
</html>


