public abstract class AbstractRecipe {
	public void executeRecipe(){ //want several classes to all executeRecipe following these three steps... but want to leave what goes on in those 3 steps up to each recipe class
		this.doPrepwork();
		this.doTheActualCooking();
		this.doTheCleanUpAfterwards();
	}

	public abstract void doPrepwork();
	public abstract void doTheActualCooking();
	public abstract void doTheCleanUpAfterwards();


}