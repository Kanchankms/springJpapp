package com.cg.payapp.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction
{
	@Id					
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tranId;
	private String mobNo;
	private String tranType;
	private double amount;
	private double balance;
	private Date tranDate;
	
	
	public Transaction()						//default constructor
	{										
		super();
	}
	
	public Transaction(String mobNo, String tranType,double amount)
	{
		super();
		this.mobNo = mobNo;
		this.tranType = tranType;				//parameterised constructor
		this.amount = amount;
		this.tranDate = new Date();
	}
	
	
	//generating getters and setters for all
	
	public Integer getTranId() {
		return tranId;
	}
	public void setTranId(Integer tranId) {
		this.tranId = tranId;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Transaction [tranId=" + tranId + ", mobNo=" + mobNo
				+ ", tranType=" + tranType + ", amount=" + amount
				+ ", tranDate=" + tranDate + "]";
	}
	
	
	
	
	
	
}
