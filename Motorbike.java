class Motorbike{

	int speed;

	void start(){
		System.out.println("Motorbike Started");
	}

	public static void main(String[] args){
		Motorbike harleyDavidson = new Motorbike();
		// Motorbike ducati = new Motorbike();
		harleyDavidson.start();
		// ducati.start();
		System.out.println(harleyDavidson.speed);

		harleyDavidson.speed = 9000;
		System.out.println(harleyDavidson.speed);
	}
}