//Purpose of file: cover other stuff that might be good to know i.e. standard coding interview questions, overriding hashCode and equals when you want to base equality not from memory aka. is it literally the same object but by property values...., etc. 

//overriding hashCode and equals methods
public int hashCode(){
	return this.balance + thisowner.hashCode(); //what you're doing here is your taking an integer property of the object.... and then adding it to the unique location of the object - that's the output value of the normal hashcode method.. this is one way to write a custom hash function
}

public boolean equals(Object obj) {
	if (this == obj) { //it's the same object 
		return true;
	}
	if (obj == null) { //compaing nothing to something 
		return false;
	}
	if (getClass() != obj.getClass()) { //one object is a different tpe from another class 
		return false; 
	}
	//now that you've gone through the basic filters... you can compare the properties to see if they are the same values 
	SomeDataType other = (SomeDataType) obj; //need to tell java this object which is type Object... really is an instance of SomeDataType... otherwise we won't be able to access the methods / properties of that class.... instead all we have to work with is the basic Object class methods.... 
	if (this.property1 == object.propty1 && this.property2 == other.property2 so on and so forth){
		return true;
	}
	else {
		return false; 
	}
}

//example of how encapsulation can be beneficial..... can limit other classes from changing properties of our object to values we don't want....
void setBalance(int balance){
	if (balance < 0) {
		throw new IllegalArgumentException(balance + " is not valid... cuz it's negative");
	}
	else {
		this.balance = balance; 
	}
}

//objects can access static aka. class properties and methods.... but not the other way around 
StaticModifierExample example = new StaticModifierExample();
example.staticVariable = 10; 
example.staticMethod(); 
// StaticModifierExample.instanceVariable = 10; //Does not work... errors on compile
// StaticModifierExample.instanceMethod();
StaticModifierExample.staticVariable = 10; //ofc class can still access class properties / methods 
StaticModifierExample.staticMethod();

//Stack and Queue adts are implemented in java using Dequeue - double ended queue.... just use Dequeue different ways to get the behaviors of either a stack or queue (for stack.... just add and remove from first.... to get LIFO behavior) for queue just add to last and remove from first.... as you would w/any line 

//simple arrays can store non-primitives aka. objects.... cuz what really is getting stored is the memory location of the object.... side note: objects get stored in this separate place in memory called a heap... and if you assign an object to a variable what happens is.... the variable is stored in this place of memory called the stack.... and it stores the location of the object inside..
//Example:
Account[] accounts = new Account[10];
accounts[0] = new Account(1000, "Sir Paycheck-to-Paycheck"); //in 1st index what'll get stored is the location of Account object.... which really exists in separate part of memory called heap
accounts[0].setBalance(5555); //can use location to get to the object and then call its methods

//can assign objects that are different implementations of an interface.... to a variable of that interface..... this is an example of polymorphism because the class that implements an interface can take on the form of that interface
//Example: 
List<Ball> balls = new ArrayList<>(); 
List<Ball> balls = new LinkedList<>(); //both work 

//Implementing a LinkedList - boilerplate aka. it's not the whole thing... just the most important thing i.e. what properties needed 
public class LinkedList {

	Node head; 

	//This inner class is made static so that main() can access it without having to create instance of LinkedList.... makes sense cuz class can access static aka. class stuff
	static class Node { 

		int data;
		Node next; 

		Node(int d) {
			data d; 
			next = null; 
		}
	}
}

//Implementing a Stack - boilerplate.... tbh... I might preffer using linkedlist cuz no need to care about resizing.... 
class Stack {

	private int[] arr; 
	private int top; 
	private int capacity; 

	Stack(int size){
		arr = new int[size];
		capacity = size; 
		top = -1;
	}

}

//an implementation of Map aka. a dictionary that uses a hashing function... a map / dictionary is just something that uses a key to get some value 
class Map<K, V> {

	//array is the underlying data structure  
	private ArrayList<HashNode<K, V>> bucketArray; 

	//Current capacity of arrayList 
	private int numBuckets; 

	//current size
	private int size; 

	public Map() {
		bucketArray = new ArrayList<>(); 
		numBuckets = 10; 
		size = 0; 
	}
}

