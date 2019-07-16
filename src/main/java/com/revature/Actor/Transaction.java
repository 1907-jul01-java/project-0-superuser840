package com.revature.Actor;

public interface Transaction {
	
	public void Deposit(int Amount, int AccountNumber);
	public void Transfer(int Amount, int TransferAccount);
	//int Transfer(int Amount, int Account1, int Account2);
	public void Withdrawl(int Amount, int AccountNumber);
	
}
