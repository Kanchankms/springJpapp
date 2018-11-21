package com.cg.payapp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.payapp.bean.Customer;
import com.cg.payapp.bean.Transaction;
import com.cg.payapp.exception.PayAppException;
import com.cg.payapp.service.PayAppService;
import com.cg.payapp.service.PayAppServiceImpl;

public class PayAppMain {

	public static void main(String[] args) throws PayAppException
	{
		PayAppServiceImpl service=new PayAppServiceImpl();
		

		String name,mobileNo;
		double amount;
		int ch = 0;
		while(ch != 6)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add Customer\n2.Deposit amount\n3.Withdraw Amount\n4.Fund transfer\n5.Show balance\n6.Print Transactions\n7.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			Customer customer;
			switch(ch){
			case 1 :
				customer = new Customer();						

				do{
					System.out.println("Enter customer name : ");
					name = sc.next();
					if(!service.validateName(name))
						System.err.println("Invalid Name!");
					else
						break;
				}while(true);
				do{
					System.out.println("Enter mobile no. : ");
					mobileNo = sc.next();
					if(!service.validateMobileNo(mobileNo))
						System.err.println("Invalid Mobile Number");
					else if(service.validateAccount(mobileNo))
						System.err.println("Account already exist with this number!");
					else
						break;								
				}while(true);

				do{
					System.out.println("Enter initial amount : ");
					amount = sc.nextDouble();
					if(!service.validateAmount(amount))
						System.err.println("Invalid Amount!");
					else
						break;							
				}while(true);



				customer.setCustName(name);
				customer.setCustMobileNo(mobileNo);
				customer.setInitialBalance(amount);

				service.createAccount(customer);

				System.out.println("Customer added successfully");

				break;

			case 2 :
				do{
					System.out.println("Enter your mobile number : ");
					mobileNo = sc.next();

					System.out.println("Enter the amount you want to deposit");
					amount = sc.nextDouble();
					if(service.validateMobileNo(mobileNo)&& service.validateAmount(amount)){
						if(service.validateAccount(mobileNo))
							break;
					}
				}while(true);

				service.deposit(mobileNo, amount);

				break;

			case 3 :
				do{
					System.out.println("Enter your mobile number : ");
					mobileNo = sc.next();

					System.out.println("Enter the amount you want to withdraw : ");
					amount = sc.nextDouble();
					if(service.validateMobileNo(mobileNo) && service.validateAmount(amount)){
						if(service.validateAccount(mobileNo))
							break;
					}
				}while(true);

				service.withdraw(mobileNo, amount);

				break;

			case 4 :
				String mobileNoReciever;
				do{
					System.out.println("Enter your mobile number : ");
					mobileNo = sc.next();

					System.out.println("Enter the amount you want to transfer : ");
					amount = sc.nextDouble();

					System.out.println("Enter receivers mobile number : ");
					mobileNoReciever = sc.next();
					if(mobileNo.equals(mobileNoReciever)){								
						System.out.println("Both numbers are same!");
						continue;
					}
					if(service.validateMobileNo(mobileNo) && service.validateMobileNo(mobileNoReciever) && service.validateAmount(amount)){
						if(service.validateAccount(mobileNoReciever) && service.validateAccount(mobileNo))
							break;
					}
				}while(true);
				service.fundTransfer(mobileNo, mobileNoReciever, amount);

				break;

			case 5 :
				do{
					System.out.println("Enter the moible no. to check balance");
					mobileNo = sc.next();
					if(service.validateAccount(mobileNo)){
						System.out.println("Mobile Number found!");
						if(service.validateMobileNo(mobileNo))									
							break;
					}
				}while(!(service.validateMobileNo(mobileNo)));

				System.out.println("Current Amount is Rs."+service.showBalance(mobileNo));

				break;
			case 6:				
				do{
					System.out.println("Enter the moible no. to print transactions");
					mobileNo = sc.next();
					if(service.validateMobileNo(mobileNo)){
						if(service.validateAccount(mobileNo))
							break;
						else
							System.out.println("Cannot find account linked to: "+ mobileNo);	
					}
				}while(true);
				List<Transaction> list = new ArrayList<Transaction>();
				PayAppService s = new PayAppServiceImpl();
				list = s.getTranList(mobileNo);
				System.out.println("MobileNo 	Credit/Debit 	Amount 		Balance");
				for(Transaction t : list){
					System.out.println(t.getMobNo()+"	  "+t.getTranType()+"		 "+t.getAmount()+"		"+t.getBalance());
				}
				break;
				
				
			case 7 :
				
				System.out.println("EXIT");
				break;
			default : System.out.println("Invalid input!");
			}

		}

	}

}
