package www.uai.com.vo;

public class PostnumVO {

	private int startPostNum, endPostNum;

	public PostnumVO(int startPostNum, int endPostNum) {
		super();
		this.startPostNum = startPostNum;
		this.endPostNum = endPostNum;
	}

	public int getStartPostNum() {
		return startPostNum;
	}

	public void setStartPostNum(int startPostNum) {
		this.startPostNum = startPostNum;
	}

	public int getEndPostNum() {
		return endPostNum;
	}

	public void setEndPostNum(int endPostNum) {
		this.endPostNum = endPostNum;
	}
	
}
