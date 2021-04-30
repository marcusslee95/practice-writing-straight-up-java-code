//Purpose of this file: going through different ways we can make our code thread safe.... aka. even if multiple threads are executing the same code..... having it result in what we'd expect it to.... i.e. if two threads are incrementing the same variable.... you'd want the variable to be incremented twice.... 
//1st way: using "synchronized" keyword
//2nd way: using locks -> better than using synchronized
//3rd way: shifting the paradigm so that instead of you having to write code that you ensure is thread safe.... you just use code that java provides that are already thread safe (i.e. Atomic class, Concurrent collections)
import java.util.HashMap;
import java.util.Iterator; 
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomigInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
	private int i; 

	// public void increment(){
	// 	i++; 
	// }

	synchronized public void increment(){ //synchronized indicates.... only one thread can run this code for the same object at a time.... this way can avoid situation where two threads try to increment i at the same time... so if we say i's value was 0.... then would expect it to become 2.... but it's 1 because both threads just took that value 0 and incremented by 1... at the same time 
		i++;
	}

	public int getI(){
		return i; 
	}
}

class ThreadThatIncrementsCounterObject extends Thread {
	Counter instanceOfCounter; 

	ThreadThatIncrementsCounterObject(Counter instanceOfCounter) {
		this.instanceOfCounter = instanceOfCounter; 
	}

	public void run(){ 
		instanceOfCounter.increment();
	}
}

class BiCounter { //purpose of this class is to show how you can make your code thread safe using locks.... locks are better than using the synchronized keyword.... because while synchronized tells threads "hey only one thread can execute this code for a given object at any time"... if you have multiple methods marked as synchronized... that means that only one thread can be executing the code for any of those methods at a given point in time.... on the other hand, locks say "only one thread can be executing the code for this method at a time for a given object... but if another thread wants to execute code for another method of the same object at the same time.... it can".... so it takes the benefits of synchronized w/out any of the cons 
	private int i; 
	private int j; 

	// synchronized public void incrementI(){
	// 	i++; 
	// }

	// synchronized public void incrementJ(){
	// 	j++; 
	// }

	Lock lockForIncrementIMethod = new ReentrantLock(); 
	Lock lockForIncrementJMethod = new ReentrantLock(); 

	public void incrementI(){
		lockForIncrementIMethod.lock(); //what lock method does.... 1. checks if any other thread is executing this method.... by seeing if the lock is unlocked..... if it is then no thread is executing this method for a given object so you're free to run the code in this method 2. lock the lock so that any other thread that tries to run this code for the same object knows another thread is running it so that thread will have to wait until it's unlocked....
		i++; 
		lockForIncrementIMethod.unlock(); //release lock so other threads can execute this method for the given object
	}

	public void incrementJ(){
		lockForIncrementJMethod.lock();
		j++; 
		lockForIncrementJMethod.unlock();
	}

	public getI(){ //whether or not multiple threads are executing this method at the same time or one after the other.... won't make a difference.... it's just getting a value.... so no need to add stuff to this method like synchronized or locks 
		return i;
	}

	public getJ(){
		return j;
	}

}

class ThreadThatIncrementsBiCounterObject1stProperty extends Thread {
	BiCounter instanceOfBiCounter; 

	ThreadThatIncrementsBiCounterObject1stProperty(BiCounter instanceOfBiCounter) {
		this.instanceOfBiCounter = instanceOfBiCounter;
	}

	public void run() { 
		instanceOfBiCounter.incrementI(); 
	}
}

class ThreadThatIncrementsBiCounterObject2ndProperty extends Thread {
	BiCounter instanceOfBiCounter; 

	ThreadThatIncrementsBiCounterObject2ndProperty(BiCounter instanceOfBiCounter) {
		this.instanceOfBiCounter = instanceOfBiCounter;
	}

	public void run() { 
		instanceOfBiCounter.incrementJ(); 
	}
}

class BiCounterViaAtomicInteger {
	private AtomicInteger i = new AtomicInteger();  //let's me outsource the burden of making my code threadsafe.... since I use atomic class methods that are already thread safe
	private AtomicInteger j = new AtomicInteger(); 

	public void incrementI(){
		// i++;
		i.incrementAndGet();
	}

	public void incrementJ(){
		// j++;
		j.incrementAndGet();
	}

	public int getI(){
		i.get(); 
	}

	public int getJ(){
		j.get(); 
	}
}




public class ThreadSafetyPractice {

