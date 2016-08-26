package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LibDBBean;
import DAO_DTO.Tourism_ListDataBean;

public class LibSearchAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		 
		
		String select = request.getParameter("select");
		String gu_nm =request.getParameter("gu_nm");
		String dongName = request.getParameter("dongName");
		String searchName = request.getParameter("searchName");
		
		
		Vector vTour = new Vector();
		Vector vPub = new Vector();
		Vector vToy = new Vector();
		
		int count = 0;
		int gu_n =0;
		
		
		if(gu_nm == null){
			gu_nm = "1";
		}
		gu_n = Integer.parseInt(gu_nm);
		
		
		
		String tour="";
		
				
		LibDBBean ldbb = LibDBBean.getInstance();
		
		if(select == null){
			
		}else if(select.equals("all")){
			vTour = ldbb.getTour(gu_n, dongName, searchName);
			vPub = ldbb.getPubLib(gu_n, dongName, searchName);
			vToy = ldbb.getToyLib(gu_n, dongName, searchName);
		} else if( select.equals( "tourism_list")){
			
			vTour = ldbb.getTour(gu_n,dongName,searchName);
			
		} else if( select.equals("pub_lib")){
			vPub = ldbb.getPubLib(gu_n,dongName,searchName);
			
		} else if( select.equals( "toy_lib")){
			vToy = ldbb.getToyLib(gu_n,dongName,searchName);
		} else{
			System.out.println("select?::" + select);
		}
		
		
		
		
		
			if(select==null){	
			}
			else if(select.equals("all")){
				count = vTour.size()+vPub.size()+vToy.size();	
			} else if( select.equals( "tourism_list")){
				count = vTour.size();
			} else if( select.equals("pub_lib")){
				count = vPub.size();
			} else if( select.equals( "toy_lib")){
				count = vToy.size();
			}
				
		
		
		
		
		request.setAttribute("select", select);
		request.setAttribute("vTour", vTour);
		request.setAttribute("vPub", vPub);
		request.setAttribute("vToy", vToy);
		request.setAttribute("count", new Integer(count));
		
		return "searchLib.jsp";
	}

}
