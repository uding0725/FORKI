package userAction;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import action.*;

public class ModifyFormAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable{
			
			request.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("id");
  
			LogonDBBean manager = LogonDBBean.getInstance();
			
			LogonDataBean m = manager.getMEMBER(id);
			
			request.setAttribute("id",m.getId());
			request.setAttribute("passwd",m.getPasswd());
			request.setAttribute("name",m.getName());
			request.setAttribute("email",m.getEmail());
			request.setAttribute("tell",m.getTell());
			request.setAttribute("zipcode",m.getZipcode());
			request.setAttribute("address",m.getAddress());
			
			LogonDataBean p = manager.getP_ETC(id);
			request.setAttribute("nickname",p.getNickname());
			request.setAttribute("b_day",p.getB_day());
			request.setAttribute("sex",p.getSex());
			
			Vector klist = manager.getKID_DATA(id);
			request.setAttribute("klist", klist);
			/*if(k!=null){
			String child_name = k.getChild_name();
			String schul_nm = k.getSchul_nm();
			System.out.println("child_name:  "+child_name+"schul_nm:   "+schul_nm);
			if(child_name !="" && schul_nm !=""){
			request.setAttribute("child_name",k.getChild_name());
			request.setAttribute("schul_nm",k.getSchul_nm());
			System.out.println("°¨2?");
			}
			}*/
		return "/content/join/UserModifyForm.jsp";
	}

}