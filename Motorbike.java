class Motorbike{

	void start(){
		System.out.println("Motorbike Started");
	}

	public static void main(String[] args){
		Motorbike harleyDavidson = new Motorbike();
		Motorbike ducati = new Motorbike();
		harleyDavidson.start();
		ducati.start();
	}
}