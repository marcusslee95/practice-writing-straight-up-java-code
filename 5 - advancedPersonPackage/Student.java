public class Student extends Person {//since it inherits everything from Person class.... besides constructors.... we just have to add the new stuff in this class
	private String college;
	private int year; 

	Student(String name, String college){
		super(name);
		this.college = college;
	}

	public void setCollege(String college){
		this.college = college;
	}

	public void setYear(int year){
		this.year = year;
	}

	public String toString(){//showing we can use stuff from super class
		//v1: 
		return String.format("name - %s, phone - %s, email - %s, college - %s, year - %d",
			super.getName(), super.getPhone(), super.getEmail(), this.college, this.year);
		
		// //v2: 
		// return super.toString() + String.format("college - %s, year - %d",
		// 	this.college, this.year);
	}

}