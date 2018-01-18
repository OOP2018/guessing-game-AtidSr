import java.util.Random;

/**
 * Game of guessing a secret number
 * 
 * @author Atid Srisukhantapuek
 * @version 2018.1.18
 */
public class AtidGame extends NumberGame {

	private int upperBound;
	private int secret;
	private int count;

	public AtidGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);

		this.secret = rand.nextInt(upperBound) + 1;
		super.setMessage("I'm thinking of a number between 1 and " + upperBound);

	}

	/**
	 * Evaluate a user's guess and count guessing time.
	 * @param number is the user's guess
	 * @return true if guess is correct, false otherwise
	 */
	public boolean guess(int number) {
		count += 1;
		if (this.secret == number) {
			setMessage("Correct! The secret number is " + secret);
			return true;
		} else if (number < secret) {
			setMessage("Sorry , too small");
			return false;
		} else if (number > secret) {
			setMessage("Sorry , too large");
			return false;
		}

		return false;
	}

	/** Get the game upper bound. */
	public int getUpperBound() {
		return upperBound;
	}

	@Override
	public String toString() {
		return "Gussing Number";
	}

	public int getCount() {
		return count;
	}

}
