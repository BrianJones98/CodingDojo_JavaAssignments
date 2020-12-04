package com.brian.bankaccount;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	public static int numberOfAccounts = 0;
	public static double totalOfAllAccounts = 0;
	
	private String generateAccountNumber() {
		Random rand = new Random();
		String numList = "1234567890";
		String number = "";
		for(int i = 0; i < 10; i++) {
			number += numList.charAt(rand.nextInt(numList.length()));
		}
		
		return number;
	}
	//Constructors
	public BankAccount() {
		accountNumber = generateAccountNumber();
		checkingBalance = 0.0;
		savingsBalance = 0.0;
		numberOfAccounts++;
	}
	public BankAccount(double checkingBalance) {
		accountNumber = generateAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = 0.0;
		numberOfAccounts++;
		totalOfAllAccounts += checkingBalance;
	}
	public BankAccount(double checkingBalance, double savingsBalance) {
		accountNumber = generateAccountNumber();
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		numberOfAccounts++;
		totalOfAllAccounts += checkingBalance + savingsBalance;
	}
	//Getters
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public String getCheckingAndSavingsBalance() {
		return "Checking: " + checkingBalance + " | Savings: " + savingsBalance;
	}
	//Setters
	public void deposit(double amount, String account) {
		if(account == "checking") {
			checkingBalance += amount;
			totalOfAllAccounts += amount;
		}
		else if(account == "savings") {
			savingsBalance += amount;
			totalOfAllAccounts += amount;
		}
		else {
			System.out.println("Invalid account type");
		}
	}
	public void withdraw(double amount, String account) {
		if(account == "checking") {
			if(checkingBalance < amount) {
				System.out.println("Insufficient funds");
			}
			else {
				checkingBalance -= amount;
				totalOfAllAccounts -= amount;
			}
		}
		else if(account == "savings") {
			if(savingsBalance < amount) {
				System.out.println("Insufficient funds");
			}
			else {
				savingsBalance -= amount;
				totalOfAllAccounts -= amount;
			}
		}
		else {
			System.out.println("Invalid account type");
		}
	}
}
