package www.uai.com.vo;

public class PaycheckDataVO {

	
	private String o_idx;
	private String pd_totalPayment;
	private String pd_totalPaymentToTeacher;
	private String pc_teacher;
	private String pd_isPaidToTeacher;
	
	
	
	public PaycheckDataVO() {
	
	}
	

	public PaycheckDataVO(String o_idx, String pd_totalPayment, String pd_totalPaymentToTeacher, String pc_teacher,
			String pd_isPaidToTeacher) {
	
		this.o_idx = o_idx;
		this.pd_totalPayment = pd_totalPayment;
		this.pd_totalPaymentToTeacher = pd_totalPaymentToTeacher;
		this.pc_teacher = pc_teacher;
		this.pd_isPaidToTeacher = pd_isPaidToTeacher;
	}

	
	public String getO_idx() {
		return o_idx;
	}


	public void setO_idx(String o_idx) {
		this.o_idx = o_idx;
	}
	public String getPd_totalPayment() {
		return pd_totalPayment;
	}
	public void setPd_totalPayment(String pd_totalPayment) {
		this.pd_totalPayment = pd_totalPayment;
	}
	public String getPd_totalPaymentToTeacher() {
		return pd_totalPaymentToTeacher;
	}
	public void setPd_totalPaymentToTeacher(String pd_totalPaymentToTeacher) {
		this.pd_totalPaymentToTeacher = pd_totalPaymentToTeacher;
	}
	public String getPc_teacher() {
		return pc_teacher;
	}
	public void setPc_teacher(String pc_teacher) {
		this.pc_teacher = pc_teacher;
	}
	public String getPd_isPaidToTeacher() {
		return pd_isPaidToTeacher;
	}
	public void setPd_isPaidToTeacher(String pd_isPaidToTeacher) {
		this.pd_isPaidToTeacher = pd_isPaidToTeacher;
	}
	
	
}
