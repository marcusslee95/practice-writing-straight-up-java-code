class Account {
	private int balance;
	private String owner;

	Account (int balance, String owner){
		this.balance = balance;
		this.owner = owner;
	}

	void setBalance(int balance){
		if (balance < 0){
			throw new IllegalArgumentException(balance + " is not valid... cuz it's negative");
		}
		else {
			this.balance = balance;
		}
	}

	int getBalance(){
		return this.balance;
	}

	String getOwner(){
		return this.owner;
	}

	public String toString(){
		return String.format("balance - %d, owner - %s",
			this.balance, this.owner);
	}
}

public class PlayWithArrays {
	public static void main(String[] args){
		// int[] intArr = new int[3];
		// intArr[0] = 69;
		// intArr[1] = 3000;
		// intArr[2] = 25;
		// for (int i = 0; i < intArr.length; i++){
		// 	System.out.println(intArr[i]);
		// }

		Account[] accounts = new Account[10];
		accounts[0] = new Account(1000, "Sir Paycheck-to-Paycheck");
		accounts[0].setBalance(100);
		accounts[1] = new Account(1000000, "Sir Chilling");
		int unfilledIndex = -1;
		for (int i = 0; i < accounts.length; i++){
			if (accounts[i] == null){//once reaches indexes at thee end that haven't been filled..... terminates loop 
				unfilledIndex = i;
				break;
			}
			if (accounts[i].getBalance() <= 100){
				System.out.println(accounts[i].getOwner());
			}
		}
		accounts[unfilledIndex] = new Account(1000000000, "Sir Billionaire"); 
		System.out.println(unfilledIndex);
		System.out.println(accounts[unfilledIndex]);
		try {
			accounts[unfilledIndex].setBalance(-999999); //would normally put potentially error causing code here.... this code we know causes error
		} catch (IllegalArgumentException e){
			e.printStackTrace();
			System.out.println(accounts[unfilledIndex].getBalance());
		}


	}
}

