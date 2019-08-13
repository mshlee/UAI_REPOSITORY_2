package www.uai.com.vo;

public class ProductVO {

	private String p_idx;
	private String p_name;
	private String p_type;
	private int p_originalPrice;
	private double p_discountRate;
	private String p_totalSaleCount; 
	private String p_postDate;
	private double p_commisionRate;
	
	public ProductVO() {}

	public ProductVO(String p_idx, String p_name, String p_type, int p_originalPrice, double p_discountRate,
			String p_totalSaleCount, String p_postDate, double p_commisionRate) {
		super();
		this.p_idx = p_idx;
		this.p_name = p_name;
		this.p_type = p_type;
		this.p_originalPrice = p_originalPrice;
		this.p_discountRate = p_discountRate;
		this.p_totalSaleCount = p_totalSaleCount;
		this.p_postDate = p_postDate;
		this.p_commisionRate = p_commisionRate;
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

	public int getP_originalPrice() {
		return p_originalPrice;
	}

	public void setP_originalPrice(int p_originalPrice) {
		this.p_originalPrice = p_originalPrice;
	}

	public double getP_discountRate() {
		return p_discountRate;
	}

	public void setP_discountRate(double p_discountRate) {
		this.p_discountRate = p_discountRate;
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

	public double getP_commisionRate() {
		return p_commisionRate;
	}

	public void setP_commisionRate(double p_commisionRate) {
		this.p_commisionRate = p_commisionRate;
	}
	
}
