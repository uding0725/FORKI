package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO_DTO.HealthDBBean;
import DAO_DTO.HealthDataBean;

public class HealthCheckUpdateAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");		
		String id = (String) session.getAttribute("id");
		HealthCheckSuppot conVal = new HealthCheckSuppot();
		
		String num = request.getParameter("num");
		String bcg = request.getParameter("bcg");
		String hepb1 = request.getParameter("hepb1");
		String hepb2 = request.getParameter("hepb2");
		String hepb3 = request.getParameter("hepb3");
		String dtap1 = request.getParameter("dtap1");
		String dtap2 = request.getParameter("dtap2");
		String dtap3 = request.getParameter("dtap3");
		String dtap4 = request.getParameter("dtap4");
		String dtap5 = request.getParameter("dtap5");
		String tdap = request.getParameter("tdap");
		String ipv1 = request.getParameter("ipv1");
		String ipv2 = request.getParameter("ipv2");
		String ipv3 = request.getParameter("ipv3");
		String ipv4 = request.getParameter("ipv4");
		String prp_t1 = request.getParameter("prp_t1");
		String prp_t2 = request.getParameter("prp_t2");
		String prp_t3 = request.getParameter("prp_t3");
		String prp_t4 = request.getParameter("prp_t4");
		String pcv1 = request.getParameter("pcv1");
		String pcv2 = request.getParameter("pcv2");
		String pcv3 = request.getParameter("pcv3");
		String pcv4 = request.getParameter("pcv4");
		String mmr1 = request.getParameter("mmr1");
		String mmr2 = request.getParameter("mmr2");	
		String var = request.getParameter("var");
		String hepa = request.getParameter("hepa");
		String jev3 = request.getParameter("jev3");
		String jev4 = request.getParameter("jev4");
		String jev5 = request.getParameter("jev5");
		String je2 = request.getParameter("je2");
		String bdg_m = request.getParameter("bdg_m");
		String rv11 = request.getParameter("rv11");
		String rv12 = request.getParameter("rv12");
		String rv51 = request.getParameter("rv51");
		String rv52 = request.getParameter("rv52");
		String rv53 = request.getParameter("rv53");
		String hpv_g = request.getParameter("hpv_g");
		String hpv_c = request.getParameter("hpv_c");
		
		HealthDataBean DBdata = new HealthDataBean();
		DBdata.setNum(conVal.convertValue(num));
		DBdata.setBcg(conVal.convertValue(bcg));
		DBdata.setHepb(conVal.convertValue(hepb1, hepb2, hepb3));
		DBdata.setDtap(conVal.convertValue(dtap1, dtap2, dtap3, dtap4, dtap5));
		DBdata.setTdap(conVal.convertValue(tdap));
		DBdata.setIpv(conVal.convertValue(ipv1, ipv2, ipv3, ipv4));
		DBdata.setPrp_t(conVal.convertValue(prp_t1, prp_t2, prp_t3, prp_t4));
		DBdata.setPcv(conVal.convertValue(pcv1, pcv2, pcv3, pcv4));
		DBdata.setMmr(conVal.convertValue(mmr1, mmr2));
		DBdata.setVar(conVal.convertValue(var));
		DBdata.setHepa(conVal.convertValue(hepa));
		DBdata.setJev(conVal.convertValue(jev3, jev4, jev5));
		DBdata.setJe(conVal.convertValue(je2));
		DBdata.setBdg_m(conVal.convertValue(bdg_m));
		DBdata.setRv1(conVal.convertValue(rv11, rv12));
		DBdata.setRv5(conVal.convertValue(rv51, rv52, rv53));
		DBdata.setHpv_g(conVal.convertValue(hpv_g));
		DBdata.setHpv_c(conVal.convertValue(hpv_c));
		
		HealthDBBean DBpro = HealthDBBean.getInstance();
		DBpro.updateHealth(id, DBdata);
		
		return "HealthCheckUpdate.jsp";
	}
}
