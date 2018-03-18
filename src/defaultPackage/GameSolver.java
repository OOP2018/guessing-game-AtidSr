package defaultPackage;


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
		int random = 0;
		int upperBound = game.getUpperBound();
		int lowerBound = 1;
		while (!correct) {		
			random = lowerBound + (upperBound - lowerBound)/2;
			correct = game.guess(random);	
			if(game.getMessage().toLowerCase().contains("too small")) {
				lowerBound = random + 1;
			}else if(game.getMessage().toLowerCase().contains("too large")) {
				upperBound = random - 1;
			}else {
				break;
			}
		
		}

		return random;
	}
}
