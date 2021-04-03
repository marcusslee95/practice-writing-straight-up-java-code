public interface GamingActions { //an interface really is just a group of methods (though it can define final constants - these aren't instance properties)
//all methods in interfaces are  1. abstract aka. don't have implementation and 2. public.... Only exception to that rule is that w/java 8 you are allowed to create default implementations.... this is to avoid situations like you have 10000 classes implementing an interface.... and you introduce a newmethod in the interface.... so you have to implement that method in all 1000 classes.
	public void hitUpButton(); 
	public void hitDownButton();
	public void hitLeftButton();
	public void hitRightButton();
//so in this case.... what actually happens when hitUpButton - for example - is determined by the implementing class
}