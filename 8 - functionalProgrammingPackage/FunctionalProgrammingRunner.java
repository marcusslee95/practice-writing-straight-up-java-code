import java.util.Arrays;
import java.util.List;

class FunctionalProgrammingRunner {
	public static void main(String[] args){
		//https://www.geeksforgeeks.org/functional-programming-in-java-with-examples/
		//Exercise 1: using lambda expression aka. anonymous function 
		List<Integer> numbers
            = Arrays.asList(11, 22, 33, 44,
                            55, 66, 77, 88,
                            99, 100);
 
        // Internal iterator
        numbers.forEach(number -> System.out.print(number + " ")); //counts as example of functional programming cuz we're treating functions like first class citizens aka. functions get same treatment objects get i.e. can be passed in as arguments 
        // // External iterator -> old not using functional programming way... no functions being used as arguments
        // for (int i = 0; i < numbers.size(); i++) {
        //     System.out.print(numbers.get(i) + " ");
        // }

        System.out.println();

        //Exercise 2: using a typical functional programming block... create a stream -> do intermediate operations on that stream -> do some terminal operation
        System.out.println(
            numbers.stream() // create stream aka. bunch of objects
                .filter(number -> number % 2 == 0) //take out the objects that don't match this condition... aka. keep the even ones 
                .mapToInt(e -> e * 2) // for each object replace it with this value
                .sum()); //take all the objects and then return their sum value. 


        // //non functional programming way - as you can see result has this changing state... goes from one value to next.... not good for when using multiple threads... whereas in above example just do all calculations and when finished return result... 
        // int result = 0;
        // for (Integer n : numbers) {
        //     if (n % 2 == 0) {
        //         result += n * 2;
        //     }
        // }
        // System.out.println(result);


	}
}