package com.sample.maven_junit_testing_examples;

public class BankAccount {
	private double balance;
	private double minimumBalance;
	private boolean isActive = true;
	private String holderName;
	
	public BankAccount(double balance, double minimumBalance) {
		this.balance = balance;
		this.minimumBalance = minimumBalance;
	}

	public double getBalance() {
		return balance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}
	
	public double withdraw(double amount) {
		if(balance - amount > minimumBalance) {
			balance -= amount;
			return amount;
		}
		else {
			throw new RuntimeException();
		}
	}
	
	public double deposit(double amount) {
		return balance += amount;
	}

	public boolean isActive() {
		return isActive;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String string) {
		holderName = string;
	}
		
}
