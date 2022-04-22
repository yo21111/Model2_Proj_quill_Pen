package repository.DTO;

public class DeclBean {
	private int dno;
	private String category;
	private String content;
	private String writer;
	private String writeDate;
	private int bno;
	
	public int getDno() {
		return dno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getWriteDate() {
		return writeDate;
	}
	
}
