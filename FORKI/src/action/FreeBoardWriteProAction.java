package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.FreeBoardDataBean;


public class FreeBoardWriteProAction implements CommandAction{
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");// 한글 인코딩

		FreeBoardDataBean article = new FreeBoardDataBean();// 데이터처리 빈
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setWriter("ho");
		article.setSubject(request.getParameter("subject"));
		article.setId("hh");
		
		
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		article.setContent(request.getParameter("content"));
		
	

		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();// DB처리
		fbdbb.insertArticle(article);
		
		return "freeBoardWritePro.jsp";
	}

}
