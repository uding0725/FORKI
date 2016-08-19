package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LibDBBean;
import DAO_DTO.Tourism_ListDataBean;

public class searchLibAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		 
		System.out.println("search action 시작");
		String select = request.getParameter("select");
		String gu_nm =request.getParameter("gu_nm");
		String dongName = request.getParameter("dongName");
		String searchName = request.getParameter("searchName");
		
		Vector vt = new Vector();
		int count = 0;
		int gu_n =0;
		
		System.out.println("se:"+select+ "g_n::" + gu_nm);
		System.out.println("dongName:"+dongName+ "sN::" + searchName);
		
		if(gu_nm == null){
			gu_nm = "1";
		}
		gu_n = Integer.parseInt(gu_nm);
		
		System.out.println("gu_n::"+gu_n);
		
		LibDBBean ldbb = LibDBBean.getInstance();
		
		if(select == null){
			
		}else if(select.equals("all")){
			
		} else if( select.equals( "tourism_list")){
			vt = ldbb.getTour(gu_n,dongName,searchName);
		} else if( select.equals("pub_lib")){
			vt = ldbb.getPubLib(gu_n,dongName,searchName);
		} else if( select.equals( "toy_lib")){
			vt = ldbb.getToyLib(gu_n,dongName,searchName);
		} else{
			System.out.println("select?::" + select);
		}
		
		if(vt == null){
			count = 0;
		}else{
			count = vt.size();
		}
		System.out.println( "count::"+count);
		
		request.setAttribute("select", select);
		request.setAttribute("vt",vt);
		request.setAttribute("count", count);
		
		return "searchLib.jsp";
	}

}
