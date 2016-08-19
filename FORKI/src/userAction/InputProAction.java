package userAction;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userAction.CreateCode;
import userAction.SendEmail;
import action.*;

public class InputProAction implements CommandAction {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

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
		
		request.setCharacterEncoding("UTF-8");

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
		//KID_DATA insert
		LogonDataBean kid_data = new LogonDataBean();

		String child_name = request.getParameter("child_name");
		String schul_nm = request.getParameter("schul_nm");

		if (child_name != "" && schul_nm != "") {
			kid_data.setId(request.getParameter("id"));
			kid_data.setChild_name(request.getParameter("child_name"));
			kid_data.setSchul_nm(request.getParameter("schul_nm"));

			manager.insertKID_DATA(kid_data);
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

		return "/content/join/UserInputPro.jsp";
	}

}