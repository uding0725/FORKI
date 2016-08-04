package DAO_DTO;

import java.sql.Timestamp;

public class DelLogonDataBean {

	private String id;
	private String pwd;
	private String e_mail;
	private int m_grade;
	private Timestamp join_date;
	private Timestamp del_date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public int getM_grade() {
		return m_grade;
	}
	public void setM_grade(int m_grade) {
		this.m_grade = m_grade;
	}
	public Timestamp getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Timestamp join_date) {
		this.join_date = join_date;
	}
	public Timestamp getDel_date() {
		return del_date;
	}
	public void setDel_date(Timestamp del_date) {
		this.del_date = del_date;
	}
	public String getDel_reason() {
		return del_reason;
	}
	public void setDel_reason(String del_reason) {
		this.del_reason = del_reason;
	}
	private String del_reason;
	
	
}
