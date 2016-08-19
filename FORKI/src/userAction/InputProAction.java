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

		//생년월일 8자리로 저장
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
		
		SendEmail sendEmail = new SendEmail(); /*이메일을 보내는 클레스*/
		CreateCode code = new CreateCode(); /*랜덤코드를 생성하는 클레스*/
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");

		LogonDBBean manager = LogonDBBean.getInstance();
		//멤버 insert
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
		//EMAIL인증
		if (check == 1) {
			session.setAttribute("id", getId); /*회원가입한 회원의 아이디값을 세션의 저장*/
			session.setAttribute("certifyKey", getKey); /*회원가입한 회원의 키값을 세션의 저장*/
			sendEmail.sendCode(getEmail, getKey, 1);
			System.out.println("졸려");
		}
		
		request.setAttribute("check", new Integer(check));

		return "/content/join/UserInputPro.jsp";
	}

}