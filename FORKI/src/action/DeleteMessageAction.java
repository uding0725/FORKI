package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.MessageDBBean;

public class DeleteMessageAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");

		String num = request.getParameter("num");
		
		MessageDBBean DBpro = MessageDBBean.getInstance();
		int check = DBpro.deleteMessage(num);
		return "DeleteMessage.jsp";
	}

}
