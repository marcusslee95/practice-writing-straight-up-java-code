public class Runner {
	public static void main(String[] args){
		SteakRecipe steakRecipeInstance = new SteakRecipe();
		steakRecipeInstance.executeRecipe();

		KimchiFriedRiceRecipe kimchiFriedRiceRecipeInstance = new KimchiFriedRiceRecipe();
		kimchiFriedRiceRecipeInstance.executeRecipe(); 
	}
}