import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Book{
	//data - what about this object do we want to keep note of
	private String title;
	private String author;
	private List<Review> reviews; 

	//constructor - what are the absolutely necessary details about this object... without which it cannot exist.... I'd say title and author.... reviews are optional
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}

	public String toString(){
		return String.format("title - %s, author - %s, reviews - %s",
			this.title, this.author, this.reviews);
	}

	public void addToReviews(List<Review> reviewsToBeAdded){
		if (this.reviews == null){
			this.reviews = reviewsToBeAdded;
		}
		else {
			for (Review review : reviewsToBeAdded){ 
			    this.reviews.add(review);
			}			
		}
	}

	public List<Review> getReviews(){
		return this.reviews;
	}

	public static void main(String[] args){
		Book myFavoriteBook = new Book("Harry Potter and the Deathly Hallows", "JK Rowling");
		System.out.println(myFavoriteBook);

		List<Review> bunchOfReviews = new LinkedList<Review>();
		bunchOfReviews.add(new Review("Great Book", 4));
		bunchOfReviews.add(new Review("Awesome", 5));
		bunchOfReviews.add(new Review("Best Fantasy Book in 21st Century", 5));
		myFavoriteBook.addToReviews(bunchOfReviews);
		System.out.println(myFavoriteBook.getReviews());

		List<Review> secondLoadOfReviews = new ArrayList<Review>(); //showing the benefits of using an interface instead of a implementation - aka. dependency inversion - now can use whatever implementation of List that I want..... this is all made possible via polymorphism.... since LinkedList and ArrayList can both take on the form of a List
		secondLoadOfReviews.add(new Review("Middling", 3));
		secondLoadOfReviews.add(new Review("Childish", 2));
		secondLoadOfReviews.add(new Review("Good for it's time but not anymore", 2));
		myFavoriteBook.addToReviews(secondLoadOfReviews);
		System.out.println(myFavoriteBook.getReviews());
	}
}