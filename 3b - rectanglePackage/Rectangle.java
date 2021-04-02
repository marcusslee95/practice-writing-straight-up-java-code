class Rectangle {
	//data
	private int length;
	private int width; 

	//constructor - for what arguments it will take..... consider what is essential to the object
	Rectangle(int initialLength, int initialWidth){
		this.length = initialLength;
		this.width = initialWidth;
	}

	//behaviors want to do on the object
	public int calculateArea(){
		return this.length * this.width;
	}

	public int calculatePerimeter(){
		return 2 * (this.length + this.width);
	}

	public String toString(){ //https://www.javatpoint.com/java-string-format
		return String.format("length - %d; width - %d, area - %d, perimeter - %d", 
			this.length, this.width, this.calculateArea(), this.calculatePerimeter());
	}

	//skipped writing setter getter methods though probably would want them... cuz already know how to do that

	public static void main(String[] args){
		Rectangle wideRectangle = new Rectangle(5, 20);
		System.out.println(wideRectangle);
	}
}