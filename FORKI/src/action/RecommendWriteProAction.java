package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.PrBoardDBBean;
import DAO_DTO.PrBoardDataBean;

public class RecommendWriteProAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		PrBoardDataBean article =new PrBoardDataBean();
		article.setNum(Integer.parseInt(request.getParameter("num")));
		article.setId((String)request.getSession().getAttribute("id"));
		article.setContent(request.getParameter("content"));
		article.setSubject(request.getParameter("subject"));
		article.setWriter(request.getParameter("writer"));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setReadcount(0);
		article.setReg_date(new Timestamp(System.currentTimeMillis()));
		
		PrBoardDBBean pbdb=PrBoardDBBean.getInstance();
		pbdb.insertArticle(article);
		return "recommendWritePro.jsp";
	}
}
