package www.uai.com.vo;

public class AdvancedSearchDataVO {
	
	//lhe-상품 상세검색용
	private String p_type;
	private String startDate;
	private String endDate;
	private String minPrice;
	private String maxPrice;
	private String keyword;
	private String value;
	private String radiobox;
	private String radioboxValue;
	private String checkbox;
	private String checkboxValue;
	
	public AdvancedSearchDataVO() {
		
	}

	public AdvancedSearchDataVO(String p_type, String startDate, String endDate, String minPrice, String maxPrice,
			String keyword, String value, String radiobox, String radioboxValue, String checkbox,
			String checkboxValue) {
		super();
		this.p_type = p_type;
		this.startDate = startDate;
		this.endDate = endDate;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.keyword = keyword;
		this.value = value;
		this.radiobox = radiobox;
		this.radioboxValue = radioboxValue;
		this.checkbox = checkbox;
		this.checkboxValue = checkboxValue;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRadiobox() {
		return radiobox;
	}

	public void setRadiobox(String radiobox) {
		this.radiobox = radiobox;
	}

	public String getRadioboxValue() {
		return radioboxValue;
	}

	public void setRadioboxValue(String radioboxValue) {
		this.radioboxValue = radioboxValue;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getCheckboxValue() {
		return checkboxValue;
	}

	public void setCheckboxValue(String checkboxValue) {
		this.checkboxValue = checkboxValue;
	}
	
	

}
