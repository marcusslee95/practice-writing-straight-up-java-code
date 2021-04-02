public class Book {
	private String name;

	Book (String name){
		this.name = name;
	}

	public String toString(){
		return this.name;
	}
	public static void main (String[] args){
		Book artOfProgramming = new Book("Art Of Programming");
		Book cleanCode = new Book("Clean Code");
		System.out.println(artOfProgramming.toString());
		System.out.println(cleanCode.toString());


	}
}