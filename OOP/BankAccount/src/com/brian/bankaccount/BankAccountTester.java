package com.brian.bankaccount;

public class BankAccountTester {

	public static void main(String[] args) {
		BankAccount firstAccount = new BankAccount();
		BankAccount secondAccount = new BankAccount(100.00);
		BankAccount thirdAccount = new BankAccount(1000.00, 50000.00);
		
		firstAccount.deposit(100.00, "checking");
		firstAccount.withdraw(10.00, "checking");
		System.out.println(firstAccount.getCheckingAndSavingsBalance());
		
		System.out.println(secondAccount.getCheckingBalance());
		System.out.println(secondAccount.getSavingsBalance());
		
		secondAccount.withdraw(1000000, "savings");
		System.out.println(thirdAccount.getCheckingAndSavingsBalance());
		System.out.println(BankAccount.numberOfAccounts);
		System.out.println(BankAccount.totalOfAllAccounts);
	}

}
