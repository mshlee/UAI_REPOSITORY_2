package www.uai.com.vo;

public class ProductVO {

	private String p_idx;
	private String p_name;
	private String p_type;
	private String p_originalPrice;
	private String p_nowPrice;
	private String p_teacher;
	private String p_maxStudent;
	private String p_startDate;
	private String p_lastDate;
	private String p_location;
	private String p_lectureDay;
	private String p_lectureTime;
	private String p_lectureInfo;
	private String p_teacherInfo;
	private String p_otherInfo;
	private String p_totalSaleCount; 
	private String p_postDate;
	
	public ProductVO() {}

	public ProductVO(String p_idx, String p_name, String p_type, String p_originalPrice, String p_nowPrice,
			String p_teacher, String p_maxstudent, String p_startdate, String p_lastdate, String p_location,
			String p_lectureday, String p_lecturetime, String p_lectureinfo, String p_teacherinfo, String p_otherinfo,
			String p_totalSaleCount, String p_postDate) {
		super();
		this.p_idx = p_idx;
		this.p_name = p_name;
		this.p_type = p_type;
		this.p_originalPrice = p_originalPrice;
		this.p_nowPrice = p_nowPrice;
		this.p_teacher = p_teacher;
		this.p_maxstudent = p_maxstudent;
		this.p_startdate = p_startdate;
		this.p_lastdate = p_lastdate;
		this.p_location = p_location;
		this.p_lectureday = p_lectureday;
		this.p_lecturetime = p_lecturetime;
		this.p_lectureinfo = p_lectureinfo;
		this.p_teacherinfo = p_teacherinfo;
		this.p_otherinfo = p_otherinfo;
		this.p_totalSaleCount = p_totalSaleCount;
		this.p_postDate = p_postDate;
	}

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_originalPrice() {
		return p_originalPrice;
	}

	public void setP_originalPrice(String p_originalPrice) {
		this.p_originalPrice = p_originalPrice;
	}

	public String getP_nowPrice() {
		return p_nowPrice;
	}

	public void setP_nowPrice(String p_nowPrice) {
		this.p_nowPrice = p_nowPrice;
	}

	public String getP_teacher() {
		return p_teacher;
	}

	public void setP_teacher(String p_teacher) {
		this.p_teacher = p_teacher;
	}

	public String getP_maxstudent() {
		return p_maxstudent;
	}

	public void setP_maxstudent(String p_maxstudent) {
		this.p_maxstudent = p_maxstudent;
	}

	public String getP_startdate() {
		return p_startdate;
	}

	public void setP_startdate(String p_startdate) {
		this.p_startdate = p_startdate;
	}

	public String getP_lastdate() {
		return p_lastdate;
	}

	public void setP_lastdate(String p_lastdate) {
		this.p_lastdate = p_lastdate;
	}

	public String getP_location() {
		return p_location;
	}

	public void setP_location(String p_location) {
		this.p_location = p_location;
	}

	public String getP_lectureday() {
		return p_lectureday;
	}

	public void setP_lectureday(String p_lectureday) {
		this.p_lectureday = p_lectureday;
	}

	public String getP_lecturetime() {
		return p_lecturetime;
	}

	public void setP_lecturetime(String p_lecturetime) {
		this.p_lecturetime = p_lecturetime;
	}

	public String getP_lectureinfo() {
		return p_lectureinfo;
	}

	public void setP_lectureinfo(String p_lectureinfo) {
		this.p_lectureinfo = p_lectureinfo;
	}

	public String getP_teacherinfo() {
		return p_teacherinfo;
	}

	public void setP_teacherinfo(String p_teacherinfo) {
		this.p_teacherinfo = p_teacherinfo;
	}

	public String getP_otherinfo() {
		return p_otherinfo;
	}

	public void setP_otherinfo(String p_otherinfo) {
		this.p_otherinfo = p_otherinfo;
	}

	public String getP_totalSaleCount() {
		return p_totalSaleCount;
	}

	public void setP_totalSaleCount(String p_totalSaleCount) {
		this.p_totalSaleCount = p_totalSaleCount;
	}

	public String getP_postDate() {
		return p_postDate;
	}

	public void setP_postDate(String p_postDate) {
		this.p_postDate = p_postDate;
	}
}
