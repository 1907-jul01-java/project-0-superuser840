package com.revature.Models;

public class Account extends User{

	public int balance;
	public int accountType;
	public int accountNumber;
	public boolean approved = false;
	public String accountOwner;

	public void setBalance(int amount){
		this.balance = amount;
	}
	public int getBalance(){
		return this.balance;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountOwner=" + accountOwner + ", accountType="
				+ accountType + ", approved=" + approved + ", balance=" + balance + "]";
	}

}
