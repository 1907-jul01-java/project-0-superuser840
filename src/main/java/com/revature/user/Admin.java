package com.revature.user;

import com.revature.Transaction;

public class Admin extends User implements Transaction{
	private String username;
	private String password;
	private String firstName;
	private String lastName;

	public Admin(String username, String password, String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	@Override
	public int Deposit(int Amount, int AccountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int Transfer(int Amount, int Account1, int Account2) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int Transfer(int Amount, int TransferAccount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Withdrawl(int Amount, int AccountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void cancelAccount(int AccountNumber) {
		
	}
	
}
