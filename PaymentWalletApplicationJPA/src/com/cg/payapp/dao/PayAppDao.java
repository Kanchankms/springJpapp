package com.cg.payapp.dao;

import java.util.List;

import com.cg.payapp.bean.Customer;
import com.cg.payapp.bean.Transaction;
import com.cg.payapp.exception.PayAppException;

public interface PayAppDao
{
	public void createAccount(Customer customer);

	public double showBalance(String mobileNo);
	
	public void deposit(String mobileNo, double amount);
	
	public void withdraw(String mobileNo, double amount);
		
	public void fundTransfer(String sender, String reciever, double amount);
	
	public boolean validateAccount(String mobileNo) throws PayAppException;
	
	public void passbookDeposit(Customer customer, double amount);

	void passbookWithdraw(Customer customer, double amount);

	void passbookFundTransfer(Customer customer1, Customer customer2, double amount);

	public List<Transaction> getTransList(String mobileNo);


}
