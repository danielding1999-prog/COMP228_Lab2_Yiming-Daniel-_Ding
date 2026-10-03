package Bank;
import insufficientFundsException.InsufficientFundsException;

public class Bank {

	private final int accountNumber;
	private double accountBalance = 0;
	
	public Bank(int accountNumber) {
		// Implement this so that account number must be 9 digits.
	}
	public int getAccountNumber() {
		return accountNumber;
	}

	
	public void deposit(double balance) throws InsufficientFundsException {
		try {
			if (balance > 0) {
				this.accountBalance += balance;
			}
			
			else{
				throw new InsufficientFundsException("Your balance must be above 0$");
			}
		}
		catch (InsufficientFundsException e) {
			System.out.println(e);
		}
		
	}
	
	
	public void withdraw(double balance) throws InsufficientFundsException {
		try {
			if (balance < this.accountBalance && balance > 0) {
				this.accountBalance -= balance;
			}
			else{
				throw new InsufficientFundsException("There is a problem with your withdraw request");
			}
		}
		catch (InsufficientFundsException e){
			System.out.println(e);
		}
	}
}
