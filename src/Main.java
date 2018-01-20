/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new AtidGame(upperBound);
		GameSolver ui = new GameSolver();
//		GameConsole ui = new GameConsole( );
		int solution = ui.play( game );
		
		//display the total guessing time
		System.out.println("total guessing :"+game.getCount());

		System.out.println("The secret number is "+solution);
		
		
		
		
		
	}
}
