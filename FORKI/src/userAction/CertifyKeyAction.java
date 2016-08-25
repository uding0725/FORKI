package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userAction.LogonDBBean;
import action.*;

public class CertifyKeyAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("certufyId");  
		String key = request.getParameter("key"); /*�̸޿��� ���۵� �Ķ��Ÿ �Ķ���ͷ� Ű���� �޾ƿ�*/
		String sessionKey = (String) session.getAttribute("certifyKey"); /*���ǿ� ����� �ִ� Ű��*/
		LogonDBBean dbPro = LogonDBBean.getInstance();
		int check = 0 ; //�����������θ� �����ϱ� ���� ����
		
		if (key.equals(sessionKey)){ 
			check = dbPro.Certify(id);
		/*���ǿ� ����� Ű���� �Ķ���ͷ� ���� Ű���� ���Ͽ� �������� �ٲٴ� �޼��� ����*/
		}
		request.setAttribute("check", new Integer(check));
		return "/content/join/factor/user/certifyKey.jsp";
	}

}
