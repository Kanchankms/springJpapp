package com.cg.payapp.service;

import java.util.List;

import com.cg.payapp.bean.Customer;
import com.cg.payapp.bean.Transaction;
import com.cg.payapp.exception.PayAppException;

public interface PayAppService
{
	public void createAccount(Customer customer);

	public double showBalance(String mobileNo);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
		
	public void fundTransfer(String sender, String reciever, double amount);
	
	public boolean validateAccount(String mobileNo) throws PayAppException;
	
	public boolean validateName(String name) throws PayAppException;
	
	public boolean validateMobileNo(String mobileNo) throws PayAppException;
	
	public boolean validateAmount(double amount) throws PayAppException;
	
	public List<Transaction> getTranList(String mobileNo);

	
			

}
