class MotorbikeRunner{

	public static void main(String[] args){
		Motorbike harleyDavidson = new Motorbike(10000);
		harleyDavidson.start();
		// System.out.println(harleyDavidson.speed);
		System.out.println(harleyDavidson.getSpeed());

		// harleyDavidson.speed = 9000;
		harleyDavidson.setSpeed(1000);
		// System.out.println(harleyDavidson.speed);
		System.out.println(harleyDavidson.getSpeed());

		harleyDavidson.increaseSpeedBy(666);
		System.out.println(harleyDavidson.getSpeed());

		harleyDavidson.decreaseSpeedBy(667);
		System.out.println(harleyDavidson.getSpeed());

	}
}