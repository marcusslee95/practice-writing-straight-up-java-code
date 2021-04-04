import java.util.Set; 
import java.util.HashSet; 
import java.util.LinkedHashSet; 
import java.util.Iterator;


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

	public boolean equals(Object obj){//when i passed in Account accout instead.... didn't register as overriding the method...  cuz when u have same method name but different arguments.... java considers it a different method
        Account account = (Account) obj;// typecast o to Complex so that we can compare data members 
		if (account.getBalance() == this.balance && account.getOwner().equals(this.owner)){//Java has a separate implementation of equals for Strings...... that compares the content and not the memory location.... https://www.geeksforgeeks.org/difference-equals-method-java/   https://www.geeksforgeeks.org/overriding-equals-method-in-java/
			return true;
		}
		return false;
	}

	public int hashCode(){//necessary because the two implementations of set I'm using are hash based collections... if they weren't I could have just finished at writing implementation of equals..... http://www.technofundo.com/tech/java/equalhash.html
		return this.balance + this.owner.hashCode(); //this hashCode method would be calling the default object hashCode method which we know is unique because it's based on memory location
	}
}

class PlayWithSet {
	public static void main(String[] args){
		// Set<Account> set = new HashSet<Account>();
		Set<Account> set = new LinkedHashSet<Account>();
		Account ofSirHundred = new Account(100, "Sir Hundred");
		set.add(ofSirHundred);
		set.add(ofSirHundred); //sets don't add duplicates so this won't be added.... since we're trying to add the literal same object - aka. same thing in memoory
		// Iterator<Account> iterator = set.iterator(); //we need iterator to go through every element in set.... because there isn't a get(index) method in set unlike w/arrays that we can use to get a particular index... in which case wecould just loop through and do array[i]
		// while (iterator.hasNext()) {
		// 	System.out.println(iterator.next());
		// }
		set.add(new Account(100, "Sir Hundred")); //even thogh this is a duplicate - aka. it has the same properties as the thing we've already added to the set..... it will be added to the set..... this is because to determine equality java checks if it's the literal same object.... obviously these are two different objects so evaluates as not equal..... if we want to change how equality is determined we have to write our own implementation of equals() method which also means we have to write our own implementation of hashCode method.... implementing hashCode is required because if two objects are equal then they need to have same hashCode.... but if we change equals method to be by content.... then two objects will now be considered equal so hashCode should of both objects should be same.... but since old hashCode method bases it on memory location.... gives them different hashcodes..... https://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#axzz6r5OTri8h
		set.add(new Account(100, "Sir Hundred"));
		Iterator<Account> iterator = set.iterator();
		while (iterator.hasNext()) {
			Account nextAccount = iterator.next();
			System.out.println(nextAccount.hashCode());
			System.out.println(nextAccount);
		}

	}
}