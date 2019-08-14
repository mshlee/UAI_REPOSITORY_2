package www.uai.com.vo;

public class PageVO {

	private String nowPage;
	private int startOfPageGroup;
	private int endOfPageGroup;
	
	public PageVO(String nowPage, int startOfPageGroup, int endOfPageGroup) {
		super();
		this.nowPage = nowPage;
		this.startOfPageGroup = startOfPageGroup;
		this.endOfPageGroup = endOfPageGroup;
	}
	
	public String getNowPage() {
		return nowPage;
	}

	public void setNowPage(String nowPage) {
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
	
	public void calculatePageGroup(String nowPage, int maxPage, int limit, int pageGroupLimit ) {
		
		int startPage = (int)(Math.ceil((double)Integer.parseInt(nowPage)/pageGroupLimit));
		
		int endPage = startPage + (pageGroupLimit -1);                                                                       
		if(endPage > maxPage) {                                                                            
		    endPage = maxPage;                                          
		}
		
		this.startOfPageGroup = startPage;
		this.endOfPageGroup = endPage;
	}
	
}
