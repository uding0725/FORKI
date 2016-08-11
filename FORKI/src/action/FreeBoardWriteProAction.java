package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;


public class FreeBoardWriteProAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");// �븳湲� �씤肄붾뵫
		
		
		FreeBoardDataBean article = new FreeBoardDataBean();// �뜲�씠�꽣泥섎━ 鍮�
		article.setNum((Integer)request.getSession().getAttribute("num"));
		article.setId((String)request.getSession().getAttribute("id"));
		article.setWriter((String)request.getSession().getAttribute("writer"));
		article.setTitle(request.getParameter("title"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setReadcount(Integer.parseInt(request.getParameter("readcount")));
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
	
		
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();// DB泥섎━
		fbdbb.insertArticle(article);
		
		
		
		return "freeBoardWritePro.jsp";
	}

}
