public class ExceptionPractice {//btw exceptions are just errors that happen as your code is running.... the only reason we don't use the word error instead of exception is because in the code world.... errors are used to refer to the errors that you can't handle / if they happen your program Will crash no matter what (i.e. stack overflow) whereas exception refers to something that you can handle to avoid program just crashing / erroring out
	
	public static void main(String[] args){
		//B4: showing the difference in what we have to do for a runtime exception aka. unchecked exception aka... low risk guy. vs. checked exception aka. high risk guy 
		try {
			someMethod();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {//code that you always want to run regardless of exception happening or not
			System.out.println("Kiss bbyah");
		}
		someOtherMethod();
		//AFTER: showing the difference in what we have to do for a runtime exception aka. unchecked exception aka... low risk guy. vs. checked exception aka. high risk guy 

		// //B4 showing the flow of an exception -> it gets thrown to the method that called this method.... that keeps repeating until we get to the method that handles the exception.... if it doesn't exist program crashes if never handled 
		// //flow w/out handling exception
		// method1();
		// System.out.println("Main ended"); 

		// //flow w/handling exception
		// try {
		// 	method1();
		// } catch (NullPointerException e) {
		// 	e.printStackTrace();
		// 	System.out.println("String is null but you called it's length() method");
		// }
		// System.out.println("Main ended"); 
		//AFTER showing the flow of an exception -> it gets thrown to the method that called this method.... that keeps repeating until we get to the method that handles the exception.... if it doesn't exist program crashes if never handled 

	}

	private static void someMethod() throws InterruptedException { //i have to have the "throws InterruptedException" on this method signature - you'll get errors if try to compile code w/out it - .... because 1. Thread.sleep can in fact cause an InterruptedException 2. InterruptedException is a checked exception... and you can think of checked exceptions as high risk guys... where methods that might cause them have to say "hey I've got potentially dangerous code".... lololol it's like at a date if there was a policy where people w/red flags had to have an indicator telling their date i'm a high risk person..... because it's high risk.... I have to write code to handle the potential exception - which I do in my try catch block in the main method....  you don't want to be caught off guard not having prepared to deal w/a high risk guy..... in contrast, an unchecked exception - which is any subclass of Runtime class - is like a low risk guy where we can just call the method.... what are the chances it happens.... and even if it happens it's no biggy.
		Thread.sleep(1000);
	}

	private static void someOtherMethod() {
		throw new RuntimeException("I'm a low risk guy.... as in even if i happen it's not a big deal.");
	}



	// private static void method1() {
	// 	method2();
	// 	System.out.println("Method1 Ended"); //even when handle the exception in main.... code here doesn't execute.... exception handling doesn't mean that all the code that should have executed does indeed execute.... it just means instead of sending an error.... we'll run some predefined code aka. the code in catch block
	// }

	// private static void method2() {
	// 	String str = null;
	// 	str.length(); 
	// 	System.out.println("Method2 Ended"); //same here. even when handle the exception in main method.... code here doesn't execute.
	// }

}