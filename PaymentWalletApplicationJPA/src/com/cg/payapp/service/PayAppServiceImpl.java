package com.cg.payapp.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.payapp.bean.Customer;
import com.cg.payapp.bean.Transaction;
import com.cg.payapp.dao.PayAppDao;
import com.cg.payapp.dao.PayAppDaoImpl;
import com.cg.payapp.exception.PayAppException;

public class PayAppServiceImpl implements PayAppService
{
	PayAppDao dao=new PayAppDaoImpl();
	
	@Override
	public void createAccount(Customer customer)
	{
		dao.createAccount(customer);

	}

	@Override
	public double showBalance(String mobileNo)
	{
			return dao.showBalance(mobileNo);
	}

	@Override
	public void deposit(String mobileNo, double amount)
	{
		dao.deposit(mobileNo, amount);

	}

	@Override
	public void withdraw(String mobileNo, double amount)
	{
		dao.withdraw(mobileNo, amount);

	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount)
	{
		dao.fundTransfer(sender, reciever, amount);

	}

	@Override
	public boolean validateAccount(String mobileNo) throws PayAppException
	{
		return dao.validateAccount(mobileNo);	
	
	}

	@Override
	public boolean validateName(String name) throws PayAppException
	{
		if(name == null)
			throw new PayAppException("Not found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{3,10}");
		Matcher m = p.matcher(name); 
		if(!m.matches())
			System.err.print("Name should start with capital alphabets");
		return m.matches();
	
		
	}

	@Override
	public boolean validateMobileNo(String mobileNo) throws PayAppException
	{
		try
		{
			if(mobileNo == null)
				throw new Exception("Not found");
			Pattern p = Pattern.compile("[6789][0-9]{9}");
			Matcher m = p.matcher(mobileNo);
			if(!m.matches())
				System.out.println("Mobile Number Invalid!"+
									"please enter 10 digit mobile number starting with [6789]");
			return m.matches();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean validateAmount(double amount) throws PayAppException
	{
		if(amount == 0)
			throw new PayAppException("Null value found");
		String am = String.valueOf(amount);
		if(!am.matches("\\d{3,9}\\.\\d{0,4}"))
			System.out.println("Invalid Amount!");
		return (am.matches("\\d{3,9}\\.\\d{0,4}"));
		
	}


	@Override
	public List<Transaction> getTranList(String mobileNo)
	{
		return dao.getTransList(mobileNo);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
