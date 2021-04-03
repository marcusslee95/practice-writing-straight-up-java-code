public class StudentWithoutInheritance { //where we just copy paste code in Person and then add additional code.... this would be a world w/out inheritance....
	private String name;
	private String phone;
	private String email;

	private String college;
	private int year; 

	StudentWithoutInheritance(String name){
		this.name = name;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setCollege(String college){
		this.college = college;
	}

	public void setYear(int year){
		this.year = year;
	}


	public String toString(){
		return String.format("name - %s, phone - %s, email - %s, college - %s, year - %d",
			this.name, this.phone, this.email, this.college, this.year);
	}
}