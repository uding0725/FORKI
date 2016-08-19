package userAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class ModifyProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("memId");
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
		member.setChild_name(request.getParameter("child_name"));
		member.setSchul_nm(request.getParameter("schul_nm"));
		
		LogonDBBean manager = LogonDBBean.getInstance();
		manager.updateMEMBER(member);
		manager.updateP_ETC(member);
		
		String child_name = member.getChild_name();
		String schul_nm = member.getSchul_nm();
		
		if(child_name != "" && schul_nm !=""){
			manager.updateKID_DATA(member);
		}
		
		return "/content/join/factor/user/modifyPro.jsp";
	}
}
