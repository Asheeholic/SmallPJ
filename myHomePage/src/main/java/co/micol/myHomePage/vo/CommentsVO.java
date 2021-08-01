package co.micol.myHomePage.vo;

public class CommentsVO {
	private int sNo;
	private int cNo;
	private String cName;
	private String cSubject;
	private String cDate;

	public CommentsVO() {
		super();
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public int getcNo() {
		return cNo;
	}

	public void setcNo(int cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcSubject() {
		return cSubject;
	}

	public void setcSubject(String cSubject) {
		this.cSubject = cSubject;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

}
