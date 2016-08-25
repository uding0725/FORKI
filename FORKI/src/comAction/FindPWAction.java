package comAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comAction.LogonDBBean;
import action.*;

public class FindPWAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key"); /*�̸޿��� ���۵� �Ķ��Ÿ �Ķ���ͷ� Ű���� �޾ƿ�*/
		String sessionKey = (String) session.getAttribute("findKey"); /*���ǿ� ����� �ִ� Ű��*/
		String id = (String) session.getAttribute("findId");
		int check = 0 ; //�����������θ� �����ϱ� ���� ����
		System.out.println(id);
		if (key.equals(sessionKey)) 
			check = 1;
		/*���ǿ� ����� Ű���� �Ķ���ͷ� ���� Ű���� ���Ͽ� �������� �ٲٴ� �޼��� ����*/
		
		request.setAttribute("check", new Integer(check));
		return "/content/join/ComFindPW.jsp";
	}

}
