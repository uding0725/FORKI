package comAction;

import java.sql.Timestamp;

public class LogonDataBean {
	//�⺻ MEMBER
	private String id;
	private String name;
	private String passwd;
	private String email;
	private int m_grade;//ȸ������
	private String certify;//��������
	private String tell;
	private String zipcode;
	private String address;
	private int yellow_card;//����
	private Timestamp join_date;//������
	
	//P_ETC(id�� ����)
	private String nickname;//�г���
	private String b_day;//�������
	private String sex;//����
	private String favorite;//���ɵ��
	
	//K_ETC(id�� ����)
	private String schul_num;//����ڹ�ȣ
	private String schul_nm;//��ġ����
	private String reg_check;//��Ͽ���
	
	
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