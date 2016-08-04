package DAO_DTO;

import java.sql.Timestamp;

public class ReportDataBean {
	private int num;
	private String reporter;
	private String sub_report;
	private String location;
	private String content;
	private Timestamp date;
	
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
