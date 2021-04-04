import java.util.List;
import java.util.ArrayList;

class AdvancedPlayWithArrayList {
	public static void main(String[] args){
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account(100, "Mr. Hundred"));
		accounts.add(new Account(1000, "Mr. Thousand"));
		accounts.add(new Account(10000, "Mr. 10k"));
		// for (int i = 0; i < accounts.size(); i++){
		// 	System.out.println(accounts.get(i));
		// }
		for (Account account : accounts){
			System.out.println(account);
		}
		// System.out.println(accounts.get(1));
		// System.out.println(accounts.indexOf(new Account(1000, "Mr. Thousand"))); //before I implemented my own version of equals() method.... returned -1.... because java's default equals() method... the one that belongs to Object class.... checks if the two things are in the same memory location aka. are they literally the same thing.... if want to base equality based on property values..... need to write your own custom implementation
		boolean wasItRemoved = accounts.remove(new Account(1000, "Mr. Thousand")); //this should work because we now determine equality not by memory location but by property values... if you comment out equals method.... in Account class.... will not remove anything... because goes back to basing equality on memory location.... and even though the two objects will have same property values.... because they aren't literally same object... won't match
		System.out.println(wasItRemoved);
		System.out.println(accounts.size());
	}
}