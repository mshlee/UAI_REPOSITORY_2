package www.uai.com.vo;

public class OrderDataVO {
	
	private String o_idx;
	private String o_totalprice;
	private String o_date;
	private String o_paymentMethod;
	private String p_idx;
	private String m_idx;
	
	public OrderDataVO() {
	}
	
	public OrderDataVO(String o_idx, String o_totalprice, String o_date, String o_paymentMethod, String p_idx, String m_idx) {
		this.o_idx = o_idx;
		this.o_totalprice = o_totalprice;
		this.o_date = o_date;
		this.o_paymentMethod = o_paymentMethod;
		this.p_idx = p_idx;
		this.m_idx = m_idx;
	}

	public String getO_idx() {
		return o_idx;
	}

	public void setO_idx(String o_idx) {
		this.o_idx = o_idx;
	}

	public String getO_totalprice() {
		return o_totalprice;
	}

	public void setO_totalprice(String o_totalprice) {
		this.o_totalprice = o_totalprice;
	}

	public String getO_date() {
		return o_date;
	}

	public void setO_date(String o_date) {
		this.o_date = o_date;
	}

	public String getO_paymentMethod() {
		return o_paymentMethod;
	}

	public void setO_paymentMethod(String o_paymentMethod) {
		this.o_paymentMethod = o_paymentMethod;
	}

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

}
	
