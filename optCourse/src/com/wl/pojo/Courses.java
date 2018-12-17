package com.wl.pojo;

public class Courses {
	private String couid;
	private String couname;
	private String teacher;
	private double credit;
	private String couexp;
	private String optCou;
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courses(String couid, String couname, String teacher, double credit,
			String couexp, String optCou) {
		super();
		this.couid = couid;
		this.couname = couname;
		this.teacher = teacher;
		this.credit = credit;
		this.couexp = couexp;
		this.optCou = optCou;
	}
	public String getCouid() {
		return couid;
	}
	public void setCouid(String couid) {
		this.couid = couid;
	}
	public String getCouname() {
		return couname;
	}
	public void setCouname(String couname) {
		this.couname = couname;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getCouexp() {
		return couexp;
	}
	public void setCouexp(String couexp) {
		this.couexp = couexp;
	}
	public String getOptCou() {
		return optCou;
	}
	public void setOptCou(String optCou) {
		this.optCou = optCou;
	}
	@Override
	public String toString() {
		return "Courses [couid=" + couid + ", couname=" + couname
				+ ", teacher=" + teacher + ", credit=" + credit + ", couexp="
				+ couexp + ", optCou=" + optCou + "]";
	}
	

}
