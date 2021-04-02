public class Book {
	private String name;

	Book (String name){
		this.name = name;
	}

	public String toString(){
		return this.name;
	}

	public void setName(String whatToChangeNameTo){
		this.name = whatToChangeNameTo;
	}
}