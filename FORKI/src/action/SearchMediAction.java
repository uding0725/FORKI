package action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_DTO.MedicalDBBean;

public class SearchMediAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("utf-8");
		String start = request.getParameter("start");//메뉴-시간
		String search= request.getParameter("search");//메뉴-시설
		String gu_nm=request.getParameter("gu_nm");//구이름
		String check=request.getParameter("check");//메뉴에서 눌렀는지 바디에서 눌럿는지 확인할 변수
		String dong=request.getParameter("dong");//동이름
		String select=request.getParameter("select");//바디영역 시설선택
		String h_nm=request.getParameter("h_nm");//시설 이름
		int n=0;//메뉴 선택값 변수
		int gu_n=0;//구 변수 초기화
		int StTime=0;
		String h_code="0"; 
		MedicalDBBean mdb=MedicalDBBean.getInstance();
		Vector vecList = new Vector();
		Vector vecList2=new Vector();
		if(check==null){}
		else if(check.equals("1")){
			if(start==null){//시간이 null이면
				start="0";
			}
			if(search==null){//메뉴의 시설 선택이 null이면
				search="0";
			}
			n=Integer.parseInt(search);
			StTime=Integer.parseInt(start);//시간을 저장하는 변수
			if(StTime<=9){
				h_code="1377101";
				
			}else if(StTime>=18){
				h_code="1377101";
			}else{
				
			}
			if(n==0){//메뉴-전체선택
				vecList= mdb.searchHosp(h_code);
				if(h_code.equals("0")){
				vecList2=mdb.searchHeal();
				}
			}else if(n==1){//메뉴-병원
				vecList=mdb.searchHosp(h_code);	
			}else{//메뉴-보건소
					if(h_code.equals("0")){
						vecList=mdb.searchHeal();
					}
			}//메뉴 끝
		}else{
	
		if(gu_nm==null){//처음 구선택이 안되있을시
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
		}//check if 문 끝
		int count=0;
		count = vecList.size()+vecList2.size();
		request.setAttribute("count", count);
		request.setAttribute("vecList", vecList);
		request.setAttribute("vecList2", vecList2);
		return "searchMedi.jsp";
	}
}
