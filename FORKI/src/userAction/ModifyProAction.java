package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class ModifyProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		LogonDataBean member = new LogonDataBean();

		member.setId(id);
		member.setPasswd(request.getParameter("passwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setTell(request.getParameter("tell"));
		member.setZipcode(request.getParameter("zipcode"));
		member.setAddress(request.getParameter("address"));
		member.setNickname(request.getParameter("nickname"));
		member.setSex(request.getParameter("sex"));
		
		LogonDBBean manager = LogonDBBean.getInstance();
		manager.updateMEMBER(member);
		manager.updateP_ETC(member);
		
		String child_name1 = request.getParameter("kidName1");
		String schul_nm1 = request.getParameter("kinderName1");
		String child_name2 = request.getParameter("kidName2");
		String schul_nm2 = request.getParameter("kinderName2");
		String child_name3 = request.getParameter("kidName3");
		String schul_nm3 = request.getParameter("kinderName3");
		System.out.println("child_name1::"+child_name1);
		System.out.println("child_name2::"+child_name2);
		System.out.println("child_name3::"+child_name3);
		
		if (child_name1 != null && child_name1 != "" && schul_nm1 != "") {
			member.setId(request.getParameter("id"));
			member.setChild_name(request.getParameter("kidName1"));
			member.setSchul_nm(request.getParameter("kinderName1"));
			manager.updateKID_DATA(member);
		}
		if (child_name2 != null && child_name2 != "" && schul_nm2 != "") {
			member.setId(request.getParameter("id"));
			member.setChild_name(request.getParameter("kidName2"));
			member.setSchul_nm(request.getParameter("kinderName2"));
			manager.updateKID_DATA(member);
		}
		if (child_name3 != null && child_name3 != "" && schul_nm3 != "") {
			member.setId(request.getParameter("id"));
			member.setChild_name(request.getParameter("kidName3"));
			member.setSchul_nm(request.getParameter("kinderName3"));
			manager.updateKID_DATA(member);
		}
		
/*		String child_name = member.getChild_name();
		String schul_nm = member.getSchul_nm();
		
		if(child_name != "" && schul_nm !=""){
			manager.updateKID_DATA(member);
		}*/
		
		return "/content/join/UserModifyPro.jsp";
	}
}
