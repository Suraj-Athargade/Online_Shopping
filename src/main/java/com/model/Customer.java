package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int cid;
	private String cname;
	private String cemail;
	private String cpassword;
	private int cphno;
	private String caddress;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public int getCphno() {
		return cphno;
	}
	public void setCphno(int cphno) {
		this.cphno = cphno;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public Customer(String cname, String cemail, String cpassword, int cphno, String caddress) {
		super();
		this.cname = cname;
		this.cemail = cemail;
		this.cpassword = cpassword;
		this.cphno = cphno;
		this.caddress = caddress;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpassword=" + cpassword
				+ ", cphno=" + cphno + ", caddress=" + caddress + "]";
	}
	
}
