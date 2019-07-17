package com.revature.Actor;


import com.revature.Entities.AccountDao;
import com.revature.Util.*;
import com.revature.Models.Account;

public class Customer extends Account {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	AccountDao accountdao = new AccountDao(connectionUtil.getConnection());
	public void Transfer(int Amount, String username, int account1, int account2) {
		
	}

	public void Deposit(int Amount, int AccountNumber) {
		
	}

	public void Withdrawl(int Amount, int AccountNumber) {
		
	}


}
