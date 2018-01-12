import java.util.Random;

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
		int lowerBound = 0;
		while (!correct) {		
			random = (int)(Math.random()*(upperBound - lowerBound)+lowerBound);
			correct = game.guess(random);	
			if(game.getMessage().equals("Sorry , too small")) {
				lowerBound = random;
			}else if(game.getMessage().equals("Sorry , too large")) {
				upperBound = random;
			}
		
		}

		return random;
	}
}
