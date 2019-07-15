package com.revature.Models;

public class Account extends User{

	public int balance;
	public String accountType;
	public int accountNumber;

	public void setBalance(int amount){
		this.balance = amount;
	}
	public int getBalance(){
		return this.balance;
	}



}
