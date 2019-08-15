package www.uai.com.vo;

public class PurchaseDataVO {
	
	private int o_idx;
	private String pch_paymentDate;
	private int pch_isPaid;
	private int m_idx;
	private String p_teacher;
	
	public PurchaseDataVO() {

	}
	
	
	public PurchaseDataVO(int o_idx, String pch_paymentDate, int pch_isPaid, int m_idx, String p_teacher) {
		this.o_idx = o_idx;
		this.pch_paymentDate = pch_paymentDate;
		this.pch_isPaid = pch_isPaid;
		this.m_idx = m_idx;
		this.p_teacher = p_teacher;
	}
	
	
	public int getO_idx() {
		return o_idx;
	}
	public void setO_idx(int o_idx) {
		this.o_idx = o_idx;
	}
	public String getPch_paymentDate() {
		return pch_paymentDate;
	}
	public void setPch_paymentDate(String pch_paymentDate) {
		this.pch_paymentDate = pch_paymentDate;
	}
	public int getPch_isPaid() {
		return pch_isPaid;
	}
	public void setPch_isPaid(int pch_isPaid) {
		this.pch_isPaid = pch_isPaid;
	}
	public int getM_idx() {
		return m_idx;
	}
	public void setM_idx(int m_idx) {
		this.m_idx = m_idx;
	}
	public String getP_teacher() {
		return p_teacher;
	}
	public void setP_teacher(String p_teacher) {
		this.p_teacher = p_teacher;
	}
	
	

}
