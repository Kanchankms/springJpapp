package com.cg.payapp.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer
{
	@Column(name="customer_Name",length=30)
	private String custName;
	
	@Id					//mobile no. as a primary key
	@Column(name="customer_MobNo",length=15)
	private String custMobileNo;
	
	@Column(name="customer_initialBalance",length=30)
	private double initialBalance;
	
	public Customer()
	{
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custMobileNo="
				+ custMobileNo + ", initialBalance=" + initialBalance + "]";
	}



	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustMobileNo() {
		return custMobileNo;
	}
	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}
	public double getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}
	
	
}
