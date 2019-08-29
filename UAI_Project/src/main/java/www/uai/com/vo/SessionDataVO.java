package www.uai.com.vo;

public class SessionDataVO {
	
	private String m_idx;
	private String m_nick;
	private String ad_idx;
	private String ad_nick;

	public SessionDataVO() {
		
	}
	
	public SessionDataVO(String m_idx, String m_nick, String ad_idx, String ad_nick) {
		super();
		this.m_idx = m_idx;
		this.m_nick = m_nick;
		this.ad_idx = ad_idx;
		this.ad_nick = ad_nick;
	}


	public String getM_idx() {
		return m_idx;
	}

	public String getM_nick() {
		return m_nick;
	}

	public String getAd_idx() {
		return ad_idx;
	}

	public String getAd_nick() {
		return ad_nick;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public void setAd_idx(String ad_idx) {
		this.ad_idx = ad_idx;
	}

	public void setAd_nick(String ad_nick) {
		this.ad_nick = ad_nick;
	}

	
	
	
}
