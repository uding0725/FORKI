package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LibDBBean;

public class searchLibAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		String select = request.getParameter("select");
		String gu_nm = request.getParameter("gu_nm");
		String dongName = request.getParameter("dongName");
		String searchName = request.getParameter("searchName");
		Vector vt = null;
		LibDBBean ldbb = LibDBBean.getInstance();
		
		if(select == "all"){
			
		} else if( select == "tourism_list"){
			vt = ldbb.getTour(gu_nm);
		} else if( select == "pub_lib"){
			
		} else if( select == "toy_lib"){
			
		}
		return "search_Lib.jsp";
	}

}
