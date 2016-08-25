package comAction;

import java.sql.Timestamp;

public class LogonDataBean {
	//기본 MEMBER
	private String id;
	private String name;
	private String passwd;
	private String email;
	private int m_grade;//회원구분
	private String certify;//인증여부
	private String tell;
	private String zipcode;
	private String address;
	private int yellow_card;//경고수
	private Timestamp join_date;//가입일
	
	//P_ETC(id는 공통)
	private String nickname;//닉네임
	private String b_day;//생년월일
	private String sex;//성별
	private String favorite;//관심등록
	
	//K_ETC(id는 공통)
	private String schul_num;//사업자번호
	private String schul_nm;//유치원명
	private String reg_check;//등록여부
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getM_grade() {
		return m_grade;
	}
	public void setM_grade(int m_grade) {
		this.m_grade = m_grade;
	}
	public String getCertify() {
		return certify;
	}
	public void setCertify(String certify) {
		this.certify = certify;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getYellow_card() {
		return yellow_card;
	}
	public void setYellow_card(int yellow_card) {
		this.yellow_card = yellow_card;
	}
	public Timestamp getJoin_date() {
		return join_date;
	}
	public void setJoin_date(Timestamp join_date) {
		this.join_date = join_date;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getB_day() {
		return b_day;
	}
	public void setB_day(String b_day) {
		this.b_day = b_day;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}
	public String getSchul_num() {
		return schul_num;
	}
	public void setSchul_num(String schul_num) {
		this.schul_num = schul_num;
	}
	public String getSchul_nm() {
		return schul_nm;
	}
	public void setSchul_nm(String schul_nm) {
		this.schul_nm = schul_nm;
	}
	public String getReg_check() {
		return reg_check;
	}
	public void setReg_check(String reg_check) {
		this.reg_check = reg_check;
	}

}