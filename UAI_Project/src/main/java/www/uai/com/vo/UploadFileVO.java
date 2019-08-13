package www.uai.com.vo;

public class UploadFileVO {
	private String f_idx;
	private String b_idx;
	private String f_path;
	private String f_originalName;
	
	public UploadFileVO() {
		
	}
	
	public UploadFileVO(String f_idx, String b_idx, String f_path, String f_originalName) {
		super();
		this.f_idx = f_idx;
		this.b_idx = b_idx;
		this.f_path = f_path;
		this.f_originalName = f_originalName;
	}


	public String getF_idx() {
		return f_idx;
	}


	public void setF_idx(String f_idx) {
		this.f_idx = f_idx;
	}


	public String getB_idx() {
		return b_idx;
	}


	public void setB_idx(String b_idx) {
		this.b_idx = b_idx;
	}


	public String getF_path() {
		return f_path;
	}


	public void setF_path(String f_path) {
		this.f_path = f_path;
	}


	public String getF_originalName() {
		return f_originalName;
	}


	public void setF_originalName(String f_originalName) {
		this.f_originalName = f_originalName;
	}
	
	
}
