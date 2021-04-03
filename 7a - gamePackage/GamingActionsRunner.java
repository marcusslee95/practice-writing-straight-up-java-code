public class GamingActionsRunner {
	public static void main(String[] args){
		// MarioGame marioGameInstance = new MarioGame();
		// marioGameInstance.hitUpButton();
		// marioGameInstance.hitDownButton();
		// marioGameInstance.hitLeftButton();
		// marioGameInstance.hitRightButton(); 

		// // GamingActions gameInstance = new MarioGame(); //using polymorphism for flexibility... since any object of a class that implements interface.... can take on the form of the interface.... we can assign any object whose class implements that interface.... to a variable of that interface type
		// // gameInstance = new ChessGame();
		// GamingActions gameInstance = new ChessGame();
		// gameInstance.hitUpButton();
		// gameInstance.hitDownButton();
		// gameInstance.hitLeftButton();
		// gameInstance.hitRightButton(); 

		//using polymorphism to have same code have different behavior 
		// GamingActions[] games = {new MarioGame(), new ChessGame(), new ChessGame(), new MarioGame()}; 
		GamingActions[] games = new GamingActions[4];
		games[0] = new MarioGame();
		games[1] = new ChessGame();
		games[2] = new ChessGame();
		games[3] = new MarioGame();
		for (GamingActions game : games){
			game.hitUpButton();
			game.hitDownButton();
			game.hitLeftButton();
			game.hitRightButton(); 
		}
	}
}