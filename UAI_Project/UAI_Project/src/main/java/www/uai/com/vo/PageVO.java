package www.uai.com.vo;

public class PageVO {

	private int nowPage;
	private int startOfPageGroup;
	private int endOfPageGroup;
	
	public PageVO(int nowPage, int startOfPageGroup, int endOfPageGroup) {
		super();
		this.nowPage = nowPage;
		this.startOfPageGroup = startOfPageGroup;
		this.endOfPageGroup = endOfPageGroup;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartOfPageGroup() {
		return startOfPageGroup;
	}

	public void setStartOfPageGroup(int startOfPageGroup) {
		this.startOfPageGroup = startOfPageGroup;
	}

	public int getEndOfPageGroup() {
		return endOfPageGroup;
	}

	public void setEndOfPageGroup(int endOfPageGroup) {
		this.endOfPageGroup = endOfPageGroup;
	}
	
}
