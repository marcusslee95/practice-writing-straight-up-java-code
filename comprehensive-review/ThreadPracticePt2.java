//Purpose of this file: 1. pracitce using executorService.... which is a better way to run multiple threads as opposed to previous approach.... 2. practice with threads that return something 
import java.util.concurrent.Callable; 
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 

public class ThreadPracticePt2 {

	public static void main(String[] args) {
		// //B4: using executorService to run one thread at a time aka. no different from normal code aka. it's blocking.... wait for one thing to finish and only then do the next 
		// ExecutorService execService = Executors.newSingleThreadExecutor();
		// execService.execute(new Task1());
		// execService.execute(new Thread(new Task2()));

		// //Task3: 
		// System.out.print("\nTask3 Start");
		// for (int i = 300; i <= 399; i++) {
		// 	System.out.print(i + " ");
		// }
		// System.out.print("\nTask3 Done");

		// execService.shutdown(); 
		// //AFTER: using executorService to run one thread at a time aka. no different from normal code aka. it's blocking.... wait for one thing to finish and only then do the next 

		//B4: using execService to run multiple threads at a time 
		// ExecutorService execService = Executors.newFixedThreadPool(2); //execService is going to run two threads simultaneously.... so if have 6 threads... then first 2 run... and when 1 of them finishes running the next one starts... 
		ExecutorService execService = Executors.newFixedThreadPool(5);
		execService.execute(new GeneralTask(1));
		execService.execute(new GeneralTask(2));
		execService.execute(new GeneralTask(3));
		execService.execute(new GeneralTask(4));
		execService.execute(new GeneralTask(5));
		execService.execute(new GeneralTask(6));
		execService.execute(new GeneralTask(7));
		execService.shutdown();
		//AFTER: using execService to run multiple threads at a time 

		// //B4: using execService to run multiple threads at a time that return something 
		// ExecutorService execService = Executors.newFixedThreadPool(2);
		// Future<Integer> whateverThread1Returns = execService.submit(new GeneralTaskThatReturnsAValue(1)); //submit is just like start except for threads that return something..... Future is the same as a promise... "I'll return back something eventually"
		// System.out.println("Here is what thread1 returns: " + whateverThread1Returns.get()); //the .get() method forces us to wait until thread1 actually does return a value... before moving onto the code below... cuz duh.... can't get something that's not there 
		// Future<Integer> whateverThread2Returns = execService.submit(new GeneralTaskThatReturnsAValue(2));
		// System.out.println("Here is what thread2 returns: " + whateverThread2Returns.get());
		// execService.submit(new GeneralTaskThatReturnsAValue(3));
		// execService.submit(new GeneralTaskThatReturnsAValue(4));
		// execService.submit(new GeneralTaskThatReturnsAValue(5));
		// //AFTER: using execService to run multiple threads at a time that return something 

		// //B4: using execService to run multiple threads at a time that return something... but instead of using multiple function calls - aka. multiple .execute - you just use 1 function call.... benefit is...it's a lot more concise.... also the function call - invokeAll - has you wait for all the thread to finish running before moving onto the next line.... cuz we need all the code to finish running to get the return value 
		// ExecutorService execService = Executors.newFixedThreadPool(3);
		// List<GeneralTaskThatReturnsAValue> threads = List.of(new GeneralTaskThatReturnsAValue(1), new GeneralTaskThatReturnsAValue(2),
		// 	new GeneralTaskThatReturnsAValue(3), new GeneralTaskThatReturnsAValue(4));
		// List<Future<Integer>> results = execService.invokeAll(threads); //invokeAll tells all the threads to run -> waits for all the threads to finish running -> gets all the return values back 
		// for (Future<Integer> result : results) {
		// 	System.out.println("Return value of a thread: " + result.get()); 
		// }

		// execService.shutdown();
		// //AFTER: using execService to run multiple threads at a time that return something... but instead of using multiple function calls - aka. multiple .execute - you just use 1 function call.... benefit is...it's a lot more concise.... also the function call - invokeAll - has you wait for all the thread to finish running before moving onto the next line.... cuz we need all the code to finish running to get the return value 

		// //B4: when u want to execute multiple threads that return a value..... and want to provide the return value of the thread that finished the fastest
		// ExecutorService execService = Executors.newFixedThreadPool(3); 
		// List<GeneralTaskThatReturnsAValue> threads = List.of(new GeneralTaskThatReturnsAValue(1), new GeneralTaskThatReturnsAValue(2),
		// 	new GeneralTaskThatReturnsAValue(3));
		// Integer returnValueOfFastestThread = execService.invokeAny(threads); //invokeAny runs all the threads just like invokeAll... but what it returns is different... whatever was returned by the thread that finished executing the fastest 
		// System.out.println(" Return value of the thread that finished running the fastest: " + returnValueOfFastestThread);

		// execService.shutdown();
		// //AFTER: when u want to execute multiple threads that return a value..... and want to provide the return value of the thread that finished the fastest

	}

}

class GeneralTask extends Thread { // a class used to create a thread is no different from a normal class - i.e. it can have properties methods aka. anything normal class has.... only difference is it implements a run method that holds the code that runs when thread is run 
	private int num; 

	GeneralTask(int num){
		this.num = num;
	}

	public void run() {
		System.out.print("\nTask " + num + " Start"); 
		for (int i = 100 * num; i <= 100 * num + 99; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask " + num + " Done"); 
	}
}

class GeneralTaskThatReturnsAValue implements Callable<Integer>{
	private int num; 

	GeneralTaskThatReturnsAValue(int num){
		this.num = num;
	}

	public Integer call() throws Exception {
		System.out.print("\nTask " + num + " Start"); 
		for (int i = 100 * num; i <= 100 * num + 99; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask " + num + " Done"); 
		return num; 
	}

}
