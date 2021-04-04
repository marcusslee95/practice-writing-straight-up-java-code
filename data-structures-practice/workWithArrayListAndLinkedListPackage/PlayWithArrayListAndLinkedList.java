import java.util.List;
import java.util.ArrayList; 
import java.util.LinkedList;

class Ball {
	private int sizeInInches; 
	private String company;

	Ball(int sizeInInches, String company){
		this.sizeInInches = sizeInInches; 
		this.company = company; 
	}

	int getSizeInInches(){
		return this.sizeInInches;
	}

	String getCompany(){
		return this.company;
	}

	public String toString(){
		return String.format("sizeInInches - %d, company - %s /",
			this.sizeInInches, this.company);
	}
}


class PlayWithArrayListAndLinkedList { //meant to just be playing w/ArrayList then remembered they both implement many of - if not all - the same methods cuz implement List interface..... so just need to change 1 line to be playing w/LinkedList
	public static void main(String[] args){
		// List<Ball> balls = new ArrayList<Ball>();
		List<Ball> balls = new LinkedList<Ball>();
		balls.add(new Ball(12, "Spalding"));
		balls.add(new Ball(2, "Callaway"));
		balls.add(new Ball(15, "Adidas"));
		// System.out.println(balls.get(0));
		for (int i = 0; i < balls.size(); i++){
			// System.out.println(balls.get(i));
			// System.out.println(balls.get(i).getSizeInInches());
			// balls.get(i).company = "wahlfjwaeafkjwljf";
			System.out.println(balls.get(i).toString());
		}

		System.out.println();

		balls.set(1, new Ball(3, "Wilson"));
		balls.remove(2);
		for ( Ball ball : balls ){
			System.out.println(ball.toString());
		}

		System.out.println();

		balls.clear();
		boolean isBallsEmpty = balls.isEmpty();
		if (isBallsEmpty){
			System.out.println("all balls deleted successfully");
		}


	}
}