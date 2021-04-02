class Customer {
	//data wanna know about customer - purpose of this activity was showing example of object composition aka. using complex object as property of another object....
	String name;
	Address homeAddress;
	Address workAddress; 

	//constructor - decide on what arguments constructor should take... by deciding which info is mandatory for object.... workAddress seems more optional
	Customer(String name, Address homeAddress){
		this.name = name;
		this.homeAddress = homeAddress;
	}

	public String toString(){
		return String.format("name - %s, homeAddress - [%s], workAddress - [%s]",
			this.name, this.homeAddress, this.workAddress); 
	}

	public void setWorkAddress(Address newWorkAddress){
		this.workAddress = newWorkAddress;
	}

	public static void main(String[] args){
		Customer someCustomer = new Customer("Mackledoodle Doo", 
			new Address(93.9, 66.66666));
		System.out.println(someCustomer);
		
		Address newWorkAddress = new Address(80, 20);
		someCustomer.setWorkAddress(newWorkAddress);
		System.out.println(someCustomer);
	}
}