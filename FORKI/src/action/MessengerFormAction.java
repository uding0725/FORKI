package action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.MessageDBBean;

public class MessengerFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");		
		String pageNum = request.getParameter("pageNum");
		String id = (String) session.getAttribute("id");

		if (pageNum == null) {
			pageNum = "1";
		}

		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number = 0;
		
		List articleList = null;
		MessageDBBean DBpro = MessageDBBean.getInstance();
		count = DBpro.getMessageCount(id);

		if (count > 0) {
			articleList = DBpro.getMessageList(id ,startRow, endRow);
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize;

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
		
		return "MessengerForm.jsp";
	}

}
