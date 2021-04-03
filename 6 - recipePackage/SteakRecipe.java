public class SteakRecipe extends AbstractRecipe { //need to implement abstract methods in AbstractRecipe.... which is essentially creating this classes' own unique implementation for the steps identified in abstractRecipe class
	public void doPrepwork(){
		System.out.println("Buy 1 butter block");
		System.out.println("Buy 1 ribeye");
		System.out.println("Defrost ribeye");
		System.out.println("Heat pan");
		System.out.println();
	}

	public void doTheActualCooking(){
		System.out.println("Melt butter on pan");
		System.out.println("Cook both sides of steak on pan");
		System.out.println("Let steak rest");
		System.out.println();
	}

	public void doTheCleanUpAfterwards(){
		System.out.println("Throw pan in dishwasher");
		System.out.println();
	}
}