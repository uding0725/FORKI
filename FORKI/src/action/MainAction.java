package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.FreeBoardDBBean;
import DAO_DTO.NotifyDBBean;

public class MainAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		Vector n = new Vector();
		Vector b = new Vector();
		
		NotifyDBBean ndbb = NotifyDBBean.getInstance();
		n = ndbb.getMain();
		
		FreeBoardDBBean fbdbb = FreeBoardDBBean.getInstance();
		b = fbdbb.getMain();
		
		request.setAttribute("n", n);
		request.setAttribute("b", b);
		
		
		return "main.jsp";
	}

}
