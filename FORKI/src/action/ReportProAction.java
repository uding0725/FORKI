package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.ReportDBBean;
import DAO_DTO.ReportDataBean;

public class ReportProAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		ReportDataBean rdb = new ReportDataBean();
		rdb.setReporter(request.getParameter("id"));
		rdb.setSub_report(request.getParameter("subid"));
		rdb.setLocation(request.getParameter("loc"));
		rdb.setContent(request.getParameter("content"));
		rdb.setR_date(new Timestamp(System.currentTimeMillis()));
		

		ReportDBBean rdbb = ReportDBBean.getInstance();
		rdbb.insertReport(rdb);
		
		return "reportPro.jsp";
	}

}
