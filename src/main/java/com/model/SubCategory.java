package com.model;

public class SubCategory {
	private int scaid;
	private String scaname;
	private float scaprice;
	private String scacolor;
	public int getScaid() {
		return scaid;
	}
	public void setScaid(int scaid) {
		this.scaid = scaid;
	}
	public String getScaname() {
		return scaname;
	}
	public void setScaname(String scaname) {
		this.scaname = scaname;
	}
	public float getScaprice() {
		return scaprice;
	}
	public void setScaprice(float scaprice) {
		this.scaprice = scaprice;
	}
	public String getScacolor() {
		return scacolor;
	}
	public void setScacolor(String scacolor) {
		this.scacolor = scacolor;
	}
	public SubCategory(String scaname, float scaprice, String scacolor) {
		super();
		this.scaname = scaname;
		this.scaprice = scaprice;
		this.scacolor = scacolor;
	}
	public SubCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SubCategory [scaid=" + scaid + ", scaname=" + scaname + ", scaprice=" + scaprice + ", scacolor="
				+ scacolor + "]";
	}
	
}
