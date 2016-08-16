package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.MessageDBBean;
import DAO_DTO.MessageDataBean;

public class MessageContentAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");		
		String num = request.getParameter("num");
	
		MessageDBBean DBpro = MessageDBBean.getInstance();
		MessageDataBean DBdata = DBpro.selectMessage(num);
		
		request.setAttribute("id", DBdata.getSend_id());
		request.setAttribute("content", DBdata.getContent());
		
		return "MessageContent.jsp";
	}

}
