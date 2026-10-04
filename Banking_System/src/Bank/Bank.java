package Bank;

public class Bank {

	private final int accountNumber;
	private String Name;
	private double accountBalance = 0;
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public double getAccountBalance() {
		return this.accountBalance;
	}
	 
	public static class InsufficientFundsException extends Exception{
		public InsufficientFundsException(String message) {
			super(message);
		}
	}
	
	// Make sure the instance of bank is not complete
	// in case a broken object is created.
	public Bank(int accountNumber, String Name, double accountBalance){
		// Implement this so that account number must be 9 digits.
			if (1000000000 < accountNumber || accountNumber < 99999999) {
				throw new IllegalArgumentException("Your account Number is not within 9 digits");
			}
			if (Name == "") {
				throw new IllegalArgumentException("Name must contain at least one character.");
			}
			if (accountBalance < 0) {
				throw new IllegalArgumentException("Balance must be positive");
			}
			this.accountNumber = accountNumber;
			this.Name = Name;
			this.accountBalance = accountBalance;
		
	}
	
	public void deposit(double balance) throws InsufficientFundsException {
		try {
			if (balance > 0) {
				this.accountBalance += balance;
				System.out.println("Successful Deposit");

			}
			
			else{
				throw new IllegalArgumentException("Insufficient Deposit.");
			}
		}
		catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		
	}
	
	
	public void withdraw(double balance) throws InsufficientFundsException {
		try {
			if (balance < this.accountBalance && balance > 0) {
				this.accountBalance -= balance;
				System.out.printf("Successful Withdrew %.2f\n", balance);
			}
			else{
				throw new InsufficientFundsException("Insufficient Balance.");
			}
		}
		catch (InsufficientFundsException e){
			System.out.println(e);
		}
	}
}
