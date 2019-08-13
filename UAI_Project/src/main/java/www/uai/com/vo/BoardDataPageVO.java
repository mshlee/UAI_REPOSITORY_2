package www.uai.com.vo;

import java.util.ArrayList;
public class BoardDataPageVO {

	private PageVO pagevo;
	private ArrayList<BoardDataVO> dataList;
	
	public BoardDataPageVO() {}

	public BoardDataPageVO(PageVO pagevo, ArrayList<BoardDataVO> dataList) {
		super();
		this.pagevo = pagevo;
		this.dataList = dataList;
	}

	public PageVO getPagevo() {
		return pagevo;
	}

	public void setPagevo(PageVO pagevo) {
		this.pagevo = pagevo;
	}

	public ArrayList<BoardDataVO> getDataList() {
		return dataList;
	}

	public void setDataList(ArrayList<BoardDataVO> dataList) {
		this.dataList = dataList;
	}

}
