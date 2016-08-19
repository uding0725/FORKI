package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.ReportDataBean;
import DAO_DTO.ReportDBBean;

public class ReportContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");		
		String num = request.getParameter("num");
		System.out.println("action: " + num);
		ReportDBBean DBpro = ReportDBBean.getInstance();
		ReportDataBean DBdata = DBpro.selectReport(num);
		
		request.setAttribute("reporter", DBdata.getReporter());
		request.setAttribute("sub_report", DBdata.getSub_report());
		request.setAttribute("location", DBdata.getLocation());
		request.setAttribute("content", DBdata.getContent());		
		
		return "ReportContent.jsp";
	}

}
