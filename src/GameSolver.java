import java.util.Random;

/**
 * Solver of guessing a secret number
 * @author Atid Srisukhantapuek
 * @version 2018.1.20
 */

public class GameSolver {

	/**
	 * Find secret number by random with large range to point
	 * @return secret number
	 * 
	 */
	
	public int play(NumberGame game){
		
		boolean correct = false;
		int guess = 0;
		int upperBound = game.getUpperBound();
		int lowerBound = 1;
		while (!correct) {		
			guess = upperBound + (upperBound - lowerBound)/2;
			correct = game.guess(guess);	
			if(game.getMessage().toLowerCase().contains("too small")) {
				lowerBound = guess + 1;
			}else if(game.getMessage().toLowerCase().contains("too large")) {
				upperBound = guess - 1;
			}else {
				break;
			}
		
		}

		return guess;
	}
}
