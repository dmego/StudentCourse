package cn.dmego.domain;

public class studyBean {
	private String Cno;
	private String Cname;
	private int Ccredit;
	private int Semester;
	private int Grade;
	public studyBean(){}
	public studyBean(String Cno,String Cname,int Ccredit,int Semester,int Grade){
		this.Cno = Cno;
		this.Cname = Cname;
		this.Ccredit = Semester;
		this.Grade = Grade;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public int getCcredit() {
		return Ccredit;
	}
	public void setCcredit(int ccredit) {
		Ccredit = ccredit;
	}
	public int getSemester() {
		return Semester;
	}
	public void setSemester(int semester) {
		Semester = semester;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	
}
