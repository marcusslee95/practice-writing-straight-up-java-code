interface Flyable {//anything that can fly shold implement these methods
	public void fly();
}

class Airplane implements Flyable {
	public void fly(){
		System.out.println("Turn engines on");
		System.out.println("Speed through runway");
		System.out.println("Lift off");
	}
}

class Bird implements Flyable {
	public void fly(){
		System.out.println("Flap wings");
	}
}

public class FlyableRunner {


	public static void main(String[] args){ //anythingThatCanFly can be... anything that implements Flyable...
		// Flyable anythingThatCanFly = new Airplane();
		Flyable anythingThatCanFly = new Bird();
		anythingThatCanFly.fly();
	}
}