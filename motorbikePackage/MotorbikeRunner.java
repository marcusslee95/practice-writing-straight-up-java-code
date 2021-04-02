class MotorbikeRunner{

	public static void main(String[] args){
		Motorbike harleyDavidson = new Motorbike();
		harleyDavidson.start();
		// System.out.println(harleyDavidson.speed);
		System.out.println(harleyDavidson.getSpeed());

		// harleyDavidson.speed = 9000;
		harleyDavidson.setSpeed(9000);
		// System.out.println(harleyDavidson.speed);
		System.out.println(harleyDavidson.getSpeed());
	}
}