	public static void main(String[] args) throws InterruptedException {
		// //B4: without threads 
		// Counter counter = new Counter();
		// System.out.println(counter.getI());
		// counter.increment();
		// counter.increment();
		// System.out.println(counter.getI());
		// //AFTER: without threads

		// //B4: with threads 
		// Counter counter = new Counter(); 
		// ThreadThatIncrementsCounterObject threadThatIncrementsCounterObject = new ThreadThatIncrementsCounterObject(counter); 
		// // threadThatIncrementsCounterObject.start(); //the basic way to run a thread 
		// ThreadThatIncrementsCounterObject anotherThreadThatIncrementsCounterObject = new ThreadThatIncrementsCounterObject(counter); 
		// // anotherThreadThatIncrementsCounterObject.start();

		// ExecutorService execService = Executors.newFixedThreadPool(5); //the better way to run threads 
		// execService.execute(threadThatIncrementsCounterObject);
		// execService.execute(anotherThreadThatIncrementsCounterObject); 
		// execService.execute(new ThreadThatIncrementsCounterObject(counter)); 
		// execService.execute(new ThreadThatIncrementsCounterObject(counter)); 
		// execService.execute(new ThreadThatIncrementsCounterObject(counter)); 
		// execService.execute(new ThreadThatIncrementsCounterObject(counter)); 

		// Thread.sleep(1000); //just telling to wait a bit before running code below.... because threads might not have finished running.... if the threads returned something.... I could have used invokeAll to wait for threads to finish running..... or if I had run threads using basic way aka. w/out executorService..... I could have used thread.join() method to wait for thread to finish.... but this is only way to wait for threads that you ran using executorService that don't return anything 

		// // threadThatIncrementsCounterObject.join(); 
		// // anotherThreadThatIncrementsCounterObject.join();
		// System.out.println(counter.getI()); //since we marked increment method as synchornized..... each thread will execute one at a time.... so i will be value we'd expect it to be..... even when you take out the synchronized it probably will end up with value you'd expect.... but synchronized eliminates all possibility of unexpected value.... aka. it's a guarantee 

		// execService.shutdown();
		// //AFTER: with threads

		//B4: using threads to work w/BiCouter object 
		BiCounter biCounter = new BiCounter();
		ThreadThatIncrementsBiCounterObject1stProperty increment1stProperty1 = new ThreadThatIncrementsBiCounterObject1stProperty(biCounter);
		ThreadThatIncrementsBiCounterObject1stProperty increment1stProperty2 = new ThreadThatIncrementsBiCounterObject1stProperty(biCounter);

		ThreadThatIncrementsBiCounterObject2ndProperty increament2ndProperty1 = new ThreadThatIncrementsBiCounterObject2ndProperty(biCounter);
		ThreadThatIncrementsBiCounterObject2ndProperty increament2ndProperty2 = new ThreadThatIncrementsBiCounterObject2ndProperty(biCounter);

		increment1stProperty1.start();
		increment1stProperty2.start(); 

		increament2ndProperty1.start();
		increament2ndProperty2.start(); 

		//wait for all the threads to finish executing.... before printing to see if incremented as many times as you'd expect 
		increment1stProperty1.join();
		increment1stProperty2.join();
		increament2ndProperty1.join();
		increament2ndProperty2.join(); 

		System.out.println("i: " + biCounter.getI());
		System.out.println("j: " +biCounter.getJ());
		//AFTER: using threads to work w/BiCouter object 

		// //B4: example of using a concurrent collection
		// 	//B4: step0 - plain old calculating # of occurrences of the characters in a string using a hashmap.... 
		// 		//use a dictionary aka. hashmap.... cuz u can just use the character in the string as the key and the # occurences as the value 
		// String string = "ABCD ABCD ABCD";
		// Map<Character, Integer> numOfEachCharInAString = new Hashmap<>();
		// for (char c : string.toCharArray()) { 
		// 	Integer integer = numOfEachCharInAString.get(c); 
		// 	if (integer != null) { //key value pair already exists 
		// 		numOfEachCharInAString.replace(c, integer + 1); 
		// 	}
		// 	else {
		// 		numOfEachCharInAString.put(c , 1);
		// 	}
		// }
		// System.out.println(numOfEachCharInAString);
		// Set<Map.Entry<Character, Inter>> entries = numOfEachCharInAString.entrySet();
		// Iterator<Map.Entry<Character, Integer>> entriesIterator = entries.iterator(); 
		// while (entriesIterator.hasNext()) {
		// 	Map.Entry<Character, Integer> next = entriesIterator.next();
		// 	System.out.println(next.getKey() + ": " + next.getValue()); //OF NOTE: I didn't memorize / pull all these methods from memory.... I looked at the java docs to see what methods the class had and found the method that gave me what i needed..... this should be the pattern that you follow when you develop 
		// }
		// 	//AFTER: step0 - plain old calculating # of occurrences of the characters in a string using a hashmap.... 

		// 	//B4: step1 - calculating # of occurrences of the characters in a string.... but doing so in a threadsafe way.... no need to really understand what's going on here.... all that you need to know that HashTable is a threadsafe implementation of Map unlike HashMap... which is to say all it's methods are marked with "synchronized" keyword
		// String string = "ABCD ABCD ABCD";
		// Map<Character, LongAdder> numOfEachCharInAString = new HashTable<>();
		// for (char c : str.toCharArray()) {
		// 	LongAdder longAdder = numOfEachCharInAString.get(c); 
		// 	if (longAdder == null) {
		// 		longAdder = new LongAdder();
		// 	}
		// 	longAdder.increment();
		// 	numOfEachCharInAString.put(c, longAdder);
		// }

		// System.out.println(numOfEachCharInAString);
		// 	//AFTER: step1 - calculating # of occurrences of the characters in a string.... but doing so in a threadsafe way.... no need to really understand what's going on here.... all that you need to know that HashTable is a threadsafe implementation of Map unlike HashMap... which is to say all it's methods are marked with "synchronized" keyword

		// 	//B4: step2 - doing the same thing as in step 1 but in a more performant way..... that's what Concurrent collections are for.... running thread safe code that's performant 
		// ConcurrentMap<Character, LongAdder> numOfEachCharInAString = new ConcurrentHashMap<>();
		// String string = "ABCD ABCD ABCD";
		// for (char c : str.toCharArray()) {
		// 	numOfEachCharInAString.computeIfAbsent(c, ch -> new LongAdder())
		// 		.increment();
		// }
		// System.out.println(numOfEachCharInAString);
		// 	//AFTER: step2 - doing the same thing as in step 1 but in a more performant way..... that's what Concurrent collections are for.... running thread safe code that's performant 

		// //AFTER: example of using a concurrent collection


	}
}