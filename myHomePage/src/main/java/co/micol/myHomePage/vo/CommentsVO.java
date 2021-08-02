package co.micol.myHomePage.vo;

import java.sql.Date;

public class CommentsVO {
	private int sNo;
	private int cNo;
	private String cName;
	private String cSubject;
	private Date cDate;
	private String id;

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

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
