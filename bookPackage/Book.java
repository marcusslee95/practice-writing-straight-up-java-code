public class Book {
	private String name;
	private int numOfPages;

	Book (String name, int numOfPages){
		this.name = name;
		this.numOfPages = numOfPages;
	}

	public String toString(){
		return this.name + "; " + this.numOfPages;
	}

	public void setName(String whatToChangeNameTo){
		this.name = whatToChangeNameTo;
	}

	public String getName(){
		return this.name;
	}

	public void setNumOfPages(int whatToChangeNumOfPagesTo){
		if (whatToChangeNumOfPagesTo < 0){
			throw new RuntimeException("Can't have a book having - pages");
		}
		this.numOfPages = whatToChangeNumOfPagesTo;
	}

	public int getNumOfPages(){
		return this.numOfPages;
	}
}