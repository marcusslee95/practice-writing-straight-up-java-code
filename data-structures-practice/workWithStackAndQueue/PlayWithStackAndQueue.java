import java.util.Deque; //java docs say that java has a Stack class.... but ArrayDeque class is better version of it... https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
import java.util.ArrayDeque; //Deque is short for double ended queue.... aka. it's a queue... but you can treat it like a stack aka. LIFO by just adding to and getting from the start
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
}

class PlayWithStackAndQueue {
	public static void main(String[] args){
		// Deque<Account> stack = new ArrayDeque<Account>(); 
		// stack.addFirst(new Account(100, "Mr. Barely Floating Above Water"));
		// stack.addFirst(new Account(100000, "Mr. Doing Pretty Good"));

		// Iterator<Account> iteratorForThisStack = stack.iterator(); 

		// while (iteratorForThisStack.hasNext()){
		// 	System.out.println(iteratorForThisStack.next().toString()); 
		// 	iteratorForThisStack.remove(); //remove something from stack after processing it
		// }

		// System.out.println(stack.size());

		//queue would be the same thing except instead of adding to beginning.... add to the end.... like you would in a normal line... aka queue
		Deque<Account> queue = new ArrayDeque<Account>(); 
		queue.addLast(new Account(100, "Mr. Barely Floating Above Water"));
		queue.addLast(new Account(100000, "Mr. Doing Pretty Good"));

		Iterator<Account> iteratorForThisQueue = queue.iterator(); 

		while (iteratorForThisQueue.hasNext()){
			System.out.println(iteratorForThisQueue.next().toString()); 
			iteratorForThisQueue.remove();
		}

		System.out.println(queue.size());

	}
}