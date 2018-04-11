package gamePackage;

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
	private int guess;

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
		guess = number;
		if (this.secret == number) {
			setChanged();
			notifyObservers();
			setMessage("Correct! The secret number is " + secret);
			return true;
		} else if (number < secret) {
			setChanged();
			notifyObservers();
			setMessage("Sorry , too small");
			return false;
		} else {
			setChanged();
			notifyObservers();
			setMessage("Sorry , too large");
			return false;
		}

	}

	/** Get the game upper bound. */
	public int getUpperBound() {
		return upperBound;
	}

    /**
     * toString describes the game or problem.
     * @return description of this game or the problem to be solved.
     */
	@Override
	public String toString() {
		return "Gussing Number";
	}

	/**
	 * Get number of guessing time
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Get secret number
	 * @return secret number
	 */
	public int getSecretNumber() {
		return secret;
	}
	/**
	 * Get guess number
	 * @return guess number
	 */
	public int getGuess() {
		return guess;
	}
}
