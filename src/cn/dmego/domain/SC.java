package cn.dmego.domain;

public class SC {
	private String Sno;
	private String Cno;
	private int Grade;
	private String XKLB;
	public SC(){}
	public SC(String Sno,String Cno,int Grade,String XKLB){
		this.Sno = Sno;
		this.Cno = Cno;
		this.Grade = Grade;
		this.XKLB = XKLB;
	}
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public String getXKLB() {
		return XKLB;
	}
	public void setXKLB(String xKLB) {
		XKLB = xKLB;
	}
	
}
