package MainDriver;

import Bank.Bank;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int account = 1000;
		int counter = 0;
		boolean go = true;
		while (go) {
			account = account / 10;
			counter++;
			if (account == 0) {
				go = false;
			}
		}
		System.out.println(counter);
	}

}
