package com.revature.Actor;

import com.revature.Util.*;
import com.revature.Models.Account;
import com.revature.Entities.*;
import java.lang.Math.*;


public class Customer extends Account {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	CustomerDao customerDao = new CustomerDao(connectionUtil.getConnection());
	Account account = new Account();

	public void Transfer(int Amount, String username, int accountNo1, int accountNo2) {
		Account account2 = new Account();
		int amount = Math.abs(Amount);
		account = customerDao.grabAccount(accountNo1);
		account2 = customerDao.grabAccount(accountNo2);
		account.balance -= amount;
		account2.balance += amount;
		//update account 1
		//update account2
	}

	public void Deposit(int Amount, int AccountNumber) {
		int amount = Math.abs(Amount);
		account.balance += amount;
		//update account
	}

	public void Withdrawl(int Amount, int AccountNo) {
		
		int amount = Math.abs(Amount);
		account = customerDao.grabAccount(AccountNo);
		if (account.balance-amount >=0){
			//Update account
		}else{
			System.out.println("Operation would result in negative balance");
		}

	}


}
