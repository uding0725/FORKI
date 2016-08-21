package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.LibDBBean;
import DAO_DTO.Pub_LibDataBean;
import DAO_DTO.Tourism_ListDataBean;
import DAO_DTO.Toy_LibDataBean;

public class LibDetailAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		String adres = request.getParameter("adres");
		String select = request.getParameter("select");
		
		LibDBBean ldbb = LibDBBean.getInstance();
		
		if(select == null){
			
		}else if(select.equals("all")){
			
		} else if( select.equals( "tourism_list")){
			Tourism_ListDataBean article = new Tourism_ListDataBean();
			article = ldbb.viewTour(adres);
		} else if( select.equals("pub_lib")){
			Pub_LibDataBean article = new Pub_LibDataBean();
			article = ldbb.viewPublic(adres);
		} else if( select.equals( "toy_lib")){
			Toy_LibDataBean article = new Toy_LibDataBean();
			article = ldbb.viewToy(adres);
		} else{
			System.out.println("select?::" + select);
		}
		
		return "";
	}

}
