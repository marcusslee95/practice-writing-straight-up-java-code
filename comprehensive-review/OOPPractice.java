


//Inheritance example: to access parent class stuff in subclass use super keyword... an object of subclass type has access to all the properties and methods of super class (i.e. marcusStudent.setPhone("")..... another thing of note is subclass can take on form of superclass.... (which is why you can do stuff like Person marcus = new Student()... works because it's actually a student object.... but a student object can take on the form of / is a person).... this is why when using inheritance.... you not only have to think about 1. reusing your code (i.e. what if you didn't and you just copy pasted all the code in Person class into student class..... if you ever had to make some change now you'd have to make that change in two places as opposed to one) 2. subclass needs to have a "is a" relationship w/superclass (i.e. student is a person, circle is a shape, etc.)
class Person {
	private String name; 
	private String phone; 
	private String email; 

	//just a reminder that when you create constructors the answer to what arguments you want your constructor to accept come from answering the question.... "What are the properties I want every user of this object to have to specify?".... though ofc... if you have multiple constructors you're giving them multiple options now
	Person (String name) { //think user shouldn't be able to create a person object w/out a name.... person w/out a name doesn't make sense / shouldn't exist
		this.name = name; 
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name; 
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//if you don't want to use the toString method that comes from Object class - all classes inherit from Object class - let me create my own implemntation of it aka. override it...... object class implementation just gives name of class + location 
	public String toString() {
		return String.format("name - %s", "phone - %s", "email - %s",
			name, phone, email); //tbh could have just used String concatenation in this situation.... but feels like cleaner way.... no need to have + signs and not as many quotes
	}
}

class Student extends Person { //since Student class inherits everything from Person class aka. can literally think of it as the code being copy pasted..... besides the constructors..... the only code we have to add inside student class is the stuff unique to it
	private String college; 
	private int yearInCollege; 

	Student(String name, String college){ // students at the very least have a name and a college - assuming they'rea ll college students
		super(name); //super just refers to super class.... so this executes code in 1 argument constructor aka. this.name = name; to set the name property correctly -> if we didn't have an explicit super constructor call then.... java would by default make a call to no argument constructor of super class.... so either way whenever run constructor of subclass 1st line of code will always make call to super class 
		this.college = college; 
	}

	public void setCollege(String college){ //didn't implement getters just cuz wasn't necessary for purpose of this activity / tedious 
		this.college = college;
	}

	public void setYearInCollege(int year) {
		this.yearInCollege = year; 
	}

	public String toString() { //so this would be saying I don't want to use Person class version of this method
		//v1: 
		return String.format("name - %s", "phone - %s", "email - %s", "college - %s", "yearInCollege - %d",
			super.getName(), super.getPhone(), super.getEmail(), college, yearInCollege); // showing that to refer to any of the code in the super class... need to use super keyword.... can't just say super.name because name is private variable so can only refer to it directly in Person class.

		// //v2: 
		// return super.toString() + String.format("college - %s", "year - %d", college, year); 
	}

}

class NormalInheritanceRunner { //not sure how I'd run this cuz normally I have a class with a main method that's the same name as the file..... and java recognizes it and runs it... but since this is different name it won't..... 
	public static void main(String[] args) {
		// Person marcus = new Person("Marcus");
		// System.out.println(marcus); 
		// marcus.setPhone("1234567890");
		// marcus.setEmail("mmmmmmmmm@gmail.com");
		// System.out.println(marcus);

		Student marcusStudent = new Student("Marcus", "Yale");
		// Person marcusStudent = new Student("Marcus", "Yale"); //works cuz student is a person
		System.out.println(marcusStudent);
		marcusStudent.setPhone("1234567890"); //using methods in super class 
		marcusStudent.setEmail("mmmmmmmmm@gmail.com");
		System.out.println(marcusStudent);

		if (marcusStudent instanceof Student && marcusStudent instanceof Person){
			System.out.println("marcusStudent really is a student.... but a subclass can take on the form of it's parent.... aka. student is also a person"); 
		}


	}
}


