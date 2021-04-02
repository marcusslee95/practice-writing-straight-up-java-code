public class Fan{
	//1. what about the fan am I interested in? -> make those properties
	private String name;
	private double radius; 
	private String color;

	private boolean isOn; 
	private int powerLevel; 

	//2. what are the absolute essential parts of fan -> require user of fan to specify in constructor 
	Fan(String name, double radius, String color){
		this.name = name;
		this.radius = radius;
		this.color = color;
		//don't mind not setting the other two properties myself..... it's not like for fan to exist it's absolutely essential.... though I guess that's a judgement call aka. no clear cut answer
	}

	public String toString(){
		return String.format("name - %s, radius - %f , color - %s , isOn - %b , powerLevel - %d", 
				name, radius, color, isOn, powerLevel); //apparently this is preferred to String concatenation... cuz performance reasons.
	}

	public void switchOn(){//note: this is more than a setter method... it's not just setting a single property to some value.
		this.isOn = true;
		this.powerLevel = 2;
	}

	public void switchOff(){
		this.isOn = false;
		this.powerLevel = 0; 
	}

	public void setPowerLevel(int newPowerLevel){
		this.powerLevel = newPowerLevel;
	}

	public int getPowerLevel(){
		return this.powerLevel;
	}



	public static void main(String[] args){
		Fan fan1 = new Fan("Refresher3000", 3.14, "Sky Blue");
		Fan fan2 = new Fan("IceBlaster2", 11.11, "Violet");
		System.out.println(fan1);
		fan1.switchOn();
		System.out.println(fan1);
		fan1.setPowerLevel(5); 
		System.out.println(fan1.getPowerLevel());
		fan1.switchOff();
		System.out.println(fan1);

	}
}