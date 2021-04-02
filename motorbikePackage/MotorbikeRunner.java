public class MotorbikeRunner{

	public static void main(String[] args){
		Motorbike harleyDavidson = new Motorbike();
		harleyDavidson.start();
		System.out.println(harleyDavidson.speed);

		harleyDavidson.speed = 9000;
		System.out.println(harleyDavidson.speed);
	}
}