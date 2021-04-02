class MotorbikeRunner{

	public static void main(String[] args){
		Motorbike harleyDavidson = new Motorbike();
		harleyDavidson.start();
		// System.out.println(harleyDavidson.speed);
		System.out.println(harleyDavidson.getSpeed());

		// harleyDavidson.speed = 9000;
		harleyDavidson.setSpeed(1000);
		// System.out.println(harleyDavidson.speed);
		System.out.println(harleyDavidson.getSpeed());

		int harleyDavidsonSpeed = harleyDavidson.getSpeed();
		harleyDavidson.setSpeed(harleyDavidsonSpeed + 666);
		System.out.println(harleyDavidson.getSpeed());

		int harleyDavidsonNewSpeed = harleyDavidson.getSpeed();
		harleyDavidson.setSpeed(harleyDavidsonNewSpeed - 666);
		System.out.println(harleyDavidson.getSpeed());
	}
}