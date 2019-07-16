package com.revature.Actor;

import com.revature.Models.Account;

public class Admin extends Account implements Transaction{

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
		this.permission = 3;
	}


	public Admin(String username, String password, String name) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.permission = 3;
	}
	
	public void Deposit(int Amount, int AccountNumber) {
		
	}

	public void Transfer(int Amount, int Account1, int Account2) {
		
	}

	public void Transfer(int Amount, int TransferAccount) {
	
	}

	public void Withdrawl(int Amount, int AccountNumber) {
		
	}
	/*
	 * private void cancelAccount(int AccountNumber) { AccountDao.delete(); }
	 */

}
