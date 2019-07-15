package com.revature.Actor;

public interface Transaction {
	
	public int Deposit(int Amount, int AccountNumber);
	public int Transfer(int Amount, int TransferAccount);
	//int Transfer(int Amount, int Account1, int Account2);
	public int Withdrawl(int Amount, int AccountNumber);
	
}
