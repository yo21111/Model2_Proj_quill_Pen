package repository.DTO;

public class CmntBean {
	private int cno;
	private int bno;
	private int cOrder;
	private String writer;
	private String content;
	private String writeDate;
	private String modifyDate;
	
	
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getcOrder() {
		return cOrder;
	}
	public void setcOrder(int cOrder) {
		this.cOrder = cOrder;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBno() {
		return bno;
	}
	public String getWriteDate() {
		return writeDate;
	}
	
	
}
