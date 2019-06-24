package main.sample;

import org.junit.jupiter.api.DisplayName;

@DisplayName("<= Account class Specification =>")
public class Account {

	private double balance;
	private int accountNumber;
	private static int nextAccountNumber = 1;

	public Account(double initialBalance) {
		this.balance = initialBalance;
		accountNumber = nextAccountNumber;
		nextAccountNumber += 1;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

//	public void setAccountNumber(int accountNumber) {
//		this.accountNumber = accountNumber;
//	}
	
	public void deposit(double depositAmount) {
		this.balance += depositAmount;
	}

	public void withdraw(double withdrawAmount) throws Exception {
		// Throw an exception if balance would drop below 0
		if (this.balance - withdrawAmount < 0) {
			throw new IllegalArgumentException( "No negative balance allowed!" );
		} else {
			this.balance -= withdrawAmount;
		}
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
