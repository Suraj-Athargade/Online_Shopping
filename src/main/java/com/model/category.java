package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class category {
	@Id
	@GeneratedValue
	private int caid;
private String caname;
private float caprice;
private String cabrand;
public int getCaid() {
	return caid;
}
public void setCaid(int caid) {
	this.caid = caid;
}
public String getCaname() {
	return caname;
}
public void setCaname(String caname) {
	this.caname = caname;
}
public float getCaprice() {
	return caprice;
}
public void setCaprice(float caprice) {
	this.caprice = caprice;
}
public String getCabrand() {
	return cabrand;
}
public void setCabrand(String cabrand) {
	this.cabrand = cabrand;
}
public category(String caname, float caprice, String cabrand) {
	super();
	this.caname = caname;
	this.caprice = caprice;
	this.cabrand = cabrand;
}
public category() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "category [caid=" + caid + ", caname=" + caname + ", caprice=" + caprice + ", cabrand=" + cabrand + "]";
}


}
