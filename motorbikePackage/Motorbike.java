class Motorbike{

	private int speed;

	public void start(){
		System.out.println("Motorbike Started");
	}

	public void setSpeed(int speed){
		if(speed > 0){
			this.speed = speed;
		}

	}

	public int getSpeed(){
		return this.speed;
	}

	public void increaseSpeedBy(int speed){
		// this.speed = this.speed + speed;
		setSpeed(this.speed + speed);
	}

	public void decreaseSpeedBy(int speed){
		setSpeed(this.speed - speed);
	}

}