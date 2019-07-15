package com.revature;

public abstract class Account implements Transaction {

	int Balance;
	String accountType;
	boolean applicationStatus;
	
	public void setStatus(boolean status){
		this.applicationStatus = status;
	}
}
