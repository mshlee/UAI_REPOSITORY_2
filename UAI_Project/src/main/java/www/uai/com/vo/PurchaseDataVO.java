package www.uai.com.vo;

public class PurchaseDataVO {
	
	private String o_idx;
	private String pch_paymentDate;
	private String pch_isPaid;
	private String m_idx;
	private String p_teacher;
	
	public PurchaseDataVO() {

	}

	public PurchaseDataVO(String o_idx, String pch_paymentDate, String pch_isPaid, String m_idx, String p_teacher) {
	
		this.o_idx = o_idx;
		this.pch_paymentDate = pch_paymentDate;
		this.pch_isPaid = pch_isPaid;
		this.m_idx = m_idx;
		this.p_teacher = p_teacher;
	}

	public String getO_idx() {
		return o_idx;
	}

	public void setO_idx(String o_idx) {
		this.o_idx = o_idx;
	}

	public String getPch_paymentDate() {
		return pch_paymentDate;
	}

	public void setPch_paymentDate(String pch_paymentDate) {
		this.pch_paymentDate = pch_paymentDate;
	}

	public String getPch_isPaid() {
		return pch_isPaid;
	}

	public void setPch_isPaid(String pch_isPaid) {
		this.pch_isPaid = pch_isPaid;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getP_teacher() {
		return p_teacher;
	}

	public void setP_teacher(String p_teacher) {
		this.p_teacher = p_teacher;
	}
	
	

}
