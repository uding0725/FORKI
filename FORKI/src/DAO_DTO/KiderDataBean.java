package DAO_DTO;//À¯Ä¡¿ø dto

import java.sql.Timestamp;
public class KiderDataBean {

	private int schul_num;
	private String schul_nm;
	private String ofcdc;
	private String matr_gu;
	private String fond;
	private String zip;
	private String adres;
	private String dong;
	private String telno;
	private int clas_co;
	private int stdnt_co_sm;
	private int grlstdn_co;
	private int frl_tcher_co_sm;
	private int frl_female_tcher_c;
	private String rm;
	private String state;
	private Timestamp reg_date;
	public Timestamp getReg_date() {
		return reg_date; 
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getSchul_num() {
		return schul_num;
	}
	public void setSchul_num(int schul_num) {
		this.schul_num = schul_num;
	}
	public String getSchul_nm() {
		return schul_nm;
	}
	public void setSchul_nm(String schul_nm) {
		this.schul_nm = schul_nm;
	}
	public String getOfcdc() {
		return ofcdc;
	}
	public void setOfcdc(String ofcdc) {
		this.ofcdc = ofcdc;
	}
	public String getMatr_gu() {
		return matr_gu;
	}
	public void setMatr_gu(String matr_gu) {
		this.matr_gu = matr_gu;
	}
	public String getFond() {
		return fond;
	}
	public void setFond(String fond) {
		this.fond = fond;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public int getClas_co() {
		return clas_co;
	}
	public void setClas_co(int clas_co) {
		this.clas_co = clas_co;
	}
	public int getStdnt_co_sm() {
		return stdnt_co_sm;
	}
	public void setStdnt_co_sm(int stdnt_co_sm) {
		this.stdnt_co_sm = stdnt_co_sm;
	}
	public int getGrlstdn_co() {
		return grlstdn_co;
	}
	public void setGrlstdn_co(int grlstdn_co) {
		this.grlstdn_co = grlstdn_co;
	}
	public int getFrl_tcher_co_sm() {
		return frl_tcher_co_sm;
	}
	public void setFrl_tcher_co_sm(int frl_tcher_co_sm) {
		this.frl_tcher_co_sm = frl_tcher_co_sm;
	}
	public int getFrl_female_tcher_c() {
		return frl_female_tcher_c;
	}
	public void setFrl_female_tcher_c(int frl_female_tcher_c) {
		this.frl_female_tcher_c = frl_female_tcher_c;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
	
}
