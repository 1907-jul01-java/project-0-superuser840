package com.revature.user;

import com.revature.Transaction;

public class Customer extends User implements Transaction{

	int accountNumber;
	
	
	@Override
	public int Transfer(int Amount, int TransferAccount) {
		// TODO Auto-generated method stub
		return 0;
	}	
	
	@Override
	public int Deposit(int Amount, int AccountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int Withdrawl(int Amount, int AccountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
