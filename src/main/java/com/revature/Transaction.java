package com.revature;

public interface Transaction {
	
	int Deposit(int Amount, int AccountNumber);
	int Transfer(int Amount, int TransferAccount);
	//int Transfer(int Amount, int Account1, int Account2);
	int Withdrawl(int Amount, int AccountNumber);
	
}
