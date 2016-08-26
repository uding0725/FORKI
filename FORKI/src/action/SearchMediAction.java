package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.MedicalDBBean;

public class SearchMediAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("utf-8");
		String start = request.getParameter("start");
		String search= request.getParameter("search");
		String gu_nm=request.getParameter("gu_nm");
		String check=request.getParameter("check");
		String dong=request.getParameter("dong");
		String select=request.getParameter("select");
		String h_nm=request.getParameter("h_nm");
	
		int n=0;
		int gu_n=0;
		int StTime=0;
		String h_code="0"; 
		MedicalDBBean mdb=MedicalDBBean.getInstance();
		Vector vecList = new Vector();
		Vector vecList2=new Vector();
		if(check==null){}
		else if(check.equals("1")){
			if(start==null){
				start="0";
			}
			if(search==null){
				search="0";
			}
			n=Integer.parseInt(search);
		
			StTime=Integer.parseInt(start);
			if(StTime<=9){
				h_code="1377101";
				
			}else if(StTime>=18){
				h_code="1377101";
			}else{
				
			}
			if(n==0){
				vecList= mdb.searchHosp(h_code);
			
				if(h_code.equals("0")&&StTime>=9&&StTime<=18){
				vecList2=mdb.searchHeal();
				
				}
			}else if(n==1){
				vecList=mdb.searchHosp(h_code);	
				
			}else{
					if(h_code.equals("0")){
						
						vecList=mdb.searchHeal();
					}
			}
		}else{
	
		if(gu_nm==null){
			gu_nm="0";
		}
		gu_n=Integer.parseInt(gu_nm);
			if(select.equals("all")){
				vecList=mdb.selectHosp(gu_n,dong,h_nm);
				vecList2=mdb.selectHel(gu_n,dong,h_nm);
			}else if(select.equals("hospital")){
				vecList=mdb.selectHosp(gu_n,dong,h_nm);
			}else{
				vecList2=mdb.selectHel(gu_n,dong,h_nm);
			}
		}
		int count=0;
		count = vecList.size()+vecList2.size();
		
		request.setAttribute("count", count);
		request.setAttribute("vecList", vecList);
		request.setAttribute("vecList2", vecList2);
		return "searchMedi.jsp";
	}
}
