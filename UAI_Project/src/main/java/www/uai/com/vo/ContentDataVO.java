package www.uai.com.vo;
/*B_IDX PRIMARY KEY,
B_REFERIDX NUMBER(8),       --@@@@@@@@@@@@@@@@@@@@@@@@@@@@ 이름만 변경하였습니다
B_TYPE NUMBER(8),       --B_Type: 0-공지사항, 1-리뷰, 2-qna
B_TITLE VARCHAR2(100),
B_CONTENT VARCHAR2(1000),
B_POSTDATE DATE,
B_COUNT NUMBER(8),
B_ISHIDDEN NUMBER(8),   --ishidden: 0-no(공개글이다), 1-yes(비밀글이다)
B_PW VARCHAR2(40),
B_QCATEGORY NUMBER(8),  --qcategoty: 0-상품문의, 1-결제문의
B_ISPOST NUMBER(8),     --ispost: 0-no(댓글이다), 1-yes(글이다)
M_IDX NUMBER(8),
P_IDX NUMBER(8),
AD_IDX NUMBER(8)
);*/
public class ContentDataVO {

	private String b_idx;
	private String b_referIdx;
	private String b_type;
	private String b_title;
	private String b_content;
	private String b_postdate;
	private String b_count;
	private String b_isHidden;
	private String b_pw;
	private String b_qCategory;
	private String b_isPost;
	private String m_idx;
	private String p_idx;
	private String ad_idx;
	private String m_id;
	private String p_name;
	
	public ContentDataVO() {
		super();
	}
	

	public ContentDataVO(String b_idx, String b_referIdx, String b_type, String b_title, String b_content,
			String b_postdate, String b_count, String b_isHidden, String b_pw, String b_qCategory, String b_isPost,
			String m_idx, String p_idx, String ad_idx, String m_id, String p_name) {
		super();
		this.b_idx = b_idx;
		this.b_referIdx = b_referIdx;
		this.b_type = b_type;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_postdate = b_postdate;
		this.b_count = b_count;
		this.b_isHidden = b_isHidden;
		this.b_pw = b_pw;
		this.b_qCategory = b_qCategory;
		this.b_isPost = b_isPost;
		this.m_idx = m_idx;
		this.p_idx = p_idx;
		this.ad_idx = ad_idx;
		this.m_id = m_id;
		this.p_name = p_name;
	}

	public String getB_idx() {
		return b_idx;
	}

	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}

	public String getB_referIdx() {
		return b_referIdx;
	}

	public void setB_referIdx(String b_referIdx) {
		this.b_referIdx = b_referIdx;
	}

	public String getB_type() {
		return b_type;
	}

	public void setB_type(String b_type) {
		this.b_type = b_type;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_postdate() {
		return b_postdate;
	}

	public void setB_postdate(String b_postdate) {
		this.b_postdate = b_postdate;
	}

	public String getB_count() {
		return b_count;
	}

	public void setB_count(String b_count) {
		this.b_count = b_count;
	}

	public String getB_isHidden() {
		return b_isHidden;
	}

	public void setB_isHidden(String b_isHidden) {
		this.b_isHidden = b_isHidden;
	}

	public String getB_pw() {
		return b_pw;
	}

	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}

	public String getB_qCategory() {
		return b_qCategory;
	}

	public void setB_qCategory(String b_qCategory) {
		this.b_qCategory = b_qCategory;
	}

	public String getB_isPost() {
		return b_isPost;
	}

	public void setB_isPost(String b_isPost) {
		this.b_isPost = b_isPost;
	}

	public String getM_idx() {
		return m_idx;
	}

	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}

	public String getP_idx() {
		return p_idx;
	}

	public void setP_idx(String p_idx) {
		this.p_idx = p_idx;
	}

	public String getAd_idx() {
		return ad_idx;
	}

	public void setAd_idx(String ad_idx) {
		this.ad_idx = ad_idx;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	
	
}