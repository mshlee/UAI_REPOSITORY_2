package www.uai.com.vo;

public class PageVO {
	
	private int nowPage;
	private int startOfPageGroup;
	private int maxPage;
	private int endPage;
	private int limit;
	
	public PageVO(int nowPage, int startOfPageGroup, int maxPage, int endPage, int limit) {
		super();
		this.nowPage = nowPage;
		this.startOfPageGroup = startOfPageGroup;
		this.maxPage = maxPage;
		this.endPage = endPage;
		this.limit = limit;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStartOfPageGroup() {
		return startOfPageGroup;
	}

	public void setStartOfPageGroup(int startOfPageGroup) {
		this.startOfPageGroup = startOfPageGroup;
	}
	
}
