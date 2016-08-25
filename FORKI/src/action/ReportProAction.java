package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.ReportDBBean;
import DAO_DTO.ReportDataBean;

public class ReportProAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		ReportDataBean rdb = new ReportDataBean();
		rdb.setReporter((String)request.getSession().getAttribute("id"));
		rdb.setSub_report(request.getParameter("sub"));
		rdb.setLocation(request.getParameter("ip"));
		rdb.setContent(request.getParameter("content"));
		rdb.setR_date(new Timestamp(System.currentTimeMillis()));
		
		ReportDBBean rdbb = ReportDBBean.getInstance();
		rdbb.insertReport(rdb);
		
		return "reportPro.jsp";
	}

}
