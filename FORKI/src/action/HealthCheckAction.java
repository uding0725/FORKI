package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.HealthDataBean;
import DAO_DTO.HealthDBBean;

public class HealthCheckAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");
		int listSize = 0;

		List chartList = null;
		HealthDBBean DBpro = HealthDBBean.getInstance();

		chartList = DBpro.getChart(id);
		
		listSize = chartList.size();

		request.setAttribute("chartList", chartList);
		request.setAttribute("listSize", new Integer(listSize));

		return "HealthCheck.jsp";
	}

}
