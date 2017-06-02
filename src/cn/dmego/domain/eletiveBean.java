package cn.dmego.domain;

public class eletiveBean {
	private String Sno;
	private String Sname;
	private String Sdept;
	private int Grade;
	public eletiveBean(){}
	public eletiveBean(String Sno,String Sname,String Sdept,int Grade){
		this.Sno = Sno;
		this.Sname = Sname;
		this.Sdept = Sdept;
		this.Grade = Grade;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getSdept() {
		return Sdept;
	}
	public void setSdept(String sdept) {
		Sdept = sdept;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	
}
