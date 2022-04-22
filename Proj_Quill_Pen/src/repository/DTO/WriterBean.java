package repository.DTO;

public class WriterBean {
	private String writer;
	private String title;
	private String content;
	private String fileName;
	private String fileOName;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOName() {
		return fileOName;
	}
	public void setFileOName(String fileOName) {
		this.fileOName = fileOName;
	}
	
}
