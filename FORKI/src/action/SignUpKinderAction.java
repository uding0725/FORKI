package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.KiderDBBean;



public class SignUpKinderAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		int pageSize=10;
		String pageNum= request.getParameter("pageNum");
		String search=request.getParameter("search");
		int searchn=0;
		if(pageNum==null){
			pageNum="1";
		}
		if(search==null){
			search="";
		}else{
			searchn=Integer.parseInt(request.getParameter("searchn"));
		}
		int currentPage =Integer.parseInt(pageNum);
		int startRow=(currentPage*pageSize)-(pageSize-1);
		int endRow= currentPage*pageSize;
		int count=0;
		int number=0;
		Vector vecList=null;
		KiderDBBean kdb=KiderDBBean.getInstance();
		
		
		
		if(search.equals("")||search==null)
			count= kdb.getCountKider();
		else
			count= kdb.getCountKider(searchn,search);
		if(count>0){
			if(search.equals("")||search==null) 
				vecList = kdb.signKinder(startRow,endRow);	
			else
				vecList=kdb.signKinder(startRow, endRow, searchn, search);
		}

		
		request.setAttribute("vecList", vecList);
		request.setAttribute("count", count);
		return "signUpLayout.jsp";
	}
}
