package repository.DTO;

public class NoticeBean {
	private int bno;
	private String mId;
	private String title;
	private String content;
	private String writeDate;
	
	public NoticeBean(int bno, String mId, String title, String content) {
		this.bno = bno;
		this.mId = mId;
		this.title = title;
		this.content = content;
	}
	
	public int getBno() {
		return bno;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	
}