class HashNode<K, V> { //the actual key value pair that will get stored in our dictionary 

	K key; 
	V value; 
	HashNode<K,V> next; //in situation where there's more than one key value pair in each bucket.... we'll have a linkedlist

	public HashNode(K key, V value) {
		this.key = key;
		this.value = value; 
	}
}

//The essence of recursion is the understanding that you might be able to solve a problem if you have the answers to the same problem w/different inputs... so if you assume you have the answers to the same problem w/different inputs.... how would you use those answers to solve the original problem.... i.e. you can get answer to what is the nth fibonacci # if you have answer to what is the n-1th fib # and what is the n-2th fib #.... just add them together
//Example: fibonnaci 
public int fib(n){
	// return fib(n - 1) + fib(n - 2); -> this is the key line... all that you have to add is code to stop recursive calls.... aka. where you already have the answer to the question s.t. you don't have to use recursive calls and can instead just return the answer.. official name for this is "base cases"

	if (n <= 0) { //already have the answer to this question - fib(0 or some - #) - the answer is..... there should be an error
		throw new IllegalArgumentException("there's such a thing as the 1st fibonacci # but not the 0th or the -1th fibonacci number");
	}
	if (n == 1 || n == 2) { //already have answer to this question - fib(1) or fib(2) - since we define first two fib #s as being 1 
		return 1; 
	}

	//now that we've covered situations where we already have the answer.... we can now think about how to use answers to the same question but with different inputs... to answer the original question... which we already thought about 
	return fib(n - 1) + fib(n - 2);
}
//My Two step process for solving questions recursively: 1. think about how you can use answers to the same problem but w/different inputs... to answer the original problem -> this will become the recursive call section in your method... 2. think about what are the inputs that if you put them into the problem... you'd already know what the answer is to the problem without having to use recursive function calls..... -> that will be the base case section of your method.

//binary search implementations: both recursive and iterative 
public int runBinarySearchRecursively (int[] sortedArray, int numberWeWantToFind) { //remember binary search only works when it's sorted 
	int indexOfLowest = 0; 
	int indexOfHighest = sortedArray.length; 

	return runBinarySearchRecursivelyHelper(sortedArray,  numberWeWantToFind, indexOfLowest, indexOfHighest); //need to use a helper function... cuz don't want to run code like int lowest = 0; with each recursive function call.. aka. might not always want to set lowest to 0 aka the 1st index
} 

public int runBinarySearchRecursively (int[] sortedArray, int numberWeWantToFind, int indexOfLowest, int indexOfHighest) {
	//You can think of a recursive function as having 2 parts: Part1: Base cases Part2: Recursive function calls
		//Base cases part is just the part where you don't have to make recursive function calls because the answer is already there 
		//Recursive function call is part where you have to call the function again using different inputs because haven't gotten to point where foud answer yet 

	//Part 1: Base cases part 
	if (indexOfLowest > indexOfHighest){ //this is an indicator that you've already searched the whole array and haven't found the number so in that case you already know that that number does not exist in the array aka. "the answer is already there"
		return -1;
	}

	int middleIndex = (indexOfLowest + indexOfHighest) / 2; 

	if (sortedArray[middleIndex] == numberWeWantToFind) { //you found that the number exists in the array and where it exists.... so you don't have to make another recursive call aka. "the answer is already there"
		return middleIndex;
	}

	//Part2: Recursive Function Call - you weren't able to find answer yet 
	if (sortedArray[middleIndex] < numberWeWantToFind) { //just look at .. and do binary search on... right half since everything in left half will be smaller than number anyways... this is the benefit of binary search... you eliminate one half of the things you have to look at each time
		return runBinarySearchRecursivelyHelper(sortedArray, numberWeWantToFind, middleIndex + 1, indexOfHighest);
	}

	if (sortedArray[middleIndex] > numberWeWantToFind) {
		return runBinarySearchRecursivelyHelper(sortedArray, numberWeWantToFind, indexOfLowest, middleIndex - 1);
	}

	throw new Exception("Code should have never arrived here... should have been caught in one of the if statements")

} 

