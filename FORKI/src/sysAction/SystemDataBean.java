package sysAction;

import java.sql.Timestamp;

public class SystemDataBean {
	//블랙리스트(black_list)
	private String id;//아이디(공통)
	private int m_grade;//회원구분(공통)
	private Timestamp r_date;//제재일
	private String content;//제재사유
	private String state;//상태
	
	//탈퇴회원(del_member)
	private String passwd;//비번
	private String email;//이메일
	private Timestamp join_date;//가입일
	private Timestamp del_date;//탈퇴일
	private String del_reason;//탈퇴사유
	
	//신고리스트(report_list)
	private int num;//순번
	private String reporter;//신고자
	private String sub_report;//신고대상
	private String location;//신고위치
	private String report_content;//신고내용
	private Timestamp report_date;//신고일
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getM_grade() {
		return m_grade;
	}
	public void setM_grade(int m_grade) {
		this.m_grade = m_grade;
	}
	public Timestamp getR_date() {
		return r_date;
	}
	public void setR_date(Timestamp r_date) {
		this.r_date = r_date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getReporter() {
		return reporter;
	}
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	public String getSub_report() {
		return sub_report;
	}
	public void setSub_report(String sub_report) {
		this.sub_report = sub_report;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getReport_content() {
		return report_content;
	}
	public void setReport_content(String report_content) {
		this.report_content = report_content;
	}
	public Timestamp getReport_date() {
		return report_date;
	}
	public void setReport_date(Timestamp report_date) {
		this.report_date = report_date;
	}
	
}
