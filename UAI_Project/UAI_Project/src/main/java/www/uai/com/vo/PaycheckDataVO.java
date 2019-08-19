package www.uai.com.vo;

public class PaycheckDataVO {

	
	private String o_idx;
	private String o_totalPrice;
	private String pd_totalPaymentToTeacher;
	private String p_teacher;
	private String pd_isPaidToTeacher;
	private String pd_paidDate;
	
	
	public PaycheckDataVO() {
	
	}


	public PaycheckDataVO(String o_idx, String o_totalPrice, String pd_totalPaymentToTeacher, String p_teacher,
			String pd_isPaidToTeacher, String pd_paidDate) {
		super();
		this.o_idx = o_idx;
		this.o_totalPrice = o_totalPrice;
		this.pd_totalPaymentToTeacher = pd_totalPaymentToTeacher;
		this.p_teacher = p_teacher;
		this.pd_isPaidToTeacher = pd_isPaidToTeacher;
		this.pd_paidDate = pd_paidDate;
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


	public String getPd_totalPaymentToTeacher() {
		return pd_totalPaymentToTeacher;
	}


	public void setPd_totalPaymentToTeacher(String pd_totalPaymentToTeacher) {
		this.pd_totalPaymentToTeacher = pd_totalPaymentToTeacher;
	}


	public String getP_teacher() {
		return p_teacher;
	}


	public void setP_teacher(String p_teacher) {
		this.p_teacher = p_teacher;
	}


	public String getPd_isPaidToTeacher() {
		return pd_isPaidToTeacher;
	}


	public void setPd_isPaidToTeacher(String pd_isPaidToTeacher) {
		this.pd_isPaidToTeacher = pd_isPaidToTeacher;
	}


	public String getPd_paidDate() {
		return pd_paidDate;
	}


	public void setPd_paidDate(String pd_paidDate) {
		this.pd_paidDate = pd_paidDate;
	}
	
	


	
	
	

}
