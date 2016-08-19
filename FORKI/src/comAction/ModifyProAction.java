package comAction;

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
		member.setSchul_num(request.getParameter("schul_num"));
		member.setSchul_nm(request.getParameter("schul_nm"));
		
		LogonDBBean manager = LogonDBBean.getInstance();
		manager.updateMEMBER(member);
		manager.updateP_ETC(member);
		
		String schul_num = member.getSchul_num();
		String schul_nm = member.getSchul_nm();
		
		if(schul_num != "" && schul_nm !=""){
			manager.updateK_ETC(member);
		}
		
		return "/content/join/ComModifyPro.jsp";
	}
}
