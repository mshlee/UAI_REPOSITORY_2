package www.uai.com.vo;
/*AD_IDX NUMBER(8) PRIMARY KEY,
AD_ID VARCHAR2(40),
AD_PW VARCHAR2(40),
AD_NICK VARCHAR2(40)*/
public class AdminDataVO {
	private String ad_idx;
	private String ad_id;
	private String ad_pw;
	private String ad_nick;
	
	
	public AdminDataVO() {
		super();
	}
	
	public AdminDataVO(String ad_idx, String ad_id, String ad_pw, String ad_nick) {
		super();
		this.ad_idx = ad_idx;
		this.ad_id = ad_id;
		this.ad_pw = ad_pw;
		this.ad_nick = ad_nick;
	}


	public String getAd_idx() {
		return ad_idx;
	}


	public void setAd_idx(String ad_idx) {
		this.ad_idx = ad_idx;
	}


	public String getAd_id() {
		return ad_id;
	}


	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}


	public String getAd_pw() {
		return ad_pw;
	}


	public void setAd_pw(String ad_pw) {
		this.ad_pw = ad_pw;
	}


	public String getAd_nick() {
		return ad_nick;
	}


	public void setAd_nick(String ad_nick) {
		this.ad_nick = ad_nick;
	}
	
	
	
}
