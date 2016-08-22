package comAction;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comAction.CreateCode;
import comAction.SendEmail;
import action.*;

public class InputProAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("UTF-8");
		
		//������� 8�ڸ��� ����
		String MM = null;
		String dd = null;
		
		if (Integer.parseInt(request.getParameter("MM")) < 10) 
			MM = "0" + Integer.parseInt(request.getParameter("MM"));
		else 
			MM = request.getParameter("MM");
		if (Integer.parseInt(request.getParameter("dd")) < 10)
			dd = "0" + Integer.parseInt(request.getParameter("dd"));
		else
			dd = request.getParameter("dd");
		String day = request.getParameter("b_day") + MM + dd;
		
		System.out.println(day);
		
		SendEmail sendEmail = new SendEmail(); /*�̸����� ������ Ŭ����*/
		CreateCode code = new CreateCode(); /*�����ڵ带 �����ϴ� Ŭ����*/
		HttpSession session = request.getSession();

		LogonDBBean manager = LogonDBBean.getInstance();
		//��� insert
		LogonDataBean member = new LogonDataBean();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setTell(request.getParameter("tell"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress(request.getParameter("address"));
		member.setJoin_date(new Timestamp(System.currentTimeMillis()));
		
		String getId = member.getId();
		String getKey = code.randomCode();
		String getEmail = member.getEmail();

		int check = manager.insertMEMBER(member);
		
		//P_ETC insert
		LogonDataBean p_etc = new LogonDataBean();
		p_etc.setId(request.getParameter("id"));
		p_etc.setNickname(request.getParameter("nickname"));
		p_etc.setB_day(day);
		p_etc.setSex(request.getParameter("sex"));

		manager.insertP_ETC(p_etc);
		//K_ETC insert
		LogonDataBean k_etc = new LogonDataBean();

		String schul_num = request.getParameter("schul_num");
		String schul_nm = request.getParameter("schul_nm");

		if (schul_num != "" && schul_nm != "") {
			k_etc.setId(request.getParameter("id"));
			k_etc.setSchul_num(request.getParameter("schul_num"));
			k_etc.setSchul_nm(request.getParameter("schul_nm"));
			System.out.println("�߰���?");

			manager.insertK_ETC(k_etc);
		}
		System.out.println(check);
		//EMAIL����
		if (check == 1) {
			session.setAttribute("id", getId); /*ȸ�������� ȸ���� ���̵��� ������ ����*/
			session.setAttribute("certifyKey", getKey); /*ȸ�������� ȸ���� Ű���� ������ ����*/
			sendEmail.sendCode(getEmail, getKey, 1);
			System.out.println("����");
		}
		
		request.setAttribute("check", new Integer(check));

		return "/content/join/ComInputPro.jsp";
	}

}