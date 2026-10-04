package MainDriver;

import Bank.Bank;
import Bank.Bank.InsufficientFundsException;

public class MainDriver {

	public static void main(String[] args) throws InsufficientFundsException {
		
		System.out.println("Initialize Bank Class with invalid parameter");
		System.out.println("---------------------------------------------");
		System.out.printf("Initialize with invalid Account Number\n");
		try {
		Bank sam = new Bank(10000000, "s", 100);
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		System.out.printf("\n\nInitialize with empty Name\n");
		try {
			Bank tim = new Bank(198787654, "", 100);
			}
			catch (IllegalArgumentException e) {
				System.out.println(e);
			}
		System.out.printf("\n\nInitialize with invalid Account Balance\n");
		try {
			Bank Amy = new Bank(198787653, "amy", -100);
			}
			catch (IllegalArgumentException e) {
				System.out.println(e);
			}
		
		System.out.println("\n\nInitialize Bank Class with valid parameter");
		System.out.println("---------------------------------------------");
		Bank daniel = new Bank(934567898, "daniel", 0);
		System.out.printf("%s's Account number is %d and balance is %.2f\n", daniel.getName(), daniel.getAccountNumber(), daniel.getAccountBalance());
		
		System.out.println("\n\nDeposit with valid balance");
		System.out.println("---------------------------------------------");
		daniel.deposit(200);
		System.out.printf("%s's current balance is %.2f\n", daniel.getName(), daniel.getAccountBalance());
		
		System.out.println("\n\nDeposit with invalid balance");
		System.out.println("---------------------------------------------");
		try {
			daniel.deposit(-200);
		}
		catch (IllegalArgumentException e){
			System.out.println(e);
		}
		
		System.out.println("\n\nWithdraw balance with proper balance");
		System.out.println("---------------------------------------------");
		daniel.withdraw(100);
		System.out.printf("%s's current balance is %.2f\n", daniel.getName(), daniel.getAccountBalance());
		
		System.out.println("\n\nWithdraw balance that is larger than current balance");
		System.out.println("---------------------------------------------");
		try {
			daniel.withdraw(1000);
		}
		catch (InsufficientFundsException e){
			System.out.println(e);
		}
	}

}
