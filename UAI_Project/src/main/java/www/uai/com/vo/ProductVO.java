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
   private String p_starRate;
   
   public ProductVO() {
      
   }

public ProductVO(String p_idx, String p_name, String p_type, String p_originalPrice, String p_nowPrice,
      String p_teacher, String p_maxStudent, String p_startDate, String p_lastDate, String p_location,
      String p_lectureDay, String p_lectureTime, String p_lectureInfo, String p_teacherInfo, String p_otherInfo,
      String p_totalSaleCount, String p_postDate, String p_starRate) {
   super();
   this.p_idx = p_idx;
   this.p_name = p_name;
   this.p_type = p_type;
   this.p_originalPrice = p_originalPrice;
   this.p_nowPrice = p_nowPrice;
   this.p_teacher = p_teacher;
   this.p_maxStudent = p_maxStudent;
   this.p_startDate = p_startDate;
   this.p_lastDate = p_lastDate;
   this.p_location = p_location;
   this.p_lectureDay = p_lectureDay;
   this.p_lectureTime = p_lectureTime;
   this.p_lectureInfo = p_lectureInfo;
   this.p_teacherInfo = p_teacherInfo;
   this.p_otherInfo = p_otherInfo;
   this.p_totalSaleCount = p_totalSaleCount;
   this.p_postDate = p_postDate;
   this.p_starRate = p_starRate;
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

public String getP_maxStudent() {
   return p_maxStudent;
}

public void setP_maxStudent(String p_maxStudent) {
   this.p_maxStudent = p_maxStudent;
}

public String getP_startDate() {
   return p_startDate;
}

public void setP_startDate(String p_startDate) {
   this.p_startDate = p_startDate;
}

public String getP_lastDate() {
   return p_lastDate;
}

public void setP_lastDate(String p_lastDate) {
   this.p_lastDate = p_lastDate;
}

public String getP_location() {
   return p_location;
}

public void setP_location(String p_location) {
   this.p_location = p_location;
}

public String getP_lectureDay() {
   return p_lectureDay;
}

public void setP_lectureDay(String p_lectureDay) {
   this.p_lectureDay = p_lectureDay;
}

public String getP_lectureTime() {
   return p_lectureTime;
}

public void setP_lectureTime(String p_lectureTime) {
   this.p_lectureTime = p_lectureTime;
}

public String getP_lectureInfo() {
   return p_lectureInfo;
}

public void setP_lectureInfo(String p_lectureInfo) {
   this.p_lectureInfo = p_lectureInfo;
}

public String getP_teacherInfo() {
   return p_teacherInfo;
}

public void setP_teacherInfo(String p_teacherInfo) {
   this.p_teacherInfo = p_teacherInfo;
}

public String getP_otherInfo() {
   return p_otherInfo;
}

public void setP_otherInfo(String p_otherInfo) {
   this.p_otherInfo = p_otherInfo;
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

public String getP_starRate() {
   return p_starRate;
}

public void setP_starRate(String p_starRate) {
   this.p_starRate = p_starRate;
}

   
}