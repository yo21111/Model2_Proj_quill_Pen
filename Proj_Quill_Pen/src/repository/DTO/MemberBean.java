package repository.DTO;

public class MemberBean {
	private String uId;
	private String uPw;
	private String uName;
	private String uEmail;
	private String writer;
	private String uBirth;
	private String uPhone;
	private String regDate;
	private String grade;
	
	public MemberBean() {}
	
	public MemberBean(String uId, String writer, String uPw, String uName, String uEmail, String uBirth, String uPhone) {
		this.uId = uId;
		this.writer = writer;
		this.uPw = uPw;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uBirth = uBirth;
		this.uPhone = uPhone;
	}
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPw() {
		return uPw;
	}
	public void setuPw(String uPw) {
		this.uPw = uPw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getuBirth() {
		return uBirth;
	}
	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
