package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.MessageDBBean;
import DAO_DTO.MessageDataBean;

public class SendMessageAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();

		String sendId = (String) session.getAttribute("id");
		String receiveId = request.getParameter("id");
		String message = request.getParameter("message");
		
		MessageDBBean DBpro = MessageDBBean.getInstance();
		DBpro.insertMessage(sendId, receiveId, message);
		
		return "SendMessage.jsp";
	}

}
