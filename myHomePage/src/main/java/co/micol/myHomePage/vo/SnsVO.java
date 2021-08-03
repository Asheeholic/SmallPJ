package co.micol.myHomePage.vo;

import java.sql.Date;

public class SnsVO extends CommentsVO{
	private int sNo;
	private String sWriter;
	private Date sDate;
	private String sTitle;
	private String sContents;
	private int sAno;
	private String id;
	private String id1; // 다른 아이디를 가져오기 위한 수단. 고쳐야함.

	public SnsVO() {
		super();
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getsWriter() {
		return sWriter;
	}

	public void setsWriter(String sWriter) {
		this.sWriter = sWriter;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public String getsTitle() {
		return sTitle;
	}

	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}

	public String getsContents() {
		return sContents;
	}

	public void setsContents(String sContents) {
		this.sContents = sContents;
	}

	public int getsAno() {
		return sAno;
	}

	public void setsAno(int sAno) {
		this.sAno = sAno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}
	
	

}
