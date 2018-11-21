package com.cg.payapp.dao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.payapp.bean.Customer;
import com.cg.payapp.bean.Transaction;
import com.cg.payapp.exception.PayAppException;
import com.cg.payapp.util.JPAUtil;

public class PayAppDaoImpl implements PayAppDao
{
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	EntityTransaction tran=null;
	EntityManager em=null;
	public PayAppDaoImpl()
	{
		em=JPAUtil.getEntityManager();
	}
	
	
	@Override
	public void createAccount(Customer customer)
	{
		tran=em.getTransaction();
		tran.begin();
		
		Transaction t = new Transaction();
		t.setMobNo(customer.getCustMobileNo());
		t.setAmount(0);
		t.setTranType("credit");
		t.setBalance(customer.getInitialBalance());
		//Date date = new Date();
		//t.setTranDate(String.valueOf(dateFormat.format(date)));		
		em.persist(customer);			
		tran.commit();
		
	}

	@Override
	public double showBalance(String mobileNo)
	{
		/*tran=em.getTransaction();
		tran.begin();*/
		Customer cust =  em.find(Customer.class, mobileNo);
		double amount = cust.getInitialBalance();
		//tran.commit();
		return amount;
		
	}

	@Override
	public void deposit(String mobileNo, double amount)
	{
		tran=em.getTransaction();
		tran.begin();

		Customer cust =  em.find(Customer.class, mobileNo);
		double amt = cust.getInitialBalance();
		amt += amount;
		System.out.println(amt);
		cust.setInitialBalance(amt);
		
		tran.commit();
		passbookDeposit(cust,amount);
		System.out.println("Amount deposited successfully! New balance: "+amt);
	}

	@Override
	public void withdraw(String mobileNo, double withdrawAmount)
	{
		tran=em.getTransaction();
		tran.begin();
		boolean flag = false;
		Customer cust = em.find(Customer.class, mobileNo);
		double amount = cust.getInitialBalance();
		if(!(amount-withdrawAmount > 500)){
			System.err.println("Insufficient Balance.\nPlease try again");
			cust.setInitialBalance(amount);
		}
		else{
			amount -= withdrawAmount;
			cust.setInitialBalance(amount);
			System.out.println("Rs."+withdrawAmount+" withdrawl successfully");
			flag = true;			
		}
		tran.commit();

	}
	
	

	@Override
	public void fundTransfer(String sender, String receiver, double amount)
	{
		tran=em.getTransaction();
		tran.begin();
		boolean flag = false;
		Customer custSender = em.find(Customer.class, sender);
		Customer custreceiver = em.find(Customer.class, receiver);
		
		double senderAmount = custSender.getInitialBalance();
		double recieverAmount = custreceiver.getInitialBalance();
		
		if((senderAmount - amount) > 500){
			senderAmount -= amount;
			recieverAmount += amount;
			custreceiver.setInitialBalance(recieverAmount);
			custSender.setInitialBalance(senderAmount);
			flag = true;
			System.out.println("Fund of Rs."+amount+" transferred successfully! from "
					+custSender.getCustName()+" to "+custreceiver.getCustName());
			passbookFundTransfer(custSender, custreceiver, amount);
		}else{
			
			System.err.println("Invalid amount! As transfer amount is greater than your account balance.");
		}
		
		tran.commit();
	}
			

	@Override
	public boolean validateAccount(String mobileNo) throws PayAppException
	{
		Customer customer = em.find(Customer.class, mobileNo);
		if(customer == null)
			return false;
		return true;
	}


	@Override
	public void passbookDeposit(Customer customer, double amount)
	{
		Transaction t1= new Transaction();
		t1.setMobNo(customer.getCustMobileNo());
		t1.setBalance(customer.getInitialBalance());
		t1.setAmount(amount);
		/*Date date = new Date();
		t1.setTranDate(String.valueOf(dateFormat.format(date)));*/
		t1.setTranType("credit");
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();		
		
	}


	@Override
	public void passbookWithdraw(Customer customer, double amount)
	{
		Transaction t1= new Transaction();
		t1.setMobNo(customer.getCustMobileNo());
		t1.setBalance(customer.getInitialBalance());
		t1.setAmount(amount);
		/*Date date = new Date();
		t1.setTranDate(String.valueOf(dateFormat.format(date)));*/
		t1.setTranType("debit");
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();		
		
	}


	@Override
	public void passbookFundTransfer(Customer customer1, Customer customer2,double amount)
	{
		
		em.getTransaction().begin();
		Transaction t1= new Transaction();
		t1.setMobNo(customer1.getCustMobileNo());
		t1.setBalance(customer1.getInitialBalance());
		t1.setAmount(amount);
		/*Date date = new Date();
		t1.setTranDate(String.valueOf(dateFormat.format(date)));*/
		t1.setTranType("debit");
		em.persist(t1);
		
		
		Transaction t2= new Transaction();
		t2.setMobNo(customer2.getCustMobileNo());
		t2.setBalance(customer2.getInitialBalance());
		t2.setAmount(amount);
		/*Date date = new Date();
		t1.setTranDate(String.valueOf(dateFormat.format(date)));*/
		t1.setTranType("credit");
		em.persist(t2);		
		em.getTransaction().commit();	
	}


	@Override
	public List<Transaction> getTransList(String mobileNo) {
		String qr = "select trans from Transactions trans where mobileNo ="+mobileNo;
		TypedQuery<Transaction> query = em.createQuery(qr, Transaction.class);
		List<Transaction> list = query.getResultList();
		return list;
	}

	
	

}
