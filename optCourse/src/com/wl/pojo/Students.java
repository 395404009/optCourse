package com.wl.pojo;

public class Students {
	private String stuid;
	private String stuname;
	private String stupwd;
	private String stusex;
	private String stuinstitute;
	private String login;
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Students(String stuid, String stuname, String stupwd, String stusex,
			String stuinstitute, String login) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.stupwd = stupwd;
		this.stusex = stusex;
		this.stuinstitute = stuinstitute;
		this.login = login;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStupwd() {
		return stupwd;
	}
	public void setStupwd(String stupwd) {
		this.stupwd = stupwd;
	}
	public String getStusex() {
		return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStuinstitute() {
		return stuinstitute;
	}
	public void setStuinstitute(String stuinstitute) {
		this.stuinstitute = stuinstitute;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "Students [stuid=" + stuid + ", stuname=" + stuname
				+ ", stupwd=" + stupwd + ", stusex=" + stusex
				+ ", stuinstitute=" + stuinstitute + ", login=" + login + "]";
	}
	

}
