package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue
private int pid;
private String pname;
private float pprice;
private String pbrand;
private String pcolor;
private String pdesc;
private String category;
private String subCategory;

public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getSubCategory() {
	return subCategory;
}
public void setSubCategory(String subCategory) {
	this.subCategory = subCategory;
}

public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public float getPprice() {
	return pprice;
}
public void setPprice(float pprice) {
	this.pprice = pprice;
}
public String getPbrand() {
	return pbrand;
}
public void setPbrand(String pbrand) {
	this.pbrand = pbrand;
}
public String getPcolor() {
	return pcolor;
}
public void setPcolor(String pcolor) {
	this.pcolor = pcolor;
}
public String getPdesc() {
	return pdesc;
}
public void setPdesc(String pdesc) {
	this.pdesc = pdesc;
}

public Product() {
	super();
}
public Product(String pname, float pprice, String pbrand, String pcolor, String pdesc, String category,
		String subCategory) {
	super();
	
	this.pname = pname;
	this.pprice = pprice;
	this.pbrand = pbrand;
	this.pcolor = pcolor;
	this.pdesc = pdesc;
	this.category = category;
	this.subCategory = subCategory;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pbrand=" + pbrand + ", pcolor="
			+ pcolor + ", pdesc=" + pdesc + ", category=" + category + ", subCategory=" + subCategory + "]";
}


}

