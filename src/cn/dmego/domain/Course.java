package cn.dmego.domain;

public class Course {
	private String Cno;
	private String Cname;
	private int Ccredit;
	private int Semester;
	public Course(){}
	public Course(String Cno,String Cname,int Ccredit,int Semester){
		this.Cno = Cno;
		this.Cname = Cname;
		this.Ccredit = Ccredit;
		this.Semester = Semester;
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
	
}
