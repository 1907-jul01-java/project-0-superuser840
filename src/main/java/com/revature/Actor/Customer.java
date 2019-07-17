package com.revature.Actor;

import com.revature.Util.*;
import com.revature.Models.Account;
import com.revature.Entities.*;
import java.lang.Math.*;


public class Customer extends Account {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	CustomerDao customerDao = new CustomerDao(connectionUtil.getConnection());
	Account account = new Account();

	public void Transfer(double Amount, int accountNo1, int accountNo2) {
		Account account2 = new Account();
		double amount = Math.abs(Amount);
		account = customerDao.grabAccount(accountNo1);
		account2 = customerDao.grabAccount(accountNo2);
		account.balance -= amount;
		account2.balance += amount;
		customerDao.update(account);
		customerDao.update(account2);
		System.out.println(account.toString());
		System.out.println(account2.toString());
	}

	public void Deposit(double Amount, int AccountNo) {
		double amount = Math.abs(Amount);
		account = customerDao.grabAccount(AccountNo);
		account.balance += amount;
		customerDao.update(account);
		System.out.println(account.toString());
	}

	public void Withdrawl(double Amount, int AccountNo) {
		
		double amount = Math.abs(Amount);
		account = customerDao.grabAccount(AccountNo);
		if (account.balance-amount >=0){
			account.balance -= amount;
			customerDao.update(account);
			System.out.println(account.toString());
		}else{
			System.out.println("Operation would result in negative balance");
		}

	}


}
