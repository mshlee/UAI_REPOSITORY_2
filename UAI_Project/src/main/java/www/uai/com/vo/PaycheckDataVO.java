package www.uai.com.vo;

public class PaycheckDataVO {

<<<<<<< HEAD
	
	private String o_idx;
	private String pd_totalPayment;
	private String pd_totalPaymentToTeacher;
	private String pc_teacher;
	private String pd_isPaidToTeacher;
	
=======
	private String o_idx;
	private String o_totalPrice;
	private String pd_totalPaymentToTeacher;
	private String p_teacher;
	private String pd_isPaidToTeacher;
	private String pd_paidDate;
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
	
	
	public PaycheckDataVO() {
	
	}
<<<<<<< HEAD
	

	public PaycheckDataVO(String o_idx, String pd_totalPayment, String pd_totalPaymentToTeacher, String pc_teacher,
			String pd_isPaidToTeacher) {
	
		this.o_idx = o_idx;
		this.pd_totalPayment = pd_totalPayment;
		this.pd_totalPaymentToTeacher = pd_totalPaymentToTeacher;
		this.pc_teacher = pc_teacher;
		this.pd_isPaidToTeacher = pd_isPaidToTeacher;
	}

	
=======


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


>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
	public String getO_idx() {
		return o_idx;
	}


	public void setO_idx(String o_idx) {
		this.o_idx = o_idx;
	}
<<<<<<< HEAD
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
=======


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
	
	


	
>>>>>>> 98a4d0fde51b1c7e651429b122f3367a09cf230c
	
	
}
