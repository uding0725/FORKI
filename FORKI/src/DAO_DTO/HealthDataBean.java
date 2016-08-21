package DAO_DTO;

import java.sql.Timestamp;

//아이예방접종표 DTO

public class HealthDataBean {

	private String id;
	private int num;
	private String name;
	private int bcg;
	private int hepb;
	private int dtap;
	private int tdap;
	private int ipv;
	private int prp_t;
	private int pcv;
	private int ppsv;
	private int mmr;
	private int var;
	private int hepa;
	private int jev;
	private int je;
	private Timestamp flu_d;
	private Timestamp flu_l;
	private int bdg_m;
	private int rv1;
	private int rv5;
	private int hpv_g;
	private int hpv_c;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBcg() {
		return bcg;
	}

	public void setBcg(int bcg) {
		this.bcg = bcg;
	}

	public int getHepb() {
		return hepb;
	}

	public void setHepb(int hepb) {
		this.hepb = hepb;
	}

	public int getDtap() {
		return dtap;
	}

	public void setDtap(int dtap) {
		this.dtap = dtap;
	}

	public int getTdap() {
		return tdap;
	}

	public void setTdap(int tdap) {
		this.tdap = tdap;
	}

	public int getIpv() {
		return ipv;
	}

	public void setIpv(int ipv) {
		this.ipv = ipv;
	}

	public int getPrp_t() {
		return prp_t;
	}

	public void setPrp_t(int prp_t) {
		this.prp_t = prp_t;
	}

	public int getPcv() {
		return pcv;
	}

	public void setPcv(int pcv) {
		this.pcv = pcv;
	}

	public int getPpsv() {
		return ppsv;
	}

	public void setPpsv(int ppsv) {
		this.ppsv = ppsv;
	}

	public int getMmr() {
		return mmr;
	}

	public void setMmr(int mmr) {
		this.mmr = mmr;
	}

	public int getVar() {
		return var;
	}

	public void setVar(int var) {
		this.var = var;
	}

	public int getHepa() {
		return hepa;
	}

	public void setHepa(int hepa) {
		this.hepa = hepa;
	}

	public int getJev() {
		return jev;
	}

	public void setJev(int jev) {
		this.jev = jev;
	}

	public int getJe() {
		return je;
	}

	public void setJe(int je) {
		this.je = je;
	}

	public Timestamp getFlu_d() {
		return flu_d;
	}

	public void setFlu_d(Timestamp flu_d) {
		this.flu_d = flu_d;
	}

	public Timestamp getFlu_l() {
		return flu_l;
	}

	public void setFlu_l(Timestamp flu_l) {
		this.flu_l = flu_l;
	}

	public int getBdg_m() {
		return bdg_m;
	}

	public void setBdg_m(int bdg_m) {
		this.bdg_m = bdg_m;
	}

	public int getRv1() {
		return rv1;
	}

	public void setRv1(int rv1) {
		this.rv1 = rv1;
	}

	public int getRv5() {
		return rv5;
	}

	public void setRv5(int rv5) {
		this.rv5 = rv5;
	}

	public int getHpv_g() {
		return hpv_g;
	}

	public void setHpv_g(int hpv_g) {
		this.hpv_g = hpv_g;
	}

	public int getHpv_c() {
		return hpv_c;
	}

	public void setHpv_c(int hpv_c) {
		this.hpv_c = hpv_c;
	}

}