public int runBinarySearchIteratively(int[] sortedArray, int numberWeWantToFind) { 

	int indexOfLowest = 0; 
	int indexOfHighest = sortedArray.length; 

	while (indexOfLowest <= indexOfHighest) {
		int middleIndex = (indexOfLowest + indexOfHighest) / 2; 
		if (sortedArray[middleIndex] == numberWeWantToFind) {
			return middleIndex;
		}
		else if (sortedArray[middleIndex] < numberWeWantToFind) {
			indexOfLowest = middleIndex + 1; 
		}
		else if (sortedArray[middleIndex] > numberWeWantToFind) {
			indexOfHighest = middleIndex - 1; 
		}
		else { 
			throw new Exception("Code should have never arrived here... should have been caught in one of the if statements")
		}
	}

	return -1; 
}


class BinaryTree {

	static Node root; 

	// create bst from sorted array
	// 1) Get the middle of the array and make it the root. 
	// 2) Recursively do the same for the left half and right half 
	// The reason this works is.... recursion is all about finding the answer to the original question by using the answers to the same question w/different inputs....
	// If we assume that we are able to create a bst out of the left half and the right half - minus the middle element - then all we need is to create root out of the middle and make it's right and left children the bsts that we created
	Node sortedArrayToBST(int[] arr, int start, int end) {

		if (start > end) { 
			return null;
		}

		int middle = (start + end) / 2; 
		Node node = new Node(arr[mid]);

		//Recursively construct the left subtree and make it left child of root 
		node.left = sortedArrayToBST(arr, start, middle - 1); 

		//Recursively construct the right subtree and make it right child of root 
		node.right = sortedArrayToBST(arr, middle + 1, end); 

		return node; 

	}

	void preOrder(Node node) { //traverse aka. visit all the nodes in BST -> this one does so in a particular way called preorder.... which is at every level of the tree you'll be visiting the node first... and then visiting all the nodes of the left subtree before visiting the nodes in the right subtree.. for more on this: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
		if (node == null) { //in this situation you don't have anything to traverse 
			return;
		}
		System.out.print(node.data + " "); // visit the node
		preOrder(node.left); //visit all the nodes in left subtree
		preOrder(node.right); //visit all the nodes in right subtree


		// preOrder(node.left); //this is inorder traversal -> visit all nodes in left subtree before visit the node you're at.. and then visit all nodes in right subtree 
		// System.out.print(node.data + " ");
		// preOrder(node.right);

		// preOrder(node.left); //this is postorder traversal -> visit all nodes in both subtrees before visiting node you're at 
		// preOrder(node.right);
		// System.out.print(node.data + " ");

		//these types of traversals... are called DFS... cuz they're all about going down the tree... it's a vertical direction... whereas bfs is horizontal direction... one level at a time 
	
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(); 
		int[] arr = new int[]{1,2,3,4,5,6,7};
		root = tree.sortedArrayToBst(arr, 0, arr.length - 1); //don't need to do tree.root because we made root a static property 
		tree.preOrder(root); 
	}
}

//A binary tree node 
class Node {

	int data;
	Node left, right; 

	Node(int d) {
		data = d; 
		left = right = null; 
	}

}

//visiting all nodes in a tree in bfs fashion aka. level by level..... 
//standard way is you use a queue and then you repeat visiting the node at the front of the queue (visit can count as anything i.e. print it's data)... you then remove it from the queue and add it's children.. 
void bfs(){
	Queue<Node> queue = new ArrayDeque<>(); 

	queue.add(root); 

	while(!queue.isEmpty()) {
		Node currentNode = queue.remove(); //node at front of the queue 
		System.out.print(currentNode.data + " "); //our version of visiting 
		queue.add(currentNode.left); 
		queue.add(currentNode.right); 

	}
}

//reverse a string 
//way1: use reverse method available in StringBuilder
String str = "Automation"; 
StringBuilder reversedString = new StringBuilder(); 
reversedString.append(str); 
reversedString = reversedString.reverse(); 
System.out.println(reversedString);
//way 2: convert String to character array and loop backwards 
String str = "Automation"; 
char[] strAsArray = str.toCharArray(); 
StringBuilder reversedString = new StringBuilder(); 
for (int i = strAsArray.length - 1; i >= 0; i--) {
	reversedString.append(strAsArray[i]); 
}




