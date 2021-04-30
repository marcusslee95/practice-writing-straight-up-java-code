public class ThreadPractice {

	public static void main(String[] args) { //the key point w/multithreading aka. using multiple threads..... is that you can do multiple things at once... as opposed to waiting for something to finish before moving onto the next... so how that looks like in this case is..... instead of printing 100- 199 then moving to 200 - 299..... Task1 starts.... and before it finishes Task2 starts and task 3 starts. 

		// //B4: normal single-threaded way 
		// //Task1: 
		// for (int i = 100; i <= 199; i++) {
		// 	System.out.print(i + " ");
		// }

		// //Task2: 
		// for (int i = 200; i <= 299; i++) {
		// 	System.out.print(i + " ");
		// }

		// //Task1: 
		// for (int i = 300; i <= 399; i++) {
		// 	System.out.print(i + " ");
		// }
		// //AFTER: normal single-threaded way 

		Task1 task1 = new Task1();
		// task1.setPriority(3); //can set priorities to different threads 
		task1.start(); //you'd think it would be task1.run() but no.... if you did that it would run like normal / blocking code. 

		Task task2 = new Task2(); 
		Thread task2Thread = new Thread(task2); //the extrap step needed when creating thread using 2nd way
		task2Thread.start(); 


		// task1.join(); //tells java to wait for this thread to finish running all it's code before moving onto the next line..... it can throw a checked exception.... aka. high risk guy.... which is the reason way main method signature has indicator that it might throw that exception.....
		// task2Thread.join(); //not only will we wait for first thread to finish but also second thread to finish before running code below.... aka. won't get into printing the 300s until 100s and 200s are done 

		//Task3: 
		System.out.print("\nTask3 Start");
		for (int i = 300; i <= 399; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask3 Done");

	}
}

class Task1 extends Thread { //1st way to create a thread: create a class that extends Thread class..... and write the code you want the class to run inside the run() method

	public void run() { //sidenote since run method return type is void.... if you want to take outcome of running some code and do something with it.... instead you have to create a class that extends Callable class...
		System.out.print("\nTask1 Start");
		// Thread.yield(); // way to tell java.... hey.... once you reach this line... you can deprioritize running the rest of the code in this thread now...
		for (int i = 100; i <= 199; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask1 Done");
	}

}

class Task2 implements Runnable { //2nd way to create a thread: create a class that implements Runnable interface.... code looks same in the class.... only difference comes to when creating an instance of the class need oneextra step.

	public void run() {
		System.out.print("\nTask2 Start");
		for (int i = 200; i <= 299; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\nTask2 Done");
	}

}