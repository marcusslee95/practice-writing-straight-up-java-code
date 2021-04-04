public class Account {
	private int balance;
	private String owner; 

	Account(int balance, String owner){//want anyone who creates an account to specify the balance and owner so i created constructor that requires those two properties
		this.balance = balance; 
		this.owner = owner;
	}

	public String toString(){//when print.... instead of seeing the default Account@someHashValue..... I want to see all the property values...
		return String.format("Balance: %d; Owner: %s",
			this.balance, this.owner);
	}

	public boolean equals(Object o){
		// if (o.balance == this.balance && o.owner == this.owner){//this line doesn't work because java sees o as type Object... which doesn't have balance or ownerr property..... need to have java see it as type Account...
		// Account oAsAccount = o; //this wouldn't work because o is an Object type.... which could be an Account but it could also be anything else.... need to reassure java it is indeed an Account via casting....
		Account oAsAccount = (Account) o;
		if (oAsAccount.balance == this.balance && oAsAccount.owner == this.owner){
			return true;
		}
		return false; 
	}
}