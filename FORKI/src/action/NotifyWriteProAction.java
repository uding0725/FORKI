package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.NotifyDBBean;
import DAO_DTO.NotifyDataBean;

public class NotifyWriteProAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("utf-8");
		NotifyDataBean ndata= new NotifyDataBean();
		ndata.setId((String)request.getSession().getAttribute("id"));
		String admin ="admin";
		ndata.setWriter(admin);
		ndata.setSubject(request.getParameter("subject"));
		ndata.setContent(request.getParameter("content"));
		ndata.setReadcount(0);
		ndata.setReg_date(new Timestamp(System.currentTimeMillis()));
		NotifyDBBean ndb=NotifyDBBean.getInstance();
		ndb.insertArticle(ndata);
		return "notifyWritePro.jsp";
	}
}
