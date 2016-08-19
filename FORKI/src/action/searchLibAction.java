package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LibDBBean;

public class searchLibAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		System.out.println("search action 시작");
		String select = request.getParameter("select");
		String gu_nm = request.getParameter("gu_nm");
		String dongName = request.getParameter("dongName");
		String searchName = request.getParameter("searchName");
		Vector vt = null;
		int count = 0;
		
		LibDBBean ldbb = LibDBBean.getInstance();
		
		System.out.println("se:"+select+ "g_n::" + gu_nm);
		System.out.println("dongName:"+dongName+ "sN::" + searchName);
		
		if(select == "all"){
			
		} else if( select == "tourism_list"){
			vt = ldbb.getTour(gu_nm);
		} else if( select == "pub_lib"){
			
		} else if( select == "toy_lib"){
			
		}
		
		
		if(vt == null){
			count = 0;
		}
		count = vt.size();
		
		
		
		request.setAttribute("vt",vt);
		request.setAttribute("count", count);
		
		return "searchLib.jsp";
	}

}
