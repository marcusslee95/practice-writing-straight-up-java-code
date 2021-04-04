import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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

	// public boolean equals(Object obj){//when i passed in Account accout instead.... didn't register as overriding the method...  cuz when u have same method name but different arguments.... java considers it a different method
 //        Account account = (Account) obj;// typecast o to Complex so that we can compare data members 
	// 	if (account.getBalance() == this.balance && account.getOwner().equals(this.owner)){//Java has a separate implementation of equals for Strings...... that compares the content and not the memory location.... https://www.geeksforgeeks.org/difference-equals-method-java/   https://www.geeksforgeeks.org/overriding-equals-method-in-java/
	// 		return true;
	// 	}
	// 	return false;
	// }

	// public int hashCode(){//necessary because the two implementations of set I'm using are hash based collections... if they weren't I could have just finished at writing implementation of equals..... http://www.technofundo.com/tech/java/equalhash.html
	// 	return this.balance + this.owner.hashCode(); //this hashCode method would be calling the default object hashCode method which we know is unique because it's based on memory location
	// }
}

class PlayWithHashtableAndHashmap { //Play with Hashtable and Hashmap class... similar to linkedlist or ArrayList can probably just replace 1 line and code should work for both cuz... implementing same Map ADT (by implementing the same Map interface) - the ADT that maps keys to values
	public static void main(String[] args){
		// Map<String, Account> accounts = new HashMap<String, Account>();
		Map<String, Account> accounts = new LinkedHashMap<String, Account>();
		// Map<String, Account> accounts = new TreeMap<String, Account>();
		// System.out.println(accounts.isEmpty());
		Account account1 = new Account(100, "Mr. Hundred");
		accounts.put(account1.getOwner(), account1); //using the owner String.... as the key
		Account account2 = new Account(1000000, "Mr. Million");
		accounts.put(account2.getOwner(), account2);
		Account account3 = new Account(1000000000, "Sir Billionaire");
		accounts.put(account3.getOwner(), account3);

		// System.out.println(accounts.size());

		// Collection<Account> allAccountsInHashTable = accounts.values(); //Collection interface has an iterator method that let's you iterate
		// Iterator<Account> valuesIterator = allAccountsInHashTable.iterator();
		// while (valuesIterator.hasNext()){
		// 	Account nextAccount = valuesIterator.next();
		// 	System.out.println(nextAccount.toString());
		// }

		// Set<String>	keysInHashTable = accounts.keySet();
		// Iterator<String> keysIterator = keysInHashTable.iterator();
		// while (keysIterator.hasNext()){
		// 	String nextKey = keysIterator.next();
		// 	System.out.println(nextKey);
		// }

		if (accounts.containsKey("Mr. Million")){
			Account	mrMillionAccount = accounts.get("Mr. Million");
			System.out.println(mrMillionAccount.getBalance());
			Account removedValue = accounts.remove("Mr. Million");
			System.out.println(removedValue.toString());
		}
		System.out.println(accounts.size());

		Set<Map.Entry<String,Account>> allKeyValuePairs = accounts.entrySet();
		Iterator<Map.Entry<String,Account>>	entriesIterator = allKeyValuePairs.iterator();
		while (entriesIterator.hasNext()){
			Map.Entry<String,Account> nextEntry = entriesIterator.next(); 
			System.out.println("Key: " + nextEntry.getKey());
			System.out.println("Value: " + nextEntry.getValue());
		}



	}
}
