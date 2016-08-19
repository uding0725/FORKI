package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class FindSendAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
		SendEmail sendEmail = new SendEmail(); /*�̸����� ������ Ŭ����*/
		CreateCode code = new CreateCode(); /*�����ڵ带 �����ϴ� Ŭ����*/
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String getKey = code.randomCode();

		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.findPWD(id, name, email);

		
		if(check == 1){
			session.setAttribute("findId", id); /*ȸ���� ���̵��� ������ ����*/
			session.setAttribute("findKey", getKey); /*ȸ���� Ű���� ������ ����*/
			sendEmail.sendCode(email, getKey, 2);
		}
		request.setAttribute("check", new Integer(check));	
		
		return "/content/join/factor/user/findSend.jsp";//�ش� ��
	}
}
