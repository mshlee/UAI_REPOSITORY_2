package www.uai.com.vo;

public class ProductContentVO {
	
	private String p_idx;
	private String pc_teacher;
	private int pc_maxStudent;
	private String pc_startDate;
	private String pc_lastDate;
	private String pc_location;
	private String pc_lectureDay;
	private String pc_lectureTime;
	private String pc_detail;
	
	public ProductContentVO() {}
	
	public ProductContentVO(String p_idx, String pc_teacher, int pc_maxStudent, String pc_startDate, String pc_lastDate,
			String pc_location, String pc_lectureDay, String pc_lectureTime, String pc_detail) {
		super();
		this.p_idx = p_idx;
		this.pc_teacher = pc_teacher;
		this.pc_maxStudent = pc_maxStudent;
		this.pc_startDate = pc_startDate;
		this.pc_lastDate = pc_lastDate;
		this.pc_location = pc_location;
		this.pc_lectureDay = pc_lectureDay;
		this.pc_lectureTime = pc_lectureTime;
		this.pc_detail = pc_detail;
	}

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getPc_teacher() {
		return pc_teacher;
	}

	public void setPc_teacher(String pc_teacher) {
		this.pc_teacher = pc_teacher;
	}

	public int getPc_maxStudent() {
		return pc_maxStudent;
	}

	public void setPc_maxStudent(int pc_maxStudent) {
		this.pc_maxStudent = pc_maxStudent;
	}

	public String getPc_startDate() {
		return pc_startDate;
	}

	public void setPc_startDate(String pc_startDate) {
		this.pc_startDate = pc_startDate;
	}

	public String getPc_lastDate() {
		return pc_lastDate;
	}

	public void setPc_lastDate(String pc_lastDate) {
		this.pc_lastDate = pc_lastDate;
	}

	public String getPc_location() {
		return pc_location;
	}

	public void setPc_location(String pc_location) {
		this.pc_location = pc_location;
	}

	public String getPc_lectureDay() {
		return pc_lectureDay;
	}

	public void setPc_lectureDay(String pc_lectureDay) {
		this.pc_lectureDay = pc_lectureDay;
	}

	public String getPc_lectureTime() {
		return pc_lectureTime;
	}

	public void setPc_lectureTime(String pc_lectureTime) {
		this.pc_lectureTime = pc_lectureTime;
	}

	public String getPc_detail() {
		return pc_detail;
	}

	public void setPc_detail(String pc_detail) {
		this.pc_detail = pc_detail;
	}
	
}
