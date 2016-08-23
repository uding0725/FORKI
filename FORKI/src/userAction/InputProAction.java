package userAction;

import java.sql.Timestamp;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userAction.CreateCode;
import userAction.SendEmail;
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
		//KID_DATA insert
		LogonDataBean kid_data = new LogonDataBean();
		
		String child_name1 = request.getParameter("kidName1");
		String schul_nm1 = request.getParameter("kinderName1");
		String child_name2 = request.getParameter("kidName2");
		String schul_nm2 = request.getParameter("kinderName2");
		String child_name3 = request.getParameter("kidName3");
		String schul_nm3 = request.getParameter("kinderName3");
		
		if (child_name1 != null && child_name1 != "" && schul_nm1 != "") {
			kid_data.setId(request.getParameter("id"));
			kid_data.setChild_name(request.getParameter("kidName1"));
			kid_data.setSchul_nm(request.getParameter("kinderName1"));
			manager.insertKID_DATA(kid_data);
		}
		if (child_name2 != null && child_name2 != "" && schul_nm2 != "") {
			kid_data.setId(request.getParameter("id"));
			kid_data.setChild_name(request.getParameter("kidName2"));
			kid_data.setSchul_nm(request.getParameter("kinderName2"));
			manager.insertKID_DATA(kid_data);
		}
		if (child_name3 != null && child_name3 != "" && schul_nm3 != "") {
			kid_data.setId(request.getParameter("id"));
			kid_data.setChild_name(request.getParameter("kidName3"));
			kid_data.setSchul_nm(request.getParameter("kinderName3"));
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