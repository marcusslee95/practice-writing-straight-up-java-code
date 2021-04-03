public class Runner {
	public static void main(String[] args){
		// Person marcus = new Person("Marcus");
		// System.out.println(marcus);
		// marcus.setPhone("123456789");
		// marcus.setEmail("mmmmmmm@mmmm.com"); 
		// System.out.println(marcus);

		Student marcusStudent = new Student("Marcus", "Yale");
		// Person marcusStudent = new Student("Marcus", "Yale"); //creating a student object and assigning it to variable of person type... works because a student is a person.
		System.out.println(marcusStudent);
		marcusStudent.setPhone("123456789"); //using methods in super class
		marcusStudent.setEmail("mmmmmmm@mmmm.com"); 
		System.out.println(marcusStudent);

		if (marcusStudent instanceof Student && marcusStudent instanceof Person){
			System.out.println("marcusStudent really is a student... but a subclass can take on the form of it's parent... aka. student is also a person");
		}


	}
}