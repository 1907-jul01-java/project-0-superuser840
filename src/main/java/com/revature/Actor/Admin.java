package com.revature.Actor;

import com.revature.Models.Account;

public class Admin extends Account {

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

	public void Deposit(int Amount, Account account) {
		// TODO Auto-generated method stub
	
	}

	public int Transfer(int Amount, int Account1, int Account2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Transfer(int Amount, int TransferAccount) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int Withdrawl(int Amount, int AccountNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
	/*
	 * private void cancelAccount(int AccountNumber) { AccountDao.delete(); }
	 */

}
