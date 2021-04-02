class Address{
	//data
	private double latitude;
	private double longitude;

	//constructor -> what are the necessary properties of this object to exist? -> both required
	Address(double latitude, double longitude){
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String toString(){
		return String.format("latitude - %f. longitude - %f",
			this.latitude, this.longitude);
	}
}