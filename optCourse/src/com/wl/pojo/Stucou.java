package com.wl.pojo;

public class Stucou {
    private String stuid;
    private String couid;
	public Stucou() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stucou(String stuid, String couid) {
		super();
		this.stuid = stuid;
		this.couid = couid;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getCouid() {
		return couid;
	}
	public void setCouid(String couid) {
		this.couid = couid;
	}
	@Override
	public String toString() {
		return "Stucou [stuid=" + stuid + ", couid=" + couid + "]";
	}
}
