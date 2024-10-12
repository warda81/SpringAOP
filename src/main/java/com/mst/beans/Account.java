package com.mst.beans;

import org.springframework.stereotype.Component;

//@Component
public class Account {

	private String accNumber;
	private double balance;
	

	public Account(String accNumber, double balance) {
		super();
		this.accNumber = accNumber;
		this.balance = balance;
	}
	
	public String getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) throws Exception {
		if(amount>0) {
			balance+=amount;
			System.out.println("Deposited: "+amount);
		}else {
			System.out.println("Invalid deposit amount");
			throw new Exception ("MST exception!!!");
		}
	}
	
	public void withdraw(double amount) {
		if((amount>0) && (amount<=balance)) {
			balance+=amount;
			System.out.println("Withdrown: "+amount);
		}else {
			System.out.println("Invalid withdraw amount");
		}
	}
	
}
