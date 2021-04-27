import java.util.Arrays;
import java.util.Collections;
import java.util.List; 

public class FunctionalProgrammingPractice {
	public static void main(String[] args) {
		//https://www.geeksforgeeks.org/functional-programming-in-java-with-examples/
		//Exercise 1: using a lambda expression... which is just java lingo to refer to an anonymous function 
		List<Integer> numbers = Arrays.asList(100, 11, 22, 99, 33, 44, 55,66, 77, 88);

		Collections.sort(numbers, (n1, n2) -> n1.compareTo(n2)); 

		numbers.forEach(number -> System.out.print(number + " ")); //****iterating via. forEach method aka. using functional programming..... any situation where you're treating functions as first class citizens is an example of functional programming. By first class citizens we mean giving them the same treatment that we do w/objects which are the traditional first class citizens in Java... so things like.... passing functions as arguments, having functions be return values of methods, etc. 
		// for (int i = 0; i < numbers.size(); i++){ //iterating via traditional method
		// 	System.out.print(numbers.get(i) + " ");
		// }

		System.out.println(); 

		//*****Exercise 2: getting practice writing a classic example of functional programming..... where you create a stream - which is just like a collection of things that you go through one by one -> do intermediate operations on that stream - which modify that stream -> do some terminal operation i.e. return something 
		System.out.println(
			numbers.stream() // create stream
				.filter(number -> number % 2 == 0) //take out the things that don't match this condition aka. aren't even 
				.mapToInt(e -> e * 2) //replace each thing w/double what it was 
				.sum() //return sum of all the things
			);

		// //******non functional programming way -> this shows how using functional programming can make code thread safe -= which just means that even if you have multiple threads running the same code at the same time... you will get the outcome that you'd expect i.e. if you have two threads incrementing the same thing at the same time then you'd expect / want the thing to have incremented twice.... going back to this example.... using the traditional way, we have this result variable that keeps changing w/each iteration.... having something like this where there is changing state is not good for thread safety...  in contrast.... w/functional programming way.... we just return a value at the end... I'm still not exactly sure why having something w/changing state makes a block of code NOT thread safe.... but whatevs
		// int result = 0;
		// for (Integer n : numbers) {
		// 	if (n % 2 == 0) {
		// 		result += n * 2;
		// 	}
		// }
		// System.out.println(result);

		System.out.println(numbers.stream().mapToInt(num -> num).sum()); //showing that stream doesn't have all the methods you'd want it to... i.e. sum method is available only to IntStream... so sometimes you need to modify it to some specific subtype of Stream if want to use some method
	}
}