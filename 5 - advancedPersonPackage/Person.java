public class Person {
	private String name;
	private String phone;
	private String email;

	//I don't want to create a person w/out a name.... w/out a phone or email is ok....
	Person(String name){
		this.name = name;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getName(){
		return this.name;
	}

	public String getPhone(){
		return this.phone;
	}

	public String getEmail(){
		return this.email;
	}

	//I don't want to use the toString method that comes w/Object class.... let me create my own implementation aka. override
	public String toString(){
		return String.format("name - %s, phone - %s, email - %s",
			this.name, this.phone, this.email);
	}
}