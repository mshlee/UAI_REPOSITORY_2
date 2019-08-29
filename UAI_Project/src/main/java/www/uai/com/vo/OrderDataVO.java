package www.uai.com.vo;

public class OrderDataVO {

	private String o_idx;
	private String o_totalPrice;
	private String o_date;
	private String o_paymentMethod;
	private String p_idx;
	private String m_idx;
	private String pch_isPaid;

	public OrderDataVO() {

	}

	public OrderDataVO(String o_idx, String o_totalPrice, String o_date, String o_paymentMethod, String p_idx,
			String m_idx, String pch_isPaid) {

		this.o_idx = o_idx;
		this.o_totalPrice = o_totalPrice;
		this.o_date = o_date;
		this.o_paymentMethod = o_paymentMethod;
		this.p_idx = p_idx;
		this.m_idx = m_idx;
		this.pch_isPaid = pch_isPaid;
	}

	public String getO_idx() {
		return o_idx;
	}

	public void setO_idx(String o_idx) {
		this.o_idx = o_idx;
	}

	public String getO_totalPrice() {
		return o_totalPrice;
	}

	public void setO_totalPrice(String o_totalPrice) {
		this.o_totalPrice = o_totalPrice;
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

	public String getPch_isPaid() {
		return pch_isPaid;
	}

	public void setPch_isPaid(String pch_isPaid) {
		this.pch_isPaid = pch_isPaid;
	}

}