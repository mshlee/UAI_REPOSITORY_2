package www.uai.com.vo;

public class OrderDataVO {
	
	private int o_idx;
	private int o_totalprice;
	private String o_date;
	private int o_paymentMethod;
	private int p_idx;
	private int m_idx;
	
	public OrderDataVO() {
	}
	
	public OrderDataVO(int o_idx, int o_totalprice, String o_date, int o_paymentMethod, int p_idx, int m_idx) {
		this.o_idx = o_idx;
		this.o_totalprice = o_totalprice;
		this.o_date = o_date;
		this.o_paymentMethod = o_paymentMethod;
		this.p_idx = p_idx;
		this.m_idx = m_idx;
	}

	public int getO_idx() {
		return o_idx;
	}
	public void setO_idx(int o_idx) {
		this.o_idx = o_idx;
	}
	public int getO_totalprice() {
		return o_totalprice;
	}
	public void setO_totalprice(int o_totalprice) {
		this.o_totalprice = o_totalprice;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
	public int getO_paymentMethod() {
		return o_paymentMethod;
	}
	public void setO_paymentMethod(int o_paymentMethod) {
		this.o_paymentMethod = o_paymentMethod;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	
	
}
	
