package com.hickory.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Column(name="pid")
	@Id
	private int pid;
	@Column(name="pname")
	private String pName;
	@Column(name="pdescription")
	private String pDescription;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
		
		
	}
	public Product() {};
	public Product(int pid, String pName, String pDescription) {
		
		this.pid = pid;
		this.pName = pName;
		this.pDescription = pDescription;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", pDescription=" + pDescription + "]";
	}
	
	
	
	
	

}
