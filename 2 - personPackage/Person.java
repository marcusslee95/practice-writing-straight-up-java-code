import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Person{
	//data I want object to have
	private String name;
	private int heightInInches;
	private List<String> passions;

	Person(String name, int heightInInches, List<String> passions){
		this.name = name;
		this.heightInInches = heightInInches;
		this.passions = passions;
	}

	public String toString(){
		return this.name + "; " + this.heightInInches + "; " + this.passions;
	}

	public static void main(String[] args){
		ArrayList<String> marcusPassions = new ArrayList<>();  //either implementation of List interface works. -> this is an example of polymorphism where a class - i.e. both ArrayList and LinkedList - can take on the form of another class / interface - i.e. List.... It's also an example of dependency inversion principle.... where we code to an interface - List - not an implementation - imagine instead of using List we used either ArrayList or LinkedList - ..... would have been tied to one implementation... whereas now we're flexible.... can use any implementation of List interface
		// LinkedList<String> marcusPassions = new LinkedList<>();
		marcusPassions.add("eating");
		marcusPassions.add("hanging out w/the lady friend");
		marcusPassions.add("sleeping in peace");
		Person marcus = new Person("marcus", 60, marcusPassions);
		System.out.println(marcus.toString());
	}
}