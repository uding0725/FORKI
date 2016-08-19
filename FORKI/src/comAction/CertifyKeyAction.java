package comAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comAction.LogonDBBean;
import action.*;

public class CertifyKeyAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String id = (String) session.getAttribute("id");  
		String key = request.getParameter("key"); /*�̸��Ͽ��� ���۵� �Ķ��Ÿ �Ķ���ͷ� Ű���� �޾ƿ�*/
		String sessionKey = (String) session.getAttribute("certifyKey"); /*���ǿ� ����� �ִ� Ű��*/
		LogonDBBean dbPro = LogonDBBean.getInstance();
		int check = 0 ; //�����������θ� �����ϱ� ���� ����
		System.out.println("id::"+id);
		System.out.println("key::"+key);
		System.out.println("sessionKey::"+sessionKey);
		System.out.println();
		if (key.equals(sessionKey)){
			check = dbPro.Certify(id);
		System.out.println("check::"+check);
		/*���ǿ� ����� Ű���� �Ķ���ͷ� ���� Ű���� ���Ͽ� �������� �ٲٴ� �޼��� ����*/
		}
		request.setAttribute("check", new Integer(check));
		return "/content/join/factor/company2/certifyKey.jsp";
	}

}

