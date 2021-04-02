public class Review {
	private String description;
	private int rating;

	Review(String description, int rating){
		this.description = description;
		this.rating = rating;
	}

	public String toString(){
		return String.format("description - %s, rating - %s",
			this.description, this.rating);
	}
}