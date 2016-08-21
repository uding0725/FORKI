package DAO_DTO;

//병원 DTO
public class HospitalDataBean {

	private int num;
	private String h_id;
	private String h_nm;
	private String h_code;
	private double x;
	private double y;
	private String gu_nm;
	private String dong;
	private String week_time;
	private String rm;

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getH_id() {
		return h_id;
	}
	public void setH_id(String h_id) {
		this.h_id = h_id;
	}
	public String getH_nm() {
		return h_nm;
	}
	public void setH_nm(String h_nm) {
		this.h_nm = h_nm;
	}
	public String getH_code() {
		return h_code;
	}
	public void setH_code(String h_code) {
		this.h_code = h_code;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getGu_nm() {
		return gu_nm;
	}
	public void setGu_nm(String gu_nm) {
		this.gu_nm = gu_nm;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getWeek_time() {
		return week_time;
	}
	public void setWeek_time(String week_time) {
		this.week_time = week_time;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
}
