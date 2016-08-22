package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LibDBBean;
import DAO_DTO.Tourism_ListDataBean;

public class LibSearchAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		 
		System.out.println("search action 시작");
		String select = request.getParameter("select");
		String gu_nm =request.getParameter("gu_nm");
		String dongName = request.getParameter("dongName");
		String searchName = request.getParameter("searchName");
		
		Vector vt = new Vector();
		Vector vTour = new Vector();
		Vector vPub = new Vector();
		Vector vToy = new Vector();
		int count = 0;
		int gu_n =0;
		
		System.out.println("se:"+select+ "g_n::" + gu_nm);
		System.out.println("dongName:"+dongName+ "sN::" + searchName);
		
		if(gu_nm == null){
			gu_nm = "1";
		}
		gu_n = Integer.parseInt(gu_nm);
		
		System.out.println("gu_n::"+gu_n);
		
		String tour="";
		System.out.println(tour);
				
		LibDBBean ldbb = LibDBBean.getInstance();
		
		if(select == null){
			
		}else if(select.equals("all")){
			vTour = ldbb.getTour(gu_n, dongName, searchName);
			vPub = ldbb.getPubLib(gu_n, dongName, searchName);
			vToy = ldbb.getToyLib(gu_n, dongName, searchName);
		} else if( select.equals( "tourism_list")){
			vt = ldbb.getTour(gu_n,dongName,searchName);
			if(vt.size()>0){
				tour = "tour";
			}
		} else if( select.equals("pub_lib")){
			vt = ldbb.getPubLib(gu_n,dongName,searchName);
		} else if( select.equals( "toy_lib")){
			vt = ldbb.getToyLib(gu_n,dongName,searchName);
		} else{
			System.out.println("select?::" + select);
		}
		
		if(vTour.size()>0){
			String aTour = "tour";
			String aToy = "toy";
		}
		
		System.out.println(tour);
		
			if(select==null){	
			}
			else if(select.equals("all")){
				count = vTour.size()+vPub.size()+vToy.size();	
			} else{
			count = vt.size();
			}
		
		System.out.println( "count::"+count);
		
		request.setAttribute("tour", tour);
		request.setAttribute("select", select);
		request.setAttribute("vTour", vTour);
		request.setAttribute("vPub", vPub);
		request.setAttribute("vToy", vToy);
		request.setAttribute("vt",vt);
		request.setAttribute("count", new Integer(count));
		
		return "searchLib.jsp";
	}

}
