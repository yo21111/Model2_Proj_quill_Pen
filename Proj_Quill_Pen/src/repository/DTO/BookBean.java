package repository.DTO;

public class BookBean {
	private int bookNo;
	private String writer;
	private String fileName;
	private String fileOName;
	private String title;
	private String subTitle;
	private String imageName;
	private String imageOName;
	private String category;
	private String link;

	// 생성자 작성도 고려해야 할 듯
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageOName() {
		return imageOName;
	}
	public void setImageOName(String imageOName) {
		this.imageOName = imageOName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
}